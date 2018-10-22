package com.mtlepberghenov.rxroomdagger.ui.impl;

import com.mtlepberghenov.rxroomdagger.storage.entities.User;
import com.mtlepberghenov.rxroomdagger.ui.StartPresenter;
import com.mtlepberghenov.rxroomdagger.ui.StartRepository;
import com.mtlepberghenov.rxroomdagger.ui.StartView;
import com.mtlepberghenov.rxroomdagger.ui.StartWireframe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

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
        .subscribeOn(Schedulers.computation())
        .subscribe(users -> {
          view.updateView(users);
        });
  }

  @Override public void onStartClicked(User u) {
    repository.insert(u)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.computation())
        .subscribe();
  }
}