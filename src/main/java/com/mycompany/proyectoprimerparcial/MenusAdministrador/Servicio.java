/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprimerparcial.MenusAdministrador;

/**
 *
 * @author Sebasceb
 */
public class Servicio {
    private String codigo;
    private String nombre;
    private double precio;

    public Servicio(String codigo, String nombre, float precio){
      this.codigo=codigo;
      this.nombre=nombre;
      this.precio=precio;
    }

    public double getPrecio() {
        return precio;
    }

    public Servicio setPrecio(double precio) {
        this.precio = precio;
        return this;
    }
    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s", codigo, nombre, precio);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null &&  obj instanceof Servicio){
            Servicio other = (Servicio) obj;
            return (codigo==other.codigo);
        }
        else
            return false;
    }

    public String getNombre() {
        return nombre;
    }
}
