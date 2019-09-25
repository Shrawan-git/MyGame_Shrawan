package com.e.mygame.np;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnFirst, btnSecond;
    private TextView Result;

    private int num1, num2, result, rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFirst = findViewById(R.id.btn1);
        btnSecond = findViewById(R.id.btn2);
        Result = findViewById(R.id.Result);

        setBtnNumber();
        setNumber();

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (compare(num1, num2)) {
                    result = result + 1;
                    Result.setText("result is " + result);
                } else {
                    result = result - 1;
                    Result.setText("result is " + result);
                }
                setBtnNumber();
                setNumber();
                declare();
            }
        });

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (compare(num1, num2)) {
                    result = result - 1;
                    Result.setText("result is " + result);
                } else {
                    result = result + 1;
                    Result.setText("result is " + result);
                }
                setBtnNumber();
                setNumber();
                declare();

            }
        });


    }


    public boolean compare(int x, int y) {
        if (x > y) {
            return true;
        } else {
            return false;
        }
    }


    public void setBtnNumber() {
        btnFirst.setText(Integer.toString(getRand()));
        btnSecond.setText(Integer.toString(getRand()));


    }

    private int getRand() {
        Random rand = new Random();
        int value = rand.nextInt(100);
        return value;
    }

    public void setNumber() {
        num1 = Integer.parseInt(btnFirst.getText().toString());
        num2 = Integer.parseInt(btnSecond.getText().toString());
    }

    public void declare() {
        if (result < 10 || result > -10) {

        }
        if (result == 10) {
            Toast.makeText(this, "You win", Toast.LENGTH_SHORT).show();
        }
        if (result == -10) {
            Toast.makeText(this, "You lose", Toast.LENGTH_SHORT).show();
        }


    }


}


