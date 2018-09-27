package br.edu.utfpr.md.model;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity
public class Documento {

    @Id
    private ObjectId id;
    @NotNull
    private String description;
    private Date date;
    private Date lastUpdate;
    private String fileName;
    @Reference
    private Usuario usuario;
    @Reference
    private Categoria categoria;
    @Reference
    private List<Tag> tags;

    public Documento() {
    }

    public Documento(String description, Date date, Date lastUpdate, String fileName, Usuario usuario, Categoria categoria, List<Tag> tags) {
        this.description = description;
        this.date = date;
        this.lastUpdate = lastUpdate;
        this.fileName = fileName;
        this.usuario = usuario;
        this.categoria = categoria;
        this.tags = tags;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

}
