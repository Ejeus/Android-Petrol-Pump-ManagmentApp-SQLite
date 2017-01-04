package com.example.bakhtiyar.helloauthentication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {


    FirebaseAuth firebaseAuth;

    AlertDialog.Builder alert;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();

        alert = new AlertDialog.Builder(this);

        if(firebaseAuth.getCurrentUser() ==null){

            finish();

            startActivity( new Intent(this, LoginActivity.class));

        }

        FirebaseUser user = firebaseAuth.getCurrentUser();





        findViewById(R.id.logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(ProfileActivity.this, LoginActivity.class));

            }
        });


        findViewById(R.id.employ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                startActivity ( new Intent (ProfileActivity.this,MainEmployPage.class));

            }
        });

        findViewById(R.id.product).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,MainProductPage.class));
            }
        });

        findViewById(R.id.boss).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,BossView.class));
            }
        });

        findViewById(R.id.event).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,EventActivity.class));
            }
        });


        findViewById(R.id.Hello).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ProfileActivity.this, "Welcome to Application About Petrol Pump :)", Toast.LENGTH_SHORT).show();

            }
        });


        findViewById(R.id.discription).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alert.setIcon(R.drawable.aaa);

                alert.setMessage("This app is about managment of Petrol Pump related In this app you can handle your products detail" +
                        "and Employs attendance record etc using SQLite Database");

                alert.show();

                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        return;
                    }
                });


            }
        });

    }
}
