/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolString;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Sergio
 */
public class Nodo {
    private Persona dato;
    private Nodo izq,der,nod;
    private int largo;
    private Posicion locacion;
    public Nodo(){
    }
    public Nodo(Persona a){
        this.dato = a;
        this.largo=10;
        this.locacion=new Posicion();
    }
    public Nodo(Persona a,Nodo izq,Nodo der){
        this.dato = a;
        this.izq = izq;
        this.der = der;
        this.locacion=new Posicion();
    }
    public void paint(Graphics g){
        Icon imagen=new ImageIcon(getClass().getResource("circulo_1.png"));//Falta imagen
        ImageIcon img=(ImageIcon) imagen;
        Graphics2D g2=(Graphics2D) g;
        g2.setPaint(Color.WHITE);
        g.drawImage(img.getImage(),locacion.getX()-10,locacion.getY(), 50,50, (ImageObserver)nod);
        g2.setPaint(Color.WHITE);
        g.drawString(this.getDato().getNombre()+"\n"+this.getDato().getEdad()+"", locacion.getX()-10, locacion.getY()+26);
        g2.setPaint(Color.WHITE);
    }

    public Persona getDato() {
        return dato;
    }
    public void setDato(Persona dato) {
        this.dato = dato;
    }
    public Nodo getIzq() {
        return izq;
    }
    public void setIzq(Nodo izq) {
        this.izq = izq;
    }
    public Nodo getDer() {
        return der;
    }
    public void setDer(Nodo der) {
        this.der = der;
    }
    public Nodo getNod() {
        return nod;
    }
    public void setNod(Nodo nod) {
        this.nod = nod;
    }
    public int getLargo() {
        return largo;
    }
    public void setLargo(int largo) {
        this.largo = largo;
    }
    public Posicion getLocacion() {
        return locacion;
    }
    public void setLocacion(Posicion locacion) {
        this.locacion = locacion;
    }
    public int getRadio(){
        return largo;
    }
    public void setRadio(int radio){
        this.largo=radio;
    }
}
