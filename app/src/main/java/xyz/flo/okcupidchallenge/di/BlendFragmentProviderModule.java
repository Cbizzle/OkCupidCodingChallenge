package xyz.flo.okcupidchallenge.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import xyz.flo.okcupidchallenge.view.BlendFragment;

@Module
public abstract class BlendFragmentProviderModule {

    @ContributesAndroidInjector(modules = {UsersModule.class, BlendViewModule.class})
    abstract BlendFragment provideBlendFragment();
}
