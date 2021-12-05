package br.edu.ifpb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "tb_marcacao")
public class Marcacao implements Serializable {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    String nome;
    String tempo_inicio;
    String tempo_fim;
    @ManyToOne
    @JoinColumn(name = "video_id", nullable = false)
    @JsonIgnore
    private Video video;

    public Video getVideo() {
        return video;
    }
    public void setVideo(Video video){
        this.video = video;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTempo_inicio() {
        return tempo_inicio;
    }

    public void setTempo_inicio(String tempo_inicio) {
        this.tempo_inicio = tempo_inicio;
    }

    public String getTempo_fim() {
        return tempo_fim;
    }

    public void setTempo_fim(String tempo_fim) {
        this.tempo_fim = tempo_fim;
    }
}
