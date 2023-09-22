
public class Usuario {
public String nombre;
public int id;

public Usuario(String nombre, int id){
	this.nombre=nombre;
	this.id=id;
	
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public void infoUsuario() {
	System.out.println("\n<nombre usuario>: "+this.nombre+" <id usuario>: "+this.id);
}

@Override
public String toString() {
	return "Usuario [nombre=" + nombre + ", id=" + id + "]";
}

	
}//fin
