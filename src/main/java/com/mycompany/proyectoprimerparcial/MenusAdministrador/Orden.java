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
public class Orden {

    private List<OrderServicio> orderServicioList = new ArrayList<>();
    private Double total;

    private String codigoCliente;


    private String fecha;

    public String getFecha() {
        return fecha;
    }

    public Orden setFecha(String fecha) {
        this.fecha = fecha;
        return this;
    }


    public Orden(List<OrderServicio> orderServicioList, Double total, String codigoCliente) {
        this.orderServicioList = orderServicioList;
        this.total = total;
        this.codigoCliente = codigoCliente;
    }

    public Orden() {
    }



    public String getCodigoCliente() {
        return codigoCliente;
    }

    public Orden setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
        return this;
    }

    public List<OrderServicio> getOrderServicioList() {
        return orderServicioList;
    }

    public Orden setOrderServicioList(List<OrderServicio> orderServicioList) {
        this.orderServicioList = orderServicioList;
        return this;
    }

    public Double getTotal() {
        return total;
    }

    public Orden setTotal(Double total) {
        this.total = total;
        return this;
    }
}
