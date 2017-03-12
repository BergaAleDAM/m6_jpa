
package personajpa;

import controlador.Asseguradora_Controller;
import java.util.Scanner;
import modelo.Asseguradora;
import modelo.Client;


public class AsseguradoraJPA {
    
     Scanner lector = new Scanner (System.in);
    Asseguradora_Controller ac= new Asseguradora_Controller();
    
    public void menuInicial(){
        
        
        
        while(true){
        
        System.out.println("Que quieres hacer: \n 1.Crear Asseguradora.\n"
                + "2. Eliminar Asseguradora.\n"
                + "3. Volver al menú anterior.\n");
     
        int opcion = lector.nextInt();
        
        switch(opcion){
            
            case 1:
                String newAsse = crearAsseguradora();
                System.out.println(newAsse);
                break;
           
            case 2:
                
                borrarAsseg();
                break;
                
            case 3:
               Main.menu(); 
        }

    }
        
    }
 
    public String crearAsseguradora(){
      
        
        System.out.println("Escoje el nombre que va a tener la asseguradora:");
        String nombre = lector.next();
        System.out.println("Ahora el CIF:");
        String cif = lector.next();
        
        Asseguradora a = new Asseguradora(nombre, cif);
        
        ac.Insertar(a);
        
        
        return a.toString();
    }

    private void borrarAsseg() {
        System.out.println("Pon la id de la asseguradora a borrar:");
        Long id = lector.nextLong();
        
        Asseguradora a= ac.Buscar(id);
        
        ac.Eliminar(a);
        
        System.out.println("Seguro Borrado ! ");
    }
   
}
