package com.example.bakhtiyar.helloauthentication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class UpdateActivity extends AppCompatActivity {

    Data data;
    String id;

Bundle bundle;

    private int REQUEST_IMAGE_CAPTURE = 1;

    Button n, f, a, s , p, e, i,iup;

    byte[] b;

    ImageView imageView;

    String name, fname, phone, email;

    int age;
    float salary;

    EditText nd, fd, ad, sd, pd, ed;

    TextView txt;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK && data!=null) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");



            imageView = (ImageView)  findViewById(R.id.edimg);
            imageView.setImageBitmap(imageBitmap);

            // Convert Bitmap to byte array
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
            b = stream.toByteArray();
        }




        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

    bundle = getIntent().getExtras();

        id = bundle.getString("key");

        txt = (TextView) findViewById(R.id.uid);

        txt.setText(id+"");

        data = new Data(this);

        nd = (EditText) findViewById(R.id.edempname);
        fd = (EditText) findViewById(R.id.edempfname);
        ad = (EditText) findViewById(R.id.edempage);
        sd = (EditText) findViewById(R.id.edempsalary);
        pd = (EditText) findViewById(R.id.edempphone);
        ed = (EditText) findViewById(R.id.edempemail);

        nd.setText(EmployTemporaryData.getName());

        fd.setText(EmployTemporaryData.getFatherName());

        ad.setText(EmployTemporaryData.getAge()+"");

        sd.setText(EmployTemporaryData.getSalary()+"");

        pd.setText(EmployTemporaryData.getPhone());

        ed.setText(EmployTemporaryData.getEmail());

        n= (Button) findViewById(R.id.btnedempname);
        f= (Button) findViewById(R.id.btnedempfname);
        a= (Button) findViewById(R.id.btnedempage);
        s= (Button) findViewById(R.id.btnedempsalary);
        p= (Button) findViewById(R.id.btnedempphone);
        e= (Button) findViewById(R.id.btnedempemail);
        i= (Button) findViewById(R.id.edemppic);
        iup= (Button) findViewById(R.id.btnedemppic);



            n.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    name = nd.getText().toString().trim();
                    if(TextUtils.isEmpty(name)){

                        return;
                    }else {
                        data.updateRecord(name,1,id);

                    }

                }
            });



            f.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    fname = fd.getText().toString().trim();
                    if(TextUtils.isEmpty(fname)){

                        return;
                    }else {
                        data.updateRecord(fname,2,id);

                    }
                }
            });

        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone = pd.getText().toString().trim();
                if(TextUtils.isEmpty(phone)){

                    return;
                }else {
                    data.updateRecord(phone,3,id);

                }
            }
        });


        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = ed.getText().toString().trim();
                if(TextUtils.isEmpty(email)){

                    return;
                }else {
                    data.updateRecord(email,4,id);

                }
            }
        });

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               try {


                   age = Integer.parseInt( ad.getText().toString());

                       data.updateRecord(age,id);


               }catch (Exception e){
                   Toast.makeText(UpdateActivity.this, ""+e, Toast.LENGTH_SHORT).show();

               }
            }
        });

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {


                    salary = Float.parseFloat( sd.getText().toString());

                    data.updateRecord(salary,id);


                }catch (Exception e){
                    Toast.makeText(UpdateActivity.this, ""+e, Toast.LENGTH_SHORT).show();

                }
            }
        });


    i.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getApplicationContext().getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    });

        iup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (b==null){

                    Toast.makeText(UpdateActivity.this, "No Image Capture for update", Toast.LENGTH_SHORT).show();

                }
                else {

                    data.updateRecord(b,id);
                }

            }
        });

    }
}
