package adapter.noemia.ufms.cpcx.agenda1.cpcx.ufms.noemia.adapter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import adapter.noemia.ufms.cpcx.agenda1.R;

import static adapter.noemia.ufms.cpcx.agenda1.R.id.imageView2;

/**
 * Created by Noemia on 28/02/2016.
 */
public class CustonAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<Contato> itens;

    public CustonAdapter(List<Contato> itens, Context context) {
        this.itens = itens;
        layoutInflater = layoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int position) {
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int positon, View convertView, ViewGroup parent) {
        Contato item = (Contato) itens.get(positon);
        convertView = layoutInflater.inflate(R.layout.content_main, null);

        ((TextView) convertView.findViewById(R.id.tvNome)).setText(item.getNome());
        ((TextView) convertView.findViewById(R.id.textNumero)).setText(item.getNumero());
        ((ImageView) convertView.findViewById(imageView2)).setImageResource(item.getImagem());
        return convertView;

    }
}
