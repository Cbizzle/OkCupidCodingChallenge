package xyz.flo.okcupidchallenge.viewmodel;

import android.databinding.ObservableBoolean;

import lombok.NonNull;
import xyz.flo.okcupidchallenge.data.User;

/**
 * View model for the user blend items that are likeable. Exposes data to be shown.
 */
public class UserBlendItemViewModel extends UserItemViewModel {

    private final LikeClickListener likeClickListener;

    private ObservableBoolean isLiked = new ObservableBoolean();


    public UserBlendItemViewModel(@NonNull User user, LikeClickListener likeClickListener) {
        super(user);
        this.likeClickListener = likeClickListener;
        isLiked.set(user.isLiked());
    }

    //onClick click listener to handle the change of liking a user
    public void like() {
        if (likeClickListener == null || isLiked == null || isLiked.get()) {
            return;
        }

        isLiked.set(true);
        likeClickListener.onLike(this.user);
    }

    public ObservableBoolean getIsLiked() {
        return this.isLiked;
    }

}
