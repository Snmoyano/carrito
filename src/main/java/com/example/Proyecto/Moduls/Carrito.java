package com.example.Proyecto.Moduls;

import com.example.Proyecto.Controller.TiendaController;
import com.example.Proyecto.Moduls.Productos.Producto;
import com.example.Proyecto.Moduls.Productos.Vendible;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class Carrito {
    Scanner scanner = new Scanner(System.in);
    public static List<Vendible> listaProductos = new ArrayList<>();


    public static void agregarProducto(Vendible producto){
        listaProductos.add(producto);
    }

    public void agregarRopa() {
        System.out.println("Ingrese id del producto ");
        int idRopa = scanner.nextInt();
        if (idRopa >= 0 && idRopa < TiendaController.listaRopa.size()) {
            Vendible productoRopa = TiendaController.listaRopa.get(idRopa);
            Carrito.agregarProducto(productoRopa);
            Producto productoRop = (Producto) productoRopa;
            System.out.println(productoRop.getNombre() + " Fue agregado  al carro.");
        } else {
            System.out.println("Producto no existe");
        }
    }

    public void agregarComestible() {
        System.out.println("Ingrese id del producto ");
        int idComestible = scanner.nextInt();
        if (idComestible >= 0 && idComestible < TiendaController.listaComestibles.size()) {
            Vendible productoComestible = TiendaController.listaComestibles.get(idComestible);
            Carrito.agregarProducto(productoComestible);
            Producto productoComes = (Producto) productoComestible;
            System.out.println(productoComes.getNombre() + " Fue agregado  al carro.");
        } else {
            System.out.println("Producto no existe");
        }
    }

    public void agregarElectronico() {
        System.out.println("Ingrese codigo/id del producto ");
        int idElectronico = scanner.nextInt();
        if (idElectronico >= 0 && idElectronico < TiendaController.listaElectronicos.size()) {
            Vendible productoElectronico = TiendaController.listaElectronicos.get(idElectronico);
            Carrito.agregarProducto(productoElectronico);
            Producto productoElec = (Producto) productoElectronico;
            System.out.println(productoElec.getNombre() + " Fue agregado  al carro.");
        } else {
            System.out.println("Producto no existe");
        }
    }

    public void contenidoCarrito() {

        for (int indice = 0; indice < Carrito.listaProductos.size(); indice++) {
            Producto producto = (Producto) Carrito.listaProductos.get(indice);
            System.out.println("Id: " + indice);
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Precio: " + producto.getCostoBase());
            ;
        }
    }

    public void verCarrito() {
        if (Carrito.listaProductos.isEmpty()) {
            System.out.println("Carro vacío.");
        } else {
            contenidoCarrito();
        }
    }

    public void eliminarProducto() {
        if (Carrito.listaProductos.isEmpty()) {
            System.out.println("Carro vacío.");

        } else {
            contenidoCarrito();

            System.out.println("Id del producto a eliminar");
            int idEliminar = scanner.nextInt();
            if (idEliminar >= 0 && idEliminar < Carrito.listaProductos.size()) {
                Producto producto = (Producto) Carrito.listaProductos.remove(idEliminar);
                System.out.println("Se Elimino : " + producto.getNombre() + " del carrito.");
            } else {
                System.out.println("Id incorrecto.");
            }
        }
    }

    public static void pagar(Double total){
        System.out.println("Ingrese dinero");
        Scanner scanner = new Scanner(System.in);
        double dinero = scanner.nextDouble();
        if (dinero<total){
            System.out.println("Dinero insuficiente");
        }else {
            double vuelto = dinero - total;
            System.out.println(" Vuelto de $" + vuelto );
            System.exit(0);
        }
    }

    public static void aplicarDescuentos(int tipoCliente){
        double total = 0;
        for (Vendible producto:listaProductos){
            total+= producto.calcularPrecio();
        }
        if (tipoCliente==1){
            double descuentoRegular = total * 0.2;
            double totalRegular = total - descuentoRegular;
            System.out.println("Total: $" + totalRegular);
            pagar(totalRegular);
        }
        else {double descuentoPremium = total * 0.5;
            double totalPremium = total - descuentoPremium;
            System.out.println("Total : $" + totalPremium) ;
            pagar(totalPremium);
        }
    }
    public void pagarCarro(){
        boolean valido;
        if (Carrito.listaProductos.isEmpty()) {
            System.out.println(" Carro Vacío.");
        } else {
            System.out.println("Tipo de cliente");
            do {
                valido = true;
                System.out.println("1. Regular 5% de descuento");
                System.out.println("2. Premium 10% de descuento");
                int tipoCliente = scanner.nextInt();
                switch (tipoCliente) {
                    case 1:
                        Carrito.aplicarDescuentos(1);
                        break;
                    case 2:
                        Carrito.aplicarDescuentos(2);
                        break;
                    default:
                        System.out.println("Ingrese  cliente válido");
                        valido = false;
                        break;
                }
            } while (!valido);
        }
    }
}