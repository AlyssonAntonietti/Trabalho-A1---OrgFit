package br.com.unoesc.orgfit.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.unoesc.orgfit.model.Mercadoria;

@Repository
public interface MercadoriaRepository extends JpaRepository<Mercadoria, Long>{
	
	@Query(value = "select u from Mercadoria u where upper(trim(u.descricao)) like %?1%")
		List<Mercadoria> buscarPorNome(String descricao);
}
