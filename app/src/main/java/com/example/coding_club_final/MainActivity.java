package com.example.coding_club_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class MainActivity extends AppCompatActivity {
    public static String name_string = "";

    public TextView username;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        username = findViewById(R.id.username);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_string = username.getText().toString();
                if (name_string.length() != 0 ){

                    openscreen1();}
                else {
                    Toast.makeText(MainActivity.this, "Please enter username", Toast.LENGTH_SHORT).show();
                }
            }
        });



        }
        public void openscreen1(){
        Intent intent = new Intent(this,screen1.class);
        startActivity(intent);
        Animatoo.INSTANCE.animateZoom(MainActivity.this);



        }

        }

