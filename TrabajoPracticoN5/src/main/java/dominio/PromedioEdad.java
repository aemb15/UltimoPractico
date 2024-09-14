package dominio;

public class PromedioEdad {

    private GestorDeSocios miGestor;

    public PromedioEdad(GestorDeSocios miGestor) {
        this.miGestor = miGestor;
    }

    public double getPromedioEdad() {
        int sum=0;
        for (Socio socio : miGestor.socios) {
            sum = sum + socio.getEdad();
        }
        return sum/miGestor.socios.size();
    }
}
