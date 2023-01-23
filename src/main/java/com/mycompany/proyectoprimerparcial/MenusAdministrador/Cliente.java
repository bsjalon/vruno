/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprimerparcial.MenusAdministrador;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sebasceb
 */
public class Cliente extends Proveedor {
    public TipoCliente tipo;

    private List<Orden> ordenList = new ArrayList<>();

    public Cliente(String c, String n, String d, String t) {
        super(c, n, d, t);

    }

    public Cliente(String codigo, String nombre, String direccion, String telefono, TipoCliente tipo) {
        super(codigo, nombre, direccion, telefono);
        this.tipo = tipo;
    }

    public Cliente(String codigo, String nombre, String direccion, String telefono, TipoCliente tipo, List<Orden> ordenList) {
        super(codigo, nombre, direccion, telefono);
        this.tipo = tipo;
        this.ordenList = ordenList;
    }


    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + tipo.toString();
    }

    public List<Orden> getOrdenList() {
        return ordenList;
    }

    public Cliente setOrdenList(List<Orden> ordenList) {
        this.ordenList = ordenList;
        return this;
    }
}
