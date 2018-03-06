package xyz.flo.okcupidchallenge.di;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import xyz.flo.okcupidchallenge.OkCupidApplication;

@Component(modules = {
        AndroidInjectionModule.class,
        OkCupidAppModule.class,
        ActivityCreatorModule.class
})
public interface OkCupidAppComponent extends AndroidInjector<OkCupidApplication> {

}
