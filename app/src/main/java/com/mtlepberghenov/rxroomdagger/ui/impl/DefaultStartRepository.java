package com.mtlepberghenov.rxroomdagger.ui.impl;

import com.mtlepberghenov.rxroomdagger.storage.dao.StartDao;
import com.mtlepberghenov.rxroomdagger.storage.entities.User;
import com.mtlepberghenov.rxroomdagger.ui.StartRepository;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.List;

public class DefaultStartRepository implements StartRepository {

  private StartDao dao;

  public DefaultStartRepository(StartDao dao) {
    this.dao = dao;
  }

  @Override public void insert(User u) {
    dao.insert(u);
  }

  @Override public Flowable<List<User>> get() {
    return dao.get();
  }

  @Override public void request() {

  }
}
