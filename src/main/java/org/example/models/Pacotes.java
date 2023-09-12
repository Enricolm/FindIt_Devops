package org.example.models;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_FINDIT_PACOTES")
public class Pacotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_PACOTES; 

    private String NM_PACOTE;

    private String TP_PACOTE;

    private String DS_PACOTE;


    @ManyToOne
    @JoinColumn(name = "id_destino")
    private Destino destino;

    @ManyToOne
    @JoinColumn(name = "id_agencia")
    private Agencia agencia;

}
