package com.example.snakegame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;

/**
 * Created by Michael Boisvert on 2019-02-18
 */


public class Snake {

    private Paint paint;
    private ArrayList<Rect> snakeBody = new ArrayList<>();
    private Rect snakeHead;

    public Snake(Context context, int screenWidth, int screenHeight){
        paint = new Paint();
        paint.setColor(ContextCompat.getColor(context, R.color.red));
        snakeHead = new Rect(screenWidth/2 - 50, screenHeight/2 - 50,
                screenWidth/2 + 50, screenHeight/2 +50);
        snakeBody.add(snakeHead);
    }

    public void draw(Canvas canvas){
        canvas.drawRect(snakeHead, paint);
    }

    public void update(String direction){
        if(direction.equals("right")){
            snakeHead.left = snakeHead.left + 100;
            snakeHead.right = snakeHead.right + 100;
        }
    }

    public void grow(){
    }

    public boolean collision(){
        return false;
    }
}
