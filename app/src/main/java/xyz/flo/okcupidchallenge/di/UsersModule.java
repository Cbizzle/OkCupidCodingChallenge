package xyz.flo.okcupidchallenge.di;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import xyz.flo.okcupidchallenge.view.BlendAdapter;
import xyz.flo.okcupidchallenge.view.BlendFragment;
import xyz.flo.okcupidchallenge.view.TopMatchAdapter;

@Module
public class UsersModule {

    @Provides
    BlendAdapter provideBlendAdapter() {
        return new BlendAdapter(new ArrayList<>());
    }

    @Provides
    TopMatchAdapter provideTopMatchAdapter() {
        return new TopMatchAdapter(new ArrayList<>());
    }

}
