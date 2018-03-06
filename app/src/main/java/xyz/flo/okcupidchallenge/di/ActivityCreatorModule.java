package xyz.flo.okcupidchallenge.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import xyz.flo.okcupidchallenge.view.MainActivity;

@Module
public abstract class ActivityCreatorModule {

    @ContributesAndroidInjector(modules = {MainViewModule.class,
            BlendFragmentProviderModule.class,
            TopMatchFragmentProviderModule.class})
    abstract MainActivity contributeActivityInjector();

}
