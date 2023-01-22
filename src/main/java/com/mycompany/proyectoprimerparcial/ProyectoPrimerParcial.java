/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.proyectoprimerparcial;
import com.mycompany.proyectoprimerparcial.MenusAdministrador.Cliente;
import com.mycompany.proyectoprimerparcial.MenusAdministrador.MenuAdmin;
import com.mycompany.proyectoprimerparcial.MenusAdministrador.MenuCobranzas;
import com.mycompany.proyectoprimerparcial.MenusAdministrador.MenuTecnico;
import com.mycompany.proyectoprimerparcial.MenusAdministrador.Orden;
import com.mycompany.proyectoprimerparcial.MenusAdministrador.Proveedor;
import com.mycompany.proyectoprimerparcial.MenusAdministrador.Servicio;
import com.mycompany.proyectoprimerparcial.MenusAdministrador.TipoUsuario;
import com.mycompany.proyectoprimerparcial.MenusAdministrador.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Sebasceb
 */
public class ProyectoPrimerParcial {
    public static ArrayList<Cliente> listaClientes;
    public static ArrayList<Proveedor> listaProveedores;
    public static ArrayList<Servicio> listaServicios;
    public static ArrayList<Usuario> listaUsuarios;
    public static ArrayList<Orden> listaOrdenes;
    
    
    public static void agregarCliente(Cliente c){
        listaClientes.add(c);
    }
    public static void agregarProveedor(Proveedor p){
        listaProveedores.add(p);
    }
    public static void agregarServicio(Servicio s){
        listaServicios.add(s);
    }
    public static void agregarUsuario(Usuario u){
        listaUsuarios.add(u);
    }
    public static void agregarOrden(Orden o){
        listaOrdenes.add(o);
    }
    
    public static ArrayList<Cliente> accederClientes(){
        return listaClientes;    
    }
    public static ArrayList<Proveedor> accederProveedores(){
        return listaProveedores;    
    }
    public static ArrayList<Servicio> accederServicios(){
        return listaServicios;    
    }
    public static ArrayList<Usuario> accederUsuarios(){
        return listaUsuarios;    
    }
    public static ArrayList<Orden> accederOrdenes(){
        return listaOrdenes;    
    }

    public void login(String username, String password) {
        List<Usuario> usersList = accederUsuarios();
       
        usersList.stream()
                .filter(user -> user.nombre.equals(username)&& user.contrasena.equals(password))
                .findFirst();
        
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su usuario:");
        String usuario = sc.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contrasena = sc.nextLine();
       // Usuario login = new Usuario(usuario, contrasena);
       
        
        for (Usuario u : Usuario.getListaUsuarios()){
            if(usuario.compareTo(u.getUsuario())== 0){
                if(contrasena.compareTo(u.getContrasena())==0){
                    if(u.getNivel() == TipoUsuario.Admin){
                        MenuAdmin menu = new MenuAdmin(listaClientes, listaProveedores, listaServicios);
                        menu.menuPrincipal();
                    }else if(u.getNivel() == TipoUsuario.Cobranzas){
                        MenuCobranzas menuConbranza = new MenuCobranzas();
                        menuConbranza.menuPrincipal();
                    }else{
                        MenuTecnico menuTecnico = new MenuTecnico();
                        menuTecnico.menuPrincipal();
                    }
                }else{
                    System.out.println("Contraseña incorrecta");
                }
            }else{
                System.out.println("No existe el usuario");
                }
            }
        }
        
        
      /*  for (Usuario u : Usuario.getListaUsuarios()){
            if(login.usuario.equals(u.getUsuario())){
                if(login.contrasena.equals(u.getContrasena())){
                    if(u.getNivel() == TipoUsuario.ADMIN){
                        menuAdmin.menuPrincipal();
                    }else if(u.getNivel() == TipoUsuario.COBRANZA){
                        menuCobranza.menuPrincipal();
                    }else{
                        menuTecnico.menuPrincipal();
                    }
                }else{
                    System.out.println("Contraseña incorrecta");
                }
            }else{
                System.out.println("No existe el usuario");
            }
       */ }
    }
}
