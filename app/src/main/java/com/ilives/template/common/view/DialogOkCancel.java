package com.ilives.template.common.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.ilives.template.R;


/**
 * Copyright © 2016 Neo-Lab Co.,Ltd.
 * Created by VuLT on 24/10/2016.
 */
public class DialogOkCancel extends Dialog {

    private int countLoading = 0;

    private OnCancel onCancel;
    private OnDiscard onDiscard;

    private boolean hasSWapButton = false;

    public DialogOkCancel(Context context) {
        super(context);

        initLoadingProgress(context);
    }

    public DialogOkCancel initView(String msg){
        ((TextView) findViewById(R.id.txtMsg)).setText(msg);
        return this;
    }

    public DialogOkCancel initView(String msg, String ok, String cancel){
        ((TextView) findViewById(R.id.txtMsg)).setText(msg);
        ((TextView) findViewById(R.id.btnOk)).setText(hasSWapButton? cancel : ok);
        ((TextView) findViewById(R.id.btnCancel)).setText(hasSWapButton? ok : cancel);
        return this;
    }

    /**
    * if call this function then before call function @initView()
     * @param isWrap: true -> swap 2 button Ok and Cancel
     * false not swap
    * */
    public DialogOkCancel hasSwapButton(boolean isWrap) {
        hasSWapButton = isWrap;
        return this;
    }


    @SuppressWarnings("ConstantConditions")
    private void initLoadingProgress(Context context) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.dialog_2button);
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(this.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        this.getWindow().setAttributes(lp);
        this.setCancelable(false);
        this.setCanceledOnTouchOutside(false);

       findViewById(R.id.btnOk).setOnClickListener(view -> {
            dismiss();
            if(onCancel != null){
                if(hasSWapButton) {
                    onDiscard.onClick();
                } else {
                    onCancel.onClick();
                }
            }
        });
        findViewById(R.id.btnCancel).setOnClickListener(view -> {
            dismiss();
            if(onDiscard != null){
                if(hasSWapButton) {
                    onCancel.onClick();
                } else {
                    onDiscard.onClick();
                }
            }
        });
    }

    public DialogOkCancel showMsg() {
        if(countLoading == 0) {
            super.show();
        }
        countLoading++;
        return this;
    }

    public void dismissMsg() {
        countLoading--;
        if(countLoading > 0) return;
        super.dismiss();
    }

    public void forceDismissMsg() {
        countLoading = 0;
        super.dismiss();
    }

    public DialogOkCancel setOnCancel(OnCancel onCancel){
        this.onCancel = onCancel;
        return this;
    }

    public DialogOkCancel setOnDiscard(OnDiscard onDiscard) {
        this.onDiscard = onDiscard;
        return this;
    }

    public interface OnCancel {
        void onClick();
    }

    public interface OnDiscard {
        void onClick();
    }
}
