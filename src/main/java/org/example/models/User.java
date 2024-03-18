package org.example.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Clientes")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CodigoCliente;

    @Column(name = "CifDni")
    private String Dni;

    @Column(name = "FechaAlta")
    private  Date FechaAlta;

    @Column(name = "RazonSocial")
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
