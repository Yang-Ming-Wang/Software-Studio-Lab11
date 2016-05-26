package com.csclab.softwarestudiopractice11;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mei on 5/24/16.
 */

public class Activity2 extends Activity implements OnTouchListener{
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN: //ACTION_DOWN
                xoffset = (int) (event.getRawX() - v.getX());
                yoffset = (int) (event.getRawY() - v.getY());
                break;
            case MotionEvent.ACTION_MOVE: //ACTION_MOVE
                dino.layout((int) event.getRawX() - xoffset, (int) event.getRawY() - yoffset,
                        v.getWidth() + (int) event.getRawX() - xoffset, v.getHeight() + (int) event.getRawY() - yoffset);
                break;
        }
        return true;
    }

    private TextView nameText;
    private ImageView dino;
    private int xoffset, yoffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        nameText = (TextView)findViewById(R.id.nameTextView);
        nameText.setText("Welcome " + this.getIntent().getExtras().getString("test"));
        dino = (ImageView) findViewById(R.id.imageView);
        dino.setOnTouchListener(this);
    }

}
