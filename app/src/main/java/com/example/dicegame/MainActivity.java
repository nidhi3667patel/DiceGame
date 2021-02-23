package com.example.dicegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView player_dice;
    ImageView CPU_dice;
    Random rand_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Higher = (Button) findViewById(R.id.btn_Higher);
        Button Lower = (Button) findViewById(R.id.btn_Lower);
         player_dice= (ImageView) findViewById(R.id.img_player_dice);
         CPU_dice = (ImageView) findViewById(R.id.img_CPU_dice);
        TextView DisplayResult = (TextView) findViewById(R.id.txt_result);

        //Higher Button Click event
        Higher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rand_num = new Random();
                int player_score = rand_num.nextInt(6) + 1;
                int cpu_score = rand_num.nextInt(6) + 1;
                int cmp = 0;

                setPlayerDice(player_score);
                setCPUDice(cpu_score);
                //0 = higher
                String result = compare_dices(player_score, cpu_score, cmp);
                DisplayResult.setText(result);
            }
        });

        //Lower Button click event
        Lower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rand_num = new Random();
                int player_score = rand_num.nextInt(6) + 1;
                int cpu_score = rand_num.nextInt(6) + 1;
                int cmp = 1;

                setPlayerDice(player_score);
                setCPUDice(cpu_score);
                //1 = lower
                String result = compare_dices(player_score, cpu_score, cmp);
                DisplayResult.setText(result);
            }
        });
    }

    public void setPlayerDice(int num){
        switch (num){
            case 1:
                player_dice.setImageResource(R.drawable.dice1);
                break;
            case 2:
                player_dice.setImageResource(R.drawable.dice2);
                break;
            case 3:
                player_dice.setImageResource(R.drawable.dice3);
                break;
            case 4:
                player_dice.setImageResource(R.drawable.dice4);
                break;
            case 5:
                player_dice.setImageResource(R.drawable.dice5);
                break;
            case 6:
                player_dice.setImageResource(R.drawable.dice6);
                break;

        }
    }

    public void setCPUDice(int num){
        switch (num){
            case 1:
                CPU_dice.setImageResource(R.drawable.dice1);
                break;
            case 2:
                CPU_dice.setImageResource(R.drawable.dice2);
                break;
            case 3:
                CPU_dice.setImageResource(R.drawable.dice3);
                break;
            case 4:
                CPU_dice.setImageResource(R.drawable.dice4);
                break;
            case 5:
                CPU_dice.setImageResource(R.drawable.dice5);
                break;
            case 6:
                CPU_dice.setImageResource(R.drawable.dice6);
                break;
        }
    }

    public  String  compare_dices(int player_score, int cpu_score, int cmp){
        String Result = "";
        if(cmp == 0){
            if(player_score == cpu_score){
                //Tie
                Result = "It’s a tie!!";
            }else if (player_score < cpu_score){
                //loose
                Result = "CPU Wins!!";
            }else {
                //Win
                Result = "Player Wins!!";
            }
        }
        if(cmp == 1){
            if(player_score == cpu_score){
                //Tie
                Result = "It’s a tie!!";
            }else if (player_score > cpu_score){
                //loose
                Result = "Computer Win!";
            }else {
                //Win
                Result = "User Win!";
            }
        }
        return  Result;

    }
}