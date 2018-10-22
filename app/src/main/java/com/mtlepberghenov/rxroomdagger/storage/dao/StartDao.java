package com.mtlepberghenov.rxroomdagger.storage.dao;

import com.mtlepberghenov.rxroomdagger.storage.entities.User;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import java.util.List;

public interface StartDao {

  Completable insert(User u);

  Flowable<List<User>> get();
}
