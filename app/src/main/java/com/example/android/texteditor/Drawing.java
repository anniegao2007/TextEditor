package com.example.android.texteditor;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by Annie on 6/11/2016.
 */
public class Drawing extends ActionBarActivity {

    CanvasDraw canvasDraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        canvasDraw = new CanvasDraw(Drawing.this);
        setContentView(canvasDraw);
    }
}
