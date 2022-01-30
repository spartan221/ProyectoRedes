package com.sistemaPreventivo.ProyectoRedes.repository;

import com.sistemaPreventivo.ProyectoRedes.models.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    public Usuario getUserByUsername(@Param("email") String email);


}
