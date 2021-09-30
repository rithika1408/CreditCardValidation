package com.example.creditcardvalidation;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    TextInputLayout l1,l2,l3,l4,l5;
    TextInputEditText cardNumber,date,cvv,firstName,lastName;
    Button submit;
    int t=0,h1=0,h2=0,h3=0,h4=0,h5=0,s,t1=0,t2=0,t3=0,t4=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l1=findViewById(R.id.textInputLayout);
        l2=findViewById(R.id.textInputLayout2);
        l3=findViewById(R.id.textInputLayout3);
        l4=findViewById(R.id.textInputLayout5);
        l5=findViewById(R.id.textInputLayout4);
        submit=findViewById(R.id.button);

        cardNumber=findViewById(R.id.cardNumber);
        date=findViewById(R.id.date);
        cvv=findViewById(R.id.cvv);
        firstName=findViewById(R.id.firstName);
        lastName=findViewById(R.id.lastName);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s5=lastName.getText().toString();
                t=0;
                Pattern p=Pattern.compile("^[ A-Za-z]+$");
                Matcher m=p.matcher(s5);
                boolean b=m.matches();
                if(s5.isEmpty()){
                    l5.setError("Last name is empty");t=0;
                }
                else if(!s5.isEmpty() && b==false){
                    l5.setError("Invalid Last name");t=0;
                }
                else{
                    l5.setErrorEnabled(false);t=1;
                }
                if(t==1){h5=1;}

                String s4=firstName.getText().toString();t1=0;
                Matcher m1=p.matcher(s4);
                boolean b1=m1.matches();
                if(s4.isEmpty()){
                    l4.setError("First name is empty");t1=0;
                }
                else if(!s4.isEmpty() && b1==false){
                    l4.setError("Invalid First name");t1=0;
                }
                else{
                    l4.setErrorEnabled(false);t1=1;
                }
                if(t1==1){h4=1;}

                String s3=cvv.getText().toString();
                t2=0;
                String a="^[0-9]{3,4}$";
                Pattern p2=Pattern.compile(a);
                Matcher m2=p2.matcher(s3);
                if(s3.isEmpty()){
                    l3.setError("CVV is empty");t2=0;
                }
                else if(!s3.isEmpty() && !m2.matches() ){
                    l3.setError("Invalid CVV");t2=0;
                }
                else{
                    l3.setErrorEnabled(false);t2=1;
                }
                if(t2==1){h3=1;}

                String s2=date.getText().toString();
                t3=0;
                if(s2.isEmpty()){
                    l2.setError("Date is empty");t3=0;
                }
                else {
                    try {
                        if(!s2.isEmpty() && new SimpleDateFormat("MM/YY").parse(s2).before(new Date())){
                            l2.setError("Invalid date");t3=0;
                        }
                        else{
                            l2.setErrorEnabled(false);t3=1;
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                if(t3==1){h2=1;}

                String s1=cardNumber.getText().toString();
                t4=0;s=0;
                int k=0,k1=0;
                String r="^(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" + "(?<mastercard>5[1-5][0-9]{14})|"
                        + "(?<discover>6(?:011|5[0-9]{2}[0-9]{12})|" + "(?<amex>3[47][0-9]{13}))$";
                Pattern p3=Pattern.compile(r);
                Matcher m3=p3.matcher(s1);
                if(m3.matches()){k1=1;}
                String a1="^[0-9]+";
                Pattern p1=Pattern.compile(a1);
                Matcher m4=p1.matcher(s1);
                if(m4.matches()){
                k=1;
                int[] n=new int[s1.length()];
                int x;
                for (x=0;x<s1.length();x++){
                    n[x]=Integer.parseInt(s1.substring(x,x+1));
                }
                int y,z;
                for(y=n.length-2;y>=0;y=y-2){
                    z=n[y];
                    z=z*2;
                    if(z>9){
                        z=z%10+1;
                    }
                    n[y]=z;
                }
                for(int g=0;g<n.length;g++){
                    s+=n[g];
                }}
                if(s1.isEmpty()){
                    l1.setError("Card number is empty");t4=0;
                }
                else if(!s1.isEmpty() && !m4.matches()){
                    l1.setError("Invalid card number");t4=0;
                }
                else if(!s1.isEmpty() && !m3.matches()){
                    l1.setError("Invalid card number");t4=0;
                }
                else if(!s1.isEmpty() && s%10!=0 ) {
                    l1.setError("Invalid card number");t4=0;}
                else{
                    l1.setErrorEnabled(false);t4=1;
                }
                if(t4==1){h1=1;}

                if(h4==1 && h5==1 && h3==1 && h2==1 && h1==1 && k==1 && k1==1){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Payment Successful").setPositiveButton("OK", null);
                    builder.show();}

            }

        });
    }

}