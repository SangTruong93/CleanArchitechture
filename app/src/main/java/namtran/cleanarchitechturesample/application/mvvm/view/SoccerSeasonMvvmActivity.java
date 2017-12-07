package namtran.cleanarchitechturesample.application.mvvm.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import namtran.cleanarchitechturesample.R;
import namtran.cleanarchitechturesample.application.mvvm.core.BaseActivityMvvm;
import namtran.cleanarchitechturesample.application.mvvm.viewmodel.SoccerSeasonActivityModel;
import namtran.cleanarchitechturesample.databinding.ActivitySoccerSeasonMvvmBinding;

public class SoccerSeasonMvvmActivity extends BaseActivityMvvm<ActivitySoccerSeasonMvvmBinding,SoccerSeasonActivityModel> {

    @Override
    public int getLayoutId() {
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(SoccerSeasonActivityModel.class);
        return R.layout.activity_soccer_season_mvvm;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        addFragment(R.id.contain_main,new SoccerSeasonMvvmFragment());
//        mViewModel.getResults().observe(this, new Observer<Resource<List<SoccerSeason>>>() {
//            @Override
//            public void onChanged(@Nullable Resource<List<SoccerSeason>> listResource) {
//                Logger.debug(listResource);
//            }
//        });
    }
}
