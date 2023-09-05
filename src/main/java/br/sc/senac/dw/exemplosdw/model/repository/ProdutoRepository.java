package br.sc.senac.dw.exemplosdw.model.repository;

import br.sc.senac.dw.exemplosdw.model.vo.ProdutoVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.ArrayList;

public interface ProdutoRepository extends JpaRepository<ProdutoVO, Long>, JpaSpecificationExecutor<ProdutoVO> {


}
