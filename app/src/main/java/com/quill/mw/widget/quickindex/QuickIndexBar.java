package com.quill.mw.widget.quickindex;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.quill.mw.R;

/**
 * Created by hspcadmin on 2016/7/1.
 */
public class QuickIndexBar extends View {
    private static final String[] LETTERS = new String[]{
            "A", "B", "C", "D", "E", "F",
            "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X",
            "Y", "Z"};
    private Paint paint;
    private float cellHeight;
    private float cellWidth;

    public QuickIndexBar(Context context) {
        this(context,null);
    }

    public QuickIndexBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public QuickIndexBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(getResources().getColor(R.color.black));
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(28);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        cellHeight = getMeasuredHeight()*1.0f/ LETTERS.length;
        cellWidth = getMeasuredWidth();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i <LETTERS.length; i++) {
            String text = LETTERS[i];
            float width=cellWidth/2-paint.measureText(text)/2;
            Rect bounds = new Rect();
            paint.getTextBounds(text,0,text.length(),bounds);
            int textHeight = bounds.height();
            float height=cellHeight/2+textHeight/2+cellHeight*i;
            canvas.drawText(text,width,height,paint);
        }
    }
}
