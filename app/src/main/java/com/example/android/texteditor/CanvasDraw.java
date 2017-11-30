package com.example.android.texteditor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by Annie on 6/11/2016.
 */
public class CanvasDraw extends View {

    Bitmap ballObj;
    int x,y;

    public CanvasDraw(Context context) {
        super(context);
        ballObj = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
        x = 0;
        y = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Rect rectangle = new Rect();
        rectangle.set(0, 0, canvas.getWidth(), canvas.getHeight()/2);

        Paint color = new Paint();
        color.setColor(Color.MAGENTA);
        color.setStyle(Paint.Style.FILL);

        canvas.drawRect(rectangle, color);

        if(x < canvas.getWidth())
        {
            x += 10;
        } else{ x = 0; }
        if(y < canvas.getHeight())
        {
            y += 10;
        } else{ y = 0; }

        Paint p = new Paint();
        canvas.drawBitmap(ballObj, x, y, p);

        invalidate();
    }
}
