package xyz.flo.okcupidchallenge.tasks;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableBoolean;

import java.util.ArrayList;
import java.util.List;

import lombok.NonNull;
import xyz.flo.okcupidchallenge.data.OkCupidData;
import xyz.flo.okcupidchallenge.data.SerializedUser;
import xyz.flo.okcupidchallenge.data.User;
import xyz.flo.okcupidchallenge.data.UserMapper;

/**
 * An asynctask listener that maps the serialized user to the desired data we want to show and lets us know we are done loading.
 */
public class OkCupidTaskListener implements TaskListener<OkCupidData> {

    private final ObservableBoolean isLoading;
    private final MutableLiveData<List<User>> usersLiveData;
    private final UserMapper userMapper;

    public OkCupidTaskListener(@NonNull MutableLiveData<List<User>> usersLiveData, @NonNull ObservableBoolean isLoading) {
        this.usersLiveData = usersLiveData;
        this.isLoading = isLoading;

        userMapper = new UserMapper();
    }

    @Override
    public void onFinished(OkCupidData response) {
        if(response != null) {

            List<User> users = new ArrayList<>(response.getSerializedUsers().size());
            for (SerializedUser user : response.getSerializedUsers()) {
                users.add(userMapper.serializedUserToUser(user));
            }

            usersLiveData.setValue(users);
        }
        isLoading.set(false);
    }
}
