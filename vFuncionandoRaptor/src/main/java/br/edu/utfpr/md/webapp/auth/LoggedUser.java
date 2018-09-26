package br.edu.utfpr.md.webapp.auth;

import br.com.caelum.vraptor.Result;
import br.edu.utfpr.md.model.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class LoggedUser implements Serializable {
    @Inject
    private Result result;
    private Usuario usuario;

    public void login(Usuario usuario) {
        this.usuario = usuario;
    }

    public void logout() {
        this.usuario = null;
        result.forwardTo("/auth");
    }

    public boolean isLogged() {
        return this.usuario != null;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
