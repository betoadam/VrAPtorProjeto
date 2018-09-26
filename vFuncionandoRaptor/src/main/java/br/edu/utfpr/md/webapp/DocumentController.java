package br.edu.utfpr.md.webapp;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.md.converter.ObjectIdVRaptorConverter;
import br.edu.utfpr.md.model.Category;
import br.edu.utfpr.md.model.Document;
import br.edu.utfpr.md.model.Keyword;
import br.edu.utfpr.md.webapp.auth.LoggedUser;
import br.edu.utfpr.md.webapp.dao.CategoryDAO;
import br.edu.utfpr.md.webapp.dao.DocumentDAO;
import br.edu.utfpr.md.webapp.dao.KeywordDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.bson.types.ObjectId;

@Controller
@Path("/document")
public class DocumentController {

    @Inject
    private Result result;
    @Inject
    private Validator validator;
    @Inject
    private DocumentDAO documentDAO;
    @Inject
    private KeywordDAO keywordDAO;
    @Inject
    private CategoryDAO categoryDAO;
    @Inject
    private LoggedUser loggedUser;
    ObjectIdVRaptorConverter conversor;

    @Path("/new")
    @Get
    public void form() {
        result.include("categorias", categoryDAO.find().asList());
        result.include("keywords", keywordDAO.find().asList());
    }

    @Path(value = {"", "/"})
    @Get
    public List<Document> list() {
        return documentDAO.find().asList();
    }

    @Post
    public void save(String description, String fileName, String date, String lastUpdate, ObjectId selectedCategoryId, ObjectId[] keywords) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        List<Keyword> keywordList = new ArrayList<>();
        Category categoriaSelecionada = this.categoryDAO.getById(selectedCategoryId);
        
        for (ObjectId keyword : keywords) {
            Keyword key = this.keywordDAO.getById(keyword);
            if (key != null) {
                keywordList.add(key);
            }
        }
        Document document = new Document(description, sdf.parse(date), sdf.parse(lastUpdate), fileName, loggedUser.getUsuario(), categoriaSelecionada, keywordList);

        validator.onErrorForwardTo(this).form();
        try {
            this.documentDAO.save(document);
        } catch (Exception e) {
            e.printStackTrace();
            validator.add(new SimpleMessage("dao", "Falha ao Inserir Documento!"));
        }
        result.redirectTo(this).list();
    }
    
    @Path("/update/{id}")
    public void update(ObjectId id){
        Document doc = this.documentDAO.getById(id);
        result.include("documento", doc);
        result.forwardTo(this).form();
    }
    
    public void atualiza(ObjectId id, String description, String fileName, String date, String lastUpdate, ObjectId selectedCategoryId, ObjectId[] keywords) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        List<Keyword> keywordList = new ArrayList<>();
        Category categoriaSelecionada = this.categoryDAO.getById(selectedCategoryId);
        
        for (ObjectId keyword : keywords) {
            Keyword key = this.keywordDAO.getById(keyword);
            if (key != null) {
                keywordList.add(key);
            }
        }
        Document document = new Document(description, sdf.parse(date), sdf.parse(lastUpdate), fileName, loggedUser.getUsuario(), categoriaSelecionada, keywordList);
        document.setId(id);
        
        validator.onErrorForwardTo(this).form();
        try {
            this.documentDAO.save(document);
        } catch (Exception e) {
            e.printStackTrace();
            validator.add(new SimpleMessage("dao", "Falha ao Inserir documento!"));
        }
        result.redirectTo(this).list();
    }
    
    @Path("/delete/{id}")
    public void delete(ObjectId id){
        Document doc = this.documentDAO.getById(id);
        this.documentDAO.delete(doc);
        result.forwardTo(this).list();
    }
}
