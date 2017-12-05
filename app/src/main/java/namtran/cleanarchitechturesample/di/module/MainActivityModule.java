package namtran.cleanarchitechturesample.di.module;


import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Module;
import dagger.Provides;
import namtran.cleanarchitechturesample.application.mvvm.viewmodel.TestViewModel;
import namtran.cleanarchitechturesample.domain.interactor.GetTestData;

@Module
public class MainActivityModule {

    @Provides
    TestViewModel provideTestViewModel(Application application, GetTestData getDataTest) {
        return new TestViewModel(application,getDataTest);
    }

    @Provides
    ViewModelProvider.Factory mainViewModelProvider(TestViewModel testViewModel) {
        return new ViewModelProviderFactory<>(testViewModel);
    }
}
