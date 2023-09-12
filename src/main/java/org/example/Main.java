package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.controllers.DestinoController;
import org.example.controllers.PreferenciaController;
import org.example.controllers.UsuarioController;
import org.example.controllers.ViagemController;
import org.example.models.Destino;
import org.example.models.Preferencias;
import org.example.models.Usuario;
import org.example.models.Viagem;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
            EntityManager entityManager = entityManagerFactory.createEntityManager();


            var testUsuario = new UsuarioController(entityManager);
            var testViagem = new ViagemController(entityManager);
            var testDestino = new DestinoController(entityManager);
            var testPreferencia = new PreferenciaController(entityManager);

            testUsuario.findUsuarioById(1);
            testViagem.findViagemById(1);
            testPreferencia.findPreferenciaById(1);
            testDestino.findDestinoById(1);

            Usuario usuario = new Usuario();
            usuario.setNM_USUARIO("sukuna");
            usuario.setNM_EMAIL("sukuna@gmail.com");
            usuario.setNM_SENHA("123");
            testUsuario.insertUsuario(usuario);

            Preferencias preferencia = new Preferencias();
            preferencia.setNM_PREFERENCIA("teste");
            preferencia.setDS_PREFERENCIA("teste");
            preferencia.setTP_PREFERENCIA("teste");
            testPreferencia.insertPreferencias(preferencia);

            Viagem viagem = new Viagem();
            viagem.setDS_VIAGEM("teste");
            viagem.setDT_PARTIDA(LocalDate.now());
            viagem.setDT_FIM(LocalDate.now());
            testViagem.insertViagem(viagem);

            Destino destino = new Destino();
            destino.setNM_DESTINO("Maldivas");
            destino.setDS_PONTOS_TURISTICOS("teste");
            destino.setSG_PAIS("teste");
            testDestino.insertDestino(destino);

            testUsuario.deleteUsuarioById(1);
            testPreferencia.deletePreferenciasById(1);
            testViagem.deleteViagemById(1);
            testDestino.deleteDestinoById(1);


            entityManager.close();
            entityManagerFactory.close();
        } catch (Exception e) {
            throw e;
        }
    }
}