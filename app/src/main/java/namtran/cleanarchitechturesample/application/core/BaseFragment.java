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

package namtran.cleanarchitechturesample.application.core;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

import javax.inject.Inject;
import javax.inject.Named;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Abstract Fragment for all Fragments and child Fragments to extend. This contains some boilerplate
 * dependency injection code and activity {@link Context}.
 * <p>
 * <b>DEPENDENCY INJECTION</b>
 * We could extend {@link dagger.android.DaggerFragment} so we can get the boilerplate
 * dagger code for free. However, we want to avoid inheritance (if possible and it is in this case)
 * so that we have to option to inherit from something else later on if needed.
 * <p>
 * <b>VIEW BINDING</b>
 * This fragment handles view bind and unbinding.
 */
public abstract class BaseFragment extends Fragment  implements HasSupportFragmentInjector {

    /**
     * A reference to the activity Context is injected and used instead of the getter method. This
     * enables ease of mocking and verification in tests (in case Activity needs testing).
     * More importantly, the getter method (getContext()) is not available for API level below 23.
     * We could use getActivity() though since that is available since API 11. However, exposing the
     * Activity reference is less safe than just exposing the Context since a lot more can be done
     * with the Activity reference.
     *
     * For more details, see https://github.com/vestrel00/android-dagger-butterknife-mvp/pull/52
     */
    @Inject
    protected Context activityContext;

    /**
     * A reference to the FragmentManager is injected and used instead of the getter method. This
     * enables ease of mocking and verification in tests (in case Fragment needs testing).
     *
     * For more details, see https://github.com/vestrel00/android-dagger-butterknife-mvp/pull/52
     */
    // Note that this should not be used within a child fragment.
    @Inject
    @Named(BaseFragmentModule.CHILD_FRAGMENT_MANAGER)
    protected FragmentManager childFragmentManager;

    @Inject
    DispatchingAndroidInjector<Fragment> childFragmentInjector;

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            // Perform injection here before M, L (API 22) and below because onAttach(Context)
            // is not yet available at L.
            AndroidSupportInjection.inject(this);
        }
        super.onAttach(activity);
    }

    @Override
    public void onAttach(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Perform injection here for M (API 23) due to deprecation of onAttach(Activity).
            AndroidSupportInjection.inject(this);
        }
        super.onAttach(context);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return childFragmentInjector;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getView() != null){
            getView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Nothing
                }
            });
        }
    }

    protected Activity getThis() {
        return getActivity();
    }

    protected final void addChildFragment(@IdRes int containerViewId, Fragment fragment) {
        childFragmentManager.beginTransaction()
                .add(containerViewId, fragment)
                .commit();
    }

    protected final void addFragment(@IdRes int containerViewId, Fragment fragment){
        if (getThis() instanceof BaseActivity){
            ((BaseActivity)getThis()).addFragment(containerViewId,fragment);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        detach();
    }

    protected abstract void detach();
}