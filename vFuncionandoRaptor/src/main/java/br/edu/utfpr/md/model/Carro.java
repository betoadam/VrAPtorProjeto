package br.edu.utfpr.md.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

public class Carro {

    @Id
    private ObjectId id;
    @NotNull
    @Size(min=2)
    private String marca;
    @NotNull
    private String modelo;

    public Carro() {
    }

    
    public Carro(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}
