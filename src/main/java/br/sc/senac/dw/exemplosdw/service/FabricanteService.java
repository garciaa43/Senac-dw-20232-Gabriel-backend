package br.sc.senac.dw.exemplosdw.service;

import br.sc.senac.dw.exemplosdw.model.repository.FabricanteRepository;
import br.sc.senac.dw.exemplosdw.model.vo.FabricanteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FabricanteService {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    public FabricanteVO salvar(FabricanteVO novoFabricante) {
        return fabricanteRepository.save(novoFabricante);
    }

    public List<FabricanteVO> listarTodos() {
        return fabricanteRepository.findAll();
    }
}
