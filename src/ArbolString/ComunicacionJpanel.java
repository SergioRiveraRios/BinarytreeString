package ArbolString;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Graphics;
import java.awt.TextField;
import javax.swing.JComponent;
/**
 *
 * @author Sergio
 */
public class ComunicacionJpanel extends JComponent {
    private Arbol Nod;

    public ComunicacionJpanel(JComponent Dibujo) {
        super();
        this.setBounds(0,0,Dibujo.getWidth(),Dibujo.getHeight());
        Dibujo.add(this);
        Nod=new Arbol();
    }
    public void update(JComponent tablero){
        this.setBounds(0,0,tablero.getWidth(),tablero.getHeight());
     
    }
    public void addChild(Persona a){
        Nod.Añadir(a);
    }
    public void DeleteChild(String a){
        Nod.Eliminar(a);
    }
    public void paint(Graphics g){
        super.paint(g);
        Nod.paint(g,this);
        
    }
}
