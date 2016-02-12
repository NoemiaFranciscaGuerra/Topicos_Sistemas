package com.example.noemia.agenda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Noemia on 28/01/2016.
 */
public class CustonAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private ArrayList itens;

    public CustonAdapter(ArrayList<Contato>itens, Context context){
        this.itens= itens;
        layoutInflater = layoutInflater.from(context);
    }
    @Override
    public int getCount(){
        return itens.size();
    }
    @Override
    public Object getItem(int position){
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int positon,View convertView,ViewGroup parent){
        Contato item = (Contato) itens.get(positon);
        convertView= layoutInflater.inflate(R.layout.activity_contato, null);

                ((TextView)convertView.findViewById(R.id.tvNome)).setText(item.getNome());
               ((TextView)convertView.findViewById(R.id.tvNumero)).setText(item.getNumero());
                      return convertView;

    }
}
