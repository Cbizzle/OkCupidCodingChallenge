package xyz.flo.okcupidchallenge.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import xyz.flo.okcupidchallenge.tasks.OkCupidAsyncTask;
import xyz.flo.okcupidchallenge.tasks.OkCupidTaskListener;
import xyz.flo.okcupidchallenge.data.User;


/**
 * The ViewModel that exposes the OkCupid user data to the views needing it
 */
public class OkCupidViewModel extends ViewModel {

    //The amount of top liked users to be displayed
    private static final int TOP_MATCH_AMOUNT = 6;

    //List of all users
    private final MutableLiveData<List<User>> users = new MutableLiveData<>();

    //List of the top liked users sorted
    private final MutableLiveData<List<User>> topMatches = new MutableLiveData<>();

    //Used for progressbar loading visibility
    private ObservableBoolean isLoading = new ObservableBoolean(false);


    public OkCupidViewModel() {
        isLoading.set(true);
        final OkCupidTaskListener okCupidTaskListener = new OkCupidTaskListener(users, isLoading);
        topMatches.setValue(new ArrayList<>());

        OkCupidAsyncTask okCupidAsyncTask = new OkCupidAsyncTask("https://www.okcupid.com/matchSample.json", okCupidTaskListener);
        okCupidAsyncTask.execute();
    }

    public ObservableBoolean getIsLoading() {
        return this.isLoading;
    }

    public LiveData<List<User>> getUsers() {
        return users;
    }

    public LiveData<List<User>> getTopMatches() {
        return topMatches;
    }

    public LikeClickListener getLikeListener() {
        return likeClickListener;
    }


    /**
     * The like click listener that sets the value of a user to like and alerts anyone observing that user list of the change.
     */
    private final LikeClickListener likeClickListener = (user) -> {
        if (topMatches.getValue() == null) {
            return;
        }

        if (!user.isLiked()) {
            user.like();

            //quick check to see if user can get into top matches
            if(!topMatches.getValue().isEmpty() &&
                    topMatches.getValue().size() >= TOP_MATCH_AMOUNT &&
                    user.getMatch() < topMatches.getValue().get(topMatches.getValue().size() - 1).getMatch()) {
                return;
            }

            List<User> sortList = new ArrayList<>(topMatches.getValue());
            sortList.add(user);
            Collections.sort(sortList);

            int chooseAmount = sortList.size() < TOP_MATCH_AMOUNT ? sortList.size() : TOP_MATCH_AMOUNT;

            topMatches.setValue(sortList.subList(0, chooseAmount));
        }
    };
}
