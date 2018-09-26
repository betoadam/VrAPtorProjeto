package br.edu.utfpr.md.webapp;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.md.model.Usuario;
import br.edu.utfpr.md.webapp.dao.UsuarioDAO;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.bson.types.ObjectId;

@Controller
@Path("/usuario")
public class UsuarioController {

    @Inject
    private Result result;
    @Inject
    private Validator validator;
    @Inject
    private UsuarioDAO usuarioDAO;

    @Path("/new")
    @Get
    public void form() {
    }

    @Path(value = {"", "/"})
    @Get
    public List<Usuario> list() {
        return usuarioDAO.find().asList();
    }

    @Post
    public void save(@Valid @NotNull Usuario usuario) {
        validator.onErrorForwardTo(this).form();
        try {
            this.usuarioDAO.save(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            validator.add(new SimpleMessage("dao", "Falha ao Inserir usuario!"));
        }
        result.redirectTo(this).list();
    }

    @Path("/update/{id}")
    public void update(ObjectId id) {
        Usuario usuario = this.usuarioDAO.getById(id);
        result.include("usuario", usuario);
        result.forwardTo(this).form();
    }

    public void atualiza(@Valid @NotNull Usuario usuario) {
        System.out.println(usuario.isAdministrator());
        validator.onErrorForwardTo(this).form();
        try {
            this.usuarioDAO.save(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            validator.add(new SimpleMessage("dao", "Falha ao Inserir usuario!"));
        }
        result.redirectTo(this).list();
    }

    @Path("/delete/{id}")
    public void delete(ObjectId id) {
        Usuario usuario = this.usuarioDAO.getById(id);
        this.usuarioDAO.delete(usuario);
        result.forwardTo(this).list();
    }
}
