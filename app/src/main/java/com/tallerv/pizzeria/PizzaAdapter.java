package com.tallerv.pizzeria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PizzaAdapter extends BaseAdapter {

    private Context context;
    private List<Pizza> pizzaList;

    private PizzaAdapter() { }

    public PizzaAdapter(Context context, List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pizzaList.size();
    }

    @Override
    public Object getItem(int i) {
        return pizzaList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return (long) pizzaList.get(i).getNombre().hashCode();
    }

    @Override
    public View getView(int i, View pizzaView, ViewGroup viewGroup) {
        pizzaView = LayoutInflater.from(context).inflate(R.layout.pizza_item, viewGroup, false);

        TextView nombreTv = (TextView) pizzaView.findViewById(R.id.nombre);
        TextView precioTv = (TextView) pizzaView.findViewById(R.id.precio);
        ImageView fotoImg = (ImageView) pizzaView.findViewById(R.id.foto);

        Pizza pizza = pizzaList.get(i);

        nombreTv.setText(pizza.getNombre());
        precioTv.setText(Double.toString(pizza.getPrecio()));
        fotoImg.setImageResource(pizza.getFotoId());
        pizzaView.setOnClickListener(new PizzaOnClickListener(context, pizza));

        return pizzaView;
    }
}
