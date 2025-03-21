package modelo;

import java.util.Map;
import java.util.Scanner;

public class GestionInventario extends Producto {
	static Scanner sc;
	public GestionInventario(String codigo, String nombre, double precio, int cantidad) {
		super(codigo, nombre, precio, cantidad);
		sc = new Scanner(System.in);
	}

	//Este método permite agregar un nuevo producto al inventario.
	//El usuario debe introducir el código, nombre, precio y cantidad del producto por consola.
	public static void agregarProducto(Map<String, Producto> inventario) {
		System.out.println("Introduce el código");
		String codigo = sc.nextLine();
		System.out.println("Introduce el nombre del producto");
		String nombre = sc.nextLine();
		System.out.println("Introduce el precio");
		String precio = sc.nextLine(); 
		System.out.println("Introduce la cantidad");
		String cantidad = sc.nextLine();
		
		inventario.put(codigo, null);
		inventario.put(nombre,null);
		inventario.put(precio, null);
		inventario.put(cantidad, null);
	}
	//Este método elimina un producto del inventario dado su código.
	//Devuelve el producto eliminado o null si el producto no existe.
	public static Producto eliminarProducto(Map<String, Producto> inventario, String codigo) {
		System.out.println("Introduce el codigo del producto a eliminar");
		String codigoEliminar = sc.nextLine();
		
		if(codigoEliminar.equals(codigo)) {
			inventario.remove(codigo);	
		}else {
			System.out.println("El producto no existe");
		}
		return null;
	}
	//Este método muestra una lista de todos los productos en el inventario junto con su código, nombre, precio y cantidad disponible.
	public static void mostrarInventario(Map<String, Producto> inventario) {
		inventario.values();
	}
	//Este método muestra una lista de productos cuyo precio es menor o igual a un valor máximo dado.
	public static void mostrarProductosBaratos(Map<String, Producto> inventario, double maxPrecio) {
		System.out.println("Elige un precio maximo para filtrar por precio");
		double maxPrecioA = sc.nextDouble();
		
		if(inventario.containsValue(maxPrecioA)) {
			System.out.println(inventario.values());
		}
	}
	// Este método permite actualizar la cantidad en stock de un producto dado su código. 
	//Si el producto existe en el inventario y la cantidad es positiva, se incrementa la cantidad en stock. 
	//Si la cantidad es negativa, se decrementa la cantidad en stock. Devuelve true si la operación se realiza con éxito, y false si el producto no existe en el inventario.
	public static boolean actualizarStock(Map<String, Producto> inventario, String codigo, int cantidad) {
		System.out.println("Introduce un codigo del producto a actualizar");
		String codigoA = sc.nextLine();
		System.out.println("Introduce la cantidad");
		int cantidadIntroducir = sc.nextInt();
		System.out.println("Deseas incrementar o decrementar");
		String opcion = sc.next();
		
		if(codigoA.isEmpty()) {
			System.out.println("Este producto no esta en nuestro almacen");
			return false;
		}else if (!codigoA.isEmpty() && opcion.equalsIgnoreCase("Incrementar")){
			cantidad += cantidadIntroducir;
			return true;
		}else if (!codigoA.isEmpty() && opcion.equalsIgnoreCase("Decrementar")) {
			cantidad -= cantidadIntroducir;
			return true;
		}
		return false;
	}
}
