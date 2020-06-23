package com.cdm.microserviciousuario.repositories;

import com.cdm.microserviciousuario.models.Alumno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
}
