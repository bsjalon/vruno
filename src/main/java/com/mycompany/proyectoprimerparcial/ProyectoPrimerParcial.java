/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.proyectoprimerparcial;

import com.mycompany.proyectoprimerparcial.MenusAdministrador.MenuAdmin;
import com.mycompany.proyectoprimerparcial.MenusAdministrador.MenuCobranzas;
import com.mycompany.proyectoprimerparcial.MenusAdministrador.MenuTecnico;
import com.mycompany.proyectoprimerparcial.MenusAdministrador.TipoUsuario;
import com.mycompany.proyectoprimerparcial.MenusAdministrador.Usuario;

import java.util.List;
import java.util.Scanner;

/**
 * @author Sebasceb
 */
public class ProyectoPrimerParcial {
    private static final DataBase db = new DataBase();

    public static DataBase getDataBase() {
        return db;
    }

    public void login(String username, String password) {
        List<Usuario> usersList = db.listaUsuarios;
        usersList.stream()
                .filter(user -> user.nombre.equals(username) && user.contrasena.equals(password))
                .findFirst();
    }


    public static void main(String[] args) {
        db.init();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su usuario:");
        String usuario = sc.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contrasena = sc.nextLine();
        // Usuario login = new Usuario(usuario, contrasena);


        for (Usuario usuarioDB : db.accederUsuarios()) {
            if (usuario.compareTo(usuarioDB.getUsuario()) == 0) {
                if (contrasena.compareTo(usuarioDB.getContrasena()) == 0) {
                    if (usuarioDB.getNivel() == TipoUsuario.Admin) {
                        MenuAdmin menu = new MenuAdmin();
                        menu.menuPrincipal();
                    } else if (usuarioDB.getNivel() == TipoUsuario.Cobranzas) {
                        MenuCobranzas menuConbranza = new MenuCobranzas();
                        menuConbranza.menuPrincipal();
                    } else {
                        MenuTecnico menuTecnico = new MenuTecnico();
                        menuTecnico.menuPrincipal();
                    }
                } else {
                    System.out.println("Contraseña incorrecta");
                }
            } else {
                System.out.println("No existe el usuario");
            }
        }
    }

}
