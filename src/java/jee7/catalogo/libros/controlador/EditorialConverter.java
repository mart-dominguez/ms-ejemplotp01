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
import jee7.catalogo.libros.modelo.Editorial;

/**
 *
 * @author Administrador
 */
@FacesConverter("jee7.catalogo.libros.controlador.editorialConverter")
public class EditorialConverter implements Converter{
    
    @Inject 
    private EditorialBackBean editBackBean;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.editBackBean.buscar(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Editorial ) value).getId()+"" ;
    }
}
