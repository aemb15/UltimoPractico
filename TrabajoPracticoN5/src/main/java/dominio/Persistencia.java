package dominio;

import java.util.ArrayList;

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



}
