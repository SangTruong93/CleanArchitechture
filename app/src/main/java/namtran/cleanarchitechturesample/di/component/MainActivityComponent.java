package namtran.cleanarchitechturesample.di.component;


import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import namtran.cleanarchitechturesample.application.mvvm.view.MainActivity;
import namtran.cleanarchitechturesample.di.module.MainActivityModule;

@Subcomponent(modules = MainActivityModule.class)
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{}
}
