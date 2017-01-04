package com.example.bakhtiyar.helloauthentication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Bakhtiyar on 12/1/2016.
 */
public class ProductCustomAdapter extends BaseAdapter {

    TextView txtname, purchase, sale, price, date,stock;


   ArrayList<Product> arrayList;

    Context context;

    LayoutInflater infl;

    public ProductCustomAdapter(ArrayList<Product> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = infl.from(context).inflate(R.layout.product_custom_layout,viewGroup,false);

        txtname= (TextView) view.findViewById(R.id.prname);

        purchase = (TextView) view.findViewById(R.id.prpurch);

        sale = (TextView) view.findViewById(R.id.pursale);

        price = (TextView) view.findViewById(R.id.purprice);

        date = (TextView) view.findViewById(R.id.purdate);

        stock = (TextView) view.findViewById(R.id.purstock);

        txtname.setText(arrayList.get(i).getName());

        purchase.setText(purchase.getText()+""+ arrayList.get(i).getPurchase());

        sale.setText(sale.getText()+""+arrayList.get(i).getSale());

        price.setText(price.getText()+""+arrayList.get(i).getPrice());

        date.setText(date.getText()+""+arrayList.get(i).getDate());

        stock.setText(stock.getText()+""+arrayList.get(i).getStock());
        return view;
    }
}
