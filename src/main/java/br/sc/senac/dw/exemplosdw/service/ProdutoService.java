package br.sc.senac.dw.exemplosdw.service;


import br.sc.senac.dw.exemplosdw.exception.CampoInvalidoException;
import br.sc.senac.dw.exemplosdw.model.repository.ProdutoRepository;
import br.sc.senac.dw.exemplosdw.model.vo.ProdutoVO;
import br.sc.senac.dw.exemplosdw.seletor.FabricanteSeletor;
import br.sc.senac.dw.exemplosdw.seletor.ProdutoSeletor;
import br.sc.senac.dw.exemplosdw.specification.ProdutoSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    @Transactional
    public List<ProdutoVO> listarTodos() {
        return produtoRepository.findAll();
    }

    public ProdutoVO consultarPorId(Long id) {
        return produtoRepository.findById(id.longValue()).get();
    }

    public ProdutoVO inserir(ProdutoVO novoProduto) {
        return produtoRepository.save(novoProduto);
    }

    public ProdutoVO atualizar(ProdutoVO produtoAtualizado) {
        return produtoRepository.save(produtoAtualizado);
    }

    public boolean excluir(Integer id) {
        produtoRepository.deleteById(id.longValue());
        return true;
    }

    public List<ProdutoVO> listarComSeletor(ProdutoSeletor seletor) {
        //https://www.baeldung.com/spring-data-jpa-query-by-example
        Specification<ProdutoVO> specification = ProdutoSpecifications.comFiltros(seletor);
        return produtoRepository.findAll(specification);
    }

    private void validarCamposObrigatorios(ProdutoVO produto) throws CampoInvalidoException {
        String mensagemValidacao = "";
        mensagemValidacao += validarCampoString(produto.getNome(), "nome");
        //mensagemValidacao += validarCampoString(produto.getFabricante(), "fabricante");
        mensagemValidacao += validarCampoDouble(produto.getValor(), "valor");
        mensagemValidacao += validarCampoDouble(produto.getPeso(), "peso");

        if(!mensagemValidacao.isEmpty()) {
            throw new CampoInvalidoException(mensagemValidacao);
        }
    }

    private String validarCampoString(String valorCampo, String nomeCampo) {
        if(valorCampo == null || valorCampo.trim().isEmpty()) {
            return "Informe o " + nomeCampo + " \n";
        }
        return "";
    }

    private String validarCampoDouble(Double valorCampo, String nomeCampo) {
        if(valorCampo == null) {
            return "Informe o " + nomeCampo + " \n";
        }
        return "";
    }
}
