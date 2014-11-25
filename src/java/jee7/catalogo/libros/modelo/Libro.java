/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee7.catalogo.libros.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name="JEE_LIBRO")
public class Libro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_PUBLICACION")
    private Date fechaPublicacion;
    private Double precio;
    private byte[] portada;
    @ElementCollection
    @CollectionTable(name="JEE_ETIQUETAS", joinColumns=@JoinColumn(name="ID_LIBRO"))
    @Column(name="ETIQUETA")
    private List<String> etiquetas;
    
    @ManyToMany
     @JoinTable(
      name="JEE_LIBRO_AUTORES",
      joinColumns = @JoinColumn(name="ID_LIBRO"),
      inverseJoinColumns=@JoinColumn(name="ID_AUTOR"))    
    private List<Autor> autores;
    
    @ManyToOne
    @JoinColumn(name="ID_EDITORIAL")
    private Editorial editor;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
     * @return the fechaPublicacion
     */
    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * @param fechaPublicacion the fechaPublicacion to set
     */
    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * @return the precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * @return the portada
     */
    public byte[] getPortada() {
        return portada;
    }

    /**
     * @param portada the portada to set
     */
    public void setPortada(byte[] portada) {
        this.portada = portada;
    }

    /**
     * @return the etiquetas
     */
    public List<String> getEtiquetas() {
        return etiquetas;
    }

    /**
     * @param etiquetas the etiquetas to set
     */
    public void setEtiquetas(List<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

    /**
     * @return the autores
     */
    public List<Autor> getAutores() {
        return autores;
    }

    /**
     * @param autores the autores to set
     */
    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    /**
     * @return the editor
     */
    public Editorial getEditor() {
        return editor;
    }

    /**
     * @param editor the editor to set
     */
    public void setEditor(Editorial editor) {
        this.editor = editor;
    }
    
    
    
}
