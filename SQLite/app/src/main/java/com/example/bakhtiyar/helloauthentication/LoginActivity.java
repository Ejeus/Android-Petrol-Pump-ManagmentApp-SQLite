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
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {


    private Button login;


    private EditText logemail, logpasword;

    private TextView loglink;

    private ProgressDialog logprogressDialog;

    private FirebaseAuth logfirebaseAuth;

    public FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logfirebaseAuth = FirebaseAuth.getInstance();


        user = logfirebaseAuth.getCurrentUser();

        if(user!=null){
            //

            Toast.makeText(LoginActivity.this, "already sign in", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this,ProfileActivity.class));
        }


        logprogressDialog = new ProgressDialog(this);

        login = (Button) findViewById(R.id.login);

        logemail = (EditText) findViewById(R.id.logemail);

        logpasword = (EditText) findViewById(R.id.logpassword);

        loglink = (TextView) findViewById(R.id.link);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email,password;


                email = logemail.getText().toString();

                password = logpasword.getText().toString();

           //     for (int i=0;i<4;i++){



             //   }


                if(TextUtils.isEmpty(email)){

                    Toast.makeText(LoginActivity.this, "Please typre email", Toast.LENGTH_SHORT).show();

                return;

                }

                if(TextUtils.isEmpty(password)){

                    Toast.makeText(LoginActivity.this, "Please typre password", Toast.LENGTH_SHORT).show();
                    return;
                }

                //
                int a=0;
                logprogressDialog.setMessage("Please wait");
                logprogressDialog.show();

                logfirebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        logprogressDialog.dismiss();
                        if(task.isSuccessful()){
                            Employ.employtableName = "tablename_"+logfirebaseAuth.getCurrentUser().getUid().toString()+"records";

                            Employ.employAttentdancetable =  "tablename_"+logfirebaseAuth.getCurrentUser().getUid().toString()+"Attendance";

                            Employ.petrolRecord = "tablename_"+logfirebaseAuth.getCurrentUser().toString()+"Petrol";
                            Employ.dieselRecord = "tablename_"+logfirebaseAuth.getCurrentUser().toString()+"Diesel";
                            Employ.cngRecord = "tablename_"+logfirebaseAuth.getCurrentUser().toString()+"Cng";


                                startActivity(new Intent(LoginActivity.this,ProfileActivity.class));
//                            Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();



                        }
                        else{

                            Toast.makeText(LoginActivity.this, "Not Success", Toast.LENGTH_SHORT).show();
//
//                            finish();
//
//                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        }



                    }
                });






            }
        });








    }
}
