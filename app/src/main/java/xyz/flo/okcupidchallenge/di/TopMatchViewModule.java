package xyz.flo.okcupidchallenge.di;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import xyz.flo.okcupidchallenge.view.TopMatchFragment;

@Module
public class TopMatchViewModule {

    @Provides
    @Named("span_2_grid")
    LinearLayoutManager providesLinearLayoutManager(TopMatchFragment fragment) {
        return new GridLayoutManager(fragment.getContext(), 2, GridLayoutManager.VERTICAL, false);
    }
}
