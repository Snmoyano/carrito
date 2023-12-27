package com.example.Proyecto.Moduls.Productos;

public class Electronico extends Producto {
    String marca;

    public Electronico(String nombre, double costoBase, String marca) {
        super(nombre, costoBase);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public double calcularPrecio() {
        return costoBase;
    }
}
