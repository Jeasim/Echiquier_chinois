package xiangqi;

public class Elephant extends Piece
{	
	public Elephant(String nom, String couleur)
	{
		super(nom,couleur);
	}
	
	public boolean estValide(Position depart, Position arrivee)
	{
		String couleur = getCouleur();
		int ligneArrivee = arrivee.getLigne();
		
		
		if(norme(depart, arrivee) == 8 || norme(depart, arrivee) == 0)		//déplacement de deux cases en diagonales, ou un déplacement de 0
		{
			if(couleur == "noir" && (ligneArrivee <= 4))					//côté nord de la rivière (ne peut être dépassé)
					return true;
			
			else if(couleur == "rouge" && (ligneArrivee >= 5))				//côté sud de la rivière (ne peut être déplacé)
					return true;
			
			else 
				return false;
		}
		else
			return false;
		
	}
	
	
}
