package org.springframework.social.foursquare.api.impl;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.*;
import org.springframework.social.foursquare.api.FoursquareApiException;
import org.springframework.social.foursquare.api.ParamErrorException;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class FoursquareErrorHandler extends DefaultResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        Map<String, Object> errorDetails = extractErrorDetailsFromResponse(response);

        int code = Integer.valueOf(String.valueOf(errorDetails.get("code"))).intValue();
        String errorType = String.valueOf(errorDetails.get("errorType"));
        String message = String.valueOf(errorDetails.get("errorDetail"));

        handleFoursquareError(code, errorType, message);

        throw new FoursquareApiException(code, errorType, message);
    }

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        if (super.hasError(response)) {
            return true;
        }
        // only bother checking the body for errors if we get past the default error check
        return false;
        //FIXME This reads the bugger stream and can break tests String content = readFully(response.getBody());
        //return content.contains("\"errorType\":") || content.equals("false");
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> extractErrorDetailsFromResponse(ClientHttpResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new JsonFactory());
        Map<String, Object> responseMap = mapper.<Map<String, Object>>readValue(response.getBody(), new TypeReference<Map<String, Object>>() {
        });
        if (responseMap.containsKey("meta")) {
            Map<String, Object> meta = (Map<String, Object>) responseMap.get("meta");
            if (Integer.valueOf(String.valueOf(meta.get("code"))).intValue() > 200) {
                return meta;
            }
        }
        return null;
    }

    private void handleFoursquareError(int code, String errorType, String message) {
        if (errorType.equals("invalid_auth")) {
            throw new NotAuthorizedException("foursquare", message);
        } else if (errorType.equals("param_error")) {
            throw new ParamErrorException(code, errorType, message);
        } else if (errorType.equals("endpoint_error")) {
            throw new ResourceNotFoundException("foursquare", message);
        } else if (errorType.equals("not_authorized")) {
            throw new InsufficientPermissionException(message);
        } else if (errorType.equals("rate_limit_exceeded")) {
            throw new RateLimitExceededException("foursquare");
        } else if (errorType.equals("server_error")) {
            throw new InternalServerErrorException("foursquare", message);
        }
    }

    private String readFully(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        while (reader.ready()) {
            sb.append(reader.readLine());
        }
        return sb.toString();
    }
}
