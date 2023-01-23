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

    public Orden(List<OrderServicio> orderServicioList, Double total, String usernameTecnico, String codigoCliente) {
        this.orderServicioList = orderServicioList;
        this.total = total;
        this.usernameTecnico = usernameTecnico;
        this.codigoCliente = codigoCliente;
    }

    public Orden() {
    }

    public String getUsernameTecnico() {
        return usernameTecnico;
    }

    public Orden setUsernameTecnico(String nombreTecnico) {
        this.usernameTecnico = nombreTecnico;
        return this;
    }

    private String usernameTecnico;

    private String codigoCliente;

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
