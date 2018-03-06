package xyz.flo.okcupidchallenge;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import xyz.flo.okcupidchallenge.di.DaggerOkCupidAppComponent;

/**
 * The OkCupid application fit with dependency injection.
 * This app can:
 * Show you a variety of OkCupid users
 * Allows you to like them
 * Shows you the top liked matches.
 */
public class OkCupidApplication extends Application implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerOkCupidAppComponent.create().inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
