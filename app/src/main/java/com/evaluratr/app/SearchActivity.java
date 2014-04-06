package com.evaluratr.app;

import android.app.Activity;
import android.content.Intent;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;
import android.widget.AdapterView.OnItemSelectedListener;

/**
 * Created by isabella on 4/5/14.
 */
public class SearchActivity extends Activity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.search_main);
        //View donetwoButton = findViewById(R.id.donetwo_button);

        /*
        Spinner makeSpinner = (Spinner)findViewById(R.id.make_spinner);
        Spinner modelSpinner = (Spinner)findViewById(R.id.model_spinner);
        Spinner yearSpinner = (Spinner)findViewById(R.id.year_spinner);

        modelSpinner.setVisibility(View.INVISIBLE);
        yearSpinner.setVisibility(View.INVISIBLE);

        makeSpinner.setOnItemSelectedListener(new makeListener());
        modelSpinner.setOnItemSelectedListener(new modelListener());
        */

        RadioGroup g1 = (RadioGroup) findViewById(R.id.makeRG);
        RadioGroup g2 = (RadioGroup) findViewById(R.id.modelRG);
        RadioGroup g3 = (RadioGroup) findViewById(R.id.yearRG);

        for(int i = 0; i < g2.getChildCount(); i++){
            ((RadioButton)g2.getChildAt(i)).setEnabled(false);
            ((RadioButton)g2.getChildAt(i)).setVisibility(View.INVISIBLE);
        }

        for(int i = 0; i < g3.getChildCount(); i++){
            ((RadioButton)g3.getChildAt(i)).setEnabled(false);
            ((RadioButton)g3.getChildAt(i)).setVisibility(View.INVISIBLE);
        }

        g1.setOnCheckedChangeListener(new g1Listener());
        g2.setOnCheckedChangeListener(new g2Listener());
    }

    public void doSearch(View view) {
        Intent k = new Intent(SearchActivity.this, ResultActivity.class);
        startActivity(k);
    }

    public class g1Listener implements RadioGroup.OnCheckedChangeListener{
        public void onCheckedChanged(RadioGroup group, int checkedId){

           // RadioGroup rg=(RadioGroup)findViewById(R.id.youradio);
            //String val = (RadioButton) (group.findViewById(group.getCheckedRadioButtonId()));

            //String radiovalue=  (RadioButton)group.findViewById(group.getCheckedRadioButtonId()).getText().toString();
            //String t =  group.getChildAt(group.getCheckedRadioButtonId()).toString();
            Toast.makeText(getApplicationContext(), "show g2", Toast.LENGTH_SHORT).show();

            RadioGroup g = (RadioGroup) findViewById(R.id.modelRG);

            for(int i = 0; i < g.getChildCount(); i++){
                ((RadioButton)g.getChildAt(i)).setEnabled(true);
                ((RadioButton)g.getChildAt(i)).setVisibility(View.VISIBLE);
            }
        }
    }

    public class g2Listener implements RadioGroup.OnCheckedChangeListener{
        public void onCheckedChanged(RadioGroup group, int checkedId){
            Toast.makeText(getApplicationContext(), "show g3", Toast.LENGTH_SHORT).show();

            RadioGroup g = (RadioGroup) findViewById(R.id.yearRG);

            for(int i = 0; i < g.getChildCount(); i++){
                ((RadioButton)g.getChildAt(i)).setEnabled(true);
                ((RadioButton)g.getChildAt(i)).setVisibility(View.VISIBLE);
            }
        }
    }
/*
    public class makeListener implements OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            Spinner mS = (Spinner)findViewById(R.id.model_spinner);
            //mS.setVisibility(View.VISIBLE);
        }

        public void onNothingSelected(AdapterView parent) {
            // Do nothing.
        }
    }*/
}
