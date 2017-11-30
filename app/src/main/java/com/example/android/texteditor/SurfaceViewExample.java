package com.example.android.texteditor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by Annie on 6/17/2016.
 */
public class SurfaceViewExample extends ActionBarActivity implements View.OnTouchListener{

    OurView v;
    Bitmap ball;
    float x, y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        v = new OurView(this);
        v.setOnTouchListener(this);
        ball = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
        x = y = 0;

        setContentView(v);
    }

    @Override
    protected void onPause() {
        super.onPause();
        v.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        v.resume();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    public class OurView extends SurfaceView implements Runnable {

        Thread thread = null;
        SurfaceHolder holder;
        boolean isItOK = false;

        public OurView(Context context)
        {
            super(context);
            holder = getHolder();
        }

        @Override
        public void run() {
            while(isItOK)
            {
                //perform canvas drawing
                if(!holder.getSurface().isValid())
                {
                    continue;
                }
                Canvas c = holder.lockCanvas();
                c.drawARGB(255, 150, 150, 10);
                c.drawBitmap(ball, x - ball.getWidth() / 2, y - ball.getHeight() / 2, null);
                holder.unlockCanvasAndPost(c);
            }
        }

        public void pause()
        {
            isItOK = false;
            while(true)
            {
                try
                {
                    thread.join();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                break;
            }
            thread = null;
        }

        public void resume()
        {
            isItOK = true;
            thread = new Thread(this);
            thread.start();
        }
    }
}
