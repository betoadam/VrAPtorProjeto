package br.edu.utfpr.md.webapp;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.md.model.Keyword;
import br.edu.utfpr.md.webapp.dao.KeywordDAO;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.bson.types.ObjectId;

@Controller
@Path("/keyword")
public class KeywordController {

    @Inject
    private Result result;
    @Inject
    private Validator validator;
    @Inject
    private KeywordDAO keywordDAO;

    @Path("/new")
    @Get
    public void form() {
    }

    @Path(value = {"", "/"})
    @Get
    public List<Keyword> list() {
        result.include("mensagem", "esta é uma mensagem");
        result.include("data", new Date());
        return keywordDAO.find().asList();
    }

    @Post
    public void save(@Valid @NotNull Keyword keyword) {
        validator.onErrorForwardTo(this).form();
        try {
            this.keywordDAO.save(keyword);
        } catch (Exception e) {
            e.printStackTrace();
            validator.add(new SimpleMessage("dao", "Falha ao Inserir keyword!"));
        }
        result.redirectTo(this).list();
    }

    @Path("/update/{id}")
    public void update(ObjectId id) {
        Keyword key = this.keywordDAO.getById(id);
        result.include("keyword", key);
        result.forwardTo(this).form();
    }

    public void atualiza(@Valid @NotNull Keyword keyword) {
        validator.onErrorForwardTo(this).form();
        try {
            this.keywordDAO.save(keyword);
        } catch (Exception e) {
            e.printStackTrace();
            validator.add(new SimpleMessage("dao", "Falha ao Inserir keyword!"));
        }
        result.redirectTo(this).list();
    }

    @Path("/delete/{id}")
    public void delete(ObjectId id) {
        Keyword cat = this.keywordDAO.getById(id);
        this.keywordDAO.delete(cat);
        result.forwardTo(this).list();
    }
}
