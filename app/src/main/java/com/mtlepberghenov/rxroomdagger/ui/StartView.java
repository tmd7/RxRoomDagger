package com.mtlepberghenov.rxroomdagger.ui;

import com.mtlepberghenov.rxroomdagger.storage.entities.User;
import java.util.List;

public interface StartView {
  void setOnStartOnclickHandler(StartClickHandler handler);

  void updateView(List<User> users);
}
