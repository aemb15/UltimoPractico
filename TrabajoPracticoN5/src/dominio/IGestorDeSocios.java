package dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public interface IGestorDeSocios {

    void agregarSocio(Socio socio);
    boolean verificarSocio(Socio socio);
    void eliminarSocio(Socio socio);
    boolean existeSocio(Socio socio);
    void limpiarSocio();
    double getPromedioEdad();
    ArrayList<Socio> getSociosPorGenero(Predicate<Socio> predicado);
    ArrayList<Socio> getSociosOrdenadosPorEdad(Comparator<Socio> comparador);
    ArrayList<Socio> getNombresSociosMayoresDe(Predicate<Socio> predicado);
    ArrayList<Socio> getSociosConPrestamosActivos(Predicate<Socio> predicado);
    ArrayList<Socio> getSocios(Predicate<Socio> p, Comparator<Socio> c);
    ArrayList<String> getSocios2(Predicate<Socio> p, Comparator<Socio> c);
    ArrayList<Integer> getSocios3(Predicate<Socio> p, Comparator<Socio> c);
}
