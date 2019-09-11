package xiangqi;

public class Cavalier extends Piece
{
	public Cavalier(String nom, String couleur)
	{
		super(nom,couleur);
	}

	public boolean estValide(Position depart, Position arrivee)
	{
		if(norme(depart, arrivee) == 5 || norme(depart, arrivee) == 0)		//toujours déplacement 1 case (ligne ou colonne) / 2 cases de l'autre axe
			return true;

			else
				return false;
	}
}
