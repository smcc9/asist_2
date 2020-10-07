/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.modelo;

import java.util.ArrayList;

/**
 *
 * @author SELVA
 */
public class libroDAO {
    private ArrayList<libro> libros;
    
    public libroDAO(){
        libros= new ArrayList<libro>();
    }
    public ArrayList<libro> getlibros(){
        return libros;
    }
    public void setlibros(ArrayList<libro> libros){
        this.libros = libros;
    }
    public void insertar(libro item){
        libros.add(item);
    }
    public void modificar(int id, libro item){
        int pos = posicion(id);
        libros.set(pos, item); 
    }
    public void eliminar(int id, libro item){
        int pos = posicion(id);
        libros.remove(pos); 
    }
    public int posicion(int id) {
        int i = -1;
        if(libros.size()>0){
            for(libro item : libros){
                ++i;
                if(item.getId() ==id){
                    break;
                }
            }
        }
        return i;
    }
}
