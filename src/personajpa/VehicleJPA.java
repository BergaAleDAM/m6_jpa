
package personajpa;

import controlador.Client_Controller;
import controlador.Vehicles_Controller;
import java.util.Scanner;
import modelo.Client;
import modelo.Vehicle;


public class VehicleJPA {
        Scanner lector = new Scanner (System.in);
    Client_Controller cc= new Client_Controller();
    Vehicles_Controller vc= new Vehicles_Controller();
    
    public void menuInicial(){
        
        
        
        while(true){
        
        System.out.println("\nQue quieres hacer: \n 1.Crear Vehicle.\n"
                + "2. Modificar Vehicle por Id.\n"
                + "3. Busca Vehicle por Matricula.\n"
                + "4. Volver al menú anterior.\n");
     
        int opcion = lector.nextInt();
        
        switch(opcion){
            
            case 1:
                String newVehi = crearCliente();
                System.out.println(newVehi);
                break;
            case 2:
                
                modificarVehicle();
                break;
            case 3:
                
                Vehicle v = cercarPerMatricula();
                System.out.println(v);
                break;
                
            case 4:
               Main.menu(); 
        }

    }
        
    }
 
    public String crearCliente(){
        
        String insertado;
        
        System.out.println("Escoje el numero de matricula");
        String matricula = lector.next();
        System.out.println("Ahora el año de fabricacion:");
        int año = lector.nextInt();
        System.out.println("Escoje el modelo/marca del vehiculo:");
        String calle = lector.next();
        System.out.println("\nPon la id del cliente propietario:");
        Long numero = lector.nextLong();
        Client client = cc.Buscar(numero);
        
        Vehicle v = new Vehicle(matricula, calle, año, client, null);
        
        vc.Insertar(v);
       
        Vehicle existe = vc.BuscarPerMatricula(matricula);
        
        
        if(existe.getMatricula().equals(matricula)){
            insertado = "Se ha insertado bien";
        }else{
            insertado = "Seha insertado mal";
        }
        return insertado;
    }

    private void modificarVehicle() {
        
        System.out.println("Pon la id del vehiclo que quieres modificar:");
        Long id = lector.nextLong();
        
        Vehicle v = vc.Buscar(id);
       
        
        System.out.println("Vas a modificar la matricula. Pon la nueva matricula");
        String matri = lector.next();
        
        v.setMatricula(matri);
        
        
        vc.Modificar(v);
        
        System.out.println("Vehiculo Modificado\n");
        
    }

    private Vehicle cercarPerMatricula() {
        System.out.println("Pon la matricula del vehiculo que quieres buscar");
        String matricula = lector.next();
        
        return vc.BuscarPerMatricula(matricula);
        
        
    }
    
    
}
