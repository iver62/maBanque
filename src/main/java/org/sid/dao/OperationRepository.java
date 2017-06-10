package org.sid.dao;

import org.sid.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OperationRepository extends JpaRepository<Operation, Long> {
	
	@Query("SELECT o FROM Operation o WHERE o.compte.idCompte = :x ORDER BY o.dateOperation DESC")
	public Page<Operation> listOperations(@Param("x")String idCompte, Pageable pageable);

}
