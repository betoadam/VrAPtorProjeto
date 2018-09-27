package br.edu.utfpr.md.webapp;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.md.converter.ObjectIdVRaptorConverter;
import br.edu.utfpr.md.model.Categoria;
import br.edu.utfpr.md.model.Documento;
import br.edu.utfpr.md.model.Tag;
import br.edu.utfpr.md.webapp.auth.LoggedUser;
import br.edu.utfpr.md.webapp.dao.CategoriaDAO;
import br.edu.utfpr.md.webapp.dao.DocumentoDAO;
import br.edu.utfpr.md.webapp.dao.TagDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.bson.types.ObjectId;

@Controller
@Path("/documento")
public class DocumentoController {

    @Inject
    private Result result;
    @Inject
    private Validator validator;
    @Inject
    private DocumentoDAO documentoDAO;
    @Inject
    private TagDAO tagDAO;
    @Inject
    private CategoriaDAO categoriaDAO;
    @Inject
    private LoggedUser loggedUser;
    ObjectIdVRaptorConverter conversor;

    @Path("/new")
    @Get
    public void form() {
        result.include("categorias", categoriaDAO.find().asList());
        result.include("tags", tagDAO.find().asList());
    }

    @Path(value = {"", "/"})
    @Get
    public List<Documento> list() {
        return documentoDAO.find().asList();
    }

    @Post
    public void save(String description, String fileName, String date, String lastUpdate, ObjectId selectedCategoriaId, ObjectId[] tags) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        List<Tag> tagList = new ArrayList<>();
        Categoria categoriaSelecionada = this.categoriaDAO.getById(selectedCategoriaId);
        
        for (ObjectId tag : tags) {
            Tag key = this.tagDAO.getById(tag);
            if (key != null) {
                tagList.add(key);
            }
        }
        Documento documento = new Documento(description, sdf.parse(date), sdf.parse(lastUpdate), fileName, loggedUser.getUsuario(), categoriaSelecionada, tagList);

        validator.onErrorForwardTo(this).form();
        try {
            this.documentoDAO.save(documento);
        } catch (Exception e) {
            e.printStackTrace();
            validator.add(new SimpleMessage("dao", "Falha ao Inserir Documento!"));
        }
        result.redirectTo(this).list();
    }
    
    @Path("/update/{id}")
    public void update(ObjectId id){
        Documento doc = this.documentoDAO.getById(id);
        result.include("documento", doc);
        result.forwardTo(this).form();
    }
    
    public void atualiza(ObjectId id, String description, String fileName, String date, String lastUpdate, ObjectId selectedCategoriaId, ObjectId[] tags) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        List<Tag> tagList = new ArrayList<>();
        Categoria categoriaSelecionada = this.categoriaDAO.getById(selectedCategoriaId);
        
        for (ObjectId tag : tags) {
            Tag key = this.tagDAO.getById(tag);
            if (key != null) {
                tagList.add(key);
            }
        }
        Documento documento = new Documento(description, sdf.parse(date), sdf.parse(lastUpdate), fileName, loggedUser.getUsuario(), categoriaSelecionada, tagList);
        documento.setId(id);
        
        validator.onErrorForwardTo(this).form();
        try {
            this.documentoDAO.save(documento);
        } catch (Exception e) {
            e.printStackTrace();
            validator.add(new SimpleMessage("dao", "Falha ao Inserir documento!"));
        }
        result.redirectTo(this).list();
    }
    
    @Path("/delete/{id}")
    public void delete(ObjectId id){
        Documento doc = this.documentoDAO.getById(id);
        this.documentoDAO.delete(doc);
        result.forwardTo(this).list();
    }
}
