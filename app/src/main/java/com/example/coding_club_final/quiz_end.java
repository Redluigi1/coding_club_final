package com.example.coding_club_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class quiz_end extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quiz_end);
        EditText editText1 = findViewById(R.id.editTextTextPersonName2);
        EditText editText2 = findViewById(R.id.editTextTextPersonName3);
        editText1.setText(quiz.correct_howmany.toString());
        Integer inco = Integer.parseInt(frag1.number) - quiz.correct_howmany;
        editText2.setText(inco.toString());


        Button button = findViewById(R.id.button29);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openscreen1();










            }
        });

    }
    public void openscreen1(){
        Intent intent = new Intent(this,screen1.class);
        startActivity(intent);
        Animatoo.INSTANCE.animateZoom(quiz_end.this);

}}