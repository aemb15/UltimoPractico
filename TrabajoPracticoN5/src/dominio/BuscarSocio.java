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

    public ArrayList<Socio> getSociosConPrestamosActivos(Predicate<Socio> predicado){
        return miGestor.socios.stream().filter(predicado).collect(Collectors.toCollection(ArrayList<Socio>::new));
    }

    public ArrayList<Socio> getSocios(Predicate<Socio> p, Comparator<Socio> c) {
        return miGestor.socios.stream().filter(p).sorted(c).collect(Collectors.toCollection(ArrayList<Socio>::new));
    }

    public ArrayList<String> getSocios2(Predicate<Socio> p, Comparator<Socio> c) {
        return miGestor.socios.stream().filter(p).sorted(c).map(s->s.toString()).collect(Collectors.toCollection(ArrayList<String>::new));
    }

    public ArrayList<Integer> getSocios3(Predicate<Socio> p, Comparator<Socio> c) {
        return miGestor.socios.stream().filter(p).sorted(c).map(s->s.getNroSocio()).collect(Collectors.toCollection(ArrayList<Integer>::new));
    }
}
