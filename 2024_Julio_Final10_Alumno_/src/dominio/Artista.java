package dominio;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;

public class Artista {
	
	private String nombre;
	private GregorianCalendar fechaNacto;
	private Sexo sexo;
	
	public Artista(String nombre, GregorianCalendar fechaNacto, Sexo sexo) throws ExceptionArtista {
		
	}
	

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public GregorianCalendar getFechaNacto() {
		return fechaNacto;
	}



	public void setFechaNacto(GregorianCalendar fechaNacto) {
		this.fechaNacto = fechaNacto;
	}



	public Sexo getSexo() {
		return sexo;
	}



	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}



	public String getFechaCorta() {
		 
	}
	
	public int getEdad() {
		Calendar fechaNacimiento = this.fechaNacto;
		Calendar fechaActual = Calendar.getInstance();
		int edad = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
		return edad;
	}
		
}

