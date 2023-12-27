package com.example.Proyecto.Moduls.Productos;

public class Ropa extends Producto{
    private String marca;
    private String color;
    private String talle;

    public Ropa(String nombre, double costoBase, String marca, String color, String talle) {
        super(nombre, costoBase);
        this.marca = marca;
        this.color = color;
        this.talle = talle;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }
    @Override
    public double calcularPrecio() {
        return costoBase;
    }
}
