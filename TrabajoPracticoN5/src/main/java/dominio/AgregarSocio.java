package dominio;


import java.util.function.Predicate;

public class AgregarSocio{

    private GestorDeSocios miGestor;

    public AgregarSocio(GestorDeSocios socios) {
        this.miGestor = socios;
    }

    public void agregarSocio(Socio socio) {
        if(!verificarSocio(socio)) {
            miGestor.socios.add(socio);
        }
    }

    public boolean verificarSocio(Socio socio) {
        if(miGestor.socios.contains(socio))
            return true;
        return false;
    }

    public boolean existeSocioConNombre(Predicate<Socio> predicado) {
        return miGestor.socios.stream().filter(predicado).findFirst().isPresent();
    }
}
