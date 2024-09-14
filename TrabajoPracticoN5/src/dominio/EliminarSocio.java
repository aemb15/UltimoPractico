package dominio;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EliminarSocio {

    private GestorDeSocios miGestor;

    public EliminarSocio(GestorDeSocios socios) {
        this.miGestor = socios;
    }

    public boolean eliminarSocio(int nroSocio) {
        if(existeSocio(nroSocio)) {
            Socio socio = miGestor.socios.stream().filter(s->s.getNroSocio() - nroSocio == 0).findFirst().get();
            return miGestor.socios.remove(socio);
        }
        return false;
    }

    public boolean existeSocio(int nroSocio) {
        return miGestor.socios.stream().filter(s->s.getNroSocio() == nroSocio).findAny().isPresent();
    }

    public void eliminarSociosConEdadMenorA(Predicate<Socio> predicado) {
        ArrayList<Socio> salida = miGestor.socios.stream().filter(predicado).collect(Collectors.toCollection(ArrayList<Socio>::new));
        //socios.removeIf(predicado);
        for (Socio socio : salida) {
            miGestor.socios.remove(socio);
        }

    }
}
