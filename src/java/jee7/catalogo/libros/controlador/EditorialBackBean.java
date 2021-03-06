/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee7.catalogo.libros.controlador;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import jee7.catalogo.libros.dao.DAOMysql;
import jee7.catalogo.libros.dao.EditorialDAO;
import jee7.catalogo.libros.modelo.Editorial;

/**
 *
 * @author Martin
 */
@Named("editCtrl")
@SessionScoped
public class EditorialBackBean implements Serializable{
    private Editorial editorialActual;

    @Inject EditorialDAO editDao;
    
    public String guardar(){
        if(editorialActual.getId()==0) editDao.agregar(editorialActual);
        else editDao.modificar(editorialActual);
        this.editorialActual = null;
        return null;
    }
    
    public String borrar(){
        editDao.borrar(this.editorialActual.getId());
        return null;
    }    

        
    public String nuevo(){
        this.editorialActual = new Editorial();
        return null;
    }    
    
    /**
     * @return the editorialActual
     */
    public Editorial getEditorialActual() {
        return editorialActual;
    }

    public List<Editorial> listar() {
        return editDao.buscar("");
    }
    /**
     * @param editorialActual the editorialActual to set
     */
    public void setEditorialActual(Editorial editorialActual) {
        this.editorialActual = editorialActual;
    }
    
}
