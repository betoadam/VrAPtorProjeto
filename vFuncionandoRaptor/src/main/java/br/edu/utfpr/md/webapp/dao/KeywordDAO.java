package br.edu.utfpr.md.webapp.dao;

import br.edu.utfpr.md.model.Keyword;
import com.mongodb.MongoClient;
import javax.inject.Inject;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

public class KeywordDAO extends BasicDAO<Keyword, ObjectId>{
    @Inject
    public KeywordDAO(MongoClient mongoClient) {
        super(Keyword.class, mongoClient, new Morphia(), MongoClientProvider.DATABASE);
    }
    
    public Keyword getById(ObjectId id) {
        return this.getDatastore().find(Keyword.class).field("_id").equal(id).get();
    }
}
