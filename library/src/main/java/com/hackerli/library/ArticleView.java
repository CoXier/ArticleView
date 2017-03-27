package com.hackerli.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by CoXier on 17-3-27.
 */

public class ArticleView extends RecyclerView {
    private int mFontColor;
    private float mFontSize;

    public ArticleView(Context context) {
        this(context, null);
    }

    public ArticleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ArticleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray a = null;
        try {
            a = context.obtainStyledAttributes(attrs, R.styleable.ArticleView);
            mFontColor =
                    a.getColor(R.styleable.ArticleView_font_color, Color.BLACK);
            mFontSize = a.getFloat(R.styleable.ArticleView_font_size,18);;
        } finally {
            a.recycle();
        }
    }

    public int getFontColor() {
        return mFontColor;
    }

    public float getFontSize() {
        return mFontSize;
    }
}
