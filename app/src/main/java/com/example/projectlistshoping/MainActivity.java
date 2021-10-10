package com.example.projectlistshoping;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ProductAdapter adapter;
    ArrayList<Product> products = new ArrayList<Product>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDate();
        ListView listView = findViewById(R.id.productList);
        ProductAdapter productAdapter = new ProductAdapter(this, R.layout.list_item, products);
        listView.setAdapter(productAdapter);

    }

    void initDate() {
        products.add(new Product("Картофель", 5, "Кг"));
        products.add(new Product("Морковь", 3, "Кг"));
        products.add(new Product("Лук", 5, "шт"));
        products.add(new Product("Вода", 1, "Литр"));

    }

    public void add(View view) {
        EditText product = (EditText) findViewById(R.id.product);
        EditText number = (EditText) findViewById(R.id.number);
        Button add = (Button) findViewById(R.id.add);
        String dob = product.getText().toString() + "" + number.getText().toString();
        if (!dob.isEmpty()) {
            adapter.add(new Product(product.toString(), number.toString()));
            product.setText("");
            number.setText("");
            adapter.notifyDataSetChanged();
        }
    }
}