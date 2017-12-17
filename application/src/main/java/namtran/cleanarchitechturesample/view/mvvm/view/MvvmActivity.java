package namtran.cleanarchitechturesample.view.mvvm.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import namtran.cleanarchitechturesample.R;
import namtran.cleanarchitechturesample.view.mvvm.core.BaseActivityMvvm;
import namtran.cleanarchitechturesample.view.mvvm.view.callback.SoccerSeasonMvvmFragmentCallback;
import namtran.cleanarchitechturesample.view.mvvm.view.callback.TeamMvvmFragmentCallback;
import namtran.cleanarchitechturesample.view.mvvm.viewmodel.MvvmActivityModel;
import namtran.cleanarchitechturesample.databinding.ActivitySoccerSeasonMvvmBinding;

public class MvvmActivity extends BaseActivityMvvm<ActivitySoccerSeasonMvvmBinding,MvvmActivityModel> implements SoccerSeasonMvvmFragmentCallback,TeamMvvmFragmentCallback {

    @Override
    public int getLayoutId() {
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MvvmActivityModel.class);
        return R.layout.activity_soccer_season_mvvm;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setSupportActionBar(mViewDataBinding.toolbar);
        addFragment(R.id.contain_main,new SoccerSeasonMvvmFragment());
//        mViewModel.getResults().observe(this, new Observer<Resource<List<SoccerSeason>>>() {
//            @Override
//            public void onChanged(@Nullable Resource<List<SoccerSeason>> listResource) {
//                Logger.debug(listResource);
//            }
//        });
    }

    @Override
    public void onSoccerSeasonMvvmFragmentCallback() {
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("Soccer Season ( Mvvm )");
    }

    @Override
    protected void detach() {
        mViewModel.detach();
    }

    @Override
    public void onTeamMvvmFragmentCallback(String seasionName) {
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("List Team of " + seasionName + " ( Mvvm )");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Fragment fragment = fragmentManager.findFragmentById(R.id.contain_main);
        if (fragment != null)
            fragment.onResume();
        else
            finish();
    }
}
