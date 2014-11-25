/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee7.catalogo.libros.dao;

import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import jee7.catalogo.libros.dao.util.ConnTest;
import jee7.catalogo.libros.modelo.Editorial;

/**
 *
 * @author Martin
 */
@Stateless
@Local(value = EditorialDAO.class)
@Dependent
public class EditorialDAOJPA implements EditorialDAO {

    @Inject
    @ConnTest
    private EntityManager em;

    @Inject
    private Logger miLogger;

    /**
     * @return the miLogger
     */
    public Logger getMiLogger() {
        return miLogger;
    }

    /**
     * @param miLogger the miLogger to set
     */
    public void setMiLogger(Logger miLogger) {
        this.miLogger = miLogger;
    }

    @Override
    public void agregar(Editorial edt) {
        //completar con el metodo del entity manager empleado para persistir
        //em.xxx(edt);        
        em.persist(edt);
    }

    @Override
    public void modificar(Editorial edt) {
        //completar con el metodo del entity manager que combina un objeto
        // propio con uno admininistrado
        //em.xxx(edt);
        em.merge(edt);
    }

    @Override
    public void borrar(int id) {
        //primero buscar la editorial
        //Editorial aux = em.xxx(Editorial.class, id);
        Editorial aux = em.find(Editorial.class, id);
        //luego si la editorial se encontro usar el metodo para borrar
        //if(aux!=null) em.xxx(aux);
        if(aux!=null) em.remove(aux);
    }

    @Override
    public Editorial buscar(int id) {
        //usar el metodo para borrar
        //TO-DO: return em.xxx(Editorial.class, id);
        return em.find(Editorial.class, id);
    }

    @Override
    public List<Editorial> buscar(String nombre) {
        return em.createQuery("SELECT e FROM Editorial e").getResultList();
    }

}
