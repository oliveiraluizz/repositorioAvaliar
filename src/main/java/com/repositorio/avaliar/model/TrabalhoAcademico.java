package com.repositorio.avaliar.model;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "trabalhos")
public class TrabalhoAcademico {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

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

    // Construtor sem argumentos
    public TrabalhoAcademico() {}

    // Construtor com todos os argumentos
    public TrabalhoAcademico(UUID id, String titulo, String tipoProducao, Integer ano, String autor,
                             String orientador, String palavrasChave, String universidade, String link) {
        this.id = id;
        this.titulo = titulo;
        this.tipoProducao = tipoProducao;
        this.ano = ano;
        this.autor = autor;
        this.orientador = orientador;
        this.palavrasChave = palavrasChave;
        this.universidade = universidade;
        this.link = link;
    }

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipoProducao() {
        return tipoProducao;
    }

    public void setTipoProducao(String tipoProducao) {
        this.tipoProducao = tipoProducao;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    public String getPalavrasChave() {
        return palavrasChave;
    }

    public void setPalavrasChave(String palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public String getUniversidade() {
        return universidade;
    }

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    // Sobrescrevendo equals e hashCode para comparação
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrabalhoAcademico that = (TrabalhoAcademico) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Sobrescrevendo toString para exibir informações do objeto
    @Override
    public String toString() {
        return "TrabalhoAcademico{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", tipoProducao='" + tipoProducao + '\'' +
                ", ano=" + ano +
                ", autor='" + autor + '\'' +
                ", orientador='" + orientador + '\'' +
                ", palavrasChave='" + palavrasChave + '\'' +
                ", universidade='" + universidade + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
