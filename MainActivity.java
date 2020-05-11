package sg.tgonet.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /* Hint
       - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 2.
       - Feel free to modify the function to suit your program.
   */
    int randomLocation;
    int score_text;
    TextView Score;
    Button Button1;
    Button Button2;
    Button Button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score_text = 0;
        Score = findViewById(R.id.Score);
        Score.setText(String.valueOf(score_text));
        Button1 = findViewById(R.id.button1);
        Button2 = findViewById(R.id.button2);
        Button3 = findViewById(R.id.button3);

        Log.v("OnCreate:", "Finished Pre-Initialisation!");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("OnStart:", "Starting GUI!");

        setNewMole();

        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Click", "Button Left Clicked");
                if (randomLocation == 0) {
                    Log.d("Correct", "Hit, score added!");
                    score_text++;

                } else {
                    Log.d("Missed", "Missed, score deducted!");
                    score_text--;
                }
                Score.setText(String.valueOf(score_text));
                setNewMole();
            }
        });
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Click", "Button Middle Clicked");
                if (randomLocation == 1) {
                    Log.d("Correct", "Hit, score added!");
                    score_text++;
                } else {
                    Log.d("Missed", "Missed, score deducted!");
                    score_text--;
                }
                Score.setText(String.valueOf(score_text));
                setNewMole();
            }
        });
        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Click", "Button Right Clicked");
                if (randomLocation == 2) {
                    Log.d("Correct", "Hit, score added!");
                    score_text++;
                } else {
                    Log.d("Missed", "Missed, score deducted!");
                    score_text--;
                }
                Score.setText(String.valueOf(score_text));
                setNewMole();
            }
        });

    }


    public void setNewMole() {
        Random ran = new Random();
        randomLocation = ran.nextInt(3);
        if (randomLocation == 0) {
            Button1.setText("*");
            Button2.setText("O");
            Button3.setText("O");

        } else if (randomLocation == 1) {
            Button1.setText("O");
            Button2.setText("*");
            Button3.setText("O");

        } else if (randomLocation == 2) {
            Button1.setText("O");
            Button2.setText("O");
            Button3.setText("*");
        }
    }
}
