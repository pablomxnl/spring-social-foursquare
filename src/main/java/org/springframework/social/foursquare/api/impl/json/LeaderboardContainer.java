package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.foursquare.api.Leaderboard;

@JsonDeserialize(using = LeaderboardContainerDeserializer.class)
public class LeaderboardContainer {

    private Leaderboard leaderboard;

    public LeaderboardContainer(Leaderboard leaderboard) {
        this.leaderboard = leaderboard;
    }

    public Leaderboard getLeaderboard() {
        return leaderboard;
    }
}
