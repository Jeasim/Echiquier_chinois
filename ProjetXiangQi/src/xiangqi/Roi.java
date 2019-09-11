package xiangqi;

public class Roi extends Piece
{
	public Roi(String nom, String couleur)
	{
		super(nom,couleur);
	}

	public boolean estValide (Position depart, Position arrivee)
	{
		String couleur = getCouleur();
		int ligneArrivee = arrivee.getLigne();
		int colonneArrivee = arrivee.getColonne();
		double norme = norme(depart, arrivee);

		
		if(colonneArrivee >= 3 && colonneArrivee <= 5)	//les deux palais ont les mêmes limites de colonnes
		{	
			if(norme <= 1)			//norme de 1 comprend les déplacements de 1 diagonales ou non et le déplacement nul
			{
				{
					if(couleur == "noir" && ligneArrivee >= 0 && ligneArrivee <= 2)			//limites du palais noir (lignes)
						return true;
						
					else if(couleur == "rouge" && ligneArrivee >= 7 && ligneArrivee <= 9)	//limites du palais rouge (lignes)
						return true;			
					else 
						return false;
				}
			}	
			else
				return false;
		}
		else
			return false;
	}
	
	
}