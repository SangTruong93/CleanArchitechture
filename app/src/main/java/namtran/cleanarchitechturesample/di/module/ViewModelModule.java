package namtran.cleanarchitechturesample.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import namtran.cleanarchitechturesample.application.mvvm.viewmodel.MvvmActivityModel;
import namtran.cleanarchitechturesample.application.mvvm.viewmodel.SoccerSeasonFragmentModel;
import namtran.cleanarchitechturesample.application.mvvm.viewmodel.TeamFragmentModel;
import namtran.cleanarchitechturesample.di.inject.ViewModelKey;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MvvmActivityModel.class)
    abstract ViewModel bindActivitySoccerSeasonViewModel(MvvmActivityModel model);

    @Binds
    @IntoMap
    @ViewModelKey(SoccerSeasonFragmentModel.class)
    abstract ViewModel bindFragmentSoccerSeasonViewModel(SoccerSeasonFragmentModel model);

    @Binds
    @IntoMap
    @ViewModelKey(TeamFragmentModel.class)
    abstract ViewModel bindFragmentTeamViewModel(TeamFragmentModel model);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
