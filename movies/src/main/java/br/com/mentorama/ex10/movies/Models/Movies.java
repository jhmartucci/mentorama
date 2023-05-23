package br.com.mentorama.ex10.movies.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Movies {

    @Id
    private String idAssessment;
    private String usuarioId;
    private String filmeNome;
    private Note note;

    public Movies() {
    }

    public Movies(String idAssessment, String usuarioId, String filmeNome, Note note) {
        this.idAssessment = idAssessment;
        this.usuarioId = usuarioId;
        this.filmeNome = filmeNome;
        this.note = note;
    }

    public String getIdAssessment() {
        return idAssessment;
    }

    public void setIdAssessment(String idAssessment) {
        this.idAssessment = idAssessment;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getFilmeNome() {
        return filmeNome;
    }

    public void setFilmeNome(String filmeNome) {
        this.filmeNome = filmeNome;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }
}
