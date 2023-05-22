package com.example.coding_club_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class quiz extends AppCompatActivity {
    TextView textView;
    int cat;
    int num;
    String diff,link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        textView = findViewById(R.id.textView90);
        textView.setText(frag1.category.toString());


        if (frag1.category == "Science and Nature"){cat = 17;}
        else if (frag1.category == "Computers"){cat = 18;}

        else if (frag1.category == "Mythology"){cat = 20;}
        else if (frag1.category == "Sports"){cat = 21;}
        else if (frag1.category == "Geography"){cat = 22;}
        else if (frag1.category == "History"){cat = 23;}
        else if (frag1.category == "Politics"){cat = 24;}
        else if (frag1.category == "Art"){cat = 25;}
        else if (frag1.category == "Celebrities"){cat = 26;}
        else if (frag1.category =="Vehicles"){cat = 28;}
        else{cat = 27;}

        num = Integer.parseInt(frag1.number);
        diff = frag1.diff;

        link = "https://opentdb.com/api.php?amount=" + frag1.number + "type=multiple&difficulty=" + diff + "&category=" + String.valueOf(cat);
        textView.setText(link);



        }

    }
