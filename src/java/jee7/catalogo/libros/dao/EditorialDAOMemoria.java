/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee7.catalogo.libros.dao;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import jee7.catalogo.libros.modelo.Editorial;

/**
 *
 * @author Martin
 */
@ApplicationScoped
public class EditorialDAOMemoria implements EditorialDAO{

    private List<Editorial> lista;
    private static int _ID = 0;
    
    @PostConstruct
    public void init(){
        this.lista = new ArrayList<>();
    }
    @Override
    public void agregar(Editorial edt) {
        // verifico que tenga seteado el ID
        if(edt.getId()==0) edt.setId(++_ID);
        // verifico que no existe en la lista y lo agrego
        System.out.println("--> "+this.lista.contains(edt)+" <--");
        if(  !this.lista.contains(edt)) this.lista.add(edt);
    }

    @Override
    public void modificar(Editorial edt) {
        // verifico que el libro no exista en la lista
        if(edt.getId()>0 && this.lista.contains(edt)) {
            this.lista.remove(edt);
            this.lista.add(edt);
        }
    }

    @Override
    public void borrar(int id) {
        Editorial aux= new Editorial();
        aux.setId(id);
        this.lista.remove(aux);
    }

    @Override
    public Editorial buscar(int id) {
        for(Editorial edt : this.lista){
            if(edt.getId()== id) return edt;
        }
        return null;
    }

    @Override
    public List<Editorial> buscar(String nombre) {
        List<Editorial> listaResultado = new ArrayList<>();
        /*for(Editorial edt : this.lista){
            if(edt.getNombre().matches(nombre)) listaResultado.add(edt);
        }*/
        return lista;
    }
    
}
