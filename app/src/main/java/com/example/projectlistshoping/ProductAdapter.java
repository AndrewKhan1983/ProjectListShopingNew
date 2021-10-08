package com.example.projectlistshoping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter <Product> {
    public LayoutInflater inflater;
    public int layout;
    public ArrayList<Product> products;

    ProductAdapter (Context context, int resource, ArrayList<Product>products){
        super(context,resource,products);
        this.products = products;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView (int position, View contentView, ViewGroup parent){
        final ViewHolder viewHolder;
        if (contentView == null){
            contentView = inflater.inflate(this.layout,parent,false);
            viewHolder = new ViewHolder(contentView);
            contentView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) contentView.getTag();
        }
        final Product product = products.get(position);

        viewHolder.nameView.setText(product.name);
        viewHolder.countView.setText(product.count + "  " + product.unit);

        viewHolder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = product.getCount()+1;
                if(count<0) count = 0;
                product.setCount(count);
                viewHolder.countView.setText(product.count + "" + product.unit);
            }
        });
        viewHolder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = product.getCount()-1;
                if(count<0) count = 0;
                product.setCount(count);
                viewHolder.countView.setText(product.count + "" + product.unit);
            }
        });
    return contentView;
    }

    private class ViewHolder{
        final Button addButton, removeButton;
        final Button add, remove;
        final TextView nameView, countView;
        final EditText product, number;
        ViewHolder (View view){
            addButton = (Button) view.findViewById(R.id.addButton);
            removeButton = (Button) view.findViewById(R.id.removeButton);
            nameView = (TextView) view.findViewById(R.id.nameView);
            countView = (TextView) view.findViewById(R.id.countView);
            add = (Button) view.findViewById(R.id.add);
            remove = (Button) view.findViewById(R.id.remove);
            product = (EditText) view.findViewById(R.id.product);
            number = (EditText) view.findViewById(R.id.number);
        }
    }
}
