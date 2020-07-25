package com.example.checkapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetDialogView extends BottomSheetDialogFragment {
  private static final String BUNDLE_KEY_THEME = "theme";
  private BottomSheetInteractionListener listener;

  public static BottomSheetDialogView newInstance(int theme) {
    BottomSheetDialogView bottomSheetDialogView = new BottomSheetDialogView();
    Bundle args = new Bundle();
    args.putInt(BUNDLE_KEY_THEME, theme);
    bottomSheetDialogView.setArguments(args);
    return bottomSheetDialogView;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

        setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogStyle);

  }

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.country_picker, container, false);
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    listener.initiateUi(view);
    listener.setCustomStyle(view);
    listener.setSearchEditText();
    listener.setupRecyclerView(view);
  }

  public void setListener(BottomSheetInteractionListener listener) {
    this.listener = listener;
  }
}
