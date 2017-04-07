package me.jakir.checkboxwithlistview;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class ShoppingListAdapter extends ArrayAdapter<ShoppingList> {
    private ArrayList<ShoppingList> shoppingLists;

    public ShoppingListAdapter(Context context, int iewResourceId,
                               ArrayList<ShoppingList> shoppingLists) {
        super(context, iewResourceId, shoppingLists);

        this.shoppingLists = new ArrayList<ShoppingList>();
        this.shoppingLists.addAll(shoppingLists);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;


        if (convertView == null) {
            LayoutInflater vi = ((Activity) getContext()).getLayoutInflater();

            convertView = vi.inflate(R.layout.list_item, null);

            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.status = (CheckBox) convertView.findViewById(R.id.checkbox);
            convertView.setTag(holder);


        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        ShoppingList shoppingList = shoppingLists.get(position);

        holder.title.setText(shoppingList.getTitle());
        holder.status.setChecked(shoppingList.isStatus());

        return convertView;

    }


    private class ViewHolder {
        TextView title;
        CheckBox status;
    }


}
