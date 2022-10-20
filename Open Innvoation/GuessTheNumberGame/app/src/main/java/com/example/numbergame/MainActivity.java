package com.example.numbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;
    public void guess(View view){
        EditText guessedittext= (EditText) findViewById(R.id.guessedittext);
        int  guessint= Integer.parseInt(guessedittext.getText().toString());

        if(guessint>randomNumber){
            Toast.makeText(MainActivity.this, "GO A BIT LOWER", Toast.LENGTH_SHORT).show();
        }else if(guessint<randomNumber){
            Toast.makeText(MainActivity.this, "GO A BIT HIGHER", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "YOU GOT THE NUMBER....GO TRY AGAIN", Toast.LENGTH_SHORT).show();
            Random rand= new Random();
            randomNumber= rand.nextInt(20)+1;
        }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Random rand= new Random();
        randomNumber= rand.nextInt(20)+1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}