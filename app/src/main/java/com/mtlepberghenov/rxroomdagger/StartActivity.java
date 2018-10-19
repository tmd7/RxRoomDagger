package com.mtlepberghenov.rxroomdagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.mtlepberghenov.rxroomdagger.ui.StartNativeView;
import com.mtlepberghenov.rxroomdagger.ui.StartPresenter;
import com.mtlepberghenov.rxroomdagger.ui.StartRepository;
import com.mtlepberghenov.rxroomdagger.ui.StartWireframe;
import com.mtlepberghenov.rxroomdagger.ui.impl.DefaultStartPresenter;
import com.mtlepberghenov.rxroomdagger.ui.impl.DefaultStartRepository;
import com.mtlepberghenov.rxroomdagger.ui.impl.DefaultStartView;
import com.mtlepberghenov.rxroomdagger.ui.impl.DefaultStartWireframe;

public class StartActivity extends AppCompatActivity {

  private StartNativeView nativeView;
  private StartPresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    final DefaultStartView view = new DefaultStartView();
    nativeView = view;
    final StartWireframe wireframe = new DefaultStartWireframe(this);
    final StartRepository repository = new DefaultStartRepository();
    presenter = new DefaultStartPresenter(view, repository, wireframe);
    setContentView(nativeView.getLayout());
  }

  @Override public void onContentChanged() {
    super.onContentChanged();
    nativeView.initView(this);
    presenter.onViewInitialised();
  }
}
