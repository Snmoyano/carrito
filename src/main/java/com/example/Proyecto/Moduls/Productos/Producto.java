package com.example.Proyecto.Moduls.Productos;

public class Producto implements Vendible {
     String nombre;
     double costoBase;


    public Producto(String nombre, double costoBase) {
        this.nombre = nombre;
        this.costoBase = costoBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    @Override
    public double calcularPrecio() {
        return costoBase;
    }
}
