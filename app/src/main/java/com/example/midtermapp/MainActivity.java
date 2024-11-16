package com.example.midtermapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText productNameEdt, brandNameEdt, priceEdt;
    private Button addItemBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all our variables.
        productNameEdt = findViewById(R.id.txtProdName);
        brandNameEdt = findViewById(R.id.txtBrandName);
        priceEdt = findViewById(R.id.txtPrice);
        addItemBtn = findViewById(R.id.btnAdd);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(MainActivity.this);

        // below line is to add on click listener for our add course button.
        addItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String productName = productNameEdt.getText().toString();
                String brandName = brandNameEdt.getText().toString();
                String price = priceEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (productName.isEmpty() && brandName.isEmpty() && price.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewItem(productName, brandName, price);

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "Item has been added to wishlist!", Toast.LENGTH_SHORT).show();
                productNameEdt.setText("");
                brandNameEdt.setText("");
                priceEdt.setText("");
            }
        });
    }
}
