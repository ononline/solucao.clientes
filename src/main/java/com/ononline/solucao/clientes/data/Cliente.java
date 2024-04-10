package com.ononline.solucao.clientes.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.Objects;

@Entity
public class Cliente {
    
    @Id
    @GeneratedValue
    private long id;
    
    private String razaoSocial;
    
    private String nomeFantasia;
    
    @Column(unique = true)
    private String cpfCnpj;
    
    private ArrayList<String> telefonesContato;
    
    private boolean status;
    
    public Cliente() {
    }
    
    public Cliente(long id, String razaoSocial, String nomeFantasia, String cpfCnpj, ArrayList<String> telefonesContato, boolean status) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cpfCnpj = cpfCnpj;
        this.telefonesContato = telefonesContato;
        this.status = status;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getRazaoSocial() {
        return razaoSocial;
    }
    
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
    public String getNomeFantasia() {
        return nomeFantasia;
    }
    
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    
    public String getCpfCnpj() {
        return cpfCnpj;
    }
    
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
    
    public ArrayList<String> getTelefonesContato() {
        return telefonesContato;
    }
    
    public void setTelefonesContato(ArrayList<String> telefonesContato) {
        this.telefonesContato = telefonesContato;
    }
    
    public boolean isStatus() {
        return status;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(getCpfCnpj(), cliente.getCpfCnpj());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getCpfCnpj());
    }
}
