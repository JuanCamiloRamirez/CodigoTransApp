package com.parcial.codigotransapp.services.persona;

import android.content.Context;
import android.widget.ListView;
import android.widget.Toast;

import com.parcial.codigotransapp.adapter.PersonaAdapter;
import com.parcial.codigotransapp.dao.PersonaDTO;
import com.parcial.codigotransapp.model.Persona;
import com.parcial.codigotransapp.services.persona.respuesta.RespuestaPersona;
import com.parcial.codigotransapp.util.CustomResponse;
import com.parcial.codigotransapp.util.Parametro;
import com.parcial.codigotransapp.util.RetrofitFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;


import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PersonaServiceImpl extends RetrofitFactory {

   public PersonaServiceImpl(Context context){
        super(context);
    }

   public void getPersona(ListView listViewPersonas){
       Retrofit retrofit =  getRetrofitInstance();
       PersonaClient client = retrofit.create(PersonaClient.class);
       Call<List<Persona>> response = client.getPersonas();
       response.enqueue(new Callback<List<Persona>>() {
           @Override
           public void onResponse(Call<List<Persona>> call, Response<List<Persona>> response) {
               List<Persona> listaPersonas = response.body();
               if(listaPersonas != null){
                   PersonaAdapter personaAdapter = new PersonaAdapter(getContext(),listaPersonas);
                   listViewPersonas.setAdapter(personaAdapter);
               }
           }

           @Override
           public void onFailure(Call<List<Persona>> call, Throwable t) {
               Toast.makeText(getContext(), "Error de comunicación: "+ t.getMessage(), Toast.LENGTH_LONG).show();
           }
       });
   }

    public void insertar(PersonaDTO persona) {
        Retrofit retrofit =  getRetrofitInstance();
        PersonaClient client = retrofit.create(PersonaClient.class);
        Call<CustomResponse<RespuestaPersona>> response =client.insertar(Parametro.CONTENT_TYPE_APPLICATION_JSON,persona);
        response.enqueue(new Callback<CustomResponse<RespuestaPersona>>() {
            @Override
            public void onResponse(Call<CustomResponse<RespuestaPersona>> call, Response<CustomResponse<RespuestaPersona>> response) {

            }

            @Override
            public void onFailure(Call<CustomResponse<RespuestaPersona>> call, Throwable t) {
                Toast.makeText(getContext(), "Error de comunicación: "+ t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void eliminar(Persona persona) {
        Retrofit retrofit =  getRetrofitInstance();
        PersonaClient client = retrofit.create(PersonaClient.class);
        Call<CustomResponse<RespuestaPersona>> response =client.eliminar(Parametro.CONTENT_TYPE_APPLICATION_JSON,persona.getIdPersona());
        response.enqueue(new Callback<CustomResponse<RespuestaPersona>>() {
            @Override
            public void onResponse(Call<CustomResponse<RespuestaPersona>> call, Response<CustomResponse<RespuestaPersona>> response) {

            }

            @Override
            public void onFailure(Call<CustomResponse<RespuestaPersona>> call, Throwable t) {
                Toast.makeText(getContext(), "Error de comunicación: "+ t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
