package com.example.noemia.lanchonete;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Noemia on 11/12/2015.
 */
public class ListViewAdapter extends BaseAdapter{

    private Context context;

    public ListViewAdapter(Context context){
        super();
        this.context=context;
    }

    @Override
    public int getCount() {
        return CardapioListActivity.lanches.length;
    }

    @Override
    public Object getItem(int position) {
        return CardapioListActivity.lanches[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String lanche = CardapioListActivity.lanches[position].nome;

        TextView t = new TextView(context);
        float dip=50;
        float densidade =context.getResources().getDisplayMetrics().density;
        int px=(int)(dip*densidade+0.5f);
        t.setHeight(px);
        t.setText(lanche);
        return t;
    }
}
