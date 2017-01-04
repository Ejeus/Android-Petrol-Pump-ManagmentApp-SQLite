package com.example.bakhtiyar.helloauthentication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class BossView extends AppCompatActivity {

    RadioButton rad1,rad2,rad3;

    int i;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boss_view);

    btn = (Button) findViewById(R.id.bossproview);
        rad1 = (RadioButton) findViewById(R.id.petrol);
        rad2 = (RadioButton) findViewById(R.id.diesel);
        rad3 = (RadioButton) findViewById(R.id.cng);

        rad1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                i=1;
            }
        });

        rad2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                i=2;
            }
        });

        rad3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                i=3;
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(rad1.isChecked()){

                    Intent intent = new Intent(BossView.this,BossReadActivity.class);

                    BossVariable.var = 1;
                    startActivity(intent);

                }
                else if(rad2.isChecked())
                {

                    Intent intent = new Intent(BossView.this,BossReadActivity.class);

                    BossVariable.var = 2;
                    startActivity(intent);


                }else
                if(rad3.isChecked()){

                    Intent intent = new Intent(BossView.this,BossReadActivity.class);

                    BossVariable.var = 3;
                    startActivity(intent);

                }


            }
        });

        findViewById(R.id.viewemplrec).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BossView.this,ViewEmployRecord.class));
            }
        });

    }
}
