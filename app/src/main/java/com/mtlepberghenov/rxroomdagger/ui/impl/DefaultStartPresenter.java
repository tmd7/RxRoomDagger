package com.mtlepberghenov.rxroomdagger.ui.impl;

import com.mtlepberghenov.rxroomdagger.ui.StartPresenter;
import com.mtlepberghenov.rxroomdagger.ui.StartRepository;
import com.mtlepberghenov.rxroomdagger.ui.StartView;
import com.mtlepberghenov.rxroomdagger.ui.StartWireframe;

public class DefaultStartPresenter implements StartPresenter {
  private StartView view;
  private StartRepository repository;
  private StartWireframe wireframe;

  public DefaultStartPresenter(StartView view, StartRepository repository, StartWireframe wireframe) {
    this.view = view;
    this.repository = repository;
    this.wireframe = wireframe;
  }

  @Override public void onViewInitialised() {
    //todo
  }

  @Override public void onClick() {
    //todo
  }
}