package com.sy.customprogressbardemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by SY on 2016/11/22.
 * 自定义进度条
 */

public class CustomProgressBar extends View {
    private final int CIRCLE_NUM = 3;
    private int full = 1;
    private Paint mStorke_paint;
    private Paint mFill_paint;

    public CustomProgressBar(Context context) {
        super(context);
    }

    public CustomProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public int getFull() {
        return full;
    }

    public void setFull(int full) {
        this.full = full;
        if (full < 0) {
            this.full = 0;
        }

        if (full > CIRCLE_NUM) {
            this.full = CIRCLE_NUM;
        }
        invalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mStorke_paint = new Paint();
        mStorke_paint.setStrokeWidth(4);
        mStorke_paint.setStyle(Paint.Style.STROKE);
        mStorke_paint.setColor(getResources().getColor(R.color.colorPrimary));

        mFill_paint = new Paint();
        mFill_paint.setStrokeWidth(4);
        mFill_paint.setStyle(Paint.Style.FILL);
        mFill_paint.setColor(getResources().getColor(R.color.colorPrimary));

        int centerX = 10;
        for (int i = 0; i < full; i++) {
            canvas.drawCircle(centerX, 10, 8, mFill_paint);
            centerX += 48;
        }

        for (int i = 0; i < CIRCLE_NUM - full; i++) {
            canvas.drawCircle(centerX, 10, 8, mStorke_paint);
            centerX += 48;
        }

        int lineX = 18;
        for (int j = 0; j < CIRCLE_NUM - 1; j++) {
            canvas.drawLine(lineX, 10, lineX + 32, 10, mFill_paint);
            lineX += 48;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = measureDimension(130, widthMeasureSpec);
        int height = measureDimension(20, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    public int measureDimension(int defaultSize, int measureSpec) {
        int result;

        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = defaultSize;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }
}
