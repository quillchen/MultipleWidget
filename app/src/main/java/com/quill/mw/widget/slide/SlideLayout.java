package com.quill.mw.widget.slide;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by quill on 2016/6/30.
 */
public class SlideLayout extends FrameLayout {

    private ViewDragHelper mDragHelper;
    private ViewGroup mLeftContent;
    private ViewGroup mMainContent;

    public SlideLayout(Context context) {
        this(context,null);
    }

    public SlideLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SlideLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //1,初始化(单例)
        mDragHelper = ViewDragHelper.create(this, mCallback);
    }

    ViewDragHelper.Callback mCallback=new ViewDragHelper.Callback() {

        //返回true可以拖拽
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return true;
        }
        //根据建议值修正将要移动到的位置
        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return left;
        }
    };

    //2,传递事件
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //让mDragHelper决定Intercept
        return mDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDragHelper.processTouchEvent(event);
        //返回true，持续接收事件
        return true;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        if (getChildCount()<2){
            throw new IllegalStateException("SlideLayout must hava two childView");
        }
        if (!(getChildAt(0) instanceof ViewGroup&&getChildAt(1) instanceof ViewGroup)){
            throw new IllegalArgumentException("childView must to be instanceof ViewGoup");
        }
        mLeftContent = (ViewGroup) getChildAt(0);
        mMainContent = (ViewGroup) getChildAt(1);
    }
}
