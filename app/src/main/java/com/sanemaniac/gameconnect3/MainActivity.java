package com.sanemaniac.gameconnect3;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int player = 0;

    Boolean gameActive = true;

    Button newGame = findViewById(R.id.btnNewGame);

    //2 is empty, 1 is yellow, 0 is blue
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8},
            {2, 4, 6}};

    String winner = null;

    public void dropCounter(View view) {
        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2 && gameActive == true) {
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


            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {
                    if(player == 1) {
                        winner = "Blue";
                    } else {
                        winner = "Yellow";
                    }
                    Toast.makeText(this, winner + " has won", Toast.LENGTH_SHORT).show();
                    gameActive = false;

                    newGame.setVisibility(View.VISIBLE);
                }
            }
        } else if (gameActive == false){
            Toast.makeText(this, winner + " has won!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Try another block", Toast.LENGTH_SHORT).show();
        }

    }

    public void newGame(View view) {
        newGame.setVisibility(View.INVISIBLE);
        for (int i = 0; i < 9; i++) {
            GridLayout
        }
    }

}