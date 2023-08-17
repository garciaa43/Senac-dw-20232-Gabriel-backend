package br.sc.senac.dw.exemplosdw.controller;

import br.sc.senac.dw.exemplosdw.model.vo.ProdutoVO;
import br.sc.senac.dw.exemplosdw.service.ProdutoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/produtos")

public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @GetMapping(path = "/todos")
    public List<ProdutoVO> listarTodosProdutos(){
        return produtoService.listarTodos();
    }

    @GetMapping(path = "/{id}")
    public ProdutoVO consultarPorId(@PathVariable Integer id) {
        return produtoService.consultarPorId(id.longValue());
    }
}

