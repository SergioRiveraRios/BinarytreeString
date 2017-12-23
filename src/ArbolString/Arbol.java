/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolString;

import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Sergio
 */
public class Arbol {
    private Nodo raiz;
    int mayor=0;
    public Arbol() {
    }
    public Arbol(Nodo raiz) {
        this.raiz = raiz;
    }
    public void Añadir(Nodo nodo,Persona a){
        if(nodo.getDato().getNombre().compareToIgnoreCase(a.getNombre())>0){
            if(nodo.getIzq()!=null){
                Añadir(nodo.getIzq(),a);
            }else{
                nodo.setIzq(new Nodo(a));
            }
        }else{
            if(nodo.getDer()!=null){
                Añadir(nodo.getDer(),a);
            }else{
                nodo.setDer(new Nodo(a));
            }
        }
    }
    public void Añadir(Persona dato){
        if(raiz==null){
            raiz=new Nodo(dato);
        }else{
            Añadir(raiz,dato);
        }
    }
    public boolean Eliminar(String dato) {
        Nodo aux = raiz;
        Nodo padre = raiz;
        boolean HijoIzq = true;
        while (!(aux.getDato().getNombre().equals(dato))) {
            padre = aux;
            if (dato.compareTo(aux.getDato().getNombre())<0) {
                HijoIzq = true;
                aux = aux.getIzq();
            } else {
                HijoIzq = false;
                aux = aux.getDer();
            }
            if (aux == null) {
                HijoIzq = false;
            }
        }//Fin while
        if (aux.getIzq() == null && aux.getDer() == null) {
            if (aux == raiz) {
                aux = padre = raiz = null;
            } else if (HijoIzq) {
                padre.setIzq(null);
            } else {
                padre.setDer(null);
            }

        } else if (aux.getDer() == null) {
            if (aux == raiz) {
                raiz = aux.getIzq();
            } else {
                if (HijoIzq) {
                    padre.setIzq(aux.getIzq());
                } else {
                    padre.setDer(aux.getIzq());
                }
            }
        } else if (aux.getDer() == null) {
            if (aux == raiz) {
                raiz = aux.getDer();
            } else {
                if (HijoIzq) {
                    padre.setIzq(aux.getDer());
                } else {
                    padre.setDer(aux.getDer());
                }
            }
        } else {
            Nodo remp = ObtenerRemp(aux);
            if (aux == raiz) {
                raiz = remp;
            } else if (HijoIzq) {
                padre.setIzq(remp);
            } else {
                padre.setDer(remp);
            }
            remp.setIzq(aux.getIzq());
        }
        return true;
    }
    public Nodo ObtenerRemp(Nodo Remp) {
        Nodo rempPadre = Remp;
        Nodo Remplazo = Remp;
        Nodo aux = Remp.getDer();
        while (aux != null) {
            rempPadre = Remplazo;
            Remplazo = aux;
            aux = aux.getIzq();
            if (Remplazo != Remp.getDer()) {
                if(Remplazo.getDer()==null && Remplazo.getIzq()!=null){
                    rempPadre.setIzq(Remplazo.getIzq());
                }
                rempPadre.setDer(Remplazo);
                Remplazo.setDer(Remp.getDer());
            }
        }
        
        System.out.println("Nodo remplazo" + Remplazo);
        return Remplazo;
    }
    public Nodo Mayor(Nodo raiz){
        while(raiz!=null){
            Mayor(raiz.getDer());
        }return null;
    }
    public void paint(Graphics g,JComponent panel){
        giveLocation(panel,this.getRaiz());
        paint(g,panel,this.getRaiz());
        paint(g,getRaiz());
    }
    public void paint(Graphics g, Nodo arb){
        if(arb!=null){
            Posicion padre=arb.getLocacion();
            int radio=arb.getRadio();
            if(arb.getIzq()!=null){
                Posicion hijo=arb.getIzq().getLocacion();
                g.drawLine(padre.getX()+radio,padre.getY()+radio,hijo.getX()+radio,hijo.getY()+radio);
                paint(g,arb.getIzq());
       
            }
            if(arb.getDer()!=null){
                Posicion hijo=arb.getDer().getLocacion();
                g.drawLine(padre.getX()+radio,padre.getY()+radio ,hijo.getX()+radio,hijo.getY()+radio);
                paint(g,arb.getDer());
            }
        }
    }
    public void paint(Graphics g,JComponent panel,Nodo arb){
        if(arb!=null){
            arb.paint(g);
            if(arb.getIzq()!=null)
                paint(g,panel,arb.getIzq());
            if(arb.getDer()!=null)
                paint(g,panel,arb.getDer());
        }
    }
    public int giveMeTheLevel(Persona dat){
        return enquenivel(raiz, 0, dat)-1;
    }
    private int enquenivel(Nodo nodo,int suma,Persona dato){
        if(!esVacioArb(nodo)){
            suma++;
            if(nodo.getDato().getNombre().toLowerCase().equals(dato.getNombre().toLowerCase())){
                return suma;
            }else{
                if(contains(nodo.getIzq(),dato))
                    suma=enquenivel(nodo.getIzq(),suma,dato);
                else if(contains(nodo.getDer(),dato))
                    suma=enquenivel(nodo.getDer(), suma, dato);
            }
        }
        return suma;
    }
    public boolean contains(Nodo raiz, Persona dato){
        if(raiz==null)
            return false;
        else{
            return raiz.getDato().equals(dato)||contains(raiz.getIzq(), dato)||contains(raiz.getDer(), dato);  
        }
    }
    public int altura(){
        altura(raiz,0);
        
        return mayor;      
    }public void altura(Nodo nodo,int cont){
        if(!esVacioArb(nodo)){
            cont++;
            if(nodo.getIzq()==null && nodo.getDer()==null){
                if(cont>mayor){
                    mayor=cont;
                }
            }else{
                altura(nodo.getIzq(),cont);
                altura(nodo.getDer(), cont);
            }
        }
    }
    public int getXincrement(Nodo arb, int width){
        int n=giveMeTheLevel(arb.getDato());
        int dos_n=(int)Math.pow(2, n); 
        return (width/dos_n)/2;
    }
    public void giveLocation(JComponent panel,Nodo tree){
        if(tree!=null){
            int n=giveMeTheLevel(tree.getDato());
            int quadrant=panel.getHeight()/this.altura();
            int margen=100;
            int pos_y=quadrant*n;
            int pos_x=0;
            if(tree.equals(this.getRaiz())){
                pos_x=getXincrement(tree,panel.getWidth());
                tree.getLocacion().setX(pos_x);            
            }
            if(!esVacioArb(tree.getIzq())){
                pos_x=tree.getLocacion().getX()-getXincrement(tree.getIzq(),panel.getWidth());
                tree.getIzq().getLocacion().setX(pos_x);
            }
            if(!esVacioArb(tree.getDer())){
                pos_x=tree.getLocacion().getX()+getXincrement(tree.getDer(),panel.getWidth());
                tree.getDer().getLocacion().setX(pos_x);
            }
            Posicion p=new Posicion(tree.getLocacion().getX(),pos_y);
            if(tree.getIzq()!=null)
                giveLocation(panel, tree.getIzq());
            if(tree.getDer()!=null)
            giveLocation(panel, tree.getDer());
            tree.setLocacion(p);
        }
    }
    private boolean esVacioArb(Nodo nodo){
        return nodo==null;
    }
   
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public int getMayor() {
        return mayor;
    }

    public void setMayor(int mayor) {
        this.mayor = mayor;
    }
    
}
