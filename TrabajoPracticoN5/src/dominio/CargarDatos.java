package dominio;

public class CargarDatos {

    private GestorDeSocios miGestor;
    private Persistencia persistencia = new Persistencia();

    public CargarDatos(GestorDeSocios miGestor) {
        this.miGestor = miGestor;
    }

    public void cargarDatos(){
        //Persistencia persistencia = new Persistencia();
        miGestor.socios = persistencia.cargarLista();
    }

}
