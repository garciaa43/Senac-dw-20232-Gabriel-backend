package br.sc.senac.dw.exemplosdw.seletor;

import br.sc.senac.dw.exemplosdw.model.vo.ProdutoVO;

import java.util.List;

public class FabricanteSeletor {

    private String nome;
    private String cnpj;

    private List<ProdutoVO> produtos;

    public FabricanteSeletor() {
        super();
    }

    public FabricanteSeletor(String nome, String cnpj, List<ProdutoVO> produtos) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.produtos = produtos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<ProdutoVO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoVO> produtos) {
        this.produtos = produtos;
    }
}
