package org.springframework.social.foursquare.api;

/**
 * User: diesel
 * Date: 18/12/13
 * Time: 00:27
 */
public class UserPhoto {
    private String prefix;
    private String suffix;
    private String url;

    public UserPhoto(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.url = prefix + suffix;
    }


    public UserPhoto(String url) {
        this.url = url;

    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }
}
