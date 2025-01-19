package com.repositorio.avaliar.repository;

import com.repositorio.avaliar.model.TrabalhoAcademico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface TrabalhoAcademicoRepository extends JpaRepository<TrabalhoAcademico, UUID> {
}
