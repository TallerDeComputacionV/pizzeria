package com.tallerv.pizzeria;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

//Interfaz que lista los metodos disponibles para ser consultados de la API
interface PizzeriaApi {

    @GET("pizzas") //Verbo HTTP y nombre del metodo de la API
    public Call<List<Pizza>> getPizzas(); //El return type define como sera parseado automaticamente el response

}
