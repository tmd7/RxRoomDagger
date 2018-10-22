package com.mtlepberghenov.rxroomdagger.ui.impl;

import android.support.annotation.LayoutRes;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.mtlepberghenov.rxroomdagger.R;
import com.mtlepberghenov.rxroomdagger.StartActivity;
import com.mtlepberghenov.rxroomdagger.storage.entities.User;
import com.mtlepberghenov.rxroomdagger.ui.DefaultStartAdapter;
import com.mtlepberghenov.rxroomdagger.ui.StartClickHandler;
import com.mtlepberghenov.rxroomdagger.ui.StartNativeView;
import com.mtlepberghenov.rxroomdagger.ui.StartView;
import java.util.List;

public class DefaultStartView implements StartView, StartNativeView {

  private final DefaultStartAdapter adapter;
  @BindView(R.id.edit_text_surname) TextInputEditText surname;
  @BindView(R.id.edit_text_name) TextInputEditText name;
  @BindView(R.id.recycler_view) RecyclerView recyclerView;

  private StartClickHandler handler;

  public DefaultStartView(DefaultStartAdapter adapter) {
    this.adapter = adapter;
  }

  @LayoutRes
  @Override public int getLayout() {
    return R.layout.activity_start;
  }

  @Override public void initView(StartActivity activity) {
    ButterKnife.bind(this, activity);
    setList(activity);
  }

  @OnClick(R.id.main_button) public void onClick() {
    onClicked();
  }

  @Override public void setOnStartOnclickHandler(StartClickHandler handler) {
    this.handler = handler;
  }

  @Override public void updateView(List<User> users) {
    adapter.update(users);
  }

  private void onClicked() {
    if (handler != null) {
      User u = new User();
      u.setSurName(surname.getText().toString());
      u.setName(name.getText().toString());
      handler.onStartClicked(u);
    }
  }

  private void setList(StartActivity activity) {
    LinearLayoutManager llm = new LinearLayoutManager(activity);
    DividerItemDecoration did = new DividerItemDecoration(activity, llm.getOrientation());
    recyclerView.setLayoutManager(llm);
    recyclerView.addItemDecoration(did);
    recyclerView.setHasFixedSize(true);
    recyclerView.setAdapter(adapter);
  }
}
