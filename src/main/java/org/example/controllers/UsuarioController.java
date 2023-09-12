package org.example.controllers;

import jakarta.persistence.EntityManager;
import org.example.models.Usuario;

public class UsuarioController {

    private EntityManager entityManager;

    public UsuarioController(EntityManager entityManager) { this.entityManager = entityManager; }

    public Usuario findUsuarioById(int id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        if(usuario == null){
            return null;
        }
        return usuario;
    }

    public void insertUsuario(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void updateUsuario(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void deleteUsuarioById(int id) {
        try{
            entityManager.getTransaction().begin();
            Usuario usuario = entityManager.find(Usuario.class, id);
            if(usuario != null) {
                entityManager.remove(usuario);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
