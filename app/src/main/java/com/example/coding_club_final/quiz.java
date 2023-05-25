package com.example.coding_club_final;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class quiz extends AppCompatActivity {
    public static int SDK_INT = android.os.Build.VERSION.SDK_INT;
    TextView textView;
    LinearLayout ll;
    String string;
    Document document;
    int cat;
    int num;
    String diff, link;
    static Integer correct_howmany;
    static  String past_quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quiz);
        List<String> question = new ArrayList<String>();
        List<String> correct = new ArrayList<String>();
        List<String> incorrect = new ArrayList<String>();
        List<String> incorrect_all = new ArrayList<String>();



        Thread t1 = new Thread(new Runnable() {
            public void run() {
                if (frag1.category_num == 0) {
                    cat = 17;
                } else if (frag1.category_num == 1) {
                    cat = 18;
                } else if (frag1.category_num == 2) {
                    cat = 20;
                } else if (frag1.category_num == 3) {
                    cat = 21;
                } else if (frag1.category_num == 4) {
                    cat = 22;
                } else if (frag1.category_num == 5) {
                    cat = 23;
                } else if (frag1.category_num == 6) {
                    cat = 24;
                } else if (frag1.category_num == 7) {
                    cat = 25;
                } else if (frag1.category_num == 8) {
                    cat = 26;
                } else if (frag1.category_num == 9) {
                    cat = 27;
                } else if (frag1.category_num == 10) {
                    cat = 28;
                } else {
                    cat = 28;
                }

                num = Integer.parseInt(frag1.number);
                if (num > 10) {
                    frag1.number = "10";
                }
                diff = frag1.diff;

                link = "https://opentdb.com/api.php?amount=" + frag1.number + "&type=multiple&difficulty=" + diff + "&category=" + String.valueOf(cat);


                String string;
                final Document document;

                try {
                    document = Jsoup.connect(link).ignoreContentType(true).get();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                string = document.body().text();

                String[] e = string.split("[:]");


                for (int x = 6; x < e.length; x += 6) {
                    question.add(e[x].substring(1, e[x].length() - 18));
                    correct.add(e[x + 1].substring(1, e[x + 1].length() - 21));

                    if (x + 6 < e.length) {
                        incorrect.add(e[x + 2].substring(1, e[x + 2].length() - 14));
                    } else {
                        incorrect.add(e[x + 2].substring(1, e[x + 2].length() - 4));
                    }

                }


                for (String x : incorrect) {
                    for (String y : x.split("[,]")) {

                        incorrect_all.add(y.substring(1, y.length() - 1));

                    }


                }

            }
        });

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        ll = findViewById(R.id.ll);

        for (int i = 0; i < Integer.parseInt(frag1.number); i++) {
            CardView cardView = new CardView(this);
            CardView cardView2 = new CardView(this);
            TextView myText = new TextView(this);
            myText.setText(question.get(i));
            myText.setTextSize(30);

            RadioGroup radioGroup = new RadioGroup(this);



            Random random = new Random();
            int randomnum = random.nextInt(3 - 0) + 0;

            if (randomnum % 4 == 0) {


                for (int j = 0; j < 3; ++j) {

                    RadioButton radioButton = new RadioButton(this);
                    radioButton.setText(incorrect_all.get(3 * i + j));

                    radioGroup.addView(radioButton);
                    if(j == 0){radioButton.setChecked(true);}

                }
                RadioButton radioButton1 = new RadioButton(this);
                radioButton1.setText(correct.get(i));
                radioGroup.addView(radioButton1);
            } else if (randomnum % 4 == 1) {
                RadioButton radioButton1 = new RadioButton(this);
                radioButton1.setText(correct.get(i));
                radioGroup.addView(radioButton1);

                for (int j = 0; j < 3; ++j) {

                    RadioButton radioButton = new RadioButton(this);
                    radioButton.setText(incorrect_all.get(3 * i + j));
                    radioGroup.addView(radioButton);
                    if(j == 0){radioButton.setChecked(true);}

                }


            } else if (randomnum % 4 == 2) {
                for (int j = 0; j < 3; ++j) {

                    if (j == 1) {
                        RadioButton radioButton1 = new RadioButton(this);
                        radioButton1.setText(correct.get(i));
                        radioGroup.addView(radioButton1);
                    }

                    RadioButton radioButton = new RadioButton(this);
                    radioButton.setText(incorrect_all.get(3 * i + j));
                    radioGroup.addView(radioButton);
                    if(j == 0){radioButton.setChecked(true);}


                }


            } else {
                for (int j = 0; j < 3; ++j) {

                    if (j == 2) {
                        RadioButton radioButton1 = new RadioButton(this);
                        radioButton1.setText(correct.get(i));
                        radioGroup.addView(radioButton1);
                    }

                    RadioButton radioButton = new RadioButton(this);
                    radioButton.setText(incorrect_all.get(3 * i + j));


                    radioGroup.addView(radioButton);


                    if(j == 0){radioButton.setChecked(true);}
                }


            }


            cardView.addView(myText);
            radioGroup.setId(900000000 + i);
            cardView2.addView(radioGroup);
            cardView.setRadius(5);
            cardView2.setRadius(5);
            cardView.setCardBackgroundColor(1);
            cardView2.setCardBackgroundColor(1);


            ll.addView(cardView);
            ll.addView(cardView2);

        }


        Button button = new Button(this);
        button.setText("Submit");
        ll.addView(button);


        List<String> selected = new ArrayList<String>();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer a = 0;


                for (int i = 0; i < Integer.parseInt(frag1.number); i++) {
                    RadioButton rb = new RadioButton(getApplicationContext());
                    RadioGroup rdg = new RadioGroup(getApplicationContext());
                    rdg = findViewById(900000000 + i);
                    rb = findViewById(rdg.getCheckedRadioButtonId());
                    selected.add(rb.getText().toString());


                }


                for (int i = 0; i < Integer.parseInt(frag1.number); i++) {

                    if (selected.get(i) == correct.get(i)) {
                        a = a + 1;
                    }


                }

                correct_howmany = a;
                openscreen1();

                SharedPreferences shf = getSharedPreferences("NAME_SharedPref",Context.MODE_PRIVATE);
                String strPref = shf.getString("past", null);
                String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                Integer inco = Integer.parseInt(frag1.number) - correct_howmany;

                if(strPref != null) {
                    SharedPreferences.Editor myEdit = shf.edit();
                    myEdit.putString("past", shf.getString("past","") + "Date - " + date + "\n" + "Correct - " + correct_howmany.toString() + "\n" + "Incorrect - " + inco.toString() + "\n" + "\n");
                    myEdit.commit();



                }
                else{
                    SharedPreferences.Editor myEdit = shf.edit();
                    myEdit.putString("past","Date - " + date + "\n" + "Correct - " + correct_howmany.toString() + "\n" + "Incorrect - " + inco.toString() + "\n" + "\n");
                    myEdit.commit();


                }

            }
        });


    }

    public void openscreen1() {
        Intent intent = new Intent(this, quiz_end.class);
        startActivity(intent);


    }

}







