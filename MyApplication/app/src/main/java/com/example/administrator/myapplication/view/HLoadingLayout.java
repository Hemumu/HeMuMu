package com.example.administrator.myapplication.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

/**
 * Created by HL on 2016/8/8 0008.
 */
public class HLoadingLayout extends FrameLayout {
    private int stateView;
    private int loadingView;
    private OnClickListener onRetryClickListener;

    public HLoadingLayout(Context context) {
        super(context, null);
    }

    public HLoadingLayout(Context context, AttributeSet attrs) {
        super(context, attrs, -1);
    }

    public HLoadingLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.LoadingLayout, 0, 0);
        try {
            stateView = a.getResourceId(R.styleable.LoadingLayout_stateView, R.layout.loadstate_layout);
            loadingView = a.getResourceId(R.styleable.LoadingLayout_loadingView, R.layout.loading_layout);
            LayoutInflater inflater = LayoutInflater.from(getContext());
            //加载布局到根布局 0为state布局，1 为loading布局
            inflater.inflate(stateView, this, true);
            inflater.inflate(loadingView, this, true);
        } finally {
            a.recycle();
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        for (int i = 0; i < getChildCount() - 1; i++) {
            getChildAt(i).setVisibility(GONE);
        }

        findViewById(R.id.state_retry).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
            if (null != onRetryClickListener) {
                onRetryClickListener.onClick(view);
            }
            }
        });

    }

    public void setOnRetryClickListener(OnClickListener onRetryClickListener) {
        this.onRetryClickListener = onRetryClickListener;
    }

    // show state view
    public void showState() {
        for (int i = 0; i > this.getChildCount(); i++) {
            View child = this.getChildAt(i);
            if (i == 0) {
                child.setVisibility(VISIBLE);
            } else {
                child.setVisibility(GONE);
            }
        }
    }

    public void showState(String tips) {
        for (int i = 0; i < this.getChildCount(); i++) {
            View child = this.getChildAt(i);
            if (i == 0) {
                child.setVisibility(VISIBLE);
                ((TextView) child.findViewById(R.id.load_state_tv)).setText(tips + "");
            } else {
                child.setVisibility(GONE);
            }
        }
    }

    public void showState(int img, String tips) {
        for (int i = 0; i < this.getChildCount(); i++) {
            View child = this.getChildAt(i);
            if (i == 0) {
                child.setVisibility(VISIBLE);
                ((ImageView) child.findViewById(R.id.load_state_img)).setImageResource(img);
                ((TextView) child.findViewById(R.id.load_state_tv)).setText(tips + "");
            } else {
                child.setVisibility(GONE);
            }
        }
    }

    // show loading view
    public void showLoading() {
        for (int i = 0; i < this.getChildCount(); i++) {
            View child = this.getChildAt(i);
            if (i == 1) {
                child.setVisibility(VISIBLE);
            } else {
                child.setVisibility(GONE);
            }
        }
    }

    // show content view
    public void showContent() {
        for (int i = 0; i < this.getChildCount(); i++) {
            View child = this.getChildAt(i);
            if (i == 2) {
                child.setVisibility(VISIBLE);
            } else {
                child.setVisibility(GONE);
            }
        }
    }


}
