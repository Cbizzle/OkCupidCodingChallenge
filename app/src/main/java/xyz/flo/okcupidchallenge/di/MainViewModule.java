package xyz.flo.okcupidchallenge.di;

import dagger.Module;
import dagger.Provides;
import xyz.flo.okcupidchallenge.view.MainActivity;
import xyz.flo.okcupidchallenge.view.MatchPagerAdapter;

@Module
public class MainViewModule {

    @Provides
    MatchPagerAdapter provideMatchPagerAdapter(MainActivity activity) {
        return new MatchPagerAdapter(activity.getSupportFragmentManager());
    }

}
