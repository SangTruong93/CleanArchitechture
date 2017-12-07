package namtran.cleanarchitechturesample.application.mvvm.view;


import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import namtran.cleanarchitechturesample.R;
import namtran.cleanarchitechturesample.application.mvvm.core.BaseFragmentMvvm;
import namtran.cleanarchitechturesample.application.mvvm.viewmodel.SoccerSeasonFragmentModel;
import namtran.cleanarchitechturesample.databinding.FragmentMvvmSoccerSeasonBinding;
import namtran.cleanarchitechturesample.util.Logger;

public class SoccerSeasonMvvmFragment extends BaseFragmentMvvm<FragmentMvvmSoccerSeasonBinding,SoccerSeasonFragmentModel> {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mvvm_soccer_season;
    }

    @Override
    public void initViewModel(ViewModelProvider.Factory factory) {
        mViewModel = ViewModelProviders.of(getThis(),factory).get(SoccerSeasonFragmentModel.class);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        Logger.debug();
    }


}
