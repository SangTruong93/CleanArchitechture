package namtran.cleanarchitechturesample.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import namtran.cleanarchitechturesample.application.mvvm.viewmodel.SoccerSeasonActivityModel;
import namtran.cleanarchitechturesample.application.mvvm.viewmodel.SoccerSeasonFragmentModel;
import namtran.cleanarchitechturesample.di.inject.ViewModelKey;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SoccerSeasonActivityModel.class)
    abstract ViewModel bindActivitySoccerSeasonViewModel(SoccerSeasonActivityModel model);

    @Binds
    @IntoMap
    @ViewModelKey(SoccerSeasonFragmentModel.class)
    abstract ViewModel bindFragmentSoccerSeasonViewModel(SoccerSeasonFragmentModel model);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
