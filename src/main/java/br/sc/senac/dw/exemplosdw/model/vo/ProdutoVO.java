package br.sc.senac.dw.exemplosdw.model.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "produtos")
public class ProdutoVO {

    @Id
    private Integer id;
    private String nome;
    private String fabricante;
    private double valor;
    private double peso;

    private LocalDate data_cadastro;


    public ProdutoVO(String nome, String fabricante, double valor, double peso, LocalDate data_cadastro) {
        this.nome = nome;
        this.fabricante = fabricante;
        this.valor = valor;
        this.peso = peso;
        this.data_cadastro = data_cadastro;
    }

    public ProdutoVO() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public double getValor() {
        return valor;
    }

    public double getPeso() {
        return peso;
    }

    public LocalDate getData_cadastro() {
        return data_cadastro;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setData_cadastro(LocalDate data_cadastro) {
        this.data_cadastro = data_cadastro;
    }
}
