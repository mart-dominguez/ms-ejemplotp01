/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee7.catalogo.libros.dao.util;

import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

/**
 *
 * @author Martin
 */
@Dependent
public class UtilDao {
 
    @Produces @ConnTest
    @Resource(lookup="jdbc/catalogo")
    private DataSource ds;
    
     
    @Produces @ConnTest
    @COMPLETAR_CON_ANOTACION_CORRECTA(unitName = "catalogoPU")
    private EntityManager em;
    
    @Produces
    public Logger produceLog(InjectionPoint injectionPoint) {   
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());   
    }
    /**
     * @return the ds
     */
    public DataSource getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(DataSource ds) {
        this.ds = ds;
    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }
}
