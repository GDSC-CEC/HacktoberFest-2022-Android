package com.shivchauhan.guessme_colorguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private int number;
    Button button, button2;     // button is the Guess Button and button2 is the Result Button
    ImageView img1, img2, img3, final_image;    // img1, img3 are the images used to guess the color. ing2 is the addition image. final_image is the result.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        final_image = findViewById(R.id.final_image);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);


        button.setOnClickListener(new View.OnClickListener() {  // when Guess button is clicked then this function will run.
            @Override
            public void onClick(View view) {
                img2.setImageResource(R.drawable.plus);


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {


                    number = (int) (((Math.random()) * 7) + 1);


                    if (number == 1) {
                        final_image.setImageResource(0);
                        img1.setImageResource(R.drawable.pin);
                        img3.setImageResource(R.drawable.k);
                        button2.setOnClickListener(new View.OnClickListener() { // when Result button is clicked then this function will run.
                            @Override
                            public void onClick(View view) {
                                final_image.setImageResource(R.drawable.pink);
                            }
                        });
                    } else if (number == 2) {
                        final_image.setImageResource(0);
                        img1.setImageResource(R.drawable.yell);
                        img3.setImageResource(R.drawable.low);
                        button2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final_image.setImageResource(R.drawable.yellow);
                            }
                        });
                    } else if (number == 3) {
                        final_image.setImageResource(0);
                        img1.setImageResource(R.drawable.g);
                        img3.setImageResource(R.drawable.ray);
                        button2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final_image.setImageResource(R.drawable.grey);
                            }
                        });
                    } else if (number == 4) {
                        final_image.setImageResource(0);
                        img1.setImageResource(R.drawable.y);
                        img3.setImageResource(R.drawable.it);
                        button2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final_image.setImageResource(R.drawable.white);
                            }
                        });
                    } else if (number == 5) {
                        final_image.setImageResource(0);
                        img1.setImageResource(R.drawable.p);
                        img3.setImageResource(R.drawable.ink);
                        button2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final_image.setImageResource(R.drawable.pink);
                            }
                        });
                    } else if (number == 6) {
                        final_image.setImageResource(0);
                        img1.setImageResource(R.drawable.b);
                        img3.setImageResource(R.drawable.lock);
                        button2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final_image.setImageResource(R.drawable.black);
                            }
                        });
                    } else if (number == 7) {
                        final_image.setImageResource(0);
                        img1.setImageResource(R.drawable.gg);
                        img3.setImageResource(R.drawable.ring);
                        button2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final_image.setImageResource(R.drawable.green);
                            }
                        });
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Your Version must be LOLLIPOP", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}