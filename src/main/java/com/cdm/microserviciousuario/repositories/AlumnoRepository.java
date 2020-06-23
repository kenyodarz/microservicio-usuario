package com.cdm.microserviciousuario.repositories;

import com.cdm.microserviciousuario.models.Alumno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

    @Query(
        "select a from Alumno a where a.nombre like %?1% or a.apellido like %?1%"
    )
    List<Alumno> findByNombreOrApellido(String term);

}
