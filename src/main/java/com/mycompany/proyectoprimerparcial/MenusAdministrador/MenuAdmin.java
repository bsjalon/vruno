/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprimerparcial.MenusAdministrador;

import com.mycompany.proyectoprimerparcial.ProyectoPrimerParcial;

import java.util.*;

/**
 * @author Sebasceb
 */
public class MenuAdmin {

    Scanner scanner = new Scanner(System.in);
    public void menuPrincipal() {
        boolean check = true;
        while (check) {
            System.out.println("1. Administrar Clientes\n2. Administrar Proveedores\n3. Admninistrar Servicios\n4. Cerrar");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1 -> administrarCliente();
                case 2 -> administrarProveedor();
                case 3 -> administrarServicios();
                case 4 -> check = false;
                default -> scanner.close();
            }
        }

    }

    public void administrarCliente() {
        int a;
        while (true) {
            ProyectoPrimerParcial.getDataBase().listaClientes.forEach(cliente -> System.out.println(cliente.toString()));
            System.out.println("1. Agregar Cliente \n2. Regresar a menú principal");
            a = scanner.nextInt();
            scanner.nextLine();
            if (a == 2) {
                return;
            }
            if (a == 1) {
                System.out.println("Ingrese el nombre del cliente: ");
                String nombre = scanner.nextLine();
                System.out.println("Ingrese la dirección del cliente: ");
                String direccion = scanner.nextLine();
                System.out.println("Ingrese el numero de teléfono del cliente: ");
                String telefono = scanner.nextLine();
                String codigo = String.valueOf(ProyectoPrimerParcial.getDataBase().listaClientes.size() + 1);
                System.out.println("Ingrese el tipo de cliente (1- Personal , 2 Empresarial):");
                TipoCliente tipoCliente = TipoCliente.values()[scanner.nextInt()];
                ProyectoPrimerParcial.getDataBase().agregarCliente(new Cliente(codigo, nombre, direccion, telefono, tipoCliente));
            }
        }
    }

    public void administrarProveedor() {
        System.out.println(ProyectoPrimerParcial.getDataBase().accederProveedores());
        int a;
        while (true) {
            ProyectoPrimerParcial.getDataBase().listaProveedores.forEach(proveedor -> System.out.println(proveedor.toString()));
            System.out.println("1. Agregar Proveedor \n2. Regresar a menú principal");
            a = scanner.nextInt();
            scanner.nextLine();
            if (a == 2) {
                return;
            }
            if (a == 1) {
                System.out.println("Ingrese el nombre del proveedor: ");
                String nombre = scanner.nextLine();

                System.out.println("Ingrese la dirección del proveedor: ");
                String direccion = scanner.nextLine();

                System.out.println("Ingrese el numero de teléfono del proveedor: ");
                String telefono = scanner.nextLine();

                String codigo = String.valueOf(ProyectoPrimerParcial.getDataBase().listaProveedores.size() + 1);

                ProyectoPrimerParcial.getDataBase().agregarProveedor(new Proveedor(codigo, nombre, direccion, telefono));
            }
        }

    }

    public void administrarServicios() {
        int a;
        while (true) {
            ProyectoPrimerParcial.getDataBase().listaServicios.forEach(servicio -> System.out.println(servicio.toString()));
            System.out.println("1. Agregar Servicio \n2. Editar Servicio \n3.Regresar a menú principal");
            a = scanner.nextInt();
            scanner.nextLine();
            if (a == 3) {
                return;
            }
            if (a == 1) {
                System.out.println("Ingrese el nombre del servicio: ");
                String nombre = scanner.nextLine();

                System.out.println("Ingrese el precio(##.##): ");
                float servicio = scanner.nextFloat();
                
                

                String codigo = String.valueOf(ProyectoPrimerParcial.getDataBase().listaServicios.size() + 1);

                ProyectoPrimerParcial.getDataBase().agregarServicio(new Servicio(codigo, nombre, servicio));
            }
            if (a==2) {
                System.out.println("Ingrese el codigo del servicio: ");
                String codigo = scanner.nextLine();
                //Se busca el servicio con el mismo codigo
                
                System.out.println("Ingrese el nuevo precio(##.##): ");
                float precio = scanner.nextFloat();
               // se cambia el precio del del servicio
               
            }
        }
    }

}
