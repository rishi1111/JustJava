package com.example.rishi.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    private String createOrderSummary(int price) {
        String summarymes = "Name : Rishi Kambil\nQuantity: " + quantity + "\nTotal: $" + price + "\nThank You!";

        return summarymes;
    }

    public void submitOrder(View view) {


        int price = calculatePrice(quantity);

        String summary = createOrderSummary(price);
        displayMessage(summary);
    }


    private void displayQuantity(int number) {
        TextView quantitytextview = (TextView) findViewById(R.id.quantity_text_view);

        quantitytextview.setText("" + number);

    }

    private int calculatePrice(int quantity) {

        int price = quantity * 50;
        return price;

    }


    /**
     * This method displays the given price on the screen.
     */
    public void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }


    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        quantity--;
        displayQuantity(quantity);
    }
}


