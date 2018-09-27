package br.edu.utfpr.md.webapp;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.md.model.Categoria;
import br.edu.utfpr.md.webapp.dao.CategoriaDAO;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.bson.types.ObjectId;

@Controller
@Path("/categoria")
public class CategoriaController {

    @Inject
    private Result result;
    @Inject
    private Validator validator;
    @Inject
    private CategoriaDAO categoriaDAO;

    @Path("/new")
    @Get
    public void form() {
    }

    @Path(value = {"", "/"})
    @Get
    public List<Categoria> list() {
        result.include("mensagem", "esta é uma mensagem");
        result.include("data", new Date());
        return categoriaDAO.find().asList();
    }

    @Post
    public void save(@Valid @NotNull Categoria categoria) {
        validator.onErrorForwardTo(this).form();
        try {
            this.categoriaDAO.save(categoria);
        } catch (Exception e) {
            e.printStackTrace();
            validator.add(new SimpleMessage("dao", "Falha ao Inserir Categoria!"));
        }
        result.redirectTo(this).list();
    }

    @Path("/update/{id}")
    public void update(ObjectId id) {
        Categoria cat = this.categoriaDAO.getById(id);
        result.include("categoria", cat);
        result.forwardTo(this).form();
    }

    @Path("/delete/{id}")
    public void delete(ObjectId id) {
        Categoria cat = this.categoriaDAO.getById(id);
        this.categoriaDAO.delete(cat);
        result.forwardTo(this).list();
    }

    public void atualiza(@Valid @NotNull Categoria categoria) {
        validator.onErrorForwardTo(this).form();
        try {
            this.categoriaDAO.save(categoria);
        } catch (Exception e) {
            e.printStackTrace();
            validator.add(new SimpleMessage("dao", "Falha ao Inserir Categoria!"));
        }
        result.redirectTo(this).list();
    }

}
