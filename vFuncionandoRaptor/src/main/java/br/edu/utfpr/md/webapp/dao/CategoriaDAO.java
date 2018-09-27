package br.edu.utfpr.md.webapp.dao;

import br.edu.utfpr.md.model.Categoria;
import com.mongodb.MongoClient;
import javax.inject.Inject;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

public class CategoriaDAO extends BasicDAO<Categoria, ObjectId>{
    @Inject
    public CategoriaDAO(MongoClient mongoClient) {
        super(Categoria.class, mongoClient, new Morphia(), MongoClientProvider.DATABASE);
    }
    
    public Categoria getById(ObjectId id) {
        return this.getDatastore().find(Categoria.class).field("_id").equal(id).get();
    }
}
