/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee7.catalogo.libros.controlador;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jee7.catalogo.libros.dao.util.ConnTest;
import jee7.catalogo.libros.modelo.Libro;

/**
 *
 * @author Martin
 */
@Named
@ConversationScoped
public class BusquedaBackBean implements Serializable{

    private String nombreEditorial;
    private Double precioMinimo;
    private Double precioMaximo;
    private String titulo;
    private List<Libro> resultadoBusqueda;
    private Libro unLibroFavorito;
    
    @Inject Conversation conv;
    
    @Inject @ConnTest EntityManager em;

    public String buscar(){
        if(conv.isTransient()) conv.begin();
        Query q = em.createNamedQuery("Libro.findByTituloEditorialPrecio");        
        if(precioMinimo==null) precioMinimo =0.0;
        if(precioMaximo==null || precioMaximo==0) precioMaximo =Double.MAX_VALUE;
        if(titulo==null || titulo.length()==0) titulo ="%";
        if(nombreEditorial==null || nombreEditorial.length()==0) nombreEditorial ="%";
        q.setParameter("P_TITULO","%"+titulo+"%");
        q.setParameter("P_PREC_MIN",precioMinimo);
        q.setParameter("P_PREC_MAX",precioMaximo);
        q.setParameter("P_EDITOR","%"+nombreEditorial+"%");
        resultadoBusqueda = q.getResultList();
        return "resultadoBusqueda.xhtml";
    }

    public void addToFavoritos(){
        // hacer
    }
    
    public String nuevaBusqueda(){
        conv.end();
        return "buscar.xhtml";
    }

    public String refinarBusqueda(){
        return "buscar.xhtml";
    }

  
    /**
     * @return the nombreEditorial
     */
    public String getNombreEditorial() {
        return nombreEditorial;
    }

    /**
     * @param nombreEditorial the nombreEditorial to set
     */
    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }

    /**
     * @return the precioMinimo
     */
    public Double getPrecioMinimo() {
        return precioMinimo;
    }

    /**
     * @param precioMinimo the precioMinimo to set
     */
    public void setPrecioMinimo(Double precioMinimo) {
        this.precioMinimo = precioMinimo;
    }

    /**
     * @return the precioMaximo
     */
    public Double getPrecioMaximo() {
        return precioMaximo;
    }

    /**
     * @param precioMaximo the precioMaximo to set
     */
    public void setPrecioMaximo(Double precioMaximo) {
        this.precioMaximo = precioMaximo;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the resultadoBusqueda
     */
    public List<Libro> getResultadoBusqueda() {
        return resultadoBusqueda;
    }

    /**
     * @param resultadoBusqueda the resultadoBusqueda to set
     */
    public void setResultadoBusqueda(List<Libro> resultadoBusqueda) {
        this.resultadoBusqueda = resultadoBusqueda;
    }

    /**
     * @return the unLibroFavorito
     */
    public Libro getUnLibroFavorito() {
        return unLibroFavorito;
    }

    /**
     * @param unLibroFavorito the unLibroFavorito to set
     */
    public void setUnLibroFavorito(Libro unLibroFavorito) {
        this.unLibroFavorito = unLibroFavorito;
    }
}
