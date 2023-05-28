package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.ByteArrayOutputStream;

public class AsmgcsSelexYearlyActivity extends AppCompatActivity {

    Button smr1,smr2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asmgcs_selex_yearly);

        setTitle("Yearly SELEX ASMGCS Maintenance");

        smr1 = (Button) findViewById(R.id.smr1);
        smr2 = (Button) findViewById(R.id.smr2);


        Intent intent = getIntent();

    }

    public void smr1Clicked (View view){

        Intent intent = new Intent(getApplicationContext(),AsmgcsSelexSmr1YearlyActivity.class);
        startActivity(intent);


    }
    public void smr2Clicked (View view){

        Intent intent = new Intent(getApplicationContext(),AsmgcsSelexSmr2YearlyActivity.class);
        startActivity(intent);


    }

}
