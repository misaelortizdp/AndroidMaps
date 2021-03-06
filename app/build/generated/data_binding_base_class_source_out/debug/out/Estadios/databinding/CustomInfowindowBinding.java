// Generated by view binder compiler. Do not edit!
package Estadios.databinding;

import Estadios.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CustomInfowindowBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView markerDescription;

  @NonNull
  public final TextView markerTitle;

  private CustomInfowindowBinding(@NonNull RelativeLayout rootView,
      @NonNull TextView markerDescription, @NonNull TextView markerTitle) {
    this.rootView = rootView;
    this.markerDescription = markerDescription;
    this.markerTitle = markerTitle;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CustomInfowindowBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CustomInfowindowBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.custom_infowindow, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CustomInfowindowBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.marker_description;
      TextView markerDescription = rootView.findViewById(id);
      if (markerDescription == null) {
        break missingId;
      }

      id = R.id.marker_title;
      TextView markerTitle = rootView.findViewById(id);
      if (markerTitle == null) {
        break missingId;
      }

      return new CustomInfowindowBinding((RelativeLayout) rootView, markerDescription, markerTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
