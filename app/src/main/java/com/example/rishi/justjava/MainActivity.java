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
     * This method is called when the order button is clicked.


    */
public void submitOrder(View view){



display(quantity);
    displayPrice(quantity*50);
}


private void display(int number)
{
TextView quantitytextview = (TextView) findViewById(R.id.quantity_text_view);

    quantitytextview.setText(""+number);

}

    /**
     * This method displays the given price on the screen.
     */
    public void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }


    public void increment(View view)
    {
        quantity++;
        display(quantity);
    }
    public void decrement(View view)
    {
        quantity--;
        display(quantity);
    }
}


