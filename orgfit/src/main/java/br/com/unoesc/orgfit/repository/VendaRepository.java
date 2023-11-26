package br.com.unoesc.orgfit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.unoesc.orgfit.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}
