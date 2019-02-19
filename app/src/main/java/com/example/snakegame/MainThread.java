package com.example.snakegame;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 *  Created by Michael Boisvert on 2019-02-17
 */


public class MainThread extends Thread {

    private SurfaceHolder surfaceHolder;
    private GameView gameView;
    private boolean running;
    public static Canvas canvas;
    private boolean starting;

    public MainThread(SurfaceHolder surfaceHolder, GameView gameView) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gameView = gameView;
        starting = true;
    }

    public void setRunning(boolean isRunning) {
        running = isRunning;
    }

    @Override
    public void run() {
        // starting position
        while (running) {
            canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    if(starting){
                        this.gameView.draw(canvas);
                        sleep(5000);
                        starting = false;
                    } else{
                        this.gameView.update();
                        this.gameView.draw(canvas);
                        sleep(5000);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
