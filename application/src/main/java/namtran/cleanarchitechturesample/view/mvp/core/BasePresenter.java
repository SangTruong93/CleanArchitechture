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

package namtran.cleanarchitechturesample.view.mvp.core;

import android.os.Bundle;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

/**
 * Abstract {@link Presenter} for all presenters to extend.
 *
 * @param <V> the type of the {@link MVPView}.
 */
public abstract class BasePresenter<V extends MVPView> implements Presenter<V> {

    private WeakReference<V> viewRef;

    public BasePresenter(V viewRef) {
        attachView(viewRef);
    }

    protected V getMvpView() {
        return viewRef == null ? null : viewRef.get();
    }

    protected boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }


    private void attachView(V view) {
        this.viewRef = new WeakReference<>(view);
    }

    protected void detachView() {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }

    @Override
    public void onStart(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onEnd() {

    }
}