import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.function.Predicate;

import dominio.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import exceptions.ExceptionSocio;

public class TestGestorDeSocios {

	@Test
	@Order(1)
	@DisplayName("testAgregarSocio")
	void test01() throws ExceptionSocio {
		//Arrange
		LocalDate c1 = LocalDate.of(1994,10,15);
        //Calendar c1 = new GregorianCalendar(1994,10,15);
		Socio s1 = new Socio("Matias", "Martinez", c1,Genero.MASCULINO,1,true); 
		Socio s2 = new Socio("Matias", "Martinez", c1,Genero.MASCULINO,1,true); 
		//Actual

		//GestorDeSocios gs = GestorDeSocios.getInstancia();
		GestorDeSocios gs = new GestorDeSocios();
		gs.agregarSocio(s1);
		gs.agregarSocio(s2);
		//Assert
		assertEquals(gs.getSocio().size(),1);
		gs.Limpiar();
	}
	
	@Test
	@Order(2)
	@DisplayName("testEliminarSocio")
	void test02() throws ExceptionSocio {
		//Arrange
		LocalDate c1 = LocalDate.of(1994,10,15);
		LocalDate c2 = LocalDate.of(1989,12,04);
		LocalDate c3 = LocalDate.of(1997,05,11);
		LocalDate c4 = LocalDate.of(1991,06,22);
		Socio s1 = new Socio("Matias", "Martinez", c1,Genero.MASCULINO,1,true);
		Socio s2 = new Socio("Juliana", "Hernandez", c2,Genero.FEMENINO,2,true);
		Socio s3 = new Socio("Carlos", "Jimenez", c3,Genero.MASCULINO,3,false); 
		Socio s4 = new Socio("Pedro", "Castillo", c4,Genero.MASCULINO,4,false); 
		//Actual
		//GestorDeSocios gs = GestorDeSocios.getInstancia();
		GestorDeSocios gs = new GestorDeSocios();
		gs.agregarSocio(s1);
		gs.agregarSocio(s2);
		gs.agregarSocio(s3);
		gs.agregarSocio(s4);
		//Assert
		ArrayList<Socio> s = new ArrayList<Socio>();
		s.add(s2);
		s.add(s3);
		
		assertEquals(gs.getSocio().size(),4);
		assertTrue(gs.eliminarSocio(4));
		assertFalse(gs.eliminarSocio(5));
		assertTrue(gs.eliminarSocio(1));
		assertEquals(gs.getSocio().size(),2);
		assertEquals(gs.getSocio(),s);
		gs.Limpiar();
	}
	
	@Test
	@Order(3)
	@DisplayName("testBuscarSocioPorNumero")
	void test03() throws ExceptionSocio{
		//Arrange
		LocalDate c1 = LocalDate.of(1994,10,15);
		Socio s1 = new Socio("Matias", "Martinez", c1,Genero.MASCULINO,1,true); 
		Socio s2 = new Socio("Juliana", "Hernandez", c1,Genero.FEMENINO,2,true);
		Socio s3 = new Socio("Pedro", "Castillo", c1,Genero.MASCULINO,3,true); 
		//Actual
		//GestorDeSocios gs = GestorDeSocios.getInstancia();
		GestorDeSocios gs = new GestorDeSocios();
		gs.agregarSocio(s1);
		gs.agregarSocio(s2);
		gs.agregarSocio(s3);
		//Assert
		assertTrue(gs.existeSocio(1));
		assertFalse(gs.existeSocio(5));
		assertTrue(gs.existeSocio(2));
		assertFalse(gs.existeSocio(8));
		gs.Limpiar();
	}
	
	@Test
	@Order(4)
	@DisplayName("testBuscarSocioPorGenero")
	void test04() throws ExceptionSocio{
		//Arrange
		LocalDate c1 = LocalDate.of(1994,10,15);
		Socio s1 = new Socio("Matias", "Martinez", c1,Genero.MASCULINO,1,true); 
		Socio s2 = new Socio("Juliana", "Hernandez", c1,Genero.FEMENINO,2,true);
		Socio s3 = new Socio("Pedro", "Castillo", c1,Genero.MASCULINO,1,true); 
		//Actual
		//GestorDeSocios gs = GestorDeSocios.getInstancia();
		GestorDeSocios gs = new GestorDeSocios();
		gs.agregarSocio(s1);
		gs.agregarSocio(s2);
		gs.agregarSocio(s3);
		Predicate<Socio> p = (Socio s)->s.getMiGenero().equals(Genero.MASCULINO);
		ArrayList<Socio> actual = gs.getSociosPorGenero(p);
		ArrayList<Socio> esperado = new ArrayList<Socio>();
		esperado.add(s1);
		esperado.add(s3);
		//Assert
		assertEquals(esperado,actual);
		gs.Limpiar();
	}
	
