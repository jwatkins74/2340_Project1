// Generated by view binder compiler. Do not edit!
package com.example.a2340anothertry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

public final class FragmentABinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView aText;

  @NonNull
  public final Button button6;

  @NonNull
  public final EditText description;

  @NonNull
  public final EditText name1;

  @NonNull
  public final Button pickDate;

  @NonNull
  public final Button pickTime;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView5;

  private FragmentABinding(@NonNull ConstraintLayout rootView, @NonNull TextView aText,
      @NonNull Button button6, @NonNull EditText description, @NonNull EditText name1,
      @NonNull Button pickDate, @NonNull Button pickTime, @NonNull TextView textView4,
      @NonNull TextView textView5) {
    this.rootView = rootView;
    this.aText = aText;
    this.button6 = button6;
    this.description = description;
    this.name1 = name1;
    this.pickDate = pickDate;
    this.pickTime = pickTime;
    this.textView4 = textView4;
    this.textView5 = textView5;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentABinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentABinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_a, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentABinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.a_text;
      TextView aText = ViewBindings.findChildViewById(rootView, id);
      if (aText == null) {
        break missingId;
      }

      id = R.id.button6;
      Button button6 = ViewBindings.findChildViewById(rootView, id);
      if (button6 == null) {
        break missingId;
      }

      id = R.id.description;
      EditText description = ViewBindings.findChildViewById(rootView, id);
      if (description == null) {
        break missingId;
      }

      id = R.id.name1;
      EditText name1 = ViewBindings.findChildViewById(rootView, id);
      if (name1 == null) {
        break missingId;
      }

      id = R.id.pickDate;
      Button pickDate = ViewBindings.findChildViewById(rootView, id);
      if (pickDate == null) {
        break missingId;
      }

      id = R.id.pickTime;
      Button pickTime = ViewBindings.findChildViewById(rootView, id);
      if (pickTime == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = ViewBindings.findChildViewById(rootView, id);
      if (textView5 == null) {
        break missingId;
      }

      return new FragmentABinding((ConstraintLayout) rootView, aText, button6, description, name1,
          pickDate, pickTime, textView4, textView5);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
