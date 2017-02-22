package com.bawei.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 作    者：云凯文
 * 时    间：2016/12/26
 * 描    述：
 * 修改时间：
 */

public class MyView extends View {

    //画笔
    private Paint paint;
    //监听
    OnClicListener onClicListener;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 需要三个方法
     */
    //1.测量高度和宽度
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    //2.画布
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        circle(canvas);

    }

    //3.位置
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    //绘制圆的方法
    public void circle(Canvas canvas) {
        //创建画笔
        paint = new Paint();
        //设置画笔颜色
        paint.setColor(Color.RED);
        //设置画笔宽度
        paint.setStrokeWidth(5);
        //设置抗锯齿
        paint.setAntiAlias(true);
        //设置空心圆
        paint.setStyle(Paint.Style.STROKE);
        //绘制圆
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 100, paint);
        //设置画笔宽度
        paint.setStrokeWidth(1);
        //设置字体大小
        paint.setTextSize(40);

        //获取子图的宽度
        String name = "大宁";
        float width = paint.measureText(name, 0, name.length());
        Rect rect = new Rect();
        paint.getTextBounds(name, 0, name.length(), rect);
        float height = rect.height();
        //绘制文字
        canvas.drawText(name, getWidth() / 2 - width / 2, getHeight() / 2 + height / 2, paint);
    }

    //点击事件


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                float x = event.getX();
                float y = event.getY();
                //转换坐标的位置
                int x1 = (int) (x - getWidth() / 2);
                int y1 = (int) (y - getHeight() / 2);

                if (x1 * x1 + y1 * y1 < 100 * 100) {//点击成功

                    if (null != onClicListener) {
                        onClicListener.OnClicListener();
                    }
                }
                break;
        }
        return true;
    }

    //观察者模式
    //1:声明一个接口//2:声明接口的对象//3:定义一个方法
    public interface OnClicListener {
        public void OnClicListener();
    }

    public void setOnClicListener(OnClicListener onClicListener) {
        this.onClicListener = onClicListener;
    }
}