package xyz.flo.okcupidchallenge.di;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import xyz.flo.okcupidchallenge.view.BlendFragment;

@Module
public class BlendViewModule {

    @Provides
    @Named("span_2_grid")
    LinearLayoutManager providesLinearLayoutManager(BlendFragment fragment) {
        return new GridLayoutManager(fragment.getContext(), 2, GridLayoutManager.VERTICAL, false);
    }
}
