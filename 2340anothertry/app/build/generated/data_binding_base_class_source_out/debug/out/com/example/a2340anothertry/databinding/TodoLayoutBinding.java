// Generated by view binder compiler. Do not edit!
package com.example.a2340anothertry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.a2340anothertry.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class TodoLayoutBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView Date;

  @NonNull
  public final TextView Description;

  @NonNull
  public final TextView Name;

  @NonNull
  public final TextView Time;

  @NonNull
  public final Button button5;

  @NonNull
  public final LinearLayout linearLayout;

  private TodoLayoutBinding(@NonNull ConstraintLayout rootView, @NonNull TextView Date,
      @NonNull TextView Description, @NonNull TextView Name, @NonNull TextView Time,
      @NonNull Button button5, @NonNull LinearLayout linearLayout) {
    this.rootView = rootView;
    this.Date = Date;
    this.Description = Description;
    this.Name = Name;
    this.Time = Time;
    this.button5 = button5;
    this.linearLayout = linearLayout;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static TodoLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TodoLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.todo_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TodoLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Date;
      TextView Date = ViewBindings.findChildViewById(rootView, id);
      if (Date == null) {
        break missingId;
      }

      id = R.id.Description;
      TextView Description = ViewBindings.findChildViewById(rootView, id);
      if (Description == null) {
        break missingId;
      }

      id = R.id.Name;
      TextView Name = ViewBindings.findChildViewById(rootView, id);
      if (Name == null) {
        break missingId;
      }

      id = R.id.Time;
      TextView Time = ViewBindings.findChildViewById(rootView, id);
      if (Time == null) {
        break missingId;
      }

      id = R.id.button5;
      Button button5 = ViewBindings.findChildViewById(rootView, id);
      if (button5 == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      return new TodoLayoutBinding((ConstraintLayout) rootView, Date, Description, Name, Time,
          button5, linearLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
