package br.edu.utfpr.md.webapp.dao;

import br.edu.utfpr.md.model.Category;
import com.mongodb.MongoClient;
import javax.inject.Inject;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

public class CategoryDAO extends BasicDAO<Category, ObjectId>{
    @Inject
    public CategoryDAO(MongoClient mongoClient) {
        super(Category.class, mongoClient, new Morphia(), MongoClientProvider.DATABASE);
    }
    
    public Category getById(ObjectId id) {
        return this.getDatastore().find(Category.class).field("_id").equal(id).get();
    }
}
