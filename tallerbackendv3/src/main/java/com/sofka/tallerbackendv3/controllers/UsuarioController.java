/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofka.tallerbackendv3.controllers;

import com.sofka.tallerbackendv3.models.UsuarioModel;
import com.sofka.tallerbackendv3.services.UsuarioService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jeaniel Osorno
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }
    
    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return usuarioService.guardarUsuario(usuario);
    }
    
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.obtenerPorId(id);
    }
    
    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }
    
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con el id " + id;
        }else{
            return "No se pudo eliminar al usuario con el id " + id;
        }
    }
    //Dado el nombre ingresado en la dirección usuario/nombre/nombre_a_buscar, trae todos los usuarios
    //registrados con el nombre ingresado.
    @GetMapping(path = "/nombre/{nombre}")
    public ArrayList<UsuarioModel> obtenerUsuarioPorNombre(@PathVariable("nombre") String nombre){
        return this.usuarioService.obtenerPorNombre(nombre);
    }
    
    
}
