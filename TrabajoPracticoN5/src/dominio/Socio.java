package dominio;

import java.util.Calendar;
import java.util.GregorianCalendar;

import exceptions.ExceptionSocio;
import exceptions.ExceptionSocioApellidoNull;
import exceptions.ExceptionSocioApellidoVacio;
import exceptions.ExceptionSocioFechaNactoNull;
import exceptions.ExceptionSocioNombreNull;
import exceptions.ExceptionSocioNombreVacio;
import exceptions.ExceptionSocioNroSocioNegativo;

public class Socio {
	String nombre;
	String apellido;
	Calendar fechaNacto;
	Genero miGenero;
	int nroSocio;
	boolean tienePrestamos;
	
	public Socio(String nombre, String apellido, Calendar fechaNacto, Genero miGenero, int nroSocio,
			boolean tienePrestamos) throws ExceptionSocio{
		super();
		if(nombre == null)
			throw new ExceptionSocioNombreNull("Error por el nombre Nula");
		if(nombre.equals(""))
			throw new ExceptionSocioNombreVacio("Error por el nombre Vacio");
		this.nombre = nombre;
		if(apellido == null)
			throw new ExceptionSocioApellidoNull("Error por el apellido Nula");
		if(apellido.equals(""))
			throw new ExceptionSocioApellidoVacio("Error por el apellido Vacio");
		this.apellido = apellido;
		if(fechaNacto == null)
			throw new ExceptionSocioFechaNactoNull("Error por la fecha nacimiento es Nula");
		this.fechaNacto = fechaNacto;
		this.miGenero = miGenero;
		if(nroSocio < 0)
			throw new ExceptionSocioNroSocioNegativo("Error por el numero de socio negativo");
		this.nroSocio = nroSocio;
		this.tienePrestamos = tienePrestamos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Calendar getFechaNacto() {
		return fechaNacto;
	}

	public void setFechaNacto(Calendar fechaNacto) {
		this.fechaNacto = fechaNacto;
	}

	public Genero getMiGenero() {
		return miGenero;
	}

	public void setMiGenero(Genero miGenero) {
		this.miGenero = miGenero;
	}

	public int getNroSocio() {
		return nroSocio;
	}

	public void setNroSocio(int nroSocio) {
		this.nroSocio = nroSocio;
	}

	public boolean isTienePrestamos() {
		return tienePrestamos;
	}

	public void setTienePrestamos(boolean tienePrestamos) {
		this.tienePrestamos = tienePrestamos;
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((fechaNacto == null) ? 0 : fechaNacto.hashCode());
		result = prime * result + ((miGenero == null) ? 0 : miGenero.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + nroSocio;
		result = prime * result + (tienePrestamos ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Socio other = (Socio) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (fechaNacto == null) {
			if (other.fechaNacto != null)
				return false;
		} else if (!fechaNacto.equals(other.fechaNacto))
			return false;
		if (miGenero != other.miGenero)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (nroSocio != other.nroSocio)
			return false;
		if (tienePrestamos != other.tienePrestamos)
			return false;
		return true;
	}

	public int getEdad() {
		Calendar fechaNacimiento = this.fechaNacto;
		Calendar fechaActual= Calendar.getInstance();
		//int year = cal.get(Calendar.YEAR);
		//fechaNacto = new GregorianCalendar();
		//int edad = fechactual.get(Calendar.YEAR) - fechaNacto.get(Calendar.YEAR);
		int edad = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
		return edad;
	}
	

	@Override
	public String toString() {
		return nroSocio + "(" + miGenero + ")" + apellido + "," + nombre + "(" + fechaNacto + ")" + "- Prestamos =" + tienePrestamos;
	}
	
	
}
