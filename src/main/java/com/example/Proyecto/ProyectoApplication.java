package com.example.Proyecto;

import com.example.Proyecto.Controller.TiendaController;
import com.example.Proyecto.Moduls.Carrito;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);

		Scanner scanner = new Scanner(System.in);
		Carrito accionesCarrito = new Carrito();
		TiendaController tiendaController = new TiendaController();

		boolean salir;

		tiendaController.inicializarListas();


		do {
			salir = false;

			System.out.println("1.Agregar productos");
			System.out.println("2.Ver carro");
			System.out.println("3.Eliminar producto del carro");
			System.out.println("4.Abonar carro");
			System.out.println("5.Salir");

			int opcion = scanner.nextInt();

			switch (opcion) {
				case 1:
					boolean volver;
					do {
						System.out.println("1.Ropa");
						System.out.println("2.Comestibles");
						System.out.println("3.Electronicos");
						System.out.println("4.Volver");
						int opcionAgregar = scanner.nextInt();
						volver = false;
						switch (opcionAgregar) {
							case 1:
								accionesCarrito.agregarRopa();
								break;
							case 2:
								accionesCarrito.agregarComestible();
								break;
							case 3:
								accionesCarrito.agregarElectronico();
								break;
							case 4:
								volver = true;
								break;
							default:
								System.out.println("Elija  opcion correcta.");
								break;
						}
					} while (!volver);
					break;
				case 2:
					accionesCarrito.verCarrito();
					break;

				case 3:
					accionesCarrito.eliminarProducto();
					break;
				case 4:
					accionesCarrito.pagarCarro();
					break;
				case 5:
					salir = true;
					break;
				default:
					System.out.println("Seleccione opcion correcta.");
					break;
			}

		} while (!salir);

		System.exit(0);

	}
	}


