package com.example.mohammadhia.scarnesdice;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public int userOverallScore = 0;
    public int userTurnScore = 0;
    public int computerOverallScore = 0;
    public int computerTurnScore = 0;

    public boolean userTurn = true;

    Button button1;
    Button button2;
    Button button3;

    public void updateRoundScore(){
        TextView textView = (TextView) findViewById(R.id.round_score);
        if(userTurn){
            textView.setText("Round Score (You): " + Integer.toString(userTurnScore));
        } else {
            textView.setText("Round Score (Computer): " + Integer.toString(computerTurnScore));
        }
    }

    public void updateScoresTextView(){
        TextView textView = (TextView) findViewById(R.id.user_score);
        TextView textView2 = (TextView) findViewById(R.id.computer_score);
        textView.setText("Your Total Score: " + Integer.toString(userOverallScore));
        textView2.setText("Computer Total Score: " + Integer.toString(computerOverallScore));

        return;
    }

    public void rollDice(){
        Random rand = new Random();
        int roll = rand.nextInt(6)+1;
        switch(roll){
            case 1: {
                if(userTurn){
                    userTurnScore = 0;
                    userTurn = false;
                    computerTurn();
                } else {
                    computerTurnScore = 0;
                    userTurn = true;
                    button1.setEnabled(true);
                    button2.setEnabled(true);
                }
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                imageView.setImageResource(R.drawable.dice1);

                updateRoundScore();
                updateScoresTextView();
                break;
            }
            case 2: {
                if(userTurn){
                    userTurnScore += roll;
                } else {
                    computerTurnScore += roll;
                }
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                imageView.setImageResource(R.drawable.dice2);

                updateRoundScore();
                updateScoresTextView();
                break;
            }
            case 3: {
                if(userTurn){
                    userTurnScore += roll;
                } else {
                    computerTurnScore += roll;
                }
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                imageView.setImageResource(R.drawable.dice3);

                updateRoundScore();
                updateScoresTextView();
                break;
            }
            case 4: {
                if(userTurn){
                    userTurnScore += roll;
                } else {
                    computerTurnScore += roll;
                }
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                imageView.setImageResource(R.drawable.dice4);

                updateRoundScore();
                updateScoresTextView();
                break;
            }
            case 5: {
                if(userTurn){
                    userTurnScore += roll;
                } else {
                    computerTurnScore += roll;
                }
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                imageView.setImageResource(R.drawable.dice5);

                updateRoundScore();
                updateScoresTextView();
                break;
            }
            case 6: {
                if(userTurn){
                    userTurnScore += roll;
                } else {
                    computerTurnScore += roll;
                }
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                imageView.setImageResource(R.drawable.dice6);

                updateRoundScore();
                updateScoresTextView();
                break;
            }
        }
    }

    public void computerTurn(){
        button1.setEnabled(false);
        button2.setEnabled(false);

        while(computerTurnScore < 20 && !userTurn){
            rollDice();
        }

        computerOverallScore += computerTurnScore;
        computerTurnScore = 0;
        userTurn = true;
        button1.setEnabled(true);//Re-enabling roll button after computer's turn is done
        button2.setEnabled(true);//Re-enabling hold button after computer's turn is done

        updateRoundScore();
        updateScoresTextView();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateScoresTextView();

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                rollDice();
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                userOverallScore += userTurnScore;
                userTurnScore = 0;
                userTurn = false;

                computerTurn();

                updateRoundScore();
                updateScoresTextView();
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                userTurnScore = 0; computerTurnScore = 0;
                userOverallScore = 0; computerOverallScore = 0;
                userTurn = true;

                updateRoundScore();
                updateScoresTextView();
            }
        });
    }



    //Called when the user hits the Send button
    /*public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }*/
}
