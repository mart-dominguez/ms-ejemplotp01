/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee7.catalogo.libros.dao;

import java.util.List;
import jee7.catalogo.libros.modelo.Editorial;

/**
 *
 * @author Martin
 */
public interface EditorialDAO {
    public void agregar(Editorial edt);
    public void modificar(Editorial edt);
    public void borrar(int id);
    public Editorial buscar(int id);
    public List<Editorial> buscar(String nombre);
}
