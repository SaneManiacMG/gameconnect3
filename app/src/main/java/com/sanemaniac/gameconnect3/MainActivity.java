package com.sanemaniac.gameconnect3;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int player = 0;

    //2 is empty, 1 is yellow, 0 is blue
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8},
            {2, 4, 6}};

    public void dropCounter(View view) {
        ImageView counter = (ImageView) view;

        Log.i("TAG", counter.getTag().toString());

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        gameState[tappedCounter] = player;

        if (player == 0) {
            counter.setTranslationY(-1500);
            counter.setImageResource(R.drawable.blue);
            counter.animate().translationYBy(1500).rotation(720).setDuration(666);
            player = 1;
        } else {
            counter.setTranslationY(-1500);
            counter.setImageResource(R.drawable.yellow);
            counter.animate().translationYBy(1500).rotation(720).setDuration(666);
            player = 0;
        }



    }

}