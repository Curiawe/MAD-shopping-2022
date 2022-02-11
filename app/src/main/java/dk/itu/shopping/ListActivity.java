package dk.itu.shopping;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {
    private static ItemsDB itemsDB;
    private TextView listThings;
    private Button deleteLastItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // list items
        itemsDB = ItemsDB.get();
        listThings = findViewById(R.id.listItems);
        listThings.setText("Shopping List" + itemsDB.listItems());

        //associate button
        deleteLastItem = findViewById(R.id.delete_button);
        //on click, delete latest item
        deleteLastItem.setOnClickListener((View delButton) -> {
                    itemsDB = ItemsDB.deleteLast();
                    listThings.setText("Shopping List" + itemsDB.listItems());
                });


    }
}
