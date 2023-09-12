package org.example.models;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_FINDIT_VIAGEM")
public class Viagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private int ID_VIAGEM;

    private String DS_VIAGEM;

    private LocalDate DT_PARTIDA;

    private LocalDate DT_FIM;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_destino")
    private Destino destino;

}
