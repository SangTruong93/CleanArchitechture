package namtran.cleanarchitechturesample.di.component;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import namtran.cleanarchitechturesample.application.AppState;
import namtran.cleanarchitechturesample.di.module.AppModule;

@Singleton
@Component(modules = { AppModule.class })
public interface AppComponent extends AndroidInjector<AppState> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<AppState> {
    }
}
