package com.parcial.codigotransapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.parcial.codigotransapp.R;
import com.parcial.codigotransapp.model.Persona;
import com.parcial.codigotransapp.services.RegistroVehiculoActivity;
import com.parcial.codigotransapp.services.persona.PersonaServiceImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonaAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private Context context;
    private final List<Persona> personas;
    private int idPersona;

    public PersonaAdapter(Context context, List<Persona> personas) {
        inflater = LayoutInflater.from(context);
        this.context=context;
        this.personas = personas;
    }

    @Override
    public int getCount() {
        return personas.size();
    }

    @Override
    public Persona getItem(int position) {
        return personas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return personas.get(position).getIdPersona().longValue();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Persona persona = getItem(position);
        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = inflater.inflate(R.layout.item_persona, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        holder.placa.setText(personas.get(position).getPlaca());
        holder.nombre.setText(personas.get(position).getNombre());
        holder.celular.setText(personas.get(position).getCelular());

        View finalConvertView = convertView;
        holder.eliminarButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setCancelable(false);
                builder.setTitle(R.string.confirm);
                builder.setMessage(R.string.confirm_message_eliminar_usuario);
                builder.setPositiveButton(R.string.confirm_action, (dialog, which) -> eliminarUsuario(finalConvertView,persona)   );
                builder.setNegativeButton(R.string.cancelar, (dialog, which) ->  dialog.cancel() );
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, RegistroVehiculoActivity.class);
                intent.putExtra("persona", persona);
                context.startActivity(intent);
            }
        });



        return convertView;
    }

    public void eliminarUsuario(View view,Persona persona ){
        PersonaServiceImpl personaService = new PersonaServiceImpl(context);
        personaService.eliminar(persona);
    }



    class ViewHolder {

        @BindView(R.id.txtPlaca)
        TextView placa;
        @BindView(R.id.txNombre)
        TextView nombre;
        @BindView(R.id.txtCelular)
        TextView celular;
        @BindView(R.id.imageButton)
        ImageButton eliminarButton;
        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
