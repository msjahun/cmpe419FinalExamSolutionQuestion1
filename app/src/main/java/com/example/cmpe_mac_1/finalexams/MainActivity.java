package com.example.cmpe_mac_1.finalexams;
//android_app_database_sqlite_example
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button buttonConvert;
EditText editTextCurrencyAmount;
RadioGroup radioGroupFrom;
RadioGroup radioGroupTo;
TextView textViewResult;
Boolean ConvertFrom, ConvertTo;
double exchangeRate1DollarToTl =4.36;
//tl =0 usd =1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonConvert= findViewById(R.id.buttonConvert);
         editTextCurrencyAmount = (EditText) findViewById(R.id.editTextCurrencyAmount);
         radioGroupFrom= (RadioGroup) findViewById(R.id.radioGroupFrom);
         radioGroupTo =(RadioGroup) findViewById(R.id.radioGroupTo);
         textViewResult = (TextView) findViewById(R.id.textViewResult);

buttonConvert.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String input ="";
        input= editTextCurrencyAmount.getText().toString();
double answer = Integer.parseInt(input);
        if(ConvertFrom && ConvertTo){
            //usd to usd
            textViewResult.setText(""+input);
        }
        else if (!ConvertFrom && ConvertTo){
            //Tl to usd
            double an = answer/exchangeRate1DollarToTl;
            textViewResult.setText(""+an);
        }
        else if(ConvertFrom && !ConvertTo){
            //usd to tl

            double an = answer * exchangeRate1DollarToTl;
            textViewResult.setText(""+an);
        }else if (!ConvertFrom && !ConvertTo){
            //tl to tl
            textViewResult.setText(""+input);
        }else {
            //default
            Toast.makeText(MainActivity.this, "Something went WRong", Toast.LENGTH_SHORT).show();
        }
    }
});

    }

    public void ConvertToUSD(View v){
        Toast.makeText(this, "ConvertToUSD", Toast.LENGTH_SHORT).show();
        ConvertTo =true;
    }
  public  void ConvertToTL(View v){
      Toast.makeText(this, "Convert To TL", Toast.LENGTH_SHORT).show();
      ConvertTo = false;
    }
    public void ConvertFromUSD(View v){
        Toast.makeText(this, "Convert From USD", Toast.LENGTH_SHORT).show();
            ConvertFrom=true;
    }
    public void ConvertFromTL(View v){
        Toast.makeText(this, "Convert From TL", Toast.LENGTH_SHORT).show();
        ConvertFrom =false;
    }
}
