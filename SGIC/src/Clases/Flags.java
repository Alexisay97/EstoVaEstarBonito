/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Alex
 */
public abstract class Flags {
        
    int band;
    
    public void setFuncion(int band){
        this.band = band;
    }
    
    public int getFuntion(int band){
        return this.band;
    }
            
}
