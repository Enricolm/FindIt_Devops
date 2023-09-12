package org.example.controllers;

import jakarta.persistence.EntityManager;
import org.example.models.Destino;

public class DestinoController {

    private EntityManager entityManager;

    public DestinoController(EntityManager entityManager) { this.entityManager = entityManager; }

    public Destino findDestinoById(int id) {
        Destino destino = entityManager.find(Destino.class, id);
        if(destino == null){
            return null;
        }
        return destino;
    }

    public void insertDestino(Destino destino) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(destino);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void updateDestino(Destino destino) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(destino);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void deleteDestinoById(int id) {
        try{
            entityManager.getTransaction().begin();
            Destino destino = entityManager.find(Destino.class, id);
            if(destino != null) {
                entityManager.remove(destino);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
