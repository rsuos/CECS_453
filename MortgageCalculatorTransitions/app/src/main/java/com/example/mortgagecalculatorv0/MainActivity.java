package com.example.mortgagecalculatorv0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static Mortgage mortgage;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mortgage = new Mortgage();
        mortgage = new Mortgage ( this );
        setContentView(R.layout.activity_main);
    }

    public void onStart(){
        super.onStart();
        updateView();
    }

    public void updateView(){
        TextView amountTV = (TextView) findViewById(R.id.amount);
        amountTV.setText(mortgage.getFormattedAmount());
        TextView yearsTV= (TextView) findViewById(R.id.years);
        yearsTV.setText("" + mortgage.getYears());
        TextView rateTV = (TextView) findViewById(R.id.rate);
        rateTV.setText(""+(mortgage.getRate() * 100 )+"%");
        TextView monthly_paymentTV = (TextView) findViewById(R.id.monthly_payment);
        monthly_paymentTV.setText("" + mortgage.formattedMonthlyPayment());
        TextView total_paymentTV = (TextView) findViewById(R.id.total_payment);
        total_paymentTV.setText("" + mortgage.formattedTotalPayment());

    }

    public void modifyData(View v) {
        Intent myIntent = new Intent(this, DataActivity.class);
        this.startActivity(myIntent);
        overridePendingTransition(R.anim.slide_from_left, 1);
    }
}
