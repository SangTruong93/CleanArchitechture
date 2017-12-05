/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package namtran.cleanarchitechturesample.application.core;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.ViewModelProvider;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import namtran.cleanarchitechturesample.application.mvvm.viewmodel.core.BaseViewModel;

@SuppressWarnings("unused")
public abstract class BaseFragment<T extends ViewDataBinding, V extends BaseViewModel> extends Fragment {

    /**
     * MVVM ViewModel ViewModelProvider.Factory
     */
    @Inject
    protected ViewModelProvider.Factory mViewModelFactory;

    /**
     * Visible, for lazy loading
     */
    protected boolean mVisible = false;
    /**
     * Whether to load for the first time, for lazy loading
     */
    protected boolean mFirst = true;

    private BaseActivity mActivity;
    private T mViewDataBinding;
    private V mViewModel;
    private View mRootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        performDependencyInjection();
        super.onCreate(savedInstanceState);
        mViewModel = getViewModel();
        setHasOptionsMenu(false);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        mRootView = mViewDataBinding.getRoot();
        if (mViewModel != null) {
            getLifecycle().addObserver((LifecycleObserver) mViewModel);
        }
        //Visible, and is the first time to load
        if (mVisible && mFirst) {
            onFragmentVisibleChange(true);
        }
        return mRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.executePendingBindings();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        mVisible = isVisibleToUser;
        if (mRootView == null) {
            return;
        }
        //Visible, and the first time loading is called
        onFragmentVisibleChange(mVisible & mFirst);
    }

    /**
     * The current Fragment visible state changes will be called back to the method.
     * If the current Fragment is the first load, waiting onCreateView callback method,
     * Callback timing is otherwise the same as {@link #setUserVisibleHint (boolean)}
     * In the callback method you can do some loading data operations, or even the operation of the control.
     *
     * @param isVisible true not visible -> visible
     *                   false visible -> not visible
     */
    protected abstract void onFragmentVisibleChange(boolean isVisible);

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mViewDataBinding = null;
        this.mRootView = null;
        this.mViewModelFactory = null;
        this.mViewModel = null;
    }

    public BaseActivity getThis() {
        return mActivity;
    }

    public T getViewDataBinding() {
        return mViewDataBinding;
    }

    private void performDependencyInjection() {
        AndroidSupportInjection.inject(this);
    }

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    public abstract V getViewModel();

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public abstract int getBindingVariable();

    /**
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutId();
}
