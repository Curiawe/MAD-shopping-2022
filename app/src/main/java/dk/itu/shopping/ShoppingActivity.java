package dk.itu.shopping;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShoppingActivity extends AppCompatActivity {

    //Shopping V1

    // GUI variables
    private Button listItems;
    private TextView items;

    // Model: Database of items
    private ItemsDB itemsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping);

        itemsDB= new ItemsDB();
        itemsDB.fillItemsDB();

        items= findViewById(R.id.items);

        listItems= findViewById(R.id.list_button);

        // Lambda expression version of writing and handling onClick listening event
        listItems.setOnClickListener((View view) -> {
            items.setBackgroundColor(Color.parseColor("#FFFFFF"));
            items.setText("Shopping List:" + itemsDB.listItems());
        });

    }
}