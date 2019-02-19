package com.example.snakegame;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 *  Created by Michael Boisvert on 2019-02-17
 */

public class MainActivity extends Activity {

    /* Code for setting up game taken from https://www.youtube.com/watch?v=6prI4ZB_rXI
    "How to write your first Android game" video posted by "Android Authority" on Jul 21, 2017
    Viewed on February 17th, 2019*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new GameView(this));

    }
}
