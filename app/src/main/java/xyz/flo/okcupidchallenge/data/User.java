package xyz.flo.okcupidchallenge.data;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

/**
 * The data model for an OkCupid user that is visible on the app
 */
@Getter
public class User implements Comparable<User>{

    @NonNull
    private final String userId;

    @NonNull
    private final String username;

    private final int age;

    @NonNull
    private final Location location;

    private final int match;

    @NonNull
    private final String photoUrl;

    private boolean isLiked = false;

    private int matchPercent;

    public void like() {
        this.isLiked = true;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public int compareTo(@NonNull User otherUser) {
        // Descending sort
        return Integer.compare(otherUser.getMatch(), match);
    }

    @Override
    public boolean equals(Object object) {
        if(object == null || !(object instanceof User)) {
            return false;
        }

        User otherUser = (User)object;

        return userId.equals(otherUser.getUserId());
    }

    @Builder
    private User(String userId,
                 String username,
                 int age,
                 Location location,
                 int match,
                 boolean isLiked,
                 String photoUrl) {
        this.userId = userId;
        this.username = username;
        this.age = age;
        this.location = location;
        this.match = match;
        this.isLiked = isLiked;
        this.photoUrl = photoUrl;
        this.matchPercent = (int) Math.round(match/100.0);
    }

}