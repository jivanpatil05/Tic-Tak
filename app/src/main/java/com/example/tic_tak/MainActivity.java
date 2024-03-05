package com.example.tic_tak;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;

    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};

    public static int counter = 0;


//    public void playerTap(View view) {
//        ImageView img = (ImageView) view;
//        int tappedImage = Integer.parseInt(img.getTag().toString());
//
//
//        if (gameState[tappedImage] == 2) {
//            counter++;
//            if (counter == 9) {
//                gameActive = false;
//            }
//            gameState[tappedImage] = activePlayer;
//
//            if (activePlayer == 0) {
//                img.setImageResource(R.drawable.xpng);
//                activePlayer = 1;
//                TextView status = findViewById(R.id.status);
//                status.setText("O's Turn - Tap to play");
//               // Toast.makeText(this, " O's Turn ", Toast.LENGTH_SHORT).show();
//            } else {
//                img.setImageResource(R.drawable.opng);
//                activePlayer = 0;
//                TextView status = findViewById(R.id.status);
//                status.setText("X's Turn - Tap to play");
//               // Toast.makeText(this, " x's Turn ", Toast.LENGTH_SHORT).show();
//
//            }
//        }
//        int flag = 0;
//        if (counter > 4) {
//            for (int[] winPosition : winPositions) {
//                if (gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] == gameState[winPosition[2]] && gameState[winPosition[0]] != 2) {
//                    flag = 1;
//                    String winnerStr;
//                    if (gameState[winPosition[0]] == 0) {
//                        winnerStr = "X has won";
//                        Toast.makeText(this, "X has won", Toast.LENGTH_SHORT).show();
//                    } else {
//                        winnerStr = "O has won";
//                        Toast.makeText(this, "O has won", Toast.LENGTH_SHORT).show();
//                    }
//
//                    TextView status = findViewById(R.id.status);
//                    status.setText(winnerStr);
//                }
//            }
//            if (counter == 9 && flag == 0) {
//                TextView status = findViewById(R.id.status);
//                status.setText("Match Draw");
//            }
//        }
//
//    }
public void playerTap(View view) {
    if (!gameActive) { // Check if the game is already won
        return; // If so, return without taking any action
    }

    ImageView img = (ImageView) view;
    int tappedImage = Integer.parseInt(img.getTag().toString());

    if (gameState[tappedImage] == 2) {
        counter++;
        gameState[tappedImage] = activePlayer;

        if (activePlayer == 0) {
            img.setImageResource(R.drawable.xpng);
            activePlayer = 1;
            TextView status = findViewById(R.id.status);
            status.setText("O's Turn - Tap to play");
        } else {
            img.setImageResource(R.drawable.opng);
            activePlayer = 0;
            TextView status = findViewById(R.id.status);
            status.setText("X's Turn - Tap to play");
        }
    }

    // Check win condition
    int flag = 0;
//    for (int[] winPosition : winPositions) {
//        if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
//                gameState[winPosition[1]] == gameState[winPosition[2]] &&
//                gameState[winPosition[0]] != 2) {
//            flag = 1;
//            String winnerStr = (gameState[winPosition[0]] == 0) ? "X has won" : "O has won";
//            TextView status = findViewById(R.id.status);
//            status.setText(winnerStr);
//            gameActive = false; // Set gameActive to false when a player wins
//            break; // No need to continue checking for win conditions
//        }
//    }
    for (int[] winPosition : winPositions) {
        if (gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] == gameState[winPosition[2]] && gameState[winPosition[0]] != 2) {
            flag = 1;
            String winnerStr;
            if (gameState[winPosition[0]] == 0) {
                winnerStr = "X has won";
                Toast.makeText(this, "X has won", Toast.LENGTH_SHORT).show();
            } else {
                winnerStr = "O has won";
                Toast.makeText(this, "O has won", Toast.LENGTH_SHORT).show();
            }

            TextView status = findViewById(R.id.status);
            status.setText(winnerStr);
            gameActive = false; // Set gameActive to false when a player wins
            break; // No need to continue checking for win conditions
        }
    }

    // Check for draw condition
    if (counter == 9 && flag == 0) {
        TextView status = findViewById(R.id.status);
        status.setText("Match Draw");
        gameActive = false; // Set gameActive to false when the game is drawn
    }
}


    // reset the game
    public void gameReset(View view) {
        gameActive = true;
        activePlayer = 0;
        Arrays.fill(gameState, 2);

        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - Tap to play");
    }

    public void Resetbtn(View view) {
        gameReset(view);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

