package dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GestorDeSocios implements IGestorDeSocios {
	
	private static GestorDeSocios gs;
	public ArrayList<Socio> socios;
	private AgregarSocio agregarSocio;
	private EliminarSocio eliminarSocio;
	private LimpiarSocio limpiarSocio;
	private BuscarSocio buscarSocio;
	private PromedioEdad promedioEdad;
	
	private GestorDeSocios() {
		socios = new ArrayList<Socio>();
	}
	
	public static GestorDeSocios getInstancia() {
		if (gs == null)
			gs = new GestorDeSocios();
		return gs;
	}

	public void agregarSocio(Socio socio) {
		this.agregarSocio.agregarSocio(socio);
		/*if(!verificarSocio(socio)) {
			socios.add(socio);
		}*/
	}

	public boolean verificarSocio(Socio socio) {
		/*if(socios.contains(socio))
			return true;
		return false;*/
		return this.agregarSocio.verificarSocio(socio);
	}
	
	public boolean eliminarSocio(int nroSocio) {
		/*if(existeSocio(nroSocio)) {
			Socio socio = socios.stream().filter(s->s.getNroSocio() - nroSocio == 0).findFirst().get();
			return socios.remove(socio);
		}
		return false;*/
		return this.eliminarSocio.eliminarSocio(nroSocio);
	}
	
	public boolean existeSocio(int nroSocio) {
		//return socios.stream().filter(s->s.getNroSocio() == nroSocio).findAny().isPresent();
		return this.eliminarSocio.existeSocio(nroSocio);
	}
	
	public void Limpiar() {
		//socios.clear();
		this.limpiarSocio.Limpiar();
	}
	
	public ArrayList<Socio> getSocio(){
		return socios;
	}
	
	
	public ArrayList<Socio> getSociosPorGenero(Predicate<Socio> predicado){
		//return socios.stream().filter(predicado).collect(Collectors.toCollection(ArrayList<Socio>::new));
		return this.buscarSocio.getSociosPorGenero(predicado);
	}
	
	public ArrayList<Socio> getSociosOrdenadosPorEdad(Comparator<Socio> comparador){
		//return socios.stream().sorted(comparador).collect(Collectors.toCollection(ArrayList<Socio>::new));
		return this.buscarSocio.getSociosOrdenadosPorEdad(comparador);
	}
	
	public ArrayList<Socio> getNombresSociosMayoresDe(Predicate<Socio> predicado){
		//return socios.stream().filter(predicado).collect(Collectors.toCollection(ArrayList<Socio>::new));
		return this.buscarSocio.getNombresSociosMayoresDe(predicado);
	}
	
	public double getPromedioEdad() {
		/*int sum=0;
		for (Socio socio : socios) {
			sum = sum + socio.getEdad();
		}
		return sum/socios.size();*/
		return this.promedioEdad.getPromedioEdad();
	}
	
	public boolean existeSocioConNombre(Predicate<Socio> predicado) {
		//return socios.stream().filter(predicado).findFirst().isPresent();
		return this.agregarSocio.existeSocioConNombre(predicado);
	}
	
	public void eliminarSociosConEdadMenorA(Predicate<Socio> predicado) {
		/*ArrayList<Socio> salida = socios.stream().filter(predicado).collect(Collectors.toCollection(ArrayList<Socio>::new));
		for (Socio socio : salida) {
			socios.remove(socio);
		}*/
		this.eliminarSocio.eliminarSociosConEdadMenorA(predicado);
	}
	
	public ArrayList<Socio> getSociosConPrestamosActivos(Predicate<Socio> predicado){
		//return socios.stream().filter(predicado).collect(Collectors.toCollection(ArrayList<Socio>::new));
		return this.buscarSocio.getSociosConPrestamosActivos(predicado);
	}
	
	public ArrayList<Socio> getSocios(Predicate<Socio> p, Comparator<Socio> c) {
		//return socios.stream().filter(p).sorted(c).collect(Collectors.toCollection(ArrayList<Socio>::new));
		return this.buscarSocio.getSocios(p, c);
	}
	
	public ArrayList<String> getSocios2(Predicate<Socio> p, Comparator<Socio> c) {
		//return socios.stream().filter(p).sorted(c).map(s->s.toString()).collect(Collectors.toCollection(ArrayList<String>::new));
		return this.buscarSocio.getSocios2(p, c);
	}
	
	public ArrayList<Integer> getSocios3(Predicate<Socio> p, Comparator<Socio> c) {
		//return socios.stream().filter(p).sorted(c).map(s->s.getNroSocio()).collect(Collectors.toCollection(ArrayList<Integer>::new));
		return this.buscarSocio.getSocios3(p, c);
	}
}
