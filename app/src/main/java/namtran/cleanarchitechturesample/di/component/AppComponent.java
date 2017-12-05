package namtran.cleanarchitechturesample.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import namtran.cleanarchitechturesample.application.Appstate;
import namtran.cleanarchitechturesample.di.builder.ActivityBuilder;
import namtran.cleanarchitechturesample.di.module.AppModule;
import namtran.cleanarchitechturesample.di.module.NetModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        NetModule.class,
        ActivityBuilder.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance Builder application(Application application);
        AppComponent build();
    }

    void inject(Appstate appstate);
}
