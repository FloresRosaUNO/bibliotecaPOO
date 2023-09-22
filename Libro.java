
public class Libro {
public String nombre;
public String autor;
public boolean dispo;

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getAutor() {
	return autor;
}
public void setAutor(String autor) {
	this.autor = autor;
}
public boolean isDispo() {
	return dispo;
}
public void setDispo(boolean a) {
	this.dispo=a;
}
public Libro(String nomb, String autor) {
	this.nombre=nomb;
	this.autor=autor;
	this.dispo=true;
}

public Libro() {
	// TODO Auto-generated constructor stub
}
public void cambiarDispo() {
	if(this.dispo == true) {
		this.dispo= false;
		System.out.println("El libro ha pasado al estado NO disponible para prestamo.");
			
		}
	else {
		this.dispo= true;
		System.out.println("El libro ha pasado al estado disponible para prestamo.");
	}
}
public void infoLibro() {
	System.out.println("\n <nombre>: "+this.nombre+" <autor>: "+this.autor+"\n <Estado disponibilidad>:"+this.disponibilidad());
}
public String disponibilidad() {
	if(this.dispo== false)
		 return" NO DISPONIBLE" ;
	else
		return" DISPONIBLE";
}

}
