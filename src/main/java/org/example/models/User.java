package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Clientes")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "CodigoCliente")
    private int CodigoCliente;

    @Column(name = "CifDni")
    private String Dni;

    @Column(name = "FechaAlta")
    private  Date FechaAlta;

    @Column(name = "RazonSocial")
    private String RazonSocial;

    public User() {
    }


    public User(int CodigoCliente, String dni, Date fechaAlta, String razonSocial) {
        CodigoCliente = CodigoCliente;
        Dni = dni;
        FechaAlta = fechaAlta;
        RazonSocial = razonSocial;
    }

    public int getCodigoCliente() {
        return CodigoCliente;
    }

    public void setCodigoCliente(int CodigoCliente) {
        CodigoCliente = CodigoCliente;
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

    @Override
    public String toString() {
        return "User{" +
                "CodigoCliente=" + CodigoCliente +
                ", Dni='" + Dni + '\'' +
                ", FechaAlta=" + FechaAlta +
                ", RazonSocial='" + RazonSocial + '\'' +
                '}';
    }
}
