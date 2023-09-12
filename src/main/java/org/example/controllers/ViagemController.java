package org.example.controllers;

import jakarta.persistence.EntityManager;
import org.example.models.Viagem;

public class ViagemController {

    private EntityManager entityManager;

    public ViagemController(EntityManager entityManager) { this.entityManager = entityManager; }

    public Viagem findViagemById(int id) {
        Viagem viagem = entityManager.find(Viagem.class, id);
        if(viagem == null){
            return null;
        }
        return viagem;
    }

    public void insertViagem(Viagem viagem) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(viagem);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void updateViagem(Viagem viagem) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(viagem);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void deleteViagemById(int id) {
        try{
            entityManager.getTransaction().begin();
            Viagem viagem = entityManager.find(Viagem.class, id);
            if(viagem != null) {
                entityManager.remove(viagem);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
