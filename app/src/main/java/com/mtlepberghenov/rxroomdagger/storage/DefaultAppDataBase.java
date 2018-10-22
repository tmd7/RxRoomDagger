package com.mtlepberghenov.rxroomdagger.storage;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.mtlepberghenov.rxroomdagger.storage.dao.UserDao;
import com.mtlepberghenov.rxroomdagger.storage.entities.User;

@Database(entities = { User.class }, version = 1)
public abstract class DefaultAppDataBase extends RoomDatabase {
  public abstract UserDao userDao();
}
