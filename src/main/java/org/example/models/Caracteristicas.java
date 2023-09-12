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
@Table(name = "T_FINDIT_CARACTERISTICAS")
public class Caracteristicas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_CARACTERISTICA;

    private String NM_CARACTERISTICA;

    private String TP_CARACTERISTICA;

    @ManyToOne
    @JoinColumn(name = "id_destino")
    private Destino destino;
}
