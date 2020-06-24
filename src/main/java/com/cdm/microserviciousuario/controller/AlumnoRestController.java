package com.cdm.microserviciousuario.controller;

import com.cdm.microserviciousuario.models.Alumno;
import com.cdm.microserviciousuario.services.AlumnoServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class AlumnoRestController {

    @Autowired
    AlumnoServiceApi serviceApi;

    @GetMapping
    public List<Alumno> getAll(){
        return serviceApi.getAll();
    }

    @GetMapping("/{id}")
    public Alumno find(@PathVariable Long id){
        return serviceApi.get(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Alumno> save (@RequestBody Alumno alumno){
        Alumno obj = serviceApi.save(alumno);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity <Alumno> delete (@PathVariable Long id){
        Alumno alumno = serviceApi.get(id);
        if (alumno != null){
            serviceApi.delete(id);
        }else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(alumno, HttpStatus.OK);
    }
    @GetMapping("/filtrar/{term}")
    public ResponseEntity<?> filtrar(@PathVariable String term){
        return ResponseEntity.ok(serviceApi.findByNombreOrApellido(term));
    }
    @PostMapping("/save-with-photo")
    public ResponseEntity<Alumno> crearConFoto (Alumno alumno, @RequestParam MultipartFile archivo) throws IOException {
        if (!archivo.isEmpty()){
            alumno.setFoto(archivo.getBytes());
        }
        Alumno obj = serviceApi.save(alumno);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
