package dominio;

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
}
