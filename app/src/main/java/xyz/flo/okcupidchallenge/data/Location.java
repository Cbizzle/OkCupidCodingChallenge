package xyz.flo.okcupidchallenge.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

/**
 * The data model for a user's location which is visible on the app
 */
@Getter
@AllArgsConstructor
public class Location {

    @NonNull
    private final String city;

    @NonNull
    private final String state;
}
