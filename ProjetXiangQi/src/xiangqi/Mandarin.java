package xiangqi;

public class Mandarin extends Piece
{

	public Mandarin(String nom, String couleur)
	{
		super(nom,couleur);
	}

	public boolean estValide (Position depart, Position arrivee)
	{
		String couleur = getCouleur();
		int ligneArrivee = arrivee.getLigne();
		int colonneArrivee = arrivee.getColonne();
		double norme = norme(depart, arrivee);
		
		if(norme == 0) 		//le mandarin ne se déplace pas 
			return true;
		
		if(colonneArrivee >= 3 && colonneArrivee <= 5)			//les colonnes droite et gauche du palais (même pour les deux palais)
		{	
			if(norme == 2)
			{
				if(couleur == "noir" && ligneArrivee >= 0 && ligneArrivee <= 2)		//intérieur du palais "noir"
					return true;
						
				else if(couleur == "rouge" && ligneArrivee >= 7 && ligneArrivee <= 9)	//intérieur du palais "rouge"
					return true;			
				else 
					return false;
			}
			else
				return false;
		}
		else
			return false;
	}
	
	
}
