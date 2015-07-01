package com.siddhartha.com.sqlite.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.siddhartha.com.sqlite.R;
import com.siddhartha.com.sqlite.bean.items;

import java.util.ArrayList;

/**
 * Created by Siddhartha Maji on 6/30/2015.
 */
public class MyListAdapter extends BaseAdapter {

    Context context;
    ArrayList<items> arrayList;
    LayoutInflater _layoutInflater;

    public MyListAdapter(Context context, ArrayList<items> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        _layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public items getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rootView = convertView;
        if(rootView == null)    //If it goes wrong....
        {
            rootView = _layoutInflater.inflate(R.layout.table_layout,null);
            ItemHolder itemHolder = new ItemHolder();
            itemHolder.txt_name = (TextView)rootView.findViewById(R.id.txt_name);
            itemHolder.txt_number = (TextView)rootView.findViewById(R.id.txt_number);
            itemHolder.txt_id = (TextView)rootView.findViewById(R.id.txt_id);

            rootView.setTag(itemHolder);

        }
        ItemHolder newItemHolder = (ItemHolder)rootView.getTag();
        newItemHolder.txt_name.setText(arrayList.get(position).getNames());
        newItemHolder.txt_number.setText(arrayList.get(position).getNumbers());
//        newItemHolder.txt_id.setText(arrayList.get(position).getIndex());
        return rootView;
    }

    private class ItemHolder
    {
       TextView txt_name,txt_number,txt_id;
    }
}
