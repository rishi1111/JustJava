package com.example.rishi.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
//        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
//        orderSummaryTextView.setText(message);
        String subject = "Just Java App";
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"));

        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);

        if (emailIntent.resolveActivity(getPackageManager()) != null)
            startActivity(emailIntent);

    }

    private String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChooclate, String name) {

        String summarymes = "";
        summarymes += "\nName: " + name;
        summarymes += "\nQuantity: " + quantity;
        summarymes += "\nAdd whipped cream?: " + hasWhippedCream;
        summarymes += "\nAdd Chocolate?: " + hasChooclate;
        summarymes += "\nTotal: $" + price;
        summarymes += "\nThank You";




        return summarymes;
    }

    public void submitOrder(View view) {

        CheckBox WhippedCream = (CheckBox) findViewById(R.id.whippedcream);
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate);
        Boolean hasChocolate = false;


        Boolean hasWhippedCream = false;

        EditText nameTextView = (EditText) findViewById(R.id.nameTextView);
        String name;
        name = nameTextView.getText().toString();

        hasWhippedCream = WhippedCream.isChecked();
        hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocolate);

        String summary = createOrderSummary(price, hasWhippedCream, hasChocolate, name);
        displayMessage(summary);
    }


    private void displayQuantity(int number) {
        TextView quantitytextview = (TextView) findViewById(R.id.quantity_text_view);

        quantitytextview.setText("" + number);

    }

    private int calculatePrice(boolean hasWhipped, boolean hasChocolate) {


        int price = 5;
        if (hasChocolate) {
            price += 2;
        }

        if (hasWhipped) {
            price += 1;
        }

        return price * quantity;

    }




    public void increment(View view) {

        if (quantity >= 50) {
            Toast.makeText(this, "Cannot order more than 50cups", Toast.LENGTH_SHORT).show();
            return;
        }

        quantity++;
        displayQuantity(quantity);
    }

    public void decrement(View view) {

        if (quantity <= 1) {
            Toast.makeText(this, "Cannot order less than 1", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity--;
        displayQuantity(quantity);
    }
}


