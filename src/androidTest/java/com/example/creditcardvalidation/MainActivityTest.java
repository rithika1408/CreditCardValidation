package com.example.creditcardvalidation;

import android.view.View;
import android.widget.EditText;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule=new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mainActivity=null;
    private EditText cardNumber,date,cvv,fName,lName;


    @Before
    public void setUp() throws Exception {
        mainActivity=activityTestRule.getActivity();
        cardNumber=mainActivity.findViewById(R.id.cardNumber);
        date=mainActivity.findViewById(R.id.date);
        cvv=mainActivity.findViewById(R.id.cvv);
        fName=mainActivity.findViewById(R.id.firstName);
        lName=mainActivity.findViewById(R.id.lastName);
    }
    @Test
    public void test(){
        View view=mainActivity.findViewById(R.id.button);
        assertNotNull(view);
    }
    @Test
    public  void notNullTest(){
        assertNotNull(cardNumber);
        assertNotNull(date);
        assertNotNull(cvv);
        assertNotNull(fName);
        assertNotNull(lName);
    }



    @After
    public void tearDown() throws Exception {
        mainActivity=null;
    }
}




