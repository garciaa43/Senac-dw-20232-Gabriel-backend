package br.sc.senac.dw.exemplosdw.controller;


import br.sc.senac.dw.exemplosdw.model.vo.FabricanteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.sc.senac.dw.exemplosdw.service.FabricanteService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/fabricantes")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)

public class FabricanteController {

    @Autowired
    private FabricanteService fabricanteService;

    @PostMapping
    public FabricanteVO salvar(@RequestBody FabricanteVO novoFabricante) {
        return fabricanteService.salvar(novoFabricante);
    }

    @GetMapping(path = "/todos")
    public List<FabricanteVO> listarTodosFabricantes() {
        return fabricanteService.listarTodos();
    }

}
