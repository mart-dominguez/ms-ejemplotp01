/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee7.catalogo.libros.controlador;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.convert.Converter;
import jee7.catalogo.libros.modelo.Libro;

/**
 *
 * @author Administrador
 */
@FacesConverter("jee7.catalogo.libros.controlador.libroConverter")
public class LibroConverter implements Converter{
    
    @Inject 
    private LibroBackBean libroBean;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.libroBean.buscar(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Libro) value).getId()+"";
    }
}
