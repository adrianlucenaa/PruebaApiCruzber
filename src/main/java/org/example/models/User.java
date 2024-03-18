package org.example.models;

import java.util.Date;

public class User {

    private int CodigoCliente;

    private String Dni;

    private  Date FechaAlta;

    private String RazonSocial;

    public User() {
    }

    public User(int codigoCliente, String dni, Date fechaAlta, String razonSocial) {
        CodigoCliente = codigoCliente;
        Dni = dni;
        FechaAlta = fechaAlta;
        RazonSocial = razonSocial;
    }

    public int getCodigoCliente() {
        return CodigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        CodigoCliente = codigoCliente;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public Date getFechaAlta() {
        return FechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        FechaAlta = fechaAlta;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        RazonSocial = razonSocial;
    }
}
