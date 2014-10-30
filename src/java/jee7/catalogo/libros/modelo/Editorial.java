/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee7.catalogo.libros.modelo;

/**
 *
 * @author Martin
 */
public class Editorial {
    private int id;
    private String nombre;

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
    
    
}
