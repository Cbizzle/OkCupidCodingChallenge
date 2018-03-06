package xyz.flo.okcupidchallenge.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import lombok.NonNull;
import xyz.flo.okcupidchallenge.data.User;

/**
 * View model for the user items. Exposes data to be shown.
 */

public class UserItemViewModel extends ViewModel {

    protected final User user;

    public final MutableLiveData<String> userId = new MutableLiveData<>();

    public final MutableLiveData<String> username = new MutableLiveData<>();

    public final MutableLiveData<String> age = new MutableLiveData<>();

    public final MutableLiveData<String> city = new MutableLiveData<>();

    public final MutableLiveData<String> state = new MutableLiveData<>();

    public final MutableLiveData<String> matchPercent = new MutableLiveData<>();

    public final MutableLiveData<String> imageUrl = new MutableLiveData<>();


    public UserItemViewModel(@NonNull User user) {
        this.user = user;

        userId.setValue(user.getUserId());
        username.setValue(user.getUsername());
        age.setValue(String.valueOf(user.getAge()));
        city.setValue(user.getLocation().getCity());
        state.setValue(user.getLocation().getState());
        matchPercent.setValue(String.valueOf(user.getMatchPercent()));

        imageUrl.setValue(user.getPhotoUrl());
    }

    //Using glide this binds to the imageview and downloads the images asynchronously as needed.
    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context)
                .load(url)
                .into(imageView);
    }

}