	@Test
	@Order(5)
	@DisplayName("testGetSociosOrdenadosPorEdad")
	void test05() throws ExceptionSocio{
		//Arrange
		LocalDate c1 = LocalDate.of(1994,10,15);
		LocalDate c2 = LocalDate.of(1989,12,04);
		LocalDate c3 = LocalDate.of(1997,05,11);
		LocalDate c4 = LocalDate.of(1991,06,22);
		Socio s1 = new Socio("Matias", "Martinez", c1,Genero.MASCULINO,1,true);
		Socio s2 = new Socio("Juliana", "Hernandez", c2,Genero.FEMENINO,2,true);
		Socio s3 = new Socio("Carlos", "Jimenez", c3,Genero.MASCULINO,3,false); 
		Socio s4 = new Socio("Pedro", "Castillo", c4,Genero.MASCULINO,4,false); 
		//Actual
		//GestorDeSocios gs = GestorDeSocios.getInstancia();
		GestorDeSocios gs = new GestorDeSocios();
		gs.agregarSocio(s1);
		gs.agregarSocio(s2);
		gs.agregarSocio(s3);
		gs.agregarSocio(s4);
		
		Comparator<Socio> comparador = (Socio so1, Socio so2)->(so1.getEdad() - so2.getEdad());
		
		

		ArrayList<Socio> actual = gs.getSociosOrdenadosPorEdad(comparador);
		ArrayList<Socio> esperado = new ArrayList<Socio>();
		esperado.add(s3);
		esperado.add(s1);
		esperado.add(s4);
		esperado.add(s2);
		//Assert
		assertEquals(esperado,actual);
		gs.Limpiar();
	}
	
	@Test
	@Order(6)
	@DisplayName("testGetSociosMayoresDe")
	void test06() throws ExceptionSocio{
		//Arrange
		LocalDate c1 = LocalDate.of(1994,10,15);
		LocalDate c2 = LocalDate.of(1989,12,04);
		LocalDate c3 = LocalDate.of(1997,05,11);
		LocalDate c4 = LocalDate.of(1991,06,22);
		Socio s1 = new Socio("Matias", "Martinez", c1,Genero.MASCULINO,1,true);
		Socio s2 = new Socio("Juliana", "Hernandez", c2,Genero.FEMENINO,2,true);
		Socio s3 = new Socio("Carlos", "Jimenez", c3,Genero.MASCULINO,3,false); 
		Socio s4 = new Socio("Pedro", "Castillo", c4,Genero.MASCULINO,4,false); 
		//Actual
		//GestorDeSocios gs = GestorDeSocios.getInstancia();
		GestorDeSocios gs = new GestorDeSocios();
		gs.agregarSocio(s1);
		gs.agregarSocio(s2);
		gs.agregarSocio(s3);
		gs.agregarSocio(s4);
		
		Predicate<Socio> p = (Socio s)->s.getEdad() > 30;
		ArrayList<Socio> actual = gs.getSociosPorGenero(p);
		ArrayList<Socio> esperado = new ArrayList<Socio>();
		
		esperado.add(s2);
		esperado.add(s4);
		//Assert
		assertEquals(esperado,actual);
		gs.Limpiar();
	}
	
	@Test
	@Order(7)
	@DisplayName("testGetPromedioEdad")
	void test07() throws ExceptionSocio{
		//Arrange
		LocalDate c1 = LocalDate.of(1994,10,15);
		LocalDate c2 = LocalDate.of(1989,12,04);
		LocalDate c3 = LocalDate.of(1997,05,11);
		LocalDate c4 = LocalDate.of(1991,06,22);
		Socio s1 = new Socio("Matias", "Martinez", c1,Genero.MASCULINO,1,true);
		Socio s2 = new Socio("Juliana", "Hernandez", c2,Genero.FEMENINO,2,true);
		Socio s3 = new Socio("Carlos", "Jimenez", c3,Genero.MASCULINO,3,false); 
		Socio s4 = new Socio("Pedro", "Castillo", c4,Genero.MASCULINO,4,false); 
		//Actual
		//GestorDeSocios gs = GestorDeSocios.getInstancia();
		GestorDeSocios gs = new GestorDeSocios();
		gs.agregarSocio(s1);
		gs.agregarSocio(s2);
		gs.agregarSocio(s3);
		gs.agregarSocio(s4);
		
		//double esperado = (s1.getEdad()+s2.getEdad()+s3.getEdad()+s4.getEdad())/4;
		//Assert
		assertEquals(31,gs.getPromedioEdad());
		gs.Limpiar();
	}
	
