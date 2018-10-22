package com.mtlepberghenov.rxroomdagger.ui;

import com.mtlepberghenov.rxroomdagger.storage.entities.User;
import io.reactivex.Flowable;
import java.util.List;

public interface StartRepository {

  void insert(User u);

  Flowable<List<User>> get();

  void request();
}
