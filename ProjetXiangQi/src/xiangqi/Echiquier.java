package xiangqi;

public class Echiquier implements MethodesEchiquier
{
	private Intersection[][] jeu;
	
	
	public Echiquier()
	{	
		jeu = new Intersection[10][9];
		
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 9; j++)
				jeu[i][j] = new Intersection();
	}


	public void debuter() 
	{
		//PLACER LES PIECES NOIRES
		
		jeu[0][0].setPiece(new Char("t1","noir"));
		jeu[0][1].setPiece(new Cavalier("c1","noir"));
		jeu[0][2].setPiece(new Elephant("e1","noir"));
		jeu[0][3].setPiece(new Mandarin("m1","noir"));
		jeu[0][4].setPiece(new Roi("r","noir"));
		jeu[0][5].setPiece(new Mandarin("m2","noir"));
		jeu[0][6].setPiece(new Elephant("e2","noir"));
		jeu[0][7].setPiece(new Cavalier("c2","noir"));
		jeu[0][8].setPiece(new Char("t2","noir"));
		
		jeu[2][1].setPiece(new Bombarde("b1","noir"));
		jeu[2][7].setPiece(new Bombarde("b2","noir"));
		
		jeu[3][0].setPiece(new Pion("p1","noir"));
		jeu[3][2].setPiece(new Pion("p2","noir"));
		jeu[3][4].setPiece(new Pion("p3","noir"));
		jeu[3][6].setPiece(new Pion("p4","noir"));
		jeu[3][8].setPiece(new Pion("p5","noir"));
		
		
		//PLACER LES PIECES ROUGES

		jeu[9][0].setPiece(new Char("t1","rouge"));
		jeu[9][1].setPiece(new Cavalier("c1","rouge"));
		jeu[9][2].setPiece(new Elephant("e1","rouge"));
		jeu[9][3].setPiece(new Mandarin("m1","rouge"));
		jeu[9][4].setPiece(new Roi("r","rouge"));
		jeu[9][5].setPiece(new Mandarin("m2","rouge"));
		jeu[9][6].setPiece(new Elephant("e2","rouge"));
		jeu[9][7].setPiece(new Cavalier("c2","rouge"));
		jeu[9][8].setPiece(new Char("t2","rouge"));
		
		jeu[7][1].setPiece(new Bombarde("b1","rouge"));
		jeu[7][7].setPiece(new Bombarde("b2","rouge"));
		
		jeu[6][0].setPiece(new Pion("p1","rouge"));
		jeu[6][2].setPiece(new Pion("p2","rouge"));
		jeu[6][4].setPiece(new Pion("p3","rouge"));
		jeu[6][6].setPiece(new Pion("p4","rouge"));
		jeu[6][8].setPiece(new Pion("p5","rouge"));
		
	}

	
	public Intersection getIntersection(int ligne, int colonne) 
	{
	
		return jeu[ligne][colonne];
	}


	
	
	public boolean cheminPossible(Position depart, Position arrivee) 
	{
		
		int ligneDepart = depart.getLigne();
		int ligneArrivee = arrivee.getLigne();
		int colonneDepart = depart.getColonne();
		int colonneArrivee = arrivee.getColonne();
		
		int deplacementLigne = ligneArrivee - ligneDepart;
		int deplacementColonne = colonneArrivee - colonneDepart;
		
		String couleurPiece = jeu[ligneDepart][colonneDepart].getPiece().getCouleur();
		Piece piece = jeu[ligneDepart][colonneDepart].getPiece();
		

		
//---------------- valider la case d'arrivée -------------------------------------------------------
		
		if(!jeu[ligneArrivee][colonneArrivee].estOccupee() || jeu[ligneArrivee][colonneArrivee].estOccupeeAdversaire(couleurPiece))   //On veut savoir si l'intersection d'arrivée est vide, ou s'il est libre (les deux sont permis)
		{
//---------------- cas Cavalier ---------------------------------------------------------------------
			
			if(piece instanceof Cavalier)				
			{
				if(((deplacementLigne == 2) && (deplacementColonne == 1) || (deplacementLigne == 2) && (deplacementColonne == -1))) {			
					if(jeu[ligneDepart + 1][colonneDepart].estOccupee())			//BAS
						return false;
				}
				
				else if(((deplacementLigne == -2) && (deplacementColonne == -1) || (deplacementLigne == -2) && (deplacementColonne == 1))) {
					if(jeu[ligneDepart - 1][colonneDepart].estOccupee())			//HAUT
						return false;		
				}
				
				else if(((deplacementLigne == -1) && (deplacementColonne == 2) || (deplacementLigne == 1) && (deplacementColonne == 2))) {
					if(jeu[ligneDepart][colonneDepart + 1].estOccupee())			//DROITE
						return false;	
				}
					
				else if(((deplacementLigne == -1) && (deplacementColonne == -2) || (deplacementLigne == 1) && (deplacementColonne == -2))) {
					if(jeu[ligneDepart + 1][colonneDepart - 1].estOccupee())		//GAUCHE
						return false;	
				}	
				else 
					return true;
			}

			
//---------------- cas Bombarde ---------------------------------------------------------------------		
			
			if(piece instanceof Bombarde)
			{		
					int nbPieceChemin = 0;		//Compteur de pieces pour savoir s'il croise seulement une piece et pas plus			
					
					if(ligneDepart > ligneArrivee && colonneDepart == colonneArrivee)			//BAS		
					{
						for(int i = 1; i < deplacementLigne; i++)
							if(jeu[ligneDepart + i][colonneDepart].estOccupee())
							{
								nbPieceChemin ++;
								if(nbPieceChemin > 1)
									return false;
							}
					}
					else if(ligneDepart > ligneArrivee && colonneDepart == colonneArrivee)		//HAUT
					{
						for(int i = 1; i < deplacementLigne; i++)										
							if(jeu[ligneDepart - i][colonneDepart].estOccupee())
							{
								nbPieceChemin ++;
								if(nbPieceChemin > 1)
									return false;
							}
					}
					else if(ligneDepart == ligneArrivee && colonneDepart > colonneArrivee)		//GAUCHE
					{
						for(int i = 1; i < deplacementColonne; i++)	
							if(jeu[ligneDepart][colonneDepart - i].estOccupee())
							{
								nbPieceChemin ++;
								if(nbPieceChemin > 1)
									return false;
							}
					}
					else if(ligneDepart == ligneArrivee && colonneDepart < colonneArrivee)		//DROITE
					{
						for(int i = 1; i < deplacementColonne; i++)		
							if(jeu[ligneDepart][colonneDepart - i].estOccupee())
							{
								nbPieceChemin ++;
								if(nbPieceChemin > 1)
									return false;
							}
					}
					else
						return true;		
			}
						
			
//---------------- cas generaux ---------------------------------------------------------------------
			
			if(ligneDepart > ligneArrivee && colonneDepart == colonneArrivee)			//BAS		on regarde toutes les intersections avant l'arrivée selon le déplacement, et on vérifie qu'elles sont libres
			{
				for(int i = 1; i < deplacementLigne; i++)										
					if(jeu[ligneDepart + i][colonneDepart].estOccupee())
						return false;
			}
			else if(ligneDepart > ligneArrivee && colonneDepart == colonneArrivee)		//HAUT
			{
				for(int i = 1; i < deplacementLigne; i++)										
					if(jeu[ligneDepart - i][colonneDepart].estOccupee())
						return false;
			}
			else if(ligneDepart == ligneArrivee && colonneDepart > colonneArrivee)		//GAUCHE
			{
				for(int i = 1; i < deplacementColonne; i++)										
					if(jeu[ligneDepart][colonneDepart - i].estOccupee())
						return false;
			}
			else if(ligneDepart == ligneArrivee && colonneDepart < colonneArrivee)		//DROITE
			{
				for(int i = 1; i < deplacementColonne; i++)										
					if(jeu[ligneDepart][colonneDepart + i].estOccupee())
						return false;
			}
			else if(ligneDepart < ligneArrivee && colonneDepart < colonneArrivee)		//BAS ET DROITE
			{
				for(int i = 1; i < deplacementLigne; i++)
					if(jeu[ligneDepart + i][colonneDepart + i].estOccupee())
						return false;
			}
			else if(ligneDepart < ligneArrivee && colonneDepart > colonneArrivee)		//BAS ET GAUCHE
			{
				for(int i = 1; i < deplacementLigne; i++)
					if(jeu[ligneDepart + i][colonneDepart - i].estOccupee())
						return false;
			}
			else if(ligneDepart > ligneArrivee && colonneDepart > colonneArrivee)		//HAUT ET GAUCHE
			{
				for(int i = 1; i < deplacementLigne; i++)
					if(jeu[ligneDepart - i][colonneDepart - i].estOccupee())
						return false;
			}
			else if(ligneDepart > ligneArrivee && colonneDepart < colonneArrivee)		//HAUT ET DROITE
			{
				for(int i = 1; i < deplacementLigne; i++)
					if(jeu[ligneDepart - i][colonneDepart + i].estOccupee())
						return false;
			}
			else 
				return true;
		}
		else 
			return true;
		
		return false;

	}

	
	
	
	public boolean roisNePouvantPasEtreFaceAFace(Position depart, Position arrivee) 
	{

		return true;
	}
	
	

	
	
	public Intersection[][] getJeu() 
	{
		return jeu;
	}

}
