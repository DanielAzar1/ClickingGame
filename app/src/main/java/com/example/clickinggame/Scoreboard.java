package com.example.clickinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Scoreboard extends AppCompatActivity {
    TextView score1, score2;
    Button ng;
    int blue, red;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard2);
        Intent gi = getIntent();

        score1 = findViewById(R.id.tV1);
        score2 = findViewById(R.id.tV2);
        ng = findViewById(R.id.ngBtn);

        blue = gi.getIntExtra("blueScore", -1);
        red = gi.getIntExtra("redScore", -1);

        String str = "Blue: %d   Red: %d";
        score1.setText(String.format(str, blue, red));

        if (blue > red)
        {
            score2.setText("BLUE WON");
            score2.setTextColor(Color.rgb(0,0,255));
        }
        else if (red > blue)
        {
            score2.setText("RED WON");
            score2.setTextColor(Color.rgb(255,0,0));
        }
        else
        {
            score2.setText("DRAW!");
            score2.setTextColor(Color.rgb(0,0,1));
        }
    }

    public void finish(View view)
    {
        finish();
    }
}