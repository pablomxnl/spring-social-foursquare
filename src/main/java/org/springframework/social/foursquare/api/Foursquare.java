package org.springframework.social.foursquare.api;

import org.springframework.social.ApiBinding;

public interface Foursquare extends ApiBinding {

    UserOperations userOperations();

    VenueOperations venueOperations();

    CheckinOperations checkinOperations();

    TipOperations tipOperations();

    PhotoOperations photoOperations();

    SettingOperations settingOperations();

    SpecialOperations specialOperations();

}
