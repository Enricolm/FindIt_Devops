package org.example.models;

import jakarta.persistence.*;
import lombok.*;



import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_FINDIT_USUARIO")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_USUARIO; 

    private String NM_USUARIO;

    private String NM_EMAIL;

    private String NM_SENHA;

    @OneToMany(mappedBy = "usuario")
    private List<Preferencias> preferencias;

    @OneToMany(mappedBy = "usuario")
    private List<Viagem> viagens;

}
