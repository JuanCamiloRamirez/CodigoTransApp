package com.parcial.codigotransapp.util;

import android.content.Context;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

    private final OkHttpClient simpleClient = new OkHttpClient.Builder()
            .readTimeout(Parametro.CONNECTION_TIMEOUT_RETROFIT, TimeUnit.SECONDS)
            .connectTimeout(Parametro.CONNECTION_TIMEOUT_RETROFIT, TimeUnit.SECONDS)
            .build();
    private Context context;

    public RetrofitFactory(Context context) {
        this.context = context;
    }


    protected Retrofit getRetrofitInstance(){
        return new Retrofit.Builder().baseUrl(Parametro.URL_BASE).addConverterFactory(GsonConverterFactory.create()).client(simpleClient).build();
    }

    protected Context getContext(){
        return context;
    }

    protected void getOnFailure(Throwable t){
        Toast.makeText(context, "Error de comunicación: "+ t.getMessage(), Toast.LENGTH_LONG).show();
    }


}
