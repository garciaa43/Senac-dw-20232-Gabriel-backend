package br.sc.senac.dw.exemplosdw.model.vo;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "fabricantes")
public class FabricanteVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cnpj;

    private String cep;

    private String cidade;

    private String uf;

    @JsonBackReference
    @OneToMany(mappedBy = "fabricanteVO")
    private List<ProdutoVO> produtos;

    public FabricanteVO() {
        super();
    }



    public FabricanteVO(Integer id, String nome, List<ProdutoVO> produtos, String cnpj, String cep, String cidade, String uf) {
        super();
        this.id = id;
        this.nome = nome;
        this.produtos = produtos;
        this.cnpj = cnpj;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
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


    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}




