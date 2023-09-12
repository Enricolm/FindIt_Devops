package org.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_FINDIT_PASSEIO")
public class Passeio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_PASSEIO;

    private String TP_PASSEIO;

    private String DS_PASSEIO;

    @ManyToOne
    @JoinColumn(name = "id_destino")
    private Destino destino;
    
}
