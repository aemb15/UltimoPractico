package dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BuscarSocio {

    private GestorDeSocios miGestor;

    public BuscarSocio(GestorDeSocios socios) {
        this.miGestor = socios;
    }

    public ArrayList<Socio> getSociosPorGenero(Predicate<Socio> predicado){
        return miGestor.socios.stream().filter(predicado).collect(Collectors.toCollection(ArrayList<Socio>::new));
    }

    public ArrayList<Socio> getSociosOrdenadosPorEdad(Comparator<Socio> comparador){
        return miGestor.socios.stream().sorted(comparador).collect(Collectors.toCollection(ArrayList<Socio>::new));
    }

    public ArrayList<Socio> getNombresSociosMayoresDe(Predicate<Socio> predicado){
        return miGestor.socios.stream().filter(predicado).collect(Collectors.toCollection(ArrayList<Socio>::new));
    }
}
