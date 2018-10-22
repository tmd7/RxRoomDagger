package com.mtlepberghenov.rxroomdagger;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.mtlepberghenov.rxroomdagger.storage.DefaultAppDataBase;
import com.mtlepberghenov.rxroomdagger.ui.DefaultStartAdapter;
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
    final DefaultStartAdapter adapter = new DefaultStartAdapter();
    final DefaultStartView view = new DefaultStartView(adapter);
    nativeView = view;
    final StartWireframe wireframe = new DefaultStartWireframe(this);
    final DefaultAppDataBase appDb = Room
        .databaseBuilder(getApplicationContext(), DefaultAppDataBase.class, "main")
        .build();
    final StartRepository repository = new DefaultStartRepository(appDb);
    presenter = new DefaultStartPresenter(view, repository, wireframe);
    setContentView(nativeView.getLayout());
  }

  @Override public void onContentChanged() {
    super.onContentChanged();
    nativeView.initView(this);
    presenter.onViewInitialised();
  }
}
