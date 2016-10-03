package com.example.vasavigeethay.sahi;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Practice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        final ViewFlipper flippy2 = (ViewFlipper)findViewById(R.id.viewFlipper2);
        Button next = (Button)findViewById(R.id.button7);
        Button prev = (Button)findViewById(R.id.button8);
        ImageButton tick = (ImageButton)findViewById(R.id.imageButton);
        ImageButton wrong = (ImageButton)findViewById(R.id.imageButton2);

        ImageView circle = (ImageView)findViewById(R.id.imageView);
        circle.setImageResource(R.drawable.circle);
        ImageView rectangle = (ImageView)findViewById(R.id.imageView2);
        rectangle.setImageResource(R.drawable.rectangle);
        ImageView square = (ImageView)findViewById(R.id.imageView3);
        square.setImageResource(R.drawable.square);
        ImageView triangle = (ImageView)findViewById(R.id.imageView4);
        triangle.setImageResource(R.drawable.triangle);
        ImageView one = (ImageView)findViewById(R.id.imageView5);
        one.setImageResource(R.drawable.one);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flippy2.showNext();
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flippy2.showPrevious();
            }
        });

        tick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        wrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
