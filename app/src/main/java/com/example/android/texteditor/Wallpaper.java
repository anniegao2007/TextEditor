package com.example.android.texteditor;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Annie on 6/10/2016.
 */
public class Wallpaper extends ActionBarActivity implements View.OnClickListener{

    ImageView display;
    int yay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); */

        setContentView(R.layout.wallpaper);
        display = (ImageView) findViewById(R.id.wallpaper);
        ImageView image1 = (ImageView) findViewById(R.id.image1);
            image1.setOnClickListener(this);
        ImageView image2 = (ImageView) findViewById(R.id.image2);
            image2.setOnClickListener(this);
        ImageView image3 = (ImageView) findViewById(R.id.image3);
            image3.setOnClickListener(this);
        ImageView image4 = (ImageView) findViewById(R.id.image4);
            image4.setOnClickListener(this);
        ImageView image5 = (ImageView) findViewById(R.id.image5);
            image5.setOnClickListener(this);
        ImageView image6 = (ImageView) findViewById(R.id.image6);
            image6.setOnClickListener(this);
        ImageView image7 = (ImageView) findViewById(R.id.image7);
            image7.setOnClickListener(this);
        ImageView image8 = (ImageView) findViewById(R.id.image8);
            image8.setOnClickListener(this);
        Button setWallpaper = (Button) findViewById(R.id.buttonSetWallpaper);
            setWallpaper.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.image1:
                yay = R.drawable.space;
                display.setImageResource(yay);
                break;
            case R.id.image2:
                yay = R.drawable.panda;
                display.setImageResource(yay);
                break;
            case R.id.image3:
                yay = R.drawable.night;
                display.setImageResource(yay);
                break;
            case R.id.image4:
                yay = R.drawable.mario;
                display.setImageResource(yay);
                break;
            case R.id.image5:
                yay = R.drawable.grass;
                display.setImageResource(yay);
                break;
            case R.id.image6:
                yay = R.drawable.flowers;
                display.setImageResource(yay);
                break;
            case R.id.image7:
                yay = R.drawable.blue;
                display.setImageResource(yay);
                break;
            case R.id.image8:
                yay = R.drawable.black;
                display.setImageResource(yay);
                break;
            case R.id.buttonSetWallpaper:
                InputStream input = getResources().openRawResource(yay);
                Bitmap bitmap = BitmapFactory.decodeStream(input);
                try
                {
                    getApplicationContext().setWallpaper(bitmap);
                    Toast toast = Toast.makeText(this, "Set!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                break;
        }
    }
}
