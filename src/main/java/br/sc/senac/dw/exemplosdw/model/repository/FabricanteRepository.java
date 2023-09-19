package br.sc.senac.dw.exemplosdw.model.repository;

import br.sc.senac.dw.exemplosdw.model.vo.FabricanteVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository extends JpaRepository<FabricanteVO, Long>, JpaSpecificationExecutor<FabricanteVO> {
}
