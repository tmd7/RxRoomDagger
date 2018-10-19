package com.mtlepberghenov.rxroomdagger.ui.impl;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import com.mtlepberghenov.rxroomdagger.R;
import com.mtlepberghenov.rxroomdagger.ui.StartNativeView;
import com.mtlepberghenov.rxroomdagger.ui.StartView;

public class DefaultStartView implements StartView, StartNativeView {

  @LayoutRes
  @Override public int getLayout() {
    return R.layout.activity_start;
  }

  @Override public void initView(Activity activity) {

  }

}
