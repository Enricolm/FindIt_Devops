package org.example.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_FINDIT_AGENCIA")
public class Agencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_AGENCIA; 

    private String NM_AGENCIA;

    private String SG_AGENCIA;

    @OneToMany(mappedBy = "agencia")
    private List<Pacotes> pacotes;
}
