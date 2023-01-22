/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprimerparcial.MenusAdministrador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebasceb
 */
public class Orden{
    private String placa;
    private String fecha;
    private TipoVehiculo tipo;
    private String codigoCliente;
    private ArrayList<Servicio> servicios;
    private double total;
    
    public Orden(String p, String f, TipoVehiculo t, String c){
        this.placa=p;
        this.fecha=f;
        this.tipo=t;
        this.codigoCliente=c;
        servicios = new ArrayList<>();
        total = 0;
    }
    
    public String getCodigoCliente(){
        return codigoCliente;
    }
    
    public String getFecha(){
        return fecha;
    }
    
    public TipoVehiculo getTipo(){
        return tipo;
    }
    
    public double getTotal(){
        return total;
    }
    
    public void agregarServicio(Servicio s){
        servicios.add(s);
        total += servicios.getPrecio();
    }

    public List<Servicio> getServiciosDeOrden() {
        return servicios;
    }
    
    
}
