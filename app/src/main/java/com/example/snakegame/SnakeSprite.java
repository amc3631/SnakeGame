package com.example.snakegame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

/**
 * Created by Michael Boisvert on 2019-02-18
 */


public class SnakeSprite {
    private Paint paint;
    private int x, y;

    public SnakeSprite(Context context){
        paint = new Paint();
        paint.setColor(ContextCompat.getColor(context, R.color.red));
        x = 100;
        y = 100;
    }

    public void draw(Canvas canvas){
        canvas.drawRect(0, 0, 100, 100, paint);
    }

    public void update(){
        y++;
    }

    public void grow(){
    }

    public boolean collision(){
        return false;
    }
}
