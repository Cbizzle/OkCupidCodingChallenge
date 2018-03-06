package xyz.flo.okcupidchallenge.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Getter;
import lombok.NonNull;

/**
 * Serialized json OkCupid data and the list of users
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown=true)
public class OkCupidData {

    @NonNull
    private final List<SerializedUser> serializedUsers;

    @JsonCreator
    OkCupidData(@JsonProperty("data") @NonNull final List<SerializedUser> serializedUsers) {
        this.serializedUsers = serializedUsers;
    }
}
