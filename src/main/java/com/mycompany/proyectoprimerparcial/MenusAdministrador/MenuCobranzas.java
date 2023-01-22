package com.mycompany.proyectoprimerparcial.MenusAdministrador;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuCobranzas {


    
    public ArrayList<Usuario> listaUsuarios;
    public ArrayList<Cliente> listaClientes;
    double ganancia = 0;
    public ArrayList<Orden> listaOrdenes;
    public String codEmpresa;
    public String anio;
    public String mes;
    public ArrayList<Orden> ordenesFinal;
    
 
  public void menuPrincipal() {
    Scanner sc = new Scanner(System.in);
    boolean salir = false;
    int opcion;
  
    
    while(!salir){
      System.out.println("1. Generar facturas de empresas");
      System.out.println("2. Reporte de ingresos por servicios");
      System.out.println("3. Reporte de atenciones por técnico");
      System.out.println("4. Salir");
          
      System.out.println("Escoge una de las opciones");
      opcion = sc.nextInt();
          
      switch(opcion){
        case 1:
          System.out.println("Opcion 1");
          this.generarFacturasEmpresas();
          break;
        case 2:
          System.out.println("Opcion 2");
          this.ingresosServicios();
          break;
        case 3:
          System.out.println("Opcion 3");
          this.recaudacionTecnicos();
          break;
        case 4:
          System.out.println("Opcion 4");
          salir = true;
          break;
        default:
          System.out.println("Solo opciones del 1 al 4");
                  
      }
          
    }
  }

  public void ingresosServicios(){
    Scanner sn = new Scanner(System.in);
    ArrayList<Orden> listaOrdenes2 = (ArrayList<Orden>)listaOrdenes.clone();
    
    System.out.println("Ingrese año a consultar: ");
    int anio = sn.nextInt();
    sn.nextLine();
    System.out.println("Ingrese mes a consultar: ");
    int mes = sn.nextInt();
    sn.nextLine();
    System.out.println("Servicio          Total");
    
    for(int i=0;i<listaOrdenes2.size();i++){
      Orden other = listaOrdenes2.remove(i);
      int ind = listaOrdenes2.indexOf(other);
      Orden other2 = listaOrdenes2.get(ind);
      
      if(other.getMes() == mes && other.getServicio() == other2.getServicio()){
        int cantidades += other.getCantidad() + other2.getCantidad();
        System.out.println(other.getServicio+"          "+(other.getPrecio()*cantidades);  
      }
    }
    sn.close();
    menuPrincipal();
  }  
  public void recaudacionTecnicos(){
    Scanner sn = new Scanner(System.in);

    System.out.println("Ingrese año a consultar: ");
    int anio = sn.nextInt();
    sn.nextLine();
    System.out.println("Ingrese mes a consultar: ");
    int mes = sn.nextInt();
    sn.nextLine();

    System.out.println("Técnico          Total");
    
    for(int i=0;i<listaUsuarios.size();i++){
      Usuario tc = listaUsuarios.get(i);
      for(Orden od: listaOrdenes){
        Servicio sv = od.getServicio();
        
        if(od.getMes() == mes){
          double precio = sv.getPrecio();
          int cant = od.getCantidad();
          ganancia += precio * cant;
        }
        System.out.println(tc.getNombre()+"          "+ganancia); 
      } 
    }
    sn.close();
    menuPrincipal();
  }
    public void generarFacturasEmpresas(){
        Scanner sn = new Scanner(System.in);
    
        System.out.println("Ingrese los siguientes datos");
        System.out.println("Año a consultar: ");
        anio = sn.nextLine();
        System.out.println("Mes a consultar: ");
        mes = sn.nextLine();
        int flag = 0;
        while(flag == 0){
          System.out.println("Codigo de la empresa: ");
          codEmpresa = sn.nextLine();
          for(Cliente cl:listaClientes){
            if((cl.getCodigo()).equals(codEmpresa) && (cl.tipo).equals(TipoCliente.EMPRESARIAL)){
              flag = 1;
            }else{
              System.out.println("Ingrese de nuevo el codigo");
            }
          }
        }
        Cliente c = new Cliente(codEmpresa,"","","");
        if(listaClientes.contains(c)){
          int ind = listaClientes.indexOf(c);
          Cliente empresa = listaClientes.get(ind);
          System.out.println("Empresa: "+empresa.getNombre());
          System.out.println("Periodo de facturación: "+mes+"-"+anio);
          System.out.println("Detalle de servicios: ");
          System.out.println("#Placa      Fecha    Tipo    Servicio    Cantidad      Total");
          for(Orden od:listaOrdenes){
              if(od.getMes()==mes){
                System.out.println(od.getPlaca()+"    "+od.getFecha()+"    "+od.getTipo()+"    "+od.getServicio());
                int totalPagar += od.getPrecio() * od.getCantidad;
              } 
          }
          System.out.println("Total a pagar: "+totalPagar);
        }
      sn.close();
      menuPrincipal();
    }

}
