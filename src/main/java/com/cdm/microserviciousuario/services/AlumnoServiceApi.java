package com.cdm.microserviciousuario.services;

import com.cdm.microserviciousuario.models.Alumno;
import com.cdm.microserviciousuario.utils.GenericServiceAPI;

import java.util.List;

public interface AlumnoServiceApi extends GenericServiceAPI<Alumno,Long> {
    List<Alumno> findByNombreOrApellido(String term);
}
