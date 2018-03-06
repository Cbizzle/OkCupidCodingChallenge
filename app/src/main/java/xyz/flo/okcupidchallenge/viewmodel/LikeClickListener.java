package xyz.flo.okcupidchallenge.viewmodel;

import xyz.flo.okcupidchallenge.data.User;

/**
 * Listens for like user events
 */
public interface LikeClickListener {
    void onLike(User user);
}
