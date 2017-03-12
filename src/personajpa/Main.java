/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajpa;

import controlador.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import modelo.*;

/**
 *
 * @author Jorge
 */
public class Main {
    
    static Scanner lector = new Scanner (System.in);
    static ClienteJPA u = new ClienteJPA();
    static VehicleJPA v = new VehicleJPA();
    static AsseguradoraJPA a = new AsseguradoraJPA();

    public static void main(String[] args) {
        try {
            
            
            
            boolean acceso = false;
            
            while(!acceso){
                
                System.out.println("Acceso a la base de datos: \nMete tu nombre de usuario (Pista): Es Fistro ->");
                String user = lector.nextLine();
                System.out.println("Y ahora la contraseña (Pista): Es Pecador ->");
                String password = lector.nextLine();
                
                Usuari_Controller uc = new Usuari_Controller();
                
                Usuari validacion = uc.Buscar("Fistro");
                
                if(validacion.getNom().equals(user) && validacion.getPass().equals(password)){
                    acceso = true;
                }else{
                    System.out.println("Has puesto mal la contraseña");
                }
                
            }
            
            menu();
            
            

            
        } catch (Exception ex) {
            System.out.println("La que has liado pollito");
        }
    }
    public static void menu(){
                
                while(true){
                
                System.out.println("Menu Inicial -> Que quieres hacer ? \n 1. Hacer Cosas con clientes\n"
                        + "2. Hacer cosas con Vehiculos\n"
                        + "3. Hacer cosas con Asseguradoras\n"
                        + "4. Hacer cosas con Polizas\n"
                        + "5. Salir");
                
                int opcion = lector.nextInt();
                
                switch(opcion){
                    
                    case 1:
                      u.menuInicial();
                      
                      break;
                    
                    case 2:
                      v.menuInicial();
                      break;
                    
                    case 3:
                       a.menuInicial();
                       break;
                       
                    case 5:
                        System.out.println("Saliendo...");
                        System.exit(0);
                }
            }
            }

  

}
