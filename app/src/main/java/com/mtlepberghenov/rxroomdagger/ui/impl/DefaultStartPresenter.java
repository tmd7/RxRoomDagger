package com.mtlepberghenov.rxroomdagger.ui.impl;

import com.mtlepberghenov.rxroomdagger.storage.entities.User;
import com.mtlepberghenov.rxroomdagger.ui.StartPresenter;
import com.mtlepberghenov.rxroomdagger.ui.StartRepository;
import com.mtlepberghenov.rxroomdagger.ui.StartView;
import com.mtlepberghenov.rxroomdagger.ui.StartWireframe;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class DefaultStartPresenter implements StartPresenter {
  private StartView view;
  private StartRepository repository;
  private StartWireframe wireframe;

  public DefaultStartPresenter(StartView view, StartRepository repository,
      StartWireframe wireframe) {
    this.view = view;
    this.repository = repository;
    this.wireframe = wireframe;
  }

  @Override public void onViewInitialised() {
    view.setOnStartOnclickHandler(this);
    repository.get()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(users -> {
          view.updateView(users);
        });
  }

  @Override public void onStartClicked(User u) {
    Completable.fromAction(new Action() {
      @Override public void run() throws Exception {
        repository.insert(u);
      }
    }).subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe(new CompletableObserver() {
        @Override public void onSubscribe(Disposable d) {

        }

        @Override public void onComplete() {
          Timber.d("done");
        }

        @Override public void onError(Throwable e) {

        }
      });
  }
}