package br.edu.utfpr.md.webapp;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.md.model.Tag;
import br.edu.utfpr.md.webapp.dao.TagDAO;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.bson.types.ObjectId;

@Controller
@Path("/tag")
public class TagController {

    @Inject
    private Result result;
    @Inject
    private Validator validator;
    @Inject
    private TagDAO tagDAO;

    @Path("/new")
    @Get
    public void form() {
    }

    @Path(value = {"", "/"})
    @Get
    public List<Tag> list() {
        result.include("mensagem", "esta é uma mensagem");
        result.include("data", new Date());
        return tagDAO.find().asList();
    }

    @Post
    public void save(@Valid @NotNull Tag tag) {
        validator.onErrorForwardTo(this).form();
        try {
            this.tagDAO.save(tag);
        } catch (Exception e) {
            e.printStackTrace();
            validator.add(new SimpleMessage("dao", "Falha ao Inserir tag!"));
        }
        result.redirectTo(this).list();
    }

    @Path("/update/{id}")
    public void update(ObjectId id) {
        Tag key = this.tagDAO.getById(id);
        result.include("tag", key);
        result.forwardTo(this).form();
    }

    public void atualiza(@Valid @NotNull Tag tag) {
        validator.onErrorForwardTo(this).form();
        try {
            this.tagDAO.save(tag);
        } catch (Exception e) {
            e.printStackTrace();
            validator.add(new SimpleMessage("dao", "Falha ao Inserir tag!"));
        }
        result.redirectTo(this).list();
    }

    @Path("/delete/{id}")
    public void delete(ObjectId id) {
        Tag cat = this.tagDAO.getById(id);
        this.tagDAO.delete(cat);
        result.forwardTo(this).list();
    }
}
