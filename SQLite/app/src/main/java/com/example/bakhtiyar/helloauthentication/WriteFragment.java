package com.example.bakhtiyar.helloauthentication;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;


/**
 * A simple {@link Fragment} subclass.
 */
public class WriteFragment extends Fragment {

    Data data;

    String name,fname,email,phone;

    int age;

    float salary;

    LayoutInflater inf;

    View v;

    private int REQUEST_IMAGE_CAPTURE = 1;
    byte[] image;


    EditText n, f, e, p, a, s;


    LayoutInflater infl;

ImageView img;

    public static final int RESULT_OK = -1;

    public WriteFragment() {

        // Required empty public constructor
    }




    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {



        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK && data!=null) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");



            img = (ImageView)  v.findViewById(R.id.img);
            img.setImageBitmap(imageBitmap);

            // Convert Bitmap to byte array
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
            image = stream.toByteArray();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        v = inflater.inflate(R.layout.fragment_write, container, false);

        n = (EditText) v.findViewById(R.id.name);
        f = (EditText) v.findViewById(R.id.fathername);
        e = (EditText) v.findViewById(R.id.email);
        p = (EditText) v.findViewById(R.id.phone);
        a = (EditText) v.findViewById(R.id.age);
        s = (EditText) v.findViewById(R.id.salary);

        data = new Data(getContext());



        v.findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    name = n.getText().toString();

                    fname = f.getText().toString();

                    age = Integer.parseInt( a.getText().toString());

                    salary = Float.parseFloat( s.getText().toString());

                    email = e.getText().toString();

                    phone = p.getText().toString();


//                    if(TextUtils.isEmpty(name)){
//
//                        Toast.makeText(getContext(), "Please Insert Name", Toast.LENGTH_SHORT).show();
//                        return;
//                    }
//
//                    else if(TextUtils.isEmpty(fname)){
//
//                        Toast.makeText(getContext(), "Please Insert Father Name", Toast.LENGTH_SHORT).show();
//                        return;
//                    }
//
//                    else if(TextUtils.isEmpty(name)){
//
//                        Toast.makeText(getContext(), "Please Insert Name", Toast.LENGTH_SHORT).show();
//                        return;
//                    }
//
//                    else if(TextUtils.isEmpty(name)){
//
//                        Toast.makeText(getContext(), "Please Insert Name", Toast.LENGTH_SHORT).show();
//                        return;
//                    }
//
//                    else if(TextUtils.isEmpty(name)){
//
//                        Toast.makeText(getContext(), "Please Insert Name", Toast.LENGTH_SHORT).show();
//                        return;
//                    }
//


                    if (image==null){

                        if(data.writeEmployData(name,fname,email,phone,age,salary,null)){

                            Toast.makeText(getContext(), "Inserted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getContext(),MainEmployPage.class));
                        }
                        else {
                            Toast.makeText(getContext(), "Not Inserted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getContext(),MainEmployPage.class));
                        }
                    }
                    else {

                        if(data.writeEmployData(name,fname,email,phone,age,salary,image)){

                            Toast.makeText(getContext(), "Inserted", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getContext(),MainEmployPage.class));
                            }
                        else {
                            Toast.makeText(getContext(), "Not Inserted", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(getContext(),MainEmployPage.class));
                        }

                    }


                }catch (Exception e){
                    Toast.makeText(getContext(), ""+e, Toast.LENGTH_SHORT).show();

                }


            }
        });

        v.findViewById(R.id.takeImage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getContext().getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });





        return v;
    }

}
