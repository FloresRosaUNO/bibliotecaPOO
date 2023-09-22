import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MenuBiblioteca {

 	ArrayList<Libro> listaLibros = new ArrayList<Libro>();
 	ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
 	ArrayList<Prestamo> listaPrestamos = new ArrayList<Prestamo>();


void menu()
{
Scanner Teclado = new Scanner(System.in);
int opc, x;
do
{
do
{
System.out.println("MENU DE OPERACIONES BIBLIOTECA");
System.out.println("1 - Agregar un nuevo libro a la biblioteca") ;
System.out.println("2 - Registrar nuevo usuario") ;
System.out.println("3 - Realizar un prestamo de libro a un usuario") ;
System.out.println("4 - Mostrar la lista de prestamos activos") ;
System.out.println("5 - Devolver un libro") ;

System.out.println("6 - Salir") ;
System.out.println("Ingrese una opcion: ");
opc=Teclado.nextInt();
if(opc==6)
{
System.out.println("Fin Programa");
}

} while(opc < 1 && opc > 5);
switch (opc)
{
case 1:
agregarLibro();
seguir(Teclado);
break;
case 2:
registrarUsuario();
seguir(Teclado);
break;
case 3:
realizarPrestamo();
seguir(Teclado);
break;
case 4:
	mostrarPrestamos();
	seguir(Teclado);
break;
case 5:
	devolverLibro();
	seguir(Teclado);
break;

}
}while (opc != 6);
}

void agregarLibro()
{
Scanner teclado = new Scanner(System.in);
String a,b;
int crear;
System.out.println("\nEstoy en agregar nuevo libro");
System.out.println("Ingrese nombre del libro: ");
a=teclado.nextLine();
System.out.println("Ingrese el autor del libro: ");
b=teclado.nextLine();

System.out.println("\nEl nuevo libro que desea ingresar es : "+ a +" del autor: "+ b +" .\nSi es correcto teclee 1 ");
crear= teclado.nextInt();
if(crear == 1) {
	Libro nuevoLibro = new Libro(a,b);
	
	listaLibros.add(nuevoLibro);
	System.out.print("El libro : "+nuevoLibro.getNombre()+ " se ingreso correctamente a la biblioteca");
	}
}
void registrarUsuario()
{
Scanner teclado = new Scanner(System.in);
String a;
int b,conta = 0;
int crear;
System.out.println("\nEstoy en registrar nuevo usuario");
System.out.println("Ingrese nombre del usuario: ");
a=teclado.nextLine();
System.out.println("Ingrese numero id asignado al usuario: ");
b=teclado.nextInt();
for(Usuario k: listaUsuarios) {
	conta=0;
	if(k.getId()!=b) { conta++; }
	
	else {
		System.out.println("El id que intenta registrar, ya se encuentra en uso por el usuario: "+k.getNombre()
		+"\nRevise el id y vuelva a realizar operacion de registro.");
		break;
		}
		
	}
if(conta==listaUsuarios.size()+1) {
	System.out.println("\nEl nuevo usuario que desea registrar es : "+ a +" con id: "+ b +" .\nSi es correcto teclee 1 ");
	crear= teclado.nextInt();
	if(crear == 1) {
		
		Usuario nuevoUsuario = new Usuario(a,b);
		listaUsuarios.add(nuevoUsuario);
		System.out.print("El usuario : "+nuevoUsuario.getId()+" ; "+nuevoUsuario.getNombre()+ " se registro correctamente a la biblioteca");

		}
			
	}
}
void realizarPrestamo()
{
Scanner teclado = new Scanner(System.in);

String libro;
int id;
String hoy;
int resp;
int contadorL=0;
int contadorU=0;
Usuario usu = null;
Libro lib = null;

System.out.println("\nEstoy en realizar prestamo de libro ");
System.out.println("Ingrese el titulo del libro: ");
libro=teclado.nextLine();
System.out.println("Ingrese el id del usuario: ");
id=teclado.nextInt();
Prestamo prestado = new Prestamo(new Libro("aaa","nn"),new Usuario("a",00));

for(Libro e: listaLibros) {
	contadorL=0;
//	System.out.println("Lista de libros con el nombre ingresado : ");
	if(libro.equals(e.getNombre())){
		
//		System.out.print("posicion: "+listaLibros.indexOf(e)+1);
		e.infoLibro();
 
		prestado.setLibro(e);;
		}
	else { contadorL++; }

	}
if(contadorL==listaLibros.size()+1) {
	System.out.println("no se encontro libro con el titulo ingresado.Vuelva a intentar con otro titulo ");
	seguir(teclado);	
	}

for(Usuario e: listaUsuarios) {
	contadorU=0;
	if(id!=e.getId()) { contadorU++;}
	else {
		prestado.setUsuario(e);
		}
	}
    
if(contadorU==listaUsuarios.size()+1) {
	System.out.println("no se encontro el usuario con el id ingresado.Vuelva a intentar con otro titulo ");
	//seguir(teclado);
	}

//System.out.println("Ingrese la posicion indicada en la lista de libros: ");
//resp=teclado.nextInt();

listaPrestamos.add(prestado);

/*System.out.println("Ingrese la fecha de prestamo: ");
LocalDate fecha = LocalDate.now();
DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
hoy=teclado.nextLine();
fecha.parse(hoy, isoFecha);

System.out.println("Ingrese periodo en dias de prestamo: ");
int dias=teclado.nextInt();
*/
System.out.println("Se registro el prestamo: ");
prestado.infoPrestamo();
//prestado.registrarFechaPrestamo(fecha);
//prestado.calcularFechaDevolucion(dias);


}

void mostrarPrestamos()
{

System.out.println("Estoy en Mostrar lista de prestamos activos.\n");

for(Prestamo e: listaPrestamos) {
	if(e.libro.isDispo()==false) {
		e.infoPrestamo();
		}
	}
}
void devolverLibro() {
	Scanner teclado = new Scanner(System.in);
	String a;
	int b;
	int crear;
	System.out.println("\nEstoy en devolver libro");
	System.out.println("Ingrese nombre del libro: ");
	a=teclado.nextLine();
	System.out.println("Ingrese id de usuario: ");
	b=teclado.nextInt();

	System.out.println("\nEl nuevo libro que desea devolver es : "+ a +" del autor: "+ b +" .\nSi es correcto teclee 1 ");
	crear= teclado.nextInt();
	if(crear == 1) {
		for(Prestamo p: listaPrestamos) {
			if(p.usuario.getId()==b && p.libro.getNombre().equals(a)) {
				p.libro.cambiarDispo();
				}
			}
		}
	}

static void seguir(Scanner Teclado)
{
int x;
System.out.print("\nPara volver a menu apriete cualquier numero ");

x=Teclado.nextInt();
}
}
