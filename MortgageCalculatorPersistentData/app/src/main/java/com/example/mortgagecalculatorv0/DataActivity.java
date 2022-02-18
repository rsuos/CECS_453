package com.example.mortgagecalculatorv0;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class DataActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
    }

    public void updateView(){
        Mortgage mortgage = MainActivity.mortgage;
        if(mortgage.getYears() == 10)
        {
            RadioButton rb10 = (RadioButton) findViewById(R.id.ten);
            rb10.setChecked(true);
        }
        else if(mortgage.getYears() == 15)
        {
            RadioButton rb15 = (RadioButton) findViewById(R.id.fifteen);
            rb15.setChecked(true);
        }
        else
        {
            RadioButton rb30 = (RadioButton) findViewById(R.id.thirty);
            rb30.setChecked(true);
        }

        EditText amountET = (EditText)findViewById(R.id.data_amount);
        amountET.setText("" + mortgage.getAmount());
        EditText rateET = (EditText)findViewById(R.id.data_rate);
        rateET.setText("" + mortgage.getRate());

    }

    public void updateMortgageObject(){
        Mortgage mortgage = MainActivity.mortgage;
        RadioButton rb10 = (RadioButton) findViewById(R.id.ten);
        RadioButton rb15 = (RadioButton) findViewById(R.id.fifteen);
        int years = 30;
        if(rb10.isChecked()) years = 10;
        else if (rb15.isChecked()) years = 15;
        else years = 30;

        mortgage.setYears(years);
        EditText amountET = (EditText)findViewById(R.id.data_amount);
        String amountString = amountET.getText().toString();
        EditText rateET = (EditText) findViewById(R.id.data_rate);
        String rateString = rateET.getText().toString();

        try {
            float amount = Float.parseFloat(amountString);
            mortgage.setAmount(amount);
            float rate = Float.parseFloat(rateString);
            mortgage.setRate(rate);
            mortgage.setPreferences( this );
        } catch (NumberFormatException nfe) {
            mortgage.setAmount(100000.0f);
            mortgage.setRate(.035f);
        }
    }

    public void goBack(View v){
        updateMortgageObject();
        this.finish();
    }
}
