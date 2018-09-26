package br.edu.utfpr.md.webapp.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // indica que as anotações seram aplicadas sobre metodos
@Retention(RetentionPolicy.RUNTIME)
public @interface Public { // @interface indica uma anotação
    
}
