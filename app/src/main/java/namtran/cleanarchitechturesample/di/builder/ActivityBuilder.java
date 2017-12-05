package namtran.cleanarchitechturesample.di.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import namtran.cleanarchitechturesample.application.mvvm.view.MainActivity;
import namtran.cleanarchitechturesample.di.module.MainActivityModule;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();

}
