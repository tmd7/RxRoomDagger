package com.mtlepberghenov.rxroomdagger.ui.impl;

import com.mtlepberghenov.rxroomdagger.storage.DefaultAppDataBase;
import com.mtlepberghenov.rxroomdagger.storage.entities.User;
import com.mtlepberghenov.rxroomdagger.ui.StartRepository;
import io.reactivex.Flowable;
import java.util.List;

public class DefaultStartRepository implements StartRepository {

  private DefaultAppDataBase dao;

  public DefaultStartRepository(DefaultAppDataBase dao) {
    this.dao = dao;
  }

  @Override public void insert(User u) {
    dao.userDao().insert(u);
  }

  @Override public Flowable<List<User>> get() {
    return dao.userDao().getAll();
  }

  @Override public void request() {

  }
}
