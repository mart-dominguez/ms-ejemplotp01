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
import jee7.catalogo.libros.dao.EditorialDAO;
import jee7.catalogo.libros.modelo.Editorial;

/**
 * EN ESTE CASO EL BACKBEAN será compacto y en una sola capa 
 * tendra el entity manager y la validacion de logica.
 * Es posible hacerlo, y tenemos todo en un componente CDI mucho mas liviano.
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
    
    public Editorial buscar(int id){
        return editDao.buscar(id);
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
