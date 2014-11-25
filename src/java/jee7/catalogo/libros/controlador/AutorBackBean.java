/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee7.catalogo.libros.controlador;

import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import jee7.catalogo.libros.dao.util.ConnTest;
import jee7.catalogo.libros.modelo.Autor;

/**
 * EN ESTE CASO EL BACKBEAN será compacto y en una sola capa 
 * tendra el entity manager y la validacion de logica.
 * Es posible hacerlo, y tenemos todo en un componente CDI mucho mas liviano.
 * @author Administrador
 */

@Named(value = "autorCtrl")
@ViewScoped
public class AutorBackBean {
    private Autor unAutor;
    
    @Inject @ConnTest EntityManager em;
    
    @Transactional
    public String guardar(){
        if(this.unAutor.getId()<=0) em.persist(unAutor);
        else em.merge(unAutor);
        return null;
    }
    
    @Transactional
    public String nuevo(){
        this.unAutor = new Autor();
        return null;
    }

    @Transactional
    public String borrar(){
        Autor aux = em.getReference(Autor.class, unAutor.getId());
        this.em.remove(aux);
        return null;
    }
    
    @Transactional
    public List<Autor> listar(){
        return em.createQuery("SELECT a From Autor a").getResultList();
    }

    /**
     * @return the unAutor
     */
    public Autor getUnAutor() {
        return unAutor;
    }

    /**
     * @param unAutor the unAutor to set
     */
    public void setUnAutor(Autor unAutor) {
        this.unAutor = unAutor;
    }
    
}
