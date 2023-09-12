package org.example.models;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_FINDIT_DESTINO")
public class Destino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_DESTINO; 

    private String NM_DESTINO;

    private String DS_PONTOS_TURISTICOS;

    private String SG_PAIS;

    @OneToMany(mappedBy = "destino")
    private List<Viagem> viagens;

    @OneToMany(mappedBy = "destino")
    private List<Pacotes> pacotes;

    @OneToMany(mappedBy = "destino")
    private List<Caracteristicas> caracteristicas;

    @OneToMany(mappedBy = "destino")
    private List<Passeio> passeios;
}
