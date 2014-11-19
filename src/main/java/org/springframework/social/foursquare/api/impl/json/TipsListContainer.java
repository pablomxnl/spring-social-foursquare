package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.foursquare.api.Tip;

import java.util.List;

@JsonDeserialize(using = TipsListContainerDeserializer.class)
public class TipsListContainer {
    private List<Tip> tips;

    public TipsListContainer(List<Tip> tips) {
        this.tips = tips;
    }

    public List<Tip> getTips() {
        return tips;
    }
}
