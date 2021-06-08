package com.parcial.codigotransapp.services.persona;

import com.parcial.codigotransapp.dao.PersonaDTO;
import com.parcial.codigotransapp.model.Persona;
import com.parcial.codigotransapp.services.persona.respuesta.RespuestaPersona;
import com.parcial.codigotransapp.util.CustomResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

interface PersonaClient {
       @GET("api/persona")
       Call<List<Persona>> getPersonas();

       @POST("api/persona")
       Call<CustomResponse<RespuestaPersona>> insertar(@Header("Content-Type") String contentTypeApplicationJson, @Body PersonaDTO persona);

       @DELETE("api/persona/{id}")
       Call<CustomResponse<RespuestaPersona>> eliminar(@Header("Content-Type") String contentTypeApplicationJson, @Body Integer idPersona);

       @PUT("v1/persona/{idPersona}")
       Call<CustomResponse<RespuestaPersona>> actualizar(@Header("Content-Type") String contentTypeApplicationJson, @Body PersonaDTO persona, @Path("idPersona") int idPersona);
}
