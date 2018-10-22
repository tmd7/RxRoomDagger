package com.mtlepberghenov.rxroomdagger.ui;

import com.mtlepberghenov.rxroomdagger.storage.entities.User;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import java.util.List;

public interface StartRepository {

  Completable insert(User u);

  Flowable<List<User>> get();

  void request();
}
