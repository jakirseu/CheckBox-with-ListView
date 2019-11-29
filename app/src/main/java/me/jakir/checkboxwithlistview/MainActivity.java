package me.jakir.checkboxwithlistview;

import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ShoppingList> shoppingLists = new ArrayList<ShoppingList>();
    ListView list;

    ShoppingListAdapter adapter;
    Button checkItems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateListView();


        checkItems = (Button) findViewById(R.id.button);

        checkItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "Checked items: ";

                for (int i = 0; i < list.getCount(); i++) {
                    v = list.getChildAt(i);



                    CheckBox cb = (CheckBox) v.findViewById(R.id.checkbox);
                    if (cb.isChecked()) {

                        TextView tv = (TextView) v.findViewById(R.id.title);
                        tv.getText();

                        result += tv.getText() + ", ";
                    }
                }

                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void populateListView() {


        ShoppingList shopping1 = new ShoppingList("Buy Coffee", false);
        shoppingLists.add(shopping1);

        ShoppingList shopping2 = new ShoppingList("Buy Milk", true);
        shoppingLists.add(shopping2);

        adapter = new ShoppingListAdapter(this, R.layout.list_item, shoppingLists);
        list = (ListView) findViewById(R.id.list_view);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                CheckBox cb = (CheckBox) view.findViewById(R.id.checkbox);
                cb.setChecked(!cb.isChecked());

            }

        });

    }


}
