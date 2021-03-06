/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofka.tallerbackendv3.repositories;

import com.sofka.tallerbackendv3.models.UsuarioModel;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jeaniel Osorno
 */
@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long>{    
    public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
    //Para traer los usuarios con X nombre.
    public abstract ArrayList<UsuarioModel> findByNombre(String nombre);

}
