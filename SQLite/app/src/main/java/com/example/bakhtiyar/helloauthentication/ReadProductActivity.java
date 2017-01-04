package com.example.bakhtiyar.helloauthentication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ReadProductActivity extends AppCompatActivity {

    Data data;

    AlertDialog.Builder alert;

    ArrayList<Product> arrayList;

    ProductCustomAdapter productCustomAdapter;

    int num;
    Bundle bundle;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_product);

    bundle = getIntent().getExtras();

        num= bundle.getInt("key");

        alert = new AlertDialog.Builder(ReadProductActivity.this);

        data = new Data(this);

        listView = (ListView) findViewById(R.id.readproductlist);


        arrayList = data.readProduct(num);

        if(arrayList==null){

            Toast.makeText(ReadProductActivity.this, "There is no data", Toast.LENGTH_SHORT).show();
        }
        else {


            productCustomAdapter = new ProductCustomAdapter(arrayList,getApplicationContext());

            listView.setAdapter(productCustomAdapter);

        }


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final int temp=i;

                alert.setMessage("Are You Sure you wan't to Delete this? ");

                alert.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        data.deleteProduct(arrayList.get(temp).getId(),num);
                        Toast.makeText(ReadProductActivity.this, "Deleted", Toast.LENGTH_SHORT).show();

                    }
                });



                alert.show();

            }
        });





    }
}
