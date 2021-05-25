package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[] gamestate  = {2,2,2,2,2,2,2,2,2};

    int[][] winningposn = {{0,1,2} , {3,4,5} , {6,7,8} , {0,3,6} , {1,4,7} , {2,5,8} , {0,4,8} , {2,4,6}};

    int activeplayer = 0,a=0;


    boolean gameactive = true;

    public void dropIn(View view){

        ImageView counter = (ImageView) view;
        counter.animate().alpha(1).rotation(3600).setDuration(200);

        int tappedCounter = Integer.parseInt(counter.getTag().toString());




            if (gameactive && gamestate[tappedCounter] == 2) {

                gamestate[tappedCounter] = activeplayer;


                if (activeplayer == 0) {
                    counter.setImageResource(R.drawable.oimg);
                    activeplayer = 1;
                } else {
                    counter.setImageResource(R.drawable.ximg);
                    activeplayer = 0;
                }

                for (int[] winningpos : winningposn) {
                    if (gamestate[winningpos[0]] == gamestate[winningpos[1]] && gamestate[winningpos[1]] == gamestate[winningpos[2]] && gamestate[winningpos[0]] != 2) {
                        String winner = "";
                        gameactive = false;
                        if (activeplayer == 1) {
                            winner = "Player1 Won";
                        } else {
                            winner = "Player2 Won";
                        }

                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText(winner);
                        Button playAgainbutton = (Button) findViewById(R.id.playAgain);
                        playAgainbutton.setVisibility(View.VISIBLE);

                    }


                }

                a=a+1;

            }

        if(gameactive && a>8)
        {

                gameactive=false;
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText("Match Drawn");
                Button playAgainbutton = (Button) findViewById(R.id.playAgain);
                playAgainbutton.setVisibility(View.VISIBLE);


        }
        }



    public void mplayAgain(View view){

        Button playAgainbutton = (Button) findViewById(R.id.playAgain);
        playAgainbutton.setVisibility(View.INVISIBLE);
        TextView textView = (TextView) findViewById(R.id.textView);

        textView.setText("O = Player1\nX = Player2");
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);


        for(int i=0; i<gridLayout.getChildCount();i++){

            ImageView counter = (ImageView) gridLayout.getChildAt(i);


            counter.setImageDrawable(null);
        }
        for (int i=0;i<gamestate.length;i++)
        {
            gamestate[i]=2;
        }


       activeplayer = 0;
        gameactive = true;
        a=0;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}