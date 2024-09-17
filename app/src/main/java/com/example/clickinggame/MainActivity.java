package com.example.clickinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    int red, blue;
    Button blueBtn, redBtn;
    TextView redPlus, bluePlus;
    Random rand = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blueBtn = findViewById(R.id.blueBtn);
        redBtn = findViewById(R.id.redBtn);
        blueBtn.setBackgroundColor(Color.rgb(0,0,255));
        redBtn.setBackgroundColor(Color.rgb(255,0,0));


        red = 0;
        blue = 0;

        blueBtn.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                blueBtn.setBackgroundColor(Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
                blue += 2;
                return false;
            }
        });
    }

    public void redClick(View view)
    {
        redBtn.setBackgroundColor(Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        red++;
    }


    public void go()
    {
        Intent si = new Intent(this,Scoreboard.class);
        si.putExtra("blueScore", blue);
        si.putExtra("redScore", red);
        startActivity(si);
        red = 0;
        blue = 0;
    }

    public void goSb(View view) {
        go();
    }
}