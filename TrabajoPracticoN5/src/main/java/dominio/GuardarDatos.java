package dominio;

public class GuardarDatos {
    private GestorDeSocios miGestor;
    private Persistencia persistencia = new Persistencia();

    public GuardarDatos(GestorDeSocios miGestor) {
        this.miGestor = miGestor;
    }

    public void guardarDatos(){
        //Persistencia persistencia = new Persistencia();
        persistencia.guardarLista(miGestor.socios);
    }
}
