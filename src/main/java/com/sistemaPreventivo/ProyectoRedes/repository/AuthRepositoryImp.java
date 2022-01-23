package com.sistemaPreventivo.ProyectoRedes.repository;

import com.sistemaPreventivo.ProyectoRedes.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class AuthRepositoryImp implements AuthRepository{

    @PersistenceContext
    EntityManager entityManager;


    public Usuario getUserFromBD(String email) {
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", email)
                .getResultList();

        return !lista.isEmpty() ? lista.get(0) : null;
    }

}
