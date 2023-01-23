package com.mycompany.proyectoprimerparcial.MenusAdministrador;

public class OrderServicio {
    private String placa;
    private String fecha;  //  dd/mm/yyyy
    private TipoVehiculo tipo;
    private Integer cantidad;
    private final Servicio servicio;
    private double total;
    private String usernameTecnico;

    public String getUsernameTecnico() {
        return usernameTecnico;
    }

    public OrderServicio setUsernameTecnico(String usernameTecnico) {
        this.usernameTecnico = usernameTecnico;
        return this;
    }

    public OrderServicio(String p, String f, TipoVehiculo t, Integer c, Servicio servicio, String usernameTecnico) {
        this.placa = p;
        this.usernameTecnico = usernameTecnico;
        this.fecha = f;
        this.tipo = t;
        this.cantidad = c;
        this.servicio = servicio;
        total = cantidad * servicio.getPrecio();
    }

    public OrderServicio(Servicio servicio) {
        this.servicio = servicio;
    }


    public String getMes() {
        return this.fecha.substring(3, 5);
    }

    public String getFecha() {
        return fecha;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public double getTotal() {
        return total;
    }

    public OrderServicio setPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public String getPlaca() {
        return this.placa;
    }

    public OrderServicio setFecha(String fecha) {
        this.fecha = fecha;
        return this;
    }

    public OrderServicio setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
        return this;
    }

    public OrderServicio setTotal(double total) {
        this.total = total;
        return this;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public OrderServicio setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public Servicio getServicio() {
        return servicio;
    }
}
