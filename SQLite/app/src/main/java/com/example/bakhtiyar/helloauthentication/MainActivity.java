package com.example.bakhtiyar.helloauthentication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button submit;

    private EditText email, pasword;

    private TextView link;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        this.deleteDatabase(Employ.DB_NAME);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        submit = (Button) findViewById(R.id.signup);

        email = (EditText) findViewById(R.id.email);

        pasword = (EditText) findViewById(R.id.password);

        link = (TextView) findViewById(R.id.link);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sEmail = email.getText().toString();

                String sPassword = pasword.getText().toString();

                if (TextUtils.isEmpty(sEmail)) {

                    Toast.makeText(MainActivity.this, "Please Enter your Email", Toast.LENGTH_SHORT).show();

                    email.setText("");
                    return;
                }

                if (TextUtils.isEmpty(sPassword)) {

                    Toast.makeText(MainActivity.this, "Please Enter your Email", Toast.LENGTH_SHORT).show();

                    pasword.setText("");
                    return;
                }

                progressDialog.setMessage("Please wait");
                progressDialog.show();

                firebaseAuth.createUserWithEmailAndPassword(sEmail, sPassword).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.hide();
                        if (task.isSuccessful()) {

                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                            //Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();

                        } else {

                            Toast.makeText(MainActivity.this, "UnSuccessful", Toast.LENGTH_SHORT).show();
                        }


                    }
                });

            }
        });


        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
                startActivity(new Intent(MainActivity.this,LoginActivity.class));


            }
        });


    }
}
