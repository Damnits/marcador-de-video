package br.edu.ifpb.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name="tb_video")
public class Video implements Serializable {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    String titulo;
    String link;

    @OneToMany(mappedBy = "video", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Marcacao> marcacaos;

    public Video() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Marcacao> getMarcacaos() {
        return marcacaos;
    }

    public void setMarcacaos(List<Marcacao> marcacaos) {
        this.marcacaos = marcacaos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
