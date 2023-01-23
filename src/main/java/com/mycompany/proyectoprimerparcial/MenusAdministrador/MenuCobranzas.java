package com.mycompany.proyectoprimerparcial.MenusAdministrador;

import com.mycompany.proyectoprimerparcial.DataBase;
import com.mycompany.proyectoprimerparcial.ProyectoPrimerParcial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class MenuCobranzas {

    double ganancia = 0;
    public String codEmpresa;
    public String anio;
    public String mes;
    public ArrayList<Orden> ordenesFinal;

    private DataBase db = ProyectoPrimerParcial.getDataBase();


    private final Scanner scanner = new Scanner(System.in);


    public void menuPrincipal() {
        boolean salir = false;
        int opcion;


        while (!salir) {
            System.out.println("1. Generar facturas de empresas");
            System.out.println("2. Reporte de ingresos por servicios");
            System.out.println("3. Reporte de atenciones por técnico");
            System.out.println("4. Salir");
            System.out.println("Escoge una de las opciones");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Opcion 1");
                    this.generarFacturasEmpresas();
                }
                case 2 -> {
                    System.out.println("Opcion 2");
                    this.ingresosServicios();
                }
                case 3 -> {
                    System.out.println("Opcion 3");
                    this.recaudacionTecnicos();
                }
                case 4 -> {
                    System.out.println("Opcion 4");
                    salir = true;
                }
                default -> System.out.println("Solo opciones del 1 al 4");
            }

        }
    }

    public void ingresosServicios() {
        List<Orden> listaOrdenes2 = db.listaOrdenes;

        System.out.println("Ingrese año a consultar: ");
        int anio = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese mes a consultar: ");
        String mes = String.valueOf(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Servicio          Total");

        for (int i = 0; i < listaOrdenes2.size(); i++) {
            Orden orden1 = listaOrdenes2.remove(i);
            int ind = listaOrdenes2.indexOf(orden1);
            Orden orden2 = listaOrdenes2.get(ind);

//            if (orden1.getMes().equals(mes) && orden1.getServicio() == orden2.getServicio()) {
//                int cantidades += orden1.getCantidad() + orden2.getCantidad();
//                System.out.println(orden1.getServicio + "          " + (orden1.getPrecio() * cantidades);
//            }
        }
        menuPrincipal();
    }

    public void recaudacionTecnicos() {

        System.out.println("Ingrese año a consultar: ");
        int anio = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese mes a consultar: ");
        int mes = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Técnico          Total");

//        for (int i = 0; i < listaUsuarios.size(); i++) {
//            Usuario tc = listaUsuarios.get(i);
//            for (Orden od : listaOrdenes) {
//                Servicio sv = od.getServicio();
//
//                if (od.getMes() == mes) {
//                    double precio = sv.getPrecio();
//                    int cant = od.getCantidad();
//                    ganancia += precio * cant;
//                }
//                System.out.println(tc.getNombre() + "          " + ganancia);
//            }
//        }
        menuPrincipal();
    }

    public void generarFacturasEmpresas() {

        System.out.println("Ingrese los siguientes datos");
        System.out.println("Año a consultar: ");
        anio = scanner.nextLine();
        System.out.println("Mes [MM] a consultar: ");
        mes = scanner.nextLine();
        int flag = 0;
        while (flag == 0) {
            System.out.println("Codigo de la empresa: ");
            codEmpresa = scanner.nextLine();
            if (db.getClienteByCodigoAndTipo(codEmpresa, TipoCliente.Empresarial).isPresent()) {
                flag = 1;
            } else {
                System.out.println("Ingrese de nuevo el codigo");
            }
        }
        Cliente empresa = db.getClienteByCodigoAndTipo(codEmpresa, TipoCliente.Empresarial).get();
        System.out.println("Empresa: " + empresa.getNombre());
        System.out.println("Periodo de facturación: " + mes + "-" + anio);
        System.out.println("Detalle de servicios: ");
        System.out.println("#Placa      Fecha    Tipo    Servicio    Cantidad      Total");
        Double total = 0D;
        for (Orden orden : empresa.getOrdenList()) {
            for (OrderServicio orderServicio : orden.getOrderServicioList()) {
                if (orderServicio.getMes().equals(mes)) {
                    System.out.println(orderServicio.getPlaca() + "    " + orderServicio.getFecha() + "    " + orderServicio.getTipo() + "   " + orderServicio.getServicio().getNombre() + "  " + orderServicio.getCantidad() + "  " + orderServicio.getTotal());
                }
                total += orden.getTotal();
            }
        }
        System.out.println(".");
        System.out.println(".");
        System.out.println("Total a pagar:" + total);
        menuPrincipal();
    }

}
