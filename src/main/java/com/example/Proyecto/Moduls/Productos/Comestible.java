package com.example.Proyecto.Moduls.Productos;

public class Comestible extends Producto{
    public Comestible(String nombre, double costoBase) {
        super(nombre, costoBase);
    }

    @Override
    public double calcularPrecio() {
        return costoBase;
    }
}
