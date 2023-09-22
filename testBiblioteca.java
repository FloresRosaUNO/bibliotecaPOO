import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
public class testBiblioteca {
public static void main(String[] arg){
	Libro lib =new Libro("corona", "axel");
	lib.infoLibro();
	System.out.println(""+lib.isDispo());
	lib.cambiarDispo();
	lib.infoLibro();
	lib.disponibilidad();
	Usuario usu = new Usuario("Carlos", 01);
	usu.infoUsuario();
	usu.toString();
	Prestamo presta = new Prestamo(lib, usu);
	presta.infoPrestamo();
//	presta.setFechaPrestamo("2022");
//    presta.calcularFechaDevolucion(20);
//	MenuBiblioteca biblio = new MenuBiblioteca();
	
//	biblio.menu();
	
}
}
