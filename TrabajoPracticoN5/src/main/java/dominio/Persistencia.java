package dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class Persistencia implements IGestorDeSocios{

    private ArrayList<Socio> listaGuardada;

    public void guardarLista(ArrayList<Socio> lista) {
        listaGuardada = new ArrayList(lista); //guarda la lista de socios
    }

    public ArrayList<Socio> cargarLista() {
        if(listaGuardada != null) {
            return new ArrayList<>(listaGuardada);
            //retorna los datos guardados
        }else{
            return new ArrayList<>();
            //si no hay datos, retorna una lista vacia
        }
    }


    @Override
    public void guardarDatos() {

    }

    @Override
    public void cargarDatos() {

    }

    @Override
    public void agregarSocio(Socio socio) {

    }

    @Override
    public boolean verificarSocio(Socio socio) {
        return false;
    }

    @Override
    public void eliminarSocio(Socio socio) {

    }

    @Override
    public boolean existeSocio(Socio socio) {
        return false;
    }

    @Override
    public void limpiarSocio() {

    }

    @Override
    public double getPromedioEdad() {
        return 0;
    }

    @Override
    public ArrayList<Socio> getSociosPorGenero(Predicate<Socio> predicado) {
        return null;
    }

    @Override
    public ArrayList<Socio> getSociosOrdenadosPorEdad(Comparator<Socio> comparador) {
        return null;
    }

    @Override
    public ArrayList<Socio> getNombresSociosMayoresDe(Predicate<Socio> predicado) {
        return null;
    }

    @Override
    public ArrayList<Socio> getSociosConPrestamosActivos(Predicate<Socio> predicado) {
        return null;
    }

    @Override
    public ArrayList<Socio> getSocios(Predicate<Socio> p, Comparator<Socio> c) {
        return null;
    }

    @Override
    public ArrayList<String> getSocios2(Predicate<Socio> p, Comparator<Socio> c) {
        return null;
    }

    @Override
    public ArrayList<Integer> getSocios3(Predicate<Socio> p, Comparator<Socio> c) {
        return null;
    }
}
