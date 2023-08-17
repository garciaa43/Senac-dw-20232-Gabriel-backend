package br.sc.senac.dw.exemplosdw.service;


import br.sc.senac.dw.exemplosdw.model.repository.ProdutoRepository;
import br.sc.senac.dw.exemplosdw.model.vo.ProdutoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
}
