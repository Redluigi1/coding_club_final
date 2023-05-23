package com.example.coding_club_final;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class quiz_stuff {

    String link = "https://opentdb.com/api.php?amount=3&type=multiple&category=17";


    public String getLink() {
        return link;
    }

    public Document getDocument() {
        return document;
    }

    public String getString() {
        return string;
    }

    public List<String> getQuestion() {
        return question;
    }

    public List<String> getCorrect() {
        return correct;
    }

    public List<String> getIncorrect() {
        return incorrect;
    }

    public List<String> getIncorrect_all() {
        return incorrect_all;
    }

    Document document = Jsoup.connect(link).ignoreContentType(true).get();
    String string = document.body().text();

    List<String> question = new ArrayList<String>();
    List<String> correct = new ArrayList<String>();
    List<String> incorrect = new ArrayList<String>();
    List<String> incorrect_all = new ArrayList<String>();
    String[] err = string.split("[:]");

    public String[] getErr() {
        return err;
    }



    public quiz_stuff() throws IOException {
    }







}
