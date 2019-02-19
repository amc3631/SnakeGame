package com.example.snakegame;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

/**
 *  Created by Michael Boisvert on 2019-02-17
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private Context context;
    private MainThread thread;
    private Snake snake;
    private int screenHeight, screenWidth;

    public GameView(Context context){
        super(context);
        this.context = context;
        screenWidth = getResources().getSystem().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getSystem().getDisplayMetrics().heightPixels;
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        snake = new Snake(context, screenWidth, screenHeight);
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry){
            try{
                thread.setRunning(false);
                thread.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            retry = false;
        }
    }

    public void update(){
        snake.update("right");
    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        if(canvas!=null){
            snake.draw(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent e){
        return false;
    }

    @Override
    public boolean performClick(){
        super.performClick();
        return false;
    }

}
