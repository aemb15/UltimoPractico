package dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GestorDeSocios {
	
	private static GestorDeSocios gs;
	private ArrayList<Socio> socios;
	
	private GestorDeSocios() {
		socios = new ArrayList<Socio>();
	}
	
	public static GestorDeSocios getInstancia() {
		if (gs == null)
			gs = new GestorDeSocios();
		return gs;
	}
	
	public void agregarSocio(Socio socio) {
		if(!verificarSocio(socio)) {
			socios.add(socio);
		}
	}
	
	public boolean verificarSocio(Socio socio) {
		if(socios.contains(socio))
			return true;
		return false;
	}
	
	public boolean eliminarSocio(int nroSocio) {
		if(existeSocio(nroSocio)) {
			Socio socio = socios.stream().filter(s->s.getNroSocio() - nroSocio == 0).findFirst().get();
			return socios.remove(socio);
		}
		return false;
	}
	
	public boolean existeSocio(int nroSocio) {
		return socios.stream().filter(s->s.getNroSocio() == nroSocio).findAny().isPresent();
	}
	
	public void Limpiar() {
		socios.clear();
	}
	
	public ArrayList<Socio> getSocio(){
		return socios;
	}
	
	
	public ArrayList<Socio> getSociosPorGenero(Predicate<Socio> predicado){
		return socios.stream().filter(predicado).collect(Collectors.toCollection(ArrayList<Socio>::new));
	}
	
	public ArrayList<Socio> getSociosOrdenadosPorEdad(Comparator<Socio> comparador){
		return socios.stream().sorted(comparador).collect(Collectors.toCollection(ArrayList<Socio>::new));
	}
	
	public ArrayList<Socio> getNombresSociosMayoresDe(Predicate<Socio> predicado){
		return socios.stream().filter(predicado).collect(Collectors.toCollection(ArrayList<Socio>::new));
	}
	
	public double getPromedioEdad() {
	int sum=0;
	for (Socio socio : socios) {
		sum = sum + socio.getEdad();
	}
		return sum/socios.size();
	}
	
	public boolean existeSocioConNombre(Predicate<Socio> predicado) {
		return socios.stream().filter(predicado).findFirst().isPresent();
	}
	
	public void eliminarSociosConEdadMenorA(Predicate<Socio> predicado) {
		ArrayList<Socio> salida = socios.stream().filter(predicado).collect(Collectors.toCollection(ArrayList<Socio>::new));
		//socios.removeIf(predicado);
		for (Socio socio : salida) {
			socios.remove(socio);
		}
		
	}
	
	public ArrayList<Socio> getSociosConPrestamosActivos(Predicate<Socio> predicado){
		return socios.stream().filter(predicado).collect(Collectors.toCollection(ArrayList<Socio>::new));
	}
	
	public ArrayList<Socio> getSocios(Predicate<Socio> p, Comparator<Socio> c) {
		return socios.stream().filter(p).sorted(c).collect(Collectors.toCollection(ArrayList<Socio>::new));
	}
	
	public ArrayList<String> getSocios2(Predicate<Socio> p, Comparator<Socio> c) {
		return socios.stream().filter(p).sorted(c).map(s->s.toString()).collect(Collectors.toCollection(ArrayList<String>::new));
	}
	
	public ArrayList<Integer> getSocios3(Predicate<Socio> p, Comparator<Socio> c) {
		return socios.stream().filter(p).sorted(c).map(s->s.getNroSocio()).collect(Collectors.toCollection(ArrayList<Integer>::new));
	}
}
