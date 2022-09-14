package com.entra21.Transportadora.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "entrega")
public class EntregaEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntrega;


    @ManyToOne
    @JoinColumn(name="id_entregador", referencedColumnName = "id")
    private FuncionarioEntity idEntregador;

    @Column(name = "tipo_entrega")
    private String tipoEntrega;
//
    @OneToMany
//    @JoinColumn(name = "id_entrega", referencedColumnName = "id")
    private List<EntregaTrechoEntity> entregaTrecho;


    //lista entrega_trecho


}