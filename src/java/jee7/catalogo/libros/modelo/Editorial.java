/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee7.catalogo.libros.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Martin
 */
@Entity
// anotacion para que la tabla se llame JEE_EDITORIAL
@Table(name = "JEE_EDITORIAL")
//xxxx(name = "JEE_EDITORIAL")
public class Editorial  implements Serializable{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
// anotacion para que la tabla se llame NOMBRE_EDITORIAL    
    //@xxx(name = "NOMBRE_EDITORIAL")
    @Column(name = "NOMBRE_EDITORIAL")    
    private String nombre;
    
    @OneToMany(mappedBy = "editor")    
    private List<Libro> libros;
    

    @Override
    /** 
     * verifica que dos objetos editorial son iguales
     * es usado por las listas para comparar libros
     */
    public boolean equals(Object obj) {
        return obj instanceof Editorial && ((Editorial) obj).id == id;
    }

    
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the libros
     */
    public List<Libro> getLibros() {
        return libros;
    }

    /**
     * @param libros the libros to set
     */
    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
    
    
}
