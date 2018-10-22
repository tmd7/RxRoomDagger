package com.mtlepberghenov.rxroomdagger.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mtlepberghenov.rxroomdagger.R;
import com.mtlepberghenov.rxroomdagger.storage.entities.User;
import java.util.ArrayList;
import java.util.List;

public class DefaultStartAdapter
    extends RecyclerView.Adapter<DefaultStartAdapter.ViewHolder>
    implements StartAdapter {

  private List<User> users = new ArrayList<>();

  @Override public void update(List<User> users) {
    this.users.clear();
    this.users.addAll(users);
    notifyDataSetChanged();
  }

  @NonNull @Override public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View v = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.item, viewGroup, false);
    return new ViewHolder(v);
  }

  @Override public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
    viewHolder.bind(users.get(i));
  }

  @Override public int getItemCount() {
    return users.size();
  }

  static class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_text_view) TextView itemTextView;
    @BindString(R.string.item_text) String itemText;

    public ViewHolder(@NonNull View v) {
      super(v);
      ButterKnife.bind(this, v);
    }

    public void bind(User user) {
      StringBuilder sb = new StringBuilder();
      //String itemText = itemTextView.getContext().getString(R.string.item_text);
      sb.append(String.format(itemText, String.valueOf(user.getUid()), user.getSurName(), user.getName()));
      itemTextView.setText(sb.toString());
      sb.delete(0, sb.length());
    }
  }
}
