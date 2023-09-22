import java.time.*;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;

import java.time.format.*;
public class Prestamo {

	public Libro libro;
	public Usuario usuario;
	public String fechaPrestamo;
	public String fechaDevolucion;
	
	
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(String fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public String getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(String fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	
	public Prestamo(Libro libro, Usuario usuario) {
		super();
		this.libro = libro;
		this.usuario = usuario;
		libro.setDispo(false);
		this.fechaPrestamo="20231112";
		}
	
	public void calcularFechaDevolucion() {
		LocalDate fecha = LocalDate.parse(fechaPrestamo);
		
		DateTimeFormatter f = DateTimeFormatter.BASIC_ISO_DATE;
		Period periodo = Period.ofDays(30);
		this.fechaPrestamo=fecha.format(f);
		LocalDate fecha2 = fecha.plus(periodo);
		this.fechaDevolucion = fecha2.format(f);
	}
	public void infoPrestamo() {
		System.out.println( "Prestamo: \n[Libro]: "+this.libro.getNombre()+" ; "+this.libro.getAutor()
				+" 	\n[Usuario]: "+this.usuario.getId()+ " ; "+this.usuario.getNombre()
				+ "\n[fecha de prestamo]: "+this.fechaPrestamo+" 	[fecha de devolucion]: "+this.fechaDevolucion);
				
	}
	

}
