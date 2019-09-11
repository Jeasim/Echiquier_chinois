package xiangqi;

/** 
 * classe abstraite Piece servant de point de départ pour tous les types de pièces d'un jeu de Xiangqi
 * @author Éric Labonté
 * @version 3
*/

public abstract class Piece {

/**
 * nom de la pièce selon les conventions
 */
private String nom;
/**
 * couleur de la pièce
 */
private String couleur;


// constructeur permettant d'initialiser le nom et la couleur d'un objet Piece

public Piece (String nom, String couleur)
{
setNom(nom);
setCouleur ( couleur );
}

public String getNom ()
  {
  return nom;
  }

public void setNom (String nom)
  {
  this.nom = nom;
  }

public String getCouleur ()
  {
  return couleur;
  }

public void setCouleur ( String couleur )
  {
  if (( couleur == "noir" ) || ( couleur == "rouge" ))
    this.couleur = couleur;
  }
 
/** 
*méthode permettant de calculer la norme mathématique entre deux Positions
* @param depart Position de départ
* @param arrivee Position d'arrivée de la Pièce
* @return la somme des carrés des distances
* 
*/
public double norme (Position depart, Position arrivee)
  {
  return Math.pow((depart.getLigne()-arrivee.getLigne()), 2)+ Math.pow((depart.getColonne() - arrivee.getColonne()),2);
  }

/* méthode abstraite à implémenter dans chacune des sous - classes */

public abstract boolean estValide (Position depart, Position arrivee);


}
