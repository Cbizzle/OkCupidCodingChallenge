package xyz.flo.okcupidchallenge.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;


/**
 * A serialized user account based on JSON elements
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown=true)
public class SerializedUser {

    @NonNull
    private final String userId;

    @NonNull
    private final String username;

    private final int age;

    @NonNull
    private final SerializedLocation location;

    private final int match;

    private final boolean liked;

    @NonNull
    private final String photoUrl;

    @SuppressWarnings("unchecked")
    @JsonCreator
    @Builder
    private SerializedUser(@JsonProperty("userid") @NonNull final String userId,
                           @JsonProperty("username") @NonNull final String username,
                           @JsonProperty("age") final int age,
                           @JsonProperty("location") @NonNull final SerializedLocation location,
                           @JsonProperty("match") final int match,
                           @JsonProperty("photo") @NonNull final Map<String, Object> photo,
                           @JsonProperty("liked") boolean liked) {
        this.userId = userId;
        this.username = username;
        this.age = age;
        this.location = location;
        this.match = match;
        this.liked = liked;

        final Map<String,String> fullPaths = (Map<String,String>)photo.get("thumb_paths");
        this.photoUrl = fullPaths.get("large");
    }

}
