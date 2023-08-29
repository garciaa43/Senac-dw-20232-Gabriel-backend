package br.sc.senac.dw.exemplosdw.model.vo;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "fabricantes")
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @JsonBackReference
    @OneToMany(mappedBy = "fabricante")
    private List<ProdutoVO> produtos;

    public Fabricante() {
        super();
    }

    public Fabricante(Integer id, String nome, List<ProdutoVO> produtos) {
        super();
        this.id = id;
        this.nome = nome;
        this.produtos = produtos;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public List<ProdutoVO> getProdutos() {
        return produtos;
    }


    public void setProdutos(List<ProdutoVO> produtos) {
        this.produtos = produtos;
    }

}




