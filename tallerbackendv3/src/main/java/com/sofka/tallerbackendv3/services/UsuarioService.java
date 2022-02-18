/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofka.tallerbackendv3.services;

import com.sofka.tallerbackendv3.models.UsuarioModel;
import com.sofka.tallerbackendv3.repositories.UsuarioRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jeaniel Osorno
 */
@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }
    
    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }
    
    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }
    
    public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad){
        return usuarioRepository.findByPrioridad(prioridad);
    }
    
    public boolean eliminarUsuario(Long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception ex){
            return false;
        }
    }
    
    public ArrayList<UsuarioModel> obtenerPorNombre(String nombre){
        return usuarioRepository.findByNombre(nombre);
    }
}
