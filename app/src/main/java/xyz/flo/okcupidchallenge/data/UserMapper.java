package xyz.flo.okcupidchallenge.data;

import lombok.NonNull;

/**
 * Maps a serialized user to a user
 */
public class UserMapper {

    public User serializedUserToUser(@NonNull SerializedUser serializedUser) {
        return User.builder()
                .age(serializedUser.getAge())
                .location(new Location(serializedUser.getLocation().getCity(), serializedUser.getLocation().getState()))
                .match(serializedUser.getMatch())
                .photoUrl(serializedUser.getPhotoUrl())
                .userId(serializedUser.getUserId())
                .username(serializedUser.getUsername())
                .isLiked(serializedUser.isLiked())
                .build();
    }
}
