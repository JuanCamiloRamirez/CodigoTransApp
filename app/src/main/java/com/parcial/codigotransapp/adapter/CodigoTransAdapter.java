package com.parcial.codigotransapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.parcial.codigotransapp.R;
import com.parcial.codigotransapp.model.CodigoTrans;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CodigoTransAdapter extends BaseAdapter implements Filterable {

    private final LayoutInflater inflater;
    private List<CodigoTrans> codigoTransIn;
    private List<CodigoTrans> codigoTransOut;

    public CodigoTransAdapter(Context context, List<CodigoTrans> codigoTrans) {
        codigoTransIn = codigoTrans;
        codigoTransOut = codigoTrans;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return codigoTransOut.size();
    }

    @Override
    public Object getItem(int position) {
        return codigoTransOut.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view != null){
            viewHolder = (ViewHolder) view.getTag();
        }else {
            view = inflater.inflate(R.layout.codigo_item, viewGroup,false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }

        viewHolder.nombre.setText(codigoTransOut.get(position).getCodigoMulta());
        viewHolder.descripcion.setText(codigoTransOut.get(position).getDescripcion());
        viewHolder.descripcion2.setText("SMDLV: "+codigoTransOut.get(position).getSalariosMinimos()+"     Valor: "+
                codigoTransOut.get(position).getValorMulta());
        return view;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults results = new FilterResults();
                List<CodigoTrans> filteredArrList = new ArrayList<>();
                if (codigoTransIn == null) {
                    codigoTransIn = new ArrayList<>(codigoTransOut);
                }
                if(charSequence == null){
                    results.count = codigoTransIn.size();
                    results.values = codigoTransIn;
                }else{
                    charSequence = charSequence.toString().toLowerCase();
                    for (int i = 0; i < codigoTransIn.size(); i++) {
                        String data = codigoTransIn.get(i).getCodigoMulta();
                        if (data.toLowerCase().contains(charSequence.toString())) {
                            filteredArrList.add(codigoTransIn.get(i));
                        }
                    }
                    results.count = filteredArrList.size();
                    results.values = filteredArrList;

                }
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                codigoTransOut = (List<CodigoTrans>) filterResults.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }

    class ViewHolder {

        @BindView(R.id.nombre)
        TextView nombre;
        @BindView(R.id.descripcion)
        TextView descripcion;
        @BindView(R.id.descripcion2)
        TextView descripcion2;

        public ViewHolder(View view)
        {
            ButterKnife.bind(this, view);
        }
    }
}
