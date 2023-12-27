package com.example.Proyecto.Controller;

import com.example.Proyecto.Moduls.Productos.Comestible;
import com.example.Proyecto.Moduls.Productos.Electronico;
import com.example.Proyecto.Moduls.Productos.Ropa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class TiendaController {
    public static List<Ropa> listaRopa;
    public static List<Comestible> listaComestibles ;
    public static List<Electronico> listaElectronicos ;
    public void inicializarListas() {
        //Si la lista de productos de ropa esta vacia AGREGA
        if (listaRopa==null ) {
            listaRopa = new ArrayList<>();
            Ropa prenda1 = new Ropa("Remera", 10000, "Zara", "Blanca", "L");
            Ropa prenda2 = new Ropa("Pantalón", 15000, "Adidas", "Negro", "50");
            Ropa prenda3 = new Ropa("Zapatillas", 50000,"Vans", "Negra", "40");
            listaRopa.add(prenda1);
            listaRopa.add(prenda2);
            listaRopa.add(prenda3);
        }
        //Si la lista de productos COMESTIBLES esta vacia AGREGA
        if (listaComestibles==null ) {
            listaComestibles = new ArrayList<>();
            Comestible comes1 = new Comestible("Limon", 700);
            Comestible comes2 = new Comestible("Fideos", 700);
            Comestible comes3 = new Comestible("Atun", 500);
            Comestible comes4 = new Comestible("Carne", 1000);
            listaComestibles.add(comes1);
            listaComestibles.add(comes2);
            listaComestibles.add(comes3);
            listaComestibles.add(comes4);
        }
            //Si la lista de productos electronicos esta vacia AGREGA
        if (listaElectronicos==null ) {
            listaElectronicos = new ArrayList<>();
            Electronico celular = new Electronico("Gabinete", 250000, "Hyperfury");
            Electronico teclado = new Electronico("Teclado ", 50000, "RedDragon");
            Electronico astrolabio = new Electronico("Parlante", 20000, "SONY");
            listaElectronicos.add(celular);
            listaElectronicos.add(teclado);
            listaElectronicos.add(astrolabio);
        }
    }
    @GetMapping("/")
    public String prueba(){
        return "Hola";
    }
    @GetMapping("/ropa")
    public String ropa(Model model){
        inicializarListas();
        model.addAttribute("prendas", listaRopa);
        return "ropa";
    }
    @GetMapping("/comida")
    public String mapComida(Model model){
        model.addAttribute("comidas", listaComestibles);
        return "comestible";
    }
    @GetMapping("/electronico")
    public String electronico(Model model){
        inicializarListas();
        model.addAttribute("electronicos", listaElectronicos);
        return "electronico";
    }

}
