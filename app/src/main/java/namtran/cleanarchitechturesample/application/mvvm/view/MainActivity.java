package namtran.cleanarchitechturesample.application.mvvm.view;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import namtran.cleanarchitechturesample.BR;
import namtran.cleanarchitechturesample.R;
import namtran.cleanarchitechturesample.application.core.BaseActivity;
import namtran.cleanarchitechturesample.application.mvvm.viewmodel.TestViewModel;
import namtran.cleanarchitechturesample.databinding.ActivityMainBinding;
import namtran.cleanarchitechturesample.flatform.Resource;
import namtran.cleanarchitechturesample.flatform.model.Test;
import namtran.cleanarchitechturesample.util.Logger;

public class MainActivity extends BaseActivity<ActivityMainBinding,TestViewModel> {

//    @Inject
//    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Override
    public TestViewModel getViewModel() {
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(TestViewModel.class);
        return mViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mViewModel.getTestData().observe(this, new Observer<Resource<List<Test>>>() {
            @Override
            public void onChanged(@Nullable Resource<List<Test>> listResource) {
                Logger.debug(listResource);
            }
        });
    }
}
