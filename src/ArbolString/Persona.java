/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolString;

/**
 *
 * @author Sergio
 */
public class Persona {
    private String nombre,numControl;
    private int edad;

    public Persona() {
        
    }
    public Persona(String nombre,String numControl,int edad){
        this.nombre=nombre;
        this.numControl=numControl;
        this.edad=edad;
    }
    public String toString(){
        return nombre+"-"+numControl+"-"+edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumControl() {
        return numControl;
    }

    public void setNumControl(String numControl) {
        this.numControl = numControl;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
}
