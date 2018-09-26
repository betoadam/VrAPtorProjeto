package br.edu.utfpr.md.webapp.auth;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.edu.utfpr.md.webapp.AuthController;
import javax.inject.Inject;

@Intercepts
public class AuthenticationInterceptor {

    @Inject
    private LoggedUser loggedUser;
    @Inject
    private Result result;

    //Condição de interceptação, é interceptado todo o metodo que não possui a anotação @Public
    @Accepts
    public boolean accepts(ControllerMethod method) {
        return !method.containsAnnotation(Public.class);
    }

    @AroundCall
    public void intercept(SimpleInterceptorStack stack) {
        // Obtendo o usuario autenticado na sessão
        // faz a verificação 
        if (!loggedUser.isLogged()) {
            result.forwardTo(AuthController.class).login();
        }
        System.out.println("Interceptou");
        stack.next();
    }
}
