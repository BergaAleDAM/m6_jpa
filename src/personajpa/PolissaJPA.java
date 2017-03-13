
package personajpa;

import controlador.Client_Controller;
import controlador.Polissa_Controller;
import controlador.Vehicles_Controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import modelo.Client;
import modelo.Polissa;
import modelo.TipusPolissa;
import modelo.Vehicle;

public class PolissaJPA {
   
     SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
    
    Scanner lector = new Scanner (System.in);
    Polissa_Controller pc= new Polissa_Controller();
    Client_Controller cc= new Client_Controller();
    Vehicles_Controller vc= new Vehicles_Controller();
    
    public void menuInicial(){
        
        
        
        while(true){
        
        System.out.println("Que quieres hacer: \n 1.Crear Polissa.\n"
                + "2. Modificar Polissa.\n"
                + "3. Buscar Polissa d'un client.\n"
                + "4. Buscar Polissa d'un vehicle.\n"
                + "5. Mostrar totes les polisses. \n"
                + "6. Volver al menú anterior.\n");
     
        int opcion = lector.nextInt();
        
        switch(opcion){
            
            case 1:
                String newPolissa = crearPolissa();
                System.out.println(newPolissa);
                break;
            case 2:
                
                
            case 3:
                
                buscarClient();
            case 4:
            
                buscarVehicle();
            case 5:
                
                mostrarTotes();
            case 6:
               Main.menu(); 
        }

    }
        
    }
 
    public String crearPolissa() {
        
        TipusPolissa tp;
        
        
        System.out.println("Pon la fecha que comenzó (dd-mm-yyyy):\n");
        String fecha = lector.next();
         java.util.Date inicio = null;
         try {
             inicio = sd.parse(fecha);
         } catch (ParseException ex) {
             System.out.println("MaL");
         }
        
        System.out.println("\nPon la fecha que caduca (dd-mm-yyyy):");
        String fecha2 = lector.next();
        java.util.Date finale = null;
         try {
             finale = sd.parse(fecha2);
         } catch (ParseException ex) {
             System.out.println("MAL");
         }
        
        System.out.println("\nPrima:");
        double prima = lector.nextDouble();
        System.out.println("\nTipo (1. Terceros 2. Todo Riesgo):");
        
        int numero = lector.nextInt();
        if(numero == 1){
            tp = TipusPolissa.TERCERS;
        }else{
            tp = TipusPolissa.TOT_RISC;
        }
        
        System.out.println("Pon la id del vehiculo:");
        Long idv = lector.nextLong();
        
        Vehicle vehicle = vc.Buscar(idv);
        
        System.out.println("Pon la id del cliente:");
        Long idc = lector.nextLong();
       
         Client client = cc.Buscar(idc);
        
        Polissa p = new Polissa(vehicle, client, inicio, finale, tp, prima, null);
        
        pc.Insertar(p);
        
        return p.toString();
    }

    private void buscarClient() {
        System.out.println("Posa la id del client:");
        Long id = lector.nextLong();
        
        Client c = cc.Buscar(id);
        
        Polissa polissa = pc.BuscarPerClient(c.getNom());
        
        System.out.println(polissa.toString());
    }

    private void buscarVehicle() {
    
        System.out.println("Posa la matricula del vehicle:");
        String matricula = lector.next();
        
       Polissa polissa = pc.BuscarPerVehicle(matricula);
        
        System.out.println(polissa.toString());
    }

    private void mostrarTotes() {
    
        pc.Consulta();
    }

    
}

