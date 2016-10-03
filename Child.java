package com.example.vasavigeethay.sahi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Child extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        Button alpha = (Button)findViewById(R.id.button2);
        Button numbers = (Button)findViewById(R.id.button3);
        Button shapes = (Button)findViewById(R.id.button4);
        Button colours = (Button)findViewById(R.id.button5);
        Button practice = (Button)findViewById(R.id.button6);

        alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Child.this, Alpha.class);
          //      intent.putExtra("path","android.resource://" + getPackageName() + "/" + R.raw.alphabets);
                startActivity(intent);
            }
        });

        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Child.this, Alpha.class);
           //     intent.putExtra("path","android.resource://" + getPackageName() + "/" + R.raw.numbers);
                startActivity(intent);
            }
        });

        shapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Child.this, Alpha.class);
            //    intent.putExtra("path","android.resource://" + getPackageName() + "/" + R.raw.shapes);
                startActivity(intent);
            }
        });

        colours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Child.this, Alpha.class);
         //       intent.putExtra("path", "https://drive.google.com/file/d/0ByknvhcdvAnNbU83aDg4ODhRYTA/view");
                startActivity(intent);
            }
        });

        practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Child.this, Practice.class);
                startActivity(intent);
            }
        });
    }
}
