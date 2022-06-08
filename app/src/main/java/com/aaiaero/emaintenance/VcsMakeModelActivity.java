package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VcsMakeModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vcs_make_model);

        Button sitti, schmid, drake, frequentis;

        sitti = (Button) findViewById(R.id.sitti);
        schmid = (Button) findViewById(R.id.schmid);
        drake = (Button) findViewById(R.id.drake);
        frequentis = (Button) findViewById(R.id.frequentis);

        sitti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),VcsSittiActivity.class);
                startActivity(intent);
            }
        });

        schmid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        drake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DmeGeclActivity.class);
                startActivity(intent);
            }
        });

        frequentis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}