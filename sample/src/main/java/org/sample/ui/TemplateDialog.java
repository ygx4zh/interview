package org.sample.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class TemplateDialog extends Dialog {
    public TemplateDialog(@NonNull Context context) {
        super(context);

        initView();
    }

    public static TemplateDialog create(Activity aty){
        return new TemplateDialog(aty);
    }

    void initView(){
        View view = new View(getContext());
        view.setBackgroundColor(0xFFFF0000);
        initWindow();
        setContentView(view);
    }

    void initWindow(){
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.CENTER;
        window.setBackgroundDrawable(new ColorDrawable(0x00000000));

        int[] size = new int[2];
        getScreenSize(size);

        params.alpha = 1;
        params.width = (int) (size[0] * 0.5f);
        params.height = (int) (size[1] * 0.5f);

        window.setAttributes(params);
    }

    void getScreenSize(int size[]){
        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
        size[0] = metrics.widthPixels;
        size[1] = metrics.heightPixels;
    }
}
