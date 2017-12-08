package namtran.cleanarchitechturesample.application.mvvm.view;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;

import java.util.List;

import javax.inject.Inject;

import namtran.cleanarchitechturesample.R;
import namtran.cleanarchitechturesample.application.adapter.SoccerSeasonAdapter;
import namtran.cleanarchitechturesample.application.mvvm.core.BaseFragmentMvvm;
import namtran.cleanarchitechturesample.application.mvvm.view.callback.SoccerSeasonMvvmFragmentCallback;
import namtran.cleanarchitechturesample.application.mvvm.viewmodel.SoccerSeasonFragmentModel;
import namtran.cleanarchitechturesample.databinding.FragmentMvvmSoccerSeasonBinding;
import namtran.cleanarchitechturesample.flatform.Resource;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeason;

public class SoccerSeasonMvvmFragment extends BaseFragmentMvvm<FragmentMvvmSoccerSeasonBinding,SoccerSeasonFragmentModel> implements SoccerSeasonAdapter.OnSoccerSeasonItemClick {

    @Inject
    SoccerSeasonAdapter mAdapter;
    @Inject
    SoccerSeasonMvvmFragmentCallback listener;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mvvm_soccer_season;
    }

    @Override
    public void initViewModel(ViewModelProvider.Factory factory) {
        mViewModel = ViewModelProviders.of(this,factory).get(SoccerSeasonFragmentModel.class);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mAdapter.setOnSoccerSeasonItemClick(this);
        mViewDataBinding.rvSoccerSeason.addItemDecoration(new DividerItemDecoration(getThis(), DividerItemDecoration.VERTICAL));
        mViewDataBinding.rvSoccerSeason.setAdapter(mAdapter);
        mViewModel.getResults().observe(this, new Observer<Resource<List<SoccerSeason>>>() {
            @Override
            public void onChanged(@Nullable Resource<List<SoccerSeason>> listResource) {
                mViewDataBinding.setResource(listResource);
                mViewDataBinding.executePendingBindings();
                if (listResource != null && listResource.data != null) {
                    mAdapter.updateData(listResource.data);
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        listener.onSoccerSeasonMvvmFragmentCallback();
    }

    @Override
    public void onSoccerSeasonItemClick(SoccerSeason data) {
        addFragment(R.id.contain_main,TeamMvvmFragment.getInstance(data.id,data.league));
    }

    @Override
    protected void detach() {
        mViewModel.detach();
    }
}
