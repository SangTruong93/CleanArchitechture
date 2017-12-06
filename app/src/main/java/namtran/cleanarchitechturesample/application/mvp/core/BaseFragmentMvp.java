/*
 * Copyright 2017 Vandolf Estrellado
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package namtran.cleanarchitechturesample.application.mvp.core;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.wang.avi.AVLoadingIndicatorView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import namtran.cleanarchitechturesample.R;
import namtran.cleanarchitechturesample.application.core.BaseFragment;

/**
 * A {@link BaseFragment} that contains and invokes {@link Presenter} lifecycle invocations.
 *
 * @param <T> the type of the {@link Presenter}.
 */
public abstract class BaseFragmentMvp<T extends Presenter> extends BaseFragment
        implements MVPView {

    @Inject
    protected T presenter;

    private AVLoadingIndicatorView mProgressLoading;

    private TextView mTvError;

    protected View mContainSubView;

    protected abstract int setLayoutContainId();
    protected abstract void initData();

    @Nullable
    private Unbinder mUnbinder;

    @Override
    public void onShowLoading() {
        mProgressLoading.setVisibility(View.VISIBLE);
        mContainSubView.setVisibility(View.GONE);
    }

    @Override
    public void onHideLoading() {
        mProgressLoading.setVisibility(View.GONE);
        mContainSubView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onShowLoadingDialog() {

    }

    @Override
    public void onHideLoadingDialog() {

    }

    @Override
    public void onShowMessageError(Throwable cause) {

    }

    public void onLoadingEmpty(String error){
        if (mTvError != null){
            mTvError.setText(error);
            mTvError.setVisibility(View.VISIBLE);
            mProgressLoading.setVisibility(View.GONE);
            mContainSubView.setVisibility(View.GONE);
        }
    }

    public void onLoadingEmpty(@StringRes int error){
        if (mTvError != null){
            mTvError.setText(error);
            mTvError.setVisibility(View.VISIBLE);
            mProgressLoading.setVisibility(View.GONE);
            mContainSubView.setVisibility(View.GONE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater != null ? inflater.inflate(R.layout.base_progress_layout, container, false) : null;
        initProgress(inflater,view);
        return view;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        /*
         * Bind the views here instead of in onViewCreated so that view state changed listeners
         * are not invoked automatically without user interaction.
         *
         * If we bind before this method (e.g. onViewCreated), then any checked changed
         * listeners bound by ButterKnife will be invoked during fragment recreation (since
         * Android itself saves and restores the views' states. Take a look at this gist for a
         * concrete example: https://gist.github.com/vestrel00/982d585144423f728342787341fa001d
         *
         * The lifecycle order is as follows (same if added via xml or java or if retain
         * instance is true):
         *
         * onAttach
         * onCreateView
         * onViewCreated
         * onActivityCreated
         * onViewStateRestored
         * onResume
         *
         * Note that the onCreate (and other lifecycle events) are omitted on purpose. The
         * caveat to this approach is that views, listeners, and resources bound by
         * Butterknife will be null until onViewStatedRestored. Just be careful not to use any
         * objects bound using Butterknife before onViewStateRestored.
         *
         * Fragments that do not return a non-null IView in onCreateView results in onViewCreated
         * and onViewStateRestored not being called. This means that Butterknife.bind will not get
         * called, which is completely fine because there is no IView to bind. Furthermore, there is
         * no need to check if getView() returns null here because this lifecycle method only gets
         * called with a non-null IView.
         */
        mUnbinder = ButterKnife.bind(this, getView());
        presenter.onStart(savedInstanceState);
    }

    @Override
    public void onViewCreated(@Nullable View view, @Nullable Bundle savedInstanceState) {
        if (view != null) {
            super.onViewCreated(view, savedInstanceState);
            mUnbinder = ButterKnife.bind(this, view);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected void initProgress(LayoutInflater inflater, View view) {
        FrameLayout frameLayout = view.findViewById(R.id.contain_fragment);
        mProgressLoading = view.findViewById(R.id.progress_loading);
        mTvError = view.findViewById(R.id.tv_error);
        mContainSubView = inflater.inflate(setLayoutContainId(), frameLayout, false);
        frameLayout.addView(mContainSubView);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @CallSuper
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        presenter.onEnd();
        // This lifecycle method still gets called even if onCreateView returns a null view.
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroyView();
    }
}