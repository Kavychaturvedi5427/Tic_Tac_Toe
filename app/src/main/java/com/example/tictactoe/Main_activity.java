package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Main_activity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    int flag=0,count=0;
    boolean GameEnded=false;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

//        btn1.setOnClickListener(new View.OnClickListener() {      if we use this then we've to create 9 onClickListener() for each button but
//                                                                  now we've created a single function and in xml file each button have the function as onClick value
//            @Override
//            public void onClick(View v) {
//                check(v);
//            }
//        });

        // When the user will press the restart button then only the game will restart not on it's own...

        Button res_btn=findViewById(R.id.Restart);
        res_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Restart();
            }
        });
    }

    // to fetch id of the button which is pressed.....
    private void initialize(){
        btn1=findViewById(R.id.Btn1);
        btn2=findViewById(R.id.Btn2);
        btn3=findViewById(R.id.Btn3);
        btn4=findViewById(R.id.Btn4);
        btn5=findViewById(R.id.Btn5);
        btn6=findViewById(R.id.Btn6);
        btn7=findViewById(R.id.Btn7);
        btn8=findViewById(R.id.Btn8);
        btn9=findViewById(R.id.Btn9);
    }

    // to get the text present in the button for comparison...
    private void Get_btn_text(){
        b1=btn1.getText().toString();
        b2=btn2.getText().toString();
        b3=btn3.getText().toString();
        b4=btn4.getText().toString();
        b5=btn5.getText().toString();
        b6=btn6.getText().toString();
        b7=btn7.getText().toString();
        b8=btn8.getText().toString();
        b9=btn9.getText().toString();
    }

    // to restart the game...
    private void Restart(){
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        flag=0;
        count=0;
        GameEnded=false;
        Toast.makeText(this, "Game Restarted!", Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("SetTextI18n")
    public void check(View view){       // view will have the reference of whichever button is clicked ...
        Button Current_btn = (Button) view; // but we need to type cast it...

        // To notify user that the game has ended and they've to press the restart button to replay...
        if(GameEnded){
            Toast.makeText(this, "Game Ended! Press Restart Button", Toast.LENGTH_SHORT).show();
        }
        if(Current_btn.getText().toString().equals("")){    // if the current button is blank then only perform the following task otherwise don't...
            count++;
            if (flag==0){               // for the first time flag will be 0 and x will be printed
                Current_btn.setText("X");
                flag=1;                 // now flag is 1 next time the btn is pressed then if cond. is false and else will be executed and O will be printed..
            }
            else{
                Current_btn.setText("O");
                flag=0;
            }

            // to determine the winner for that minimum 5 moves are required
            if (count>4) {
                Get_btn_text();

                // comparing row wise...
                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    Toast.makeText(this, "Winner is " + b1, Toast.LENGTH_SHORT).show();
                    GameEnded=true;

                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    Toast.makeText(this, "Winner is " + b4, Toast.LENGTH_SHORT).show();
                    GameEnded=true;
                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    Toast.makeText(this, "Winner is " + b7, Toast.LENGTH_SHORT).show();
                    GameEnded=true;
                }

                // comparing column wise...
                else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    Toast.makeText(this, "Winner is " + b1, Toast.LENGTH_SHORT).show();
                    GameEnded=true;
                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    Toast.makeText(this, "Winner is " + b2, Toast.LENGTH_SHORT).show();
                    GameEnded=true;
                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    Toast.makeText(this, "Winner is " + b3, Toast.LENGTH_SHORT).show();
                    GameEnded=true;
                }

                // comparing diagonally...
                else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    Toast.makeText(this, "Winner is " + b1, Toast.LENGTH_SHORT).show();
                    GameEnded=true;
                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    Toast.makeText(this, "Winner is " + b3, Toast.LENGTH_SHORT).show();
                    GameEnded=true;
                }
            }

//          if used this logic then game will automatically restart on it own ....
//            if(GameEnded){
//                Restart();
//            } else
            if (!GameEnded && count==9) {
                Toast.makeText(this, "Oops! It's a Draw.", Toast.LENGTH_LONG).show();
                Restart();
            }
        }
    }
}
