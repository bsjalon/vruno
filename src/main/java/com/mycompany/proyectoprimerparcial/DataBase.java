package com.mycompany.proyectoprimerparcial;

import com.mycompany.proyectoprimerparcial.MenusAdministrador.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataBase {

    public ArrayList<Cliente> listaClientes = new ArrayList<>();
    public ArrayList<Proveedor> listaProveedores = new ArrayList<>();
    ;
    public ArrayList<Servicio> listaServicios = new ArrayList<>();
    ;
    public ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    ;
    public ArrayList<Orden> listaOrdenes = new ArrayList<>();
    ;

    public void agregarCliente(Cliente c) {
        listaClientes.add(c);
    }

    public void agregarProveedor(Proveedor p) {
        listaProveedores.add(p);
    }

    public void agregarServicio(Servicio s) {
        listaServicios.add(s);
    }

    public Optional<Servicio> getServicioByCodigo(String codigo) {
        return listaServicios.stream().filter(servicio -> servicio.getCodigo().equals(codigo)).findFirst();
    }

    public Optional<Cliente> getClienteByCodigo(String codigo) {
        return listaClientes
                .stream()
                .filter(cliente -> cliente.getCodigo().equals(codigo))
                .findFirst();
    }

    public Optional<Cliente> getClienteByCodigoAndTipo(String codigo, TipoCliente tipo) {
        return listaClientes
                .stream()
                .filter(cliente -> cliente.getCodigo().equals(codigo) && cliente.tipo.equals(tipo))
                .findFirst();
    }

    public void actualizarServicio(Servicio servicio) {
        listaServicios.set(Integer.parseInt(servicio.getCodigo()) - 1, servicio);
    }

    public void actualizarCliente(Cliente cliente) {
        listaClientes.set(Integer.parseInt(cliente.getCodigo()) - 1, cliente);
    }

    public void agregarUsuario(Usuario u) {
        listaUsuarios.add(u);
    }

    public void agregarOrden(Orden o) {
        listaOrdenes.add(o);
    }

    public ArrayList<Cliente> accederClientes() {
        return listaClientes;
    }

    public ArrayList<Proveedor> accederProveedores() {
        return listaProveedores;
    }

    public ArrayList<Servicio> accederServicios() {
        return listaServicios;
    }

    public ArrayList<Usuario> accederUsuarios() {
        return listaUsuarios;
    }

    public ArrayList<Orden> accederOrdenes() {
        return listaOrdenes;
    }

    public void init() {

        //se crean los objetos correspondientes
        //Usuarios
        Usuario u0 = new Usuario("a", "a", "Administrador", TipoUsuario.Cobranzas);
        Usuario u1 = new Usuario("admin1", "12345678", "Administrador", TipoUsuario.Admin);
        Usuario u2 = new Usuario("alopez", "al123456", "Alvaro Lopez", TipoUsuario.Tecnico);
        Usuario u3 = new Usuario("mcastro", "mc123456", "Maria Castro", TipoUsuario.Cobranzas);
        Usuario u4 = new Usuario("mbarcos", "mb123456", "Mario Barcos", TipoUsuario.Tecnico);
        listaUsuarios.add(u0);
        listaUsuarios.add(u1);
        listaUsuarios.add(u2);
        listaUsuarios.add(u3);
        listaUsuarios.add(u4);

        //Servicios
        Servicio s1 = new Servicio("1", "servicio uno", 10.00F);
        listaServicios.add(s1);
        //Proveedores

        //Ordenes
        Orden o1 = new Orden(List.of(new OrderServicio("ASC", "11/11/2020", TipoVehiculo.Bus, 2, s1)), 20.00, "alopez", "1");
        listaOrdenes.add(o1);

        //Clientes
        Cliente c1 = new Cliente("1", "uno", "aqui", "123", TipoCliente.Empresarial, List.of(o1));
        listaClientes.add(c1);


    }
}
