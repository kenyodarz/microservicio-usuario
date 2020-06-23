package com.cdm.microserviciousuario.services;

import com.cdm.microserviciousuario.models.Alumno;
import com.cdm.microserviciousuario.repositories.AlumnoRepository;
import com.cdm.microserviciousuario.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl extends GenericServiceImpl<Alumno,Long> implements AlumnoServiceApi {

    @Autowired
    private AlumnoRepository repository;

    @Override
    public CrudRepository<Alumno, Long> getRepository() {
        return repository;
    }
}
