package xyz.flo.okcupidchallenge.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import xyz.flo.okcupidchallenge.view.TopMatchFragment;

@Module
public abstract class TopMatchFragmentProviderModule {

    @ContributesAndroidInjector(modules = {UsersModule.class, TopMatchViewModule.class})
    abstract TopMatchFragment provideTopMatchFragment();
}
