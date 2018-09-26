package br.edu.utfpr.md.webapp.dao;

import br.edu.utfpr.md.model.Document;
import com.mongodb.MongoClient;
import javax.inject.Inject;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

public class DocumentDAO extends BasicDAO<Document, ObjectId> {

    @Inject
    public DocumentDAO(MongoClient mongoClient) {
        super(Document.class, mongoClient, new Morphia(), MongoClientProvider.DATABASE);
    }

    public Document getById(ObjectId id) {
        return this.getDatastore().find(Document.class).field("_id").equal(id).get();
    }
}
