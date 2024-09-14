package dominio;

public class LimpiarSocio {

    private GestorDeSocios miGestor;

    public LimpiarSocio(GestorDeSocios socios) {
        this.miGestor = socios;
    }

    public void Limpiar() {
        miGestor.socios.clear();
    }
}
