package com.example.noemia.agenda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Noemia on 28/01/2016.
 */
public class CustonAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<Contato> contatos;

    public CustonAdapter(List<Contato> itens,Context context) {
        this.contatos = contatos;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return contatos.size();
    }

    @Override
    public Object getItem(int position) {
        return contatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        Contato l = contatos.get(position);

        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView =  layoutInflater.inflate(R.layout.activity_contato, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        holder.nome.setText(l.getNome());
        holder.imagem.setImageResource(l.getImagem());
        holder.numero.setText(l.getNumero());

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.tvNome) TextView nome;
        @Bind(R.id.tvNumero) TextView numero;
        @Bind(R.id.imageView)
        ImageView imagem;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}