/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprimerparcial.MenusAdministrador;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sebasceb
 */
public class MenuTecnico {
    public ArrayList<Orden> listaOrdenes;
    public ArrayList<Servicio> listaServicios;
    public String mailResponsable="correo@gmail.com";
   
    
    
    public void menuPrincipal(){
        int check=0;
        while(check==0){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Generar orden de servicios\n2. Reportar falta de insumos\n3. Salir");
        int opcion=sc.nextInt();
        switch(opcion){
          case 1:
            generarOrden();
          case 2:
            reportarInsumo();
          case 3:
            check=1;  
          default:
            sc.close();
      }
  
    }
    
  }
  
    public void generarOrden(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Generando Orden...");
        System.out.println("Ingrese código del cliente: ");
        String codeC=sc.nextLine();
        System.out.println("Ingrese fecha del servicio: ");
        String fecha=sc.nextLine();
        int tipoNum=0;
        TipoVehiculo tipo=null;
        while(tipoNum!=1&& tipoNum!=2 && tipoNum!=3){
            System.out.println("Ingrese tipo de vehiculo 1. automóvil 2. motocicletas 3. bus(Ingrese el numero de la opcion correcta)");
            tipoNum=sc.nextInt();
            sc.nextLine();
        }
            switch(tipoNum){
                case 1:
                    tipo=TipoVehiculo.Automóvil;
                case 2:
                    tipo=TipoVehiculo.Motocicleta;
                case 3:
                    tipo=TipoVehiculo.Bus;
        }
       System.out.println("Ingrese la placa del vehículo: ");
       String placa=sc.nextLine();
       float precioFinal=0;
       int bandera=0;
       while(bandera==0){
           System.out.println("Ingrese el código del servicio: ");
           String codeS=sc.nextLine();
           Servicio servicioTemp=new Servicio(codeS, "", 0);
           if(codeS.equals("-1")){
               break;
           }
           else{
               if(listaServicios.contains(servicioTemp)){
                   int index=listaServicios.indexOf(servicioTemp);
                   Servicio servicioAgregar=listaServicios.get(index);
                   System.out.println("Ingrese la cantidad para el servicio: ");
                   int cant=sc.nextInt();
                   sc.nextLine();
                   if(cant==-1){
                       break;
                   }
                   else{
                       servicioAgregar.setCantidad(cant);    
                   }
                   Orden ordenAgregar=new Orden(placa, fecha, tipo, codeC);
                   float precio=cant*servicioAgregar.getPrecio();
                   precioFinal+=precio;
                   listaOrdenes.add(ordenAgregar);
               }
               else{
                   System.out.println("Codigo no encontrado");
               }
               
           }
           
           
       }
       
       
       
       
       sc.close();
       menuPrincipal();
    }

    public void reportarInsumo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el mensaje a reportar: ");
        String mensaje=sc.nextLine();
        String conf="";
        while(!(conf.equals("S")||(conf.equals("N")))){
            System.out.println("Desea enviar el correo al personal responsable(S/N)?");
            conf=sc.nextLine();
            if(conf.equals("S")){
                System.out.println("Correo enviado");
            }
        }
        sc.close();
        menuPrincipal();
    }
      
}
