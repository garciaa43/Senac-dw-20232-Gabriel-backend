package br.sc.senac.dw.exemplosdw.model.vo;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "produtos")
public class ProdutoVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "id_fabricante")
    private FabricanteVO fabricanteVO;
    private double valor;
    private double peso;

    @Column(name = "data_cadastro")
    private LocalDate data_cadastro;


    public ProdutoVO(String nome, FabricanteVO fabricanteVO, double valor, double peso, LocalDate data_cadastro) {
        this.nome = nome;
        this.fabricanteVO = fabricanteVO;
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

    public FabricanteVO getFabricante() {
        return fabricanteVO;
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

    public void setFabricante(FabricanteVO fabricanteVO) {
        this.fabricanteVO = fabricanteVO;
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
