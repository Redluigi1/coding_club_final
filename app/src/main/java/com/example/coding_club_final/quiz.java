package com.example.coding_club_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class quiz extends AppCompatActivity {
    public static int SDK_INT = android.os.Build.VERSION.SDK_INT;
    TextView textView;
    LinearLayout ll;
    String string;
    Document document;
    int cat;
    int num;
    String diff,link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quiz);



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

        link = "https://opentdb.com/api.php?amount=" + frag1.number + "&type=multiple&difficulty=" + diff + "&category=" + String.valueOf(cat);




        String string;
        final Document document;
        if (SDK_INT >= 10) {
            StrictMode.ThreadPolicy tp = StrictMode.ThreadPolicy.LAX;
            StrictMode.setThreadPolicy(tp);
        }
        try {
            document = Jsoup.connect(link).ignoreContentType(true).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        string = document.body().text();

        String[] e = string.split("[:]");
        System.out.println(string);

        List<String> question = new ArrayList<String>();
        List<String> correct = new ArrayList<String>();
        List<String> incorrect = new ArrayList<String>();
        List<String> incorrect_all = new ArrayList<String>();



        for(int x = 6; x < e.length;x+=6){
            question.add(e[x].substring(1,e[x].length() - 18));
            correct.add(e[x+1].substring(1,e[x+1].length() - 21));

            if(x+ 6 < e.length){
                incorrect.add(e[x+2].substring(1,e[x+2].length()-14));}
            else {incorrect.add(e[x+2].substring(1,e[x+2].length() - 4));}

        }


        for(String x :incorrect){
            for(String y: x.split("[,]")){

                incorrect_all.add(y.substring(1,y.length()-1));

            }


        }

        ll = findViewById(R.id.ll);

        for (int i = 0; i < Integer.parseInt(frag1.number) ; i++)
        {
            TextView myText = new TextView(this);
            myText.setText(question.get(i));
            myText.setTextSize(40);
            ll.addView(myText);

        }


    }
}









