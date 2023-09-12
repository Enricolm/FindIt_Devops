package org.example.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_FINDIT_PREFERECIAS")
public class Preferencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_PREFERENCIA;

    private String NM_PREFERENCIA;

    private String TP_PREFERENCIA;

    private String DS_PREFERENCIA;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
