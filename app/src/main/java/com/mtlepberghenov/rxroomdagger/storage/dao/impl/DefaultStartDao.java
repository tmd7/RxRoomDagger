package com.mtlepberghenov.rxroomdagger.storage.dao.impl;

import com.mtlepberghenov.rxroomdagger.storage.DefaultAppDataBase;
import com.mtlepberghenov.rxroomdagger.storage.dao.StartDao;
import com.mtlepberghenov.rxroomdagger.storage.entities.User;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import java.util.List;

public class DefaultStartDao implements StartDao {

  private DefaultAppDataBase appDb;

  public DefaultStartDao(DefaultAppDataBase appDb) {
    this.appDb = appDb;
  }

  @Override public Completable insert(final User u) {
    return new Completable() {
      @Override protected void subscribeActual(CompletableObserver observer) {
        appDb.userDao().insert(u);
      }
    };
  }

  @Override public Flowable<List<User>> get() {
    return appDb.userDao().getAll();
  }
}
