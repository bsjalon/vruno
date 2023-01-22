/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprimerparcial.MenusAdministrador;

/**
 *
 * @author Sebasceb
 */
public class Cliente extends Proveedor{
    public TipoCliente tipo;

    public Cliente(String c, String n, String d, String t){
      super(c,n,d,t);
      
    }
    
    public Cliente(String c, String n, String d, String t,TipoCliente tipo){
      super(c,n,d,t);
      this.tipo=tipo;
      
    }
    public String getNombre(){
      return nombre;
    }
}
