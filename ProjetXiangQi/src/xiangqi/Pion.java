package xiangqi;

public class Pion extends Piece
{
	public Pion(String nom, String couleur)
	{
		super(nom,couleur);
	}
	
	public boolean estValide(Position depart, Position arrivee)
	{
		String couleur = getCouleur();
		int ligneDepart = depart.getLigne();
		int colonneDepart = depart.getColonne();
		int ligneArrivee = arrivee.getLigne();
		int colonneArrivee = arrivee.getColonne();
		double norme = norme(depart, arrivee);
		
		
		if(norme == 0)		//pas de déplacement
			return true;
			
		else if(couleur == "noir")
		{
			if(ligneArrivee == (ligneDepart + 1) && (colonneArrivee == colonneDepart))	//avance d'une case
				return true;			//valide pour les deux bords de la rivière
				
			if(ligneDepart >= 5)		//de l'autre côté de la rivière (zone adverse)
			{
				if(norme == 1)
					return true;
					
				else
					return false;
			}
			else
				return false;
		}
			
		else if(couleur == "rouge")
		{
			if(ligneArrivee == (ligneDepart - 1) && (colonneArrivee == colonneDepart))	//avance d'une case
				return true;			//valide pour les deux bords de la rivière
				
			if(ligneDepart <= 4)		//de l'autre côté de la rivière (zone adverse)
			{
				if(norme == 1)
					return true;
			
				else
					return false;
			}
			else
				return false;
		}
		return false;
	}
}
