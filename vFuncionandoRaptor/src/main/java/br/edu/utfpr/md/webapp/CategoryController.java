package br.edu.utfpr.md.webapp;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.md.model.Category;
import br.edu.utfpr.md.webapp.dao.CategoryDAO;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.bson.types.ObjectId;

@Controller
@Path("/category")
public class CategoryController {

    @Inject
    private Result result;
    @Inject
    private Validator validator;
    @Inject
    private CategoryDAO categoryDAO;

    @Path("/new")
    @Get
    public void form() {
    }

    @Path(value = {"", "/"})
    @Get
    public List<Category> list() {
        result.include("mensagem", "esta é uma mensagem");
        result.include("data", new Date());
        return categoryDAO.find().asList();
    }

    @Post
    public void save(@Valid @NotNull Category category) {
        validator.onErrorForwardTo(this).form();
        try {
            this.categoryDAO.save(category);
        } catch (Exception e) {
            e.printStackTrace();
            validator.add(new SimpleMessage("dao", "Falha ao Inserir Categoria!"));
        }
        result.redirectTo(this).list();
    }

    @Path("/update/{id}")
    public void update(ObjectId id) {
        Category cat = this.categoryDAO.getById(id);
        result.include("categoria", cat);
        result.forwardTo(this).form();
    }

    @Path("/delete/{id}")
    public void delete(ObjectId id) {
        Category cat = this.categoryDAO.getById(id);
        this.categoryDAO.delete(cat);
        result.forwardTo(this).list();
    }

    public void atualiza(@Valid @NotNull Category category) {
        validator.onErrorForwardTo(this).form();
        try {
            this.categoryDAO.save(category);
        } catch (Exception e) {
            e.printStackTrace();
            validator.add(new SimpleMessage("dao", "Falha ao Inserir Categoria!"));
        }
        result.redirectTo(this).list();
    }

}
