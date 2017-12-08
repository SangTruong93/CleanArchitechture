/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package namtran.cleanarchitechturesample.domain.interactor.core;

import io.reactivex.observers.DisposableObserver;
import io.reactivex.subscribers.DisposableSubscriber;
import namtran.cleanarchitechturesample.application.mvp.core.MVPView;
import namtran.cleanarchitechturesample.util.Logger;

/**
 * Default {@link DisposableObserver} base class to be used whenever you want default error handling.
 */
public abstract class DefaultMvpObserve<T,V extends MVPView> extends DisposableObserver<T> {

  protected V view;

  public DefaultMvpObserve(V v) {
    this.view = v;
  }

  @Override
  protected void onStart() {
    view.onShowLoading();
  }

  @Override
  public void onError(Throwable t) {
    view.onShowMessageError(t);
    view.onHideLoading();
    Logger.debug(t);
  }

  @Override
  public void onComplete() {
    view.onHideLoading();
  }
}
