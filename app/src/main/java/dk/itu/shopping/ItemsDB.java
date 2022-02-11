package dk.itu.shopping;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ItemsDB {
    private static ItemsDB sItemsDB;
    private List<Item> itemsDB= new ArrayList<>();

    private ItemsDB() {
        fillItemsDB();
    }

    public static void initialize() {
        if (sItemsDB == null) sItemsDB= new ItemsDB();
    }

    public static ItemsDB get() {
        if (sItemsDB == null) throw new IllegalStateException("ItemsDB must be initialized");
        return sItemsDB;
    }

    //remove last item on list
    public static ItemsDB deleteLast() {
        if (sItemsDB.itemsDB.size() != 0) {
            sItemsDB.itemsDB.remove(sItemsDB.itemsDB.size()-1);
        }
        return sItemsDB;
    }

    public String listItems() {
        String r= "";
        for(Item i: itemsDB)
            r= r+"\n Buy " + i.toString();
        return r;
    }

    public void addItem(String what, String where){
        itemsDB.add(new Item(what, where));
    }



    public void fillItemsDB() {
        itemsDB.add(new Item("coffee", "Irma"));
        itemsDB.add(new Item("carrots", "Netto"));
        itemsDB.add(new Item("milk", "Netto"));
        itemsDB.add(new Item("bread", "bakery"));
        itemsDB.add(new Item("butter", "Irma"));
    }

}

