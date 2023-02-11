package br.com.alura.persistence01.javajpa1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titular;
    private Integer agencia;
    private Integer numero;
    private Double saldo;
    
    
    public Conta() {}
    
    public Conta(Long id, String titular, Integer agencia, Integer numero,
            Double saldo) {
        this.id = id;
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
    }
    // métodos get e set foram omitidos
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public Integer getAgencia() {
        return agencia;
    }
    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    
    
    
}
