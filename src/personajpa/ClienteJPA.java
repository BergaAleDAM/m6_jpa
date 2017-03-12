
package personajpa;

import controlador.Client_Controller;
import java.util.Scanner;
import modelo.Client;

/**
 *
 * @author Alejandro
 */
public class ClienteJPA {
    
    Scanner lector = new Scanner (System.in);
    Client_Controller cc= new Client_Controller();
    
    public void menuInicial(){
        
        
        
        while(true){
        
        System.out.println("Que quieres hacer: \n 1.Crear Cliente.\n"
                + "2. Buscar Cliente por Nombre.\n"
                + "3. Eliminar Cliente por Id.\n"
                + "4. Volver al menú anterior.\n");
     
        int opcion = lector.nextInt();
        
        switch(opcion){
            
            case 1:
                String newCliente = crearCliente();
                System.out.println(newCliente);
                break;
            case 2:
                
                Client clientBusqueda = busquedaClient();
                System.out.println(clientBusqueda);
                break;
            case 3:
                
                borrarClient();
                break;
                
            case 4:
               Main.menu(); 
        }

    }
        
    }
 
    public String crearCliente(){
        
        String insertado;
        
        System.out.println("Escoje el nombre que va a tener el usuario:\n");
        String nombre = lector.next();
        System.out.println("\nAhora el NIF:");
        String nif = lector.next();
        System.out.println("\nCalle:");
        String calle = lector.next();
        System.out.println("\nNumero de la casa:");
        int numero = lector.nextInt();
        System.out.println("Poblacion : ");
        String pueblo = lector.next();
        
        Client c = new Client(nif, nombre, calle, numero, pueblo);
        
        cc.Insertar(c);
        
        Client existe = cc.BuscarPerNom(nombre);
        
        if(existe.getNom().equals(nombre)){
            insertado = "Se ha insertado bien";
        }else{
            insertado = "Seha insertado mal";
        }
        return insertado;
    }

    private Client busquedaClient() {
        System.out.println("Pon el nombre del cliente que quieres buscar:");
        String nombre = lector.next();
        
        return cc.BuscarPerNom(nombre);
    }

    private void borrarClient() {
        System.out.println("Pon la id del cliente que quieres borrar:");
        Long id = lector.nextLong();
        
        Client c= cc.Buscar(id);
        
        cc.Eliminar(c);
        
        System.out.println("Cliente Borrado ! ");
    }
    
    //Si en algun momento decidiesemos modificar clientes lo hariamos con cc.Modificar(cliente);
    
    
    
}
