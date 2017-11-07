package com.tallerv.pizzeria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

//Es necesario que el adapter extienda de BaseAdapter
public class PizzaAdapter extends BaseAdapter {

    //Los atributos de la clase
    private Context context;
    private List<Pizza> pizzaList;

    //Anulamos el posible uso del constructor por defecto
    private PizzaAdapter() { }

    //El unico constructor habilitado para instanciar esta clase
    public PizzaAdapter(Context context, List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
        this.context = context;
    }

    //La cantidad de elementos de la lista
    @Override
    public int getCount() {
        return pizzaList.size();
    }

    //Obtiene el objeto de la lista
    @Override
    public Object getItem(int i) {
        return pizzaList.get(i);
    }

    //El id representativo del objeto de la lista
    @Override
    public long getItemId(int i) {
        return (long) pizzaList.get(i).getNombre().hashCode();
    }

    //Se infla el item y se lo llena de la informacion a mostrar del objeto del modelo en la posicion adecuada de la lista
    @Override
    public View getView(int i, View pizzaView, ViewGroup viewGroup) {
        //Usamos el LayoutInflater para obtener la vista del item
        pizzaView = LayoutInflater.from(context).inflate(R.layout.pizza_item, viewGroup, false);

        //Las vistas asociadas al item
        TextView nombreTv = (TextView) pizzaView.findViewById(R.id.nombre);
        TextView precioTv = (TextView) pizzaView.findViewById(R.id.precio);
        ImageView fotoImg = (ImageView) pizzaView.findViewById(R.id.foto);

        //Obtengo el objeto de la lista adecuado a la posicion con la que se llamo el metodo (parametro)
        Pizza pizza = pizzaList.get(i);

        //Le asigno a cada vista asociada, su contenido
        nombreTv.setText(pizza.getNombre());
        precioTv.setText(Double.toString(pizza.getPrecio()));
        fotoImg.setImageResource(pizza.getFotoId());
        pizzaView.setOnClickListener(new PizzaOnClickListener(context, pizza));

        //Devuelvo el item
        return pizzaView;
    }
}
