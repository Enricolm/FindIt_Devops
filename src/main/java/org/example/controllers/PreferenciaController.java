package org.example.controllers;

import jakarta.persistence.EntityManager;
import org.example.models.Preferencias;

public class PreferenciaController {

    private EntityManager entityManager;

    public PreferenciaController(EntityManager entityManager) { this.entityManager = entityManager; }

    public Preferencias findPreferenciaById(int id) {
        Preferencias preferencias = entityManager.find(Preferencias.class, id);
        if(preferencias == null){
            return null;
        }
        return preferencias;
    }

    public void insertPreferencias(Preferencias preferencias) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(preferencias);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void updatePreferencias(Preferencias preferencias) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(preferencias);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void deletePreferenciasById(int id) {
        try{
            entityManager.getTransaction().begin();
            Preferencias preferencias = entityManager.find(Preferencias.class, id);
            if(preferencias != null) {
                entityManager.remove(preferencias);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
