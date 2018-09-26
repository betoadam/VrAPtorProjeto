package br.edu.utfpr.md.webapp.dao;

import br.edu.utfpr.md.model.Carro;
import com.mongodb.MongoClient;
import javax.inject.Inject;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

public class CarroDAO extends BasicDAO<Carro, ObjectId> {

    @Inject
    public CarroDAO(MongoClient mongoClient) {
        super(Carro.class, mongoClient, new Morphia(), MongoClientProvider.DATABASE);
    }
}
