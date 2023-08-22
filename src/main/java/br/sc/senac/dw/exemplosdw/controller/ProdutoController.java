package br.sc.senac.dw.exemplosdw.controller;

import br.sc.senac.dw.exemplosdw.exception.CampoInvalidoException;
import br.sc.senac.dw.exemplosdw.model.vo.ProdutoVO;
import br.sc.senac.dw.exemplosdw.service.ProdutoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ProdutoVO salvar(@RequestBody ProdutoVO novoProduto) throws CampoInvalidoException {

        return produtoService.inserir(novoProduto);
    }

    @PutMapping()
    public boolean atualizar(@RequestBody ProdutoVO produtoAtualizado) throws CampoInvalidoException{

        return produtoService.atualizar(produtoAtualizado) != null;
    }

    @DeleteMapping("/{id}")
    public boolean excluir(@PathVariable Integer id) {
        return produtoService.excluir(id);
    }
}

