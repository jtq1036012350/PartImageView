package com.marsjiang.partimageview;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Jiang on 2017-07-13.
 */

public class PartImageView extends RelativeLayout {
    private TextView tv_test;
    private onPartClickCallBack partClickCallBack;

    public interface onPartClickCallBack {
        public void partClick();
    }

    public PartImageView(@NonNull Context context) {
        super(context);
    }

    public PartImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PartImageView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnPartClickListener(onPartClickCallBack partClickCallBack) {
        this.partClickCallBack = partClickCallBack;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        initView();
    }

    private void initView() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            if (childView instanceof TextView) {
                tv_test = (TextView) getChildAt(i);
                break;
            }
        }
        tv_test.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (partClickCallBack != null) {
                    partClickCallBack.partClick();
                }
            }
        });

    }

}
