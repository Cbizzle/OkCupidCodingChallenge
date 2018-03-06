package xyz.flo.okcupidchallenge.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

/**
 * Serialized user location based on JSON elements
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown=true)
class SerializedLocation {

    @NonNull
    private final String city;

    @NonNull
    private final String state;

    @JsonCreator
    @Builder
    private SerializedLocation(@JsonProperty("city_name") @NonNull final String city,
                               @JsonProperty("state_code") @NonNull final String state) {
        this.city = city;
        this.state = state;
    }
}
