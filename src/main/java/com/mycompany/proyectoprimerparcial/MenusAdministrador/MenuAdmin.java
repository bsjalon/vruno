/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprimerparcial.MenusAdministrador;
import com.mycompany.proyectoprimerparcial.ProyectoPrimerParcial;
import java.util.*;
/**
 *
 * @author Sebasceb
 */
public class MenuAdmin {
    
    public ArrayList<Cliente> listaClientes;
    public ArrayList<Proveedor> listaProveedores;
    public ArrayList<Servicio> listaServicios;
  
  
    public MenuAdmin(ArrayList<Cliente> c, ArrayList<Proveedor> p,ArrayList<Servicio> s ){
      this.listaClientes=c;
      this.listaProveedores=p;
      this.listaServicios=s;
    }
    
  

  public void menuPrincipal(){
    int check=0;
    while(check==0){
      Scanner sc = new Scanner(System.in);
      System.out.println("1. Administrar Clientes\n2. Administrar Proveedores\n3. Admninistrar Servicios");
      int opcion=sc.nextInt();
      switch(opcion){
        case 1:
          administrarCliente();
        case 2:
          administrarProveedor();
        case 3:
          administrarServicios();  
        default:
          sc.close();
      }
  
      
    }
    
  }
  
  public void administrarCliente(){
    System.out.println(ProyectoPrimerParcial.accederClientes());

    Scanner sc = new Scanner(System.in);
    int a= 0;
    while(a!=1 && a!=2){
      System.out.println("1. Agregar Cliente \n2. Regresar a menú principal");
      a= sc.nextInt();
      sc.nextLine(); 
      if(a==2){
        sc.close();
        return;
      }
      if(a==1){
       System.out.println("Ingrese el nombre del cliente: ");
        String nombre= sc.nextLine();
    
        System.out.println("Ingrese la dirección del cliente: ");
        String direccion= sc.nextLine();
    
        System.out.println("Ingrese el numero de teléfono del cliente: ");
        String telefono= sc.nextLine();
        
        String codigo= "Falta hacer codigo";
    
        ProyectoPrimerParcial.agregarCliente(new Cliente(codigo, nombre, direccion, telefono)); 
      }
    }
    sc.close();
  }

  public void administrarProveedor(){
    System.out.println(ProyectoPrimerParcial.accederProveedores());

    Scanner sc = new Scanner(System.in);
    int a= 0;
    while(a!=1 && a!=2){
      System.out.println("1. Agregar Proveedor \n2. Regresar a menú principal");
      a= sc.nextInt();
      sc.nextLine(); 
      if(a==2){
        sc.close();
        return;
      }
      if(a==1){
        System.out.println("Ingrese el nombre del proveedor: ");
        String nombre= sc.nextLine();

        System.out.println("Ingrese la dirección del proveedor: ");
        String direccion= sc.nextLine();

        System.out.println("Ingrese el numero de teléfono del proveedor: ");
        String telefono= sc.nextLine();

        String codigo= "Falta hacer codigo";
    
        ProyectoPrimerParcial.agregarProveedor(new Proveedor(codigo, nombre, direccion, telefono)); 
      }
    }
    sc.close();
    
  }

  public void administrarServicios(){
    System.out.println(ProyectoPrimerParcial.accederServicios());

    Scanner sc = new Scanner(System.in);
    int a= 0;
    while(a!=1 && a!=2){
      System.out.println("1. Agregar Servicio \n2. Regresar a menú principal");
      a= sc.nextInt();
      sc.nextLine(); 
      if(a==2){
        sc.close();
        return;
      }
      if(a==1){
       System.out.println("Ingrese el nombre del servicio: ");
        String nombre= sc.nextLine();
    
        System.out.println("Ingrese el precio(##.##): ");
        float servicio= sc.nextFloat();
        
        String codigo= "Falta hacer codigo";
    
        ProyectoPrimerParcial.agregarServicio(new Servicio(codigo, nombre, servicio)); 
      }
    }
    sc.close();
    
  
  }
    
}
