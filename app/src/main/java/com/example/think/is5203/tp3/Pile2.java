package com.example.think.is5203.tp3;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{

  private Stack<T> stk;
  /** la capcite de la pile */
  private int   capacite;
  
  /** Creation d'une pile.
   * @param taille la taille de la pile, la taille doit etre > 0
   */
  public Pile2(int taille){
    this.stk = new Stack<T>();
    this.capacite = taille;
  }

  public Pile2(){
    this(PileI.CAPACITE_PAR_DEFAUT);
  }
  

  public void empiler(T o) throws PilePleineException{
    if(estPleine()) throw new PilePleineException(o.toString());
    stk.push(o);
  }
  

  public T depiler() throws PileVideException{
    if(estVide())  throw new PileVideException();
    return stk.pop();
  }


  public T sommet() throws PileVideException{
    if(estVide())  throw new PileVideException();
     return stk.peek();
  }
  
  /** Effectue un test de l'etat de la pile.
   * @return vrai si la pile est vide, faux autrement
   */
  public boolean estVide(){
    return stk.empty();
  }

  /** Effectue un test de l'etat de la pile.
   * @return vrai si la pile est pleine, faux autrement
   */   
  public boolean estPleine(){
    return capacite == stk.size();
  }
  
  /** Retourne une representation en String d'une pile, 
   * contenant la representation en String de chaque element.
   * @return une representation en String d'une pile
   */ 
  public String toString(){
    String s = "[";
    for(int i = stk.size()-1; i>=0;i--){
      s = s + stk.elementAt(i);
      if(i>0) s = s+ ", ";
    }
    return s + "]";
  }
  
  /** Retourne la taille de la pile
   * @return cette taille
   */ 
  public int taille(){
    return this.stk.size();
  }
  
  /** Retourne la taille de la pile
   * @return cette taille
   */ 
  public int capacite(){
    return this.capacite;
  }
}
