/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee7.catalogo.libros.controlador;

import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import jee7.catalogo.libros.dao.util.ConnTest;
import jee7.catalogo.libros.modelo.Libro;

/**
 *
 * @author Martin
 */
@Named("libroCtrl")
@ViewScoped
public class LibroBackBean implements Serializable{
    private Libro unLibro;

    @Inject @ConnTest EntityManager em;
    
    @Transactional
    public String guardar(){
        if(this.unLibro.getId()<=0) em.persist(unLibro);
        else em.merge(unLibro);
        return null;
    }
    
    public String nuevo(){
        this.unLibro = new Libro();
        return null;
    }

    @Transactional
    public String borrar(){
        Libro aux = em.getReference(Libro.class, unLibro.getId());
        this.em.remove(aux);
        return null;
    }
    
    @Transactional
    public List<Libro> listar(){
        return em.createQuery("SELECT l From Libro l").getResultList();
    }

    @Transactional
    public Libro buscar(int id){
        return em.find(Libro.class,id);
    }

    public Libro getUnLibro() {
        return unLibro;
    }

    public void setUnLibro(Libro unLibro) {
        this.unLibro = unLibro;
    }
    

}