	@Test
	@Order(8)
	@DisplayName("testExisteSocioConNombre")
	void test08() throws ExceptionSocio{
		//Arrange
		LocalDate c1 = LocalDate.of(1994,10,15);
		LocalDate c2 = LocalDate.of(1989,12,04);
		LocalDate c3 = LocalDate.of(1997,05,11);
		LocalDate c4 = LocalDate.of(1991,06,22);
		Socio s1 = new Socio("Matias", "Martinez", c1,Genero.MASCULINO,1,true);
		Socio s2 = new Socio("Juliana", "Hernandez", c2,Genero.FEMENINO,2,true);
		Socio s3 = new Socio("Carlos", "Jimenez", c3,Genero.MASCULINO,3,false); 
		Socio s4 = new Socio("Pedro", "Castillo", c4,Genero.MASCULINO,4,false);
		Socio s5 = new Socio("Matias", "Gomez", c3,Genero.MASCULINO,5,true);
		//Actual
		//GestorDeSocios gs = GestorDeSocios.getInstancia();
		GestorDeSocios gs = new GestorDeSocios();
		gs.agregarSocio(s1);
		gs.agregarSocio(s2);
		gs.agregarSocio(s3);
		gs.agregarSocio(s4);
		gs.agregarSocio(s5);
		
		Predicate<Socio> p = (Socio s)->s.getNombre().equals("Matias");

		//Assert
		assertTrue(gs.existeSocioConNombre(p));
		gs.Limpiar();
	}
	
	@Test
	@Order(9)
	@DisplayName("testEliminarSociosConEdadMenorA")
	void test09() throws ExceptionSocio{
		//Arrange
		LocalDate c1 = LocalDate.of(1994,10,15);
		LocalDate c2 = LocalDate.of(1989,12,04);
		LocalDate c3 = LocalDate.of(1997,05,11);
		LocalDate c4 = LocalDate.of(1991,06,22);
		Socio s1 = new Socio("Matias", "Martinez", c1,Genero.MASCULINO,1,true);
		Socio s2 = new Socio("Juliana", "Hernandez", c2,Genero.FEMENINO,2,true);
		Socio s3 = new Socio("Carlos", "Jimenez", c3,Genero.MASCULINO,3,false); 
		Socio s4 = new Socio("Pedro", "Castillo", c4,Genero.MASCULINO,4,false); 
		//Actual
		//GestorDeSocios gs = GestorDeSocios.getInstancia();
		GestorDeSocios gs = new GestorDeSocios();
		gs.agregarSocio(s1);
		gs.agregarSocio(s2);
		gs.agregarSocio(s3);
		gs.agregarSocio(s4);
		
		Predicate<Socio> p = (Socio s)->s.getEdad() < 31;
		//ArrayList<Socio> actual = gs.eliminarSociosConEdadMenorA(p);
		gs.eliminarSociosConEdadMenorA(p);
		ArrayList<Socio> esperado = new ArrayList<Socio>();
		
		esperado.add(s2);
		esperado.add(s4);

		//Assert
	    assertEquals(gs.getSocio().size(),2);
	    assertEquals(gs.getSocio(), esperado);
		
		gs.Limpiar();
	}
	
	@Test
	@Order(10)
	@DisplayName("testGetSociosMayoresDe")
	void test10() throws ExceptionSocio{
		//Arrange
		LocalDate c1 = LocalDate.of(1994,10,15);
		LocalDate c2 = LocalDate.of(1989,12,04);
		LocalDate c3 = LocalDate.of(1997,05,11);
		LocalDate c4 = LocalDate.of(1991,06,22);
		Socio s1 = new Socio("Matias", "Martinez", c1,Genero.MASCULINO,1,true);
		Socio s2 = new Socio("Juliana", "Hernandez", c2,Genero.FEMENINO,2,true);
		Socio s3 = new Socio("Carlos", "Jimenez", c3,Genero.MASCULINO,3,false); 
		Socio s4 = new Socio("Pedro", "Castillo", c4,Genero.MASCULINO,4,false); 
		//Actual
		//GestorDeSocios gs = GestorDeSocios.getInstancia();
		GestorDeSocios gs = new GestorDeSocios();
		gs.agregarSocio(s1);
		gs.agregarSocio(s2);
		gs.agregarSocio(s3);
		gs.agregarSocio(s4);
		
		Predicate<Socio> p = (Socio s)->s.isTienePrestamos();
		ArrayList<Socio> actual = gs.getSociosConPrestamosActivos(p);
		ArrayList<Socio> esperado = new ArrayList<Socio>();
		
		esperado.add(s1);
		esperado.add(s2);
		//Assert
		assertEquals(esperado,actual);
		gs.Limpiar();
	}
	
