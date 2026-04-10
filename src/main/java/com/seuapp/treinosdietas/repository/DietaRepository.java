package com.seuapp.treinosdietas.repository;

import com.seuapp.treinosdietas.model.Dieta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DietaRepository extends JpaRepository<Dieta, Long> {
    List<Dieta> findByAlunoId(Long alunoId);
}