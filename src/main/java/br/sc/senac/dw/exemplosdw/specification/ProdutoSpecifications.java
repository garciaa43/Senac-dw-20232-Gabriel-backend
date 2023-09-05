package br.sc.senac.dw.exemplosdw.specification;

import br.sc.senac.dw.exemplosdw.model.vo.ProdutoVO;
import br.sc.senac.dw.exemplosdw.seletor.FabricanteSeletor;
import br.sc.senac.dw.exemplosdw.seletor.ProdutoSeletor;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ProdutoSpecifications {
    /*
     *
     * root: é uma referência à entidade raiz que você está consultando.
     * No contexto do JPA, isso representa a tabela do banco de dados correspondente
     * à entidade Produto.
     *
     * query: O parâmetro query representa a consulta JPA que está sendo construída.
     * Ele é usado para adicionar cláusulas WHERE, JOIN, ORDER BY, entre outras, à consulta.
     *
     * cb (CriteriaBuilder): é uma interface que oferece métodos para construção de cláusulas de consulta de forma programática. Você usa métodos deste objeto para criar expressões de predicado, funções agregadas e outras partes da consulta.
     *
     * */
    public static Specification<ProdutoVO> comFiltros(ProdutoSeletor seletor) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (seletor.getNome() != null) {
                predicates.add(cb.like(cb.lower(root.get("nome")), "%"
                        + seletor.getNome().toLowerCase() + "%"));
            }

            if (seletor.getFabricante() != null) {
                predicates.add(cb.like(cb.lower(root.get("fabricante")), "%"
                        + seletor.getFabricante().toLowerCase() + "%"));
            }

            if(seletor.getCnpj() != null) {
                predicates.add(cb.equal(root.join("fabricante").get("cnpj"), seletor.getCnpj()));
            }


            if(seletor.getPesoMinimo() != null && seletor.getPesoMaximo() != null) {
                //WHERE peso BETWEEN min AND max
                predicates.add(cb.between(root.get("peso"), seletor.getPesoMinimo(),
                        seletor.getPesoMaximo()));
            } else if(seletor.getPesoMinimo() != null) {
                //WHERE peso >= min
                predicates.add(cb.greaterThanOrEqualTo(root.get("peso"), seletor.getPesoMinimo()));
            } else if(seletor.getPesoMaximo() != null) {
                //WHERE peso <= max
                predicates.add(cb.lessThanOrEqualTo(root.get("peso"), seletor.getPesoMaximo()));
            }

            if(seletor.getValorMinimo() != null && seletor.getValorMaximo() != null) {
                predicates.add(cb.between(root.get("valor"), seletor.getValorMinimo(),seletor.getValorMaximo()));
            } else if(seletor.getValorMinimo() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("valor"), seletor.getValorMinimo()));
            } else if (seletor.getValorMaximo() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("valor"), seletor.getValorMaximo()));
            }


            // TODO Adicionar outros filtros aqui
//            private Double valorMinimo;
//            private Double valorMaximo;
//            private LocalDate dataCadastroInicial;
//            private LocalDate dataCadastroFinal;

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
