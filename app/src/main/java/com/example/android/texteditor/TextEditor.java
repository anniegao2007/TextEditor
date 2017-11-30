package com.example.android.texteditor;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Annie on 6/10/2016.
 */
public class TextEditor extends ActionBarActivity implements RadioGroup.OnCheckedChangeListener {
    TextView tvOut;
    EditText input;
    RadioGroup rgGravity;
    RadioGroup rgStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_editor);
        input = (EditText) findViewById(R.id.input);
        rgGravity = (RadioGroup) findViewById(R.id.rgGravity);
        rgGravity.setOnCheckedChangeListener(this);
        rgStyle = (RadioGroup) findViewById(R.id.rgStyle);
        rgStyle.setOnCheckedChangeListener(this);
        tvOut = (TextView) findViewById(R.id.tvDisplay);
        Button bGen = (Button) findViewById(R.id.buttonGen);
        bGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOut.setText(input.getText());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id)
        {
            case R.id.action_settings :
                return true;

            case R.id.blurb :
                startActivity(new Intent(this, Blurb.class));
                return true;

            case R.id.toast :
                Toast toast = Toast.makeText(this, "You're so cool", Toast.LENGTH_LONG);
                toast.show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch(checkedId)
        {
            case R.id.rbLeft :
                tvOut.setGravity(Gravity.LEFT);
                break;

            case R.id.rbCenter :
                tvOut.setGravity(Gravity.CENTER);
                break;

            case R.id.rbRight :
                tvOut.setGravity(Gravity.RIGHT);
                break;

            case R.id.rbNormal :
                tvOut.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL), Typeface.NORMAL);
                break;

            case R.id.rbBold :
                tvOut.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD), Typeface.BOLD);
                break;

            case R.id.rbItalics :
                tvOut.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC), Typeface.ITALIC);
                break;
        }
    }
}
