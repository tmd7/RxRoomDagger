package com.mtlepberghenov.rxroomdagger.ui.impl;

import com.mtlepberghenov.rxroomdagger.storage.dao.StartDao;
import com.mtlepberghenov.rxroomdagger.ui.StartRepository;
import java.util.List;

public class DefaultStartRepository implements StartRepository {

  private StartDao dao;

  public DefaultStartRepository(StartDao dao) {
    this.dao = dao;
  }

  @Override public void insert() {
    dao.insert();
  }

  @Override public List get() {
    return dao.get();
  }

  @Override public void request() {

  }
}
