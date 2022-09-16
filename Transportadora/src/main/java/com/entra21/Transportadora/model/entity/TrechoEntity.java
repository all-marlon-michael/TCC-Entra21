package com.entra21.Transportadora.model.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "trecho")
public class TrechoEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrecho;

    @Column(name = "local_inicio")
    private String LocalInicio;

    @Column(name = "local_fim")
    private String localFim;

    @ManyToOne
    @JoinColumn(name = "id_entrega", referencedColumnName = "id")
    private EntregaTrechoEntity entregaTrecho;

}
