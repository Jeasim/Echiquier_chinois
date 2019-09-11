package xiangqi;

public class Char extends Piece
{
	
	public Char(String nom, String couleur)
	{
		super(nom,couleur);
	}

	
	public boolean estValide(Position depart, Position arrivee)
	{
		int ligneDepart = depart.getLigne();
		int colonneDepart = depart.getColonne();
		int ligneArrivee = arrivee.getLigne();
		int colonneArrivee = arrivee.getColonne();
		
		if(ligneDepart == ligneArrivee)				//reste sur la même ligne
			return true;
		
		else if(colonneDepart == colonneArrivee)	//ou reste sur la même colonne
			return true;
		
		else
			return false;		
	}
	
}
