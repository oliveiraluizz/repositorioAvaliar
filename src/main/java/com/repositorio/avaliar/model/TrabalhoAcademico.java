package com.repositorio.avaliar.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "trabalhos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TrabalhoAcademico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String titulo;

    @Column(length = 255, nullable = false)
    private String tipoProducao;

    @Column(nullable = false)
    private Integer ano;

    @Column(length = 255, nullable = false)
    private String autor;

    @Column(length = 255, nullable = false)
    private String orientador;

    @Column(length = 255, nullable = false)
    private String palavrasChave;

    @Column(length = 255, nullable = false)
    private String universidade;

    @Column(length = 255, nullable = false)
    private String link;
}