	@Test
	@Order(11)
	@DisplayName("testGetSocios")
	void test11() throws ExceptionSocio{
		//Arrange
		LocalDate c1 = LocalDate.of(1994,10,15);
		LocalDate c2 = LocalDate.of(1989,12,04);
		LocalDate c3 = LocalDate.of(1997,05,11);
		LocalDate c4 = LocalDate.of(1991,06,22);
		Socio s1 = new Socio("Matias", "Martinez", c1,Genero.MASCULINO,1,true);
		Socio s2 = new Socio("Juliana", "Hernandez", c2,Genero.FEMENINO,2,true);
		Socio s3 = new Socio("Carlos", "Jimenez", c3,Genero.MASCULINO,3,false); 
		Socio s4 = new Socio("Pedro", "Castillo", c4,Genero.MASCULINO,4,false); 
		//Actual
		//GestorDeSocios gs = GestorDeSocios.getInstancia();
		GestorDeSocios gs = new GestorDeSocios();
		gs.agregarSocio(s1);
		gs.agregarSocio(s2);
		gs.agregarSocio(s3);
		gs.agregarSocio(s4);
		

		Predicate<Socio> p = (Socio s)->s.getMiGenero().equals(Genero.MASCULINO);
		Comparator<Socio> c = (Socio so1, Socio so2)->(so1.getEdad() - so2.getEdad());
		ArrayList<Socio> actual = gs.getSocios(p, c);
		ArrayList<Socio> esperado = new ArrayList<Socio>();
		
		esperado.add(s3); //1997
		esperado.add(s1); //1994
		esperado.add(s4); //1991
		
		//Assert
		assertEquals(esperado,actual);
		gs.Limpiar();
	}
	
	@Test
	@Order(12)
	@DisplayName("testGetSocios2")
	void test12() throws ExceptionSocio{
		//Arrange
		LocalDate c1 = LocalDate.of(1994,10,15);
		LocalDate c2 = LocalDate.of(1989,12,04);
		LocalDate c3 = LocalDate.of(1997,05,11);
		LocalDate c4 = LocalDate.of(1991,06,22);
		Socio s1 = new Socio("Matias", "Sosa", c1,Genero.MASCULINO,1,true);
		Socio s2 = new Socio("Juliana", "Hernandez", c2,Genero.FEMENINO,2,true);
		Socio s3 = new Socio("Carlos", "Jimenez", c3,Genero.MASCULINO,3,false); 
		Socio s4 = new Socio("Pedro", "Castillo", c4,Genero.MASCULINO,4,false); 
		//Actual
		//GestorDeSocios gs = GestorDeSocios.getInstancia();
		GestorDeSocios gs = new GestorDeSocios();
		gs.agregarSocio(s1);
		gs.agregarSocio(s2);
		gs.agregarSocio(s3);
		gs.agregarSocio(s4);
		

		Predicate<Socio> p = (Socio s)->s.getApellido().toLowerCase().contains("e");
		Comparator<Socio> c = (Socio so1, Socio so2)->(so1.getApellido().compareTo(so2.getApellido()));
		ArrayList<Socio> actual = gs.getSocios(p, c);
		ArrayList<Socio> esperado = new ArrayList<Socio>();
		
		esperado.add(s2); //Carlos Jimenes
		esperado.add(s3); //Juliana Hernandez
		
		//Assert
		assertEquals(esperado,actual);
		gs.Limpiar();
	}
	
	@Test
	@Order(13)
	@DisplayName("testGetSocios3")
	void test13() throws ExceptionSocio{
		//Arrange
		LocalDate c1 = LocalDate.of(1994,10,15);
		LocalDate c2 = LocalDate.of(1989,12,04);
		LocalDate c3 = LocalDate.of(1997,05,11);
		LocalDate c4 = LocalDate.of(1991,06,22);
		Socio s1 = new Socio("Matias", "Sosa", c1,Genero.MASCULINO,1,true);
		Socio s2 = new Socio("Juliana", "Hernandez", c2,Genero.FEMENINO,2,true);
		Socio s3 = new Socio("Carlos", "Jimenez", c3,Genero.MASCULINO,3,false); 
		Socio s4 = new Socio("Pedro", "Castillo", c4,Genero.MASCULINO,4,false); 
		//Actual
		//GestorDeSocios gs = GestorDeSocios.getInstancia();
		GestorDeSocios gs = new GestorDeSocios();
		gs.agregarSocio(s1);
		gs.agregarSocio(s2);
		gs.agregarSocio(s3);
		gs.agregarSocio(s4);
		

		Predicate<Socio> p = (Socio s)->s.isTienePrestamos() && s.getMiGenero().equals(Genero.FEMENINO) && s.getEdad() > 21;
		Comparator<Socio> c = (Socio so1, Socio so2)->(so1.getApellido().compareTo(so2.getApellido()));
		ArrayList<Socio> actual = gs.getSocios(p, c);
		ArrayList<Socio> esperado = new ArrayList<Socio>();
		
		esperado.add(s2);
		
		//Assert
		assertEquals(esperado,actual);
		gs.Limpiar();
	}

}
