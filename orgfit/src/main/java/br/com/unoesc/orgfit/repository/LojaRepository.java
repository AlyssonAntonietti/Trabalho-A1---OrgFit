package br.com.unoesc.orgfit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unoesc.orgfit.model.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long> {

}
