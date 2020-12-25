package com.pratikum.pratikummp.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.annotation.NonNull;

import com.pratikum.pratikummp.R;
import com.pratikum.pratikummp.common.DialogImage;

public class CustomDialog extends Dialog {

    private final DialogImage listener;

    public CustomDialog(@NonNull Context context, DialogImage listener) {
        super(context);
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_activity);

        findViewById(R.id.open_camera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onCameraClick();
                dismiss();
            }
        });

        findViewById(R.id.open_file).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onGalleryClick();
                dismiss();
            }
        });
    }
}
