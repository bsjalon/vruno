/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprimerparcial.MenusAdministrador;

import com.mycompany.proyectoprimerparcial.DataBase;
import com.mycompany.proyectoprimerparcial.ProyectoPrimerParcial;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Sebasceb
 */
public class MenuTecnico {
    public ArrayList<Orden> listaOrdenes;
    public String mailResponsable = "correo@gmail.com";

    private DataBase db = ProyectoPrimerParcial.getDataBase();

    private String usernameTecnico;
    Scanner sc = new Scanner(System.in);

    public MenuTecnico(String usernameTecnico) {
        this.usernameTecnico = usernameTecnico;
    }

    public void menuPrincipal() {
        int check = 0;
        while (check == 0) {
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Generar orden de servicios\n2. Reportar falta de insumos\n3. Salir");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    generarOrden();
                case 2:
                    reportarInsumo();
                default:
                    check = 1;
            }

        }

    }

    public void generarOrden() {
        System.out.println("Generando Orden...");
        System.out.println("Ingrese código del cliente: ");
        String codigoCliente = sc.nextLine();
        if (ProyectoPrimerParcial.getDataBase().getClienteByCodigo(codigoCliente).isEmpty()) {
            System.out.println("Cliente no encontrado");
            return;
        }
        Orden orden = new Orden();
        Cliente cliente = ProyectoPrimerParcial.getDataBase().getClienteByCodigo(codigoCliente).get();
        float precioFinal = 0;
        while (true) {

            System.out.println("Ingrese el código del servicio: ");
            String codigoServicio = sc.nextLine();

            if (codigoServicio.equals("-1"))
                break;

            if (db.getServicioByCodigo(codigoServicio).isEmpty()) {
                System.out.println("Servicio no encontrado");
                continue;
            }

            Servicio servicioAgregar = db.getServicioByCodigo(codigoServicio).get();
            OrderServicio ordenServicio = new OrderServicio(servicioAgregar);

            System.out.println("Ingrese fecha del servicio [dd/mm/yyyy]: ");
            ordenServicio.setFecha(sc.nextLine());
            int tipoNum = 0;
            while (tipoNum != 1 && tipoNum != 2 && tipoNum != 3) {
                System.out.println("Ingrese tipo de vehiculo 1. automóvil 2. motocicletas 3. bus(Ingrese el numero de la opcion correcta)");
                tipoNum = sc.nextInt();
                sc.nextLine();
            }

            switch (tipoNum) {
                case 1:
                    ordenServicio.setTipo(TipoVehiculo.Automóvil);
                case 2:
                    ordenServicio.setTipo(TipoVehiculo.Motocicleta);
                case 3:
                    ordenServicio.setTipo(TipoVehiculo.Bus);
            }

            System.out.println("Ingrese la placa del vehículo: ");
            ordenServicio.setPlaca(sc.nextLine());

            System.out.println("Ingrese la cantidad para el servicio: ");
            ordenServicio.setCantidad(sc.nextInt());
            sc.nextLine();

            if (ordenServicio.getCantidad() <= 0) {
                System.out.println("Cantidad Invalida, Ingrese el servicio nuevamente");
                continue;
            }

            double precio = ordenServicio.getCantidad() * servicioAgregar.getPrecio();
            ordenServicio.setTotal(precio);
            precioFinal += precio;
            orden.getOrderServicioList().add(ordenServicio);
            System.out.println("Total: " + precio);
        }
        orden.setCodigoCliente(cliente.codigo);
        orden.setUsernameTecnico(usernameTecnico);
        orden.setTotal((double) precioFinal);
        cliente.getOrdenList().add(orden);
        db.listaOrdenes.add(orden);
        db.actualizarCliente(cliente);
        System.out.println("Total a Pagar: " + precioFinal);
        menuPrincipal();
    }

    public void reportarInsumo() {

        System.out.println("Ingrese el mensaje a reportar: ");
        String mensaje = sc.nextLine();
        String conf = "";
        while (!(conf.equals("S") || (conf.equals("N")))) {
            System.out.println("Desea enviar el correo al personal responsable(S/N)?");
            conf = sc.nextLine();
            if (conf.equals("S")) {
                System.out.println("Correo enviado");
            }
        }
        menuPrincipal();
    }

}
