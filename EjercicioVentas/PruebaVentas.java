package ventas;
 
import java.util.Scanner;
 
public class PruebaVentas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*** Sistema de Ventas ***");
 
        // Solicitar al usuario la cantidad de órdenes que desea crear.
        System.out.print("Ingresa cantidad de órdenes: ");
        int cantidadOrdenes = Integer.parseInt(sc.nextLine());
 
        // Crear un array de Orden con la cantidad ingresada.
        Orden[] ordenes = new Orden[cantidadOrdenes];
 
        // Bucle para crear cada orden.
        for (int i=0; i<cantidadOrdenes; i++) {
            System.out.println("\nCreando Orden Nº " + (i + 1));
            Orden orden = new Orden(); // Se crea una nueva orden.
 
            // Solicitar la cantidad de productos para la orden actual.
            System.out.print("Ingresa cantidad de productos para esta orden (máximo " + Orden.MAX_PRODUCTOS + "): ");
            int cantidadProduc = Integer.parseInt(sc.nextLine());
 
            // Si la cantidad excede el máximo permitido, se ajusta.
            if (cantidadProduc > Orden.MAX_PRODUCTOS) {
                System.out.println("Solo se permiten " + Orden.MAX_PRODUCTOS + " productos por orden. Se ajusta a ese número. ");
                cantidadProduc = Orden.MAX_PRODUCTOS;
            }
 
            // Bucle para ingresar los productos de la orden actual.
            for (int j=0; j<cantidadProduc; j++) {
                System.out.println("Ingreso de producto Nº " + (j + 1));
                System.out.print("Nombre de producto: ");
                String nombreProducto = sc.nextLine();
                System.out.print("Precio de producto: ");
                double precioProducto = Double.parseDouble(sc.nextLine());
 
                // Crear el objeto Producto y agregarlo a la orden.
                Producto producto = new Producto(nombreProducto, precioProducto);
                orden.agregarProducto(producto);
            }
 
            // Se guarda la orden creada en el array de órdenes.
            ordenes[i] = orden;
        }
 
        // Mostrar todas las órdenes creadas.
        System.out.println("\n--- Todas las Órdenes ---");
        for (int i=0; i<cantidadOrdenes; i++) {
            System.out.println("\n");
            ordenes[i].mostrarOrden();
        }
 
        sc.close();
    }
}