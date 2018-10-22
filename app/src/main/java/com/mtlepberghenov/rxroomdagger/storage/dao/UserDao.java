package com.mtlepberghenov.rxroomdagger.storage.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.mtlepberghenov.rxroomdagger.storage.entities.User;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import java.util.List;

@Dao
public interface UserDao {

  @Query("SELECT * FROM user") Flowable<List<User>> getAll();
  @Insert Completable insert(User u);
}
