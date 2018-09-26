package br.edu.utfpr.md.model;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity
public class Document {

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
    private Category category;
    @Reference
    private List<Keyword> keywords;

    public Document() {
    }

    public Document(String description, Date date, Date lastUpdate, String fileName, Usuario usuario, Category category, List<Keyword> keywords) {
        this.description = description;
        this.date = date;
        this.lastUpdate = lastUpdate;
        this.fileName = fileName;
        this.usuario = usuario;
        this.category = category;
        this.keywords = keywords;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

}
