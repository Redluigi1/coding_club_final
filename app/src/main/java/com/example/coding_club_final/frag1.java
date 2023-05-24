package com.example.coding_club_final;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link frag1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class frag1 extends Fragment {

Button button;
EditText editText;
Spinner spinner2,spinner3;
public static String diff,category,number;
public static Integer category_num;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public frag1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment frag1.
     */
    // TODO: Rename and change types and number of parameters
    public static frag1 newInstance(String param1, String param2) {
        frag1 fragment = new frag1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag1, container, false);
        Button button = view.findViewById(R.id.button);
        EditText editText = view.findViewById(R.id.editTextTextPersonName);
        Spinner spinner2 = view.findViewById(R.id.spinner2);
        Spinner spinner3 = view.findViewById(R.id.spinner3);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diff = spinner3.getSelectedItem().toString();
                category = spinner2.getSelectedItem().toString();
                category_num = spinner2.getSelectedItemPosition();

                number = editText.getText().toString();
                openscreen0();

            }
        });
        return view;
    }


    public void openscreen0(){
        Intent intent = new Intent(frag1.this.getActivity(),quiz.class);
        startActivity(intent);

    }
}