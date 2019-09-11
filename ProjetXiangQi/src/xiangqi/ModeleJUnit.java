package xiangqi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ModeleJUnit 
{
	private Roi rNoir, rRouge;
	private Mandarin mNoir, mRouge;
	//private Char tNoir, tRouge;
	private Elephant eNoir, eRouge;
	private Cavalier cNoir, cRouge;
	private Pion pNoir, pRouge;
	private Bombarde bNoir, bRouge;
	
	
@Before
public void initialisation()
{
	rNoir = new Roi("rNoir", "noir");
	rRouge = new Roi("rRouge", "rouge");
	
	mNoir = new Mandarin("mNoir", "noir");
	mRouge = new Mandarin("mRouge", "rouge");
	
	//tNoir = new Char("tNoir","noir");
	//tRouge = new Char("tRouge","rouge");
	
	eNoir = new Elephant("eNoir","noir");
	eRouge = new Elephant("eRouge","rouge");

	cNoir = new Cavalier("cNoir","noir");
	cRouge = new Cavalier("cRouge","rouge");

	pNoir = new Pion("pNoir","noir");
	pRouge = new Pion("pRouge","rouge");
	
	bNoir = new Bombarde("bNoir","noir");	
	bRouge = new Bombarde("bRouge","rouge");
	
}

//------------------------------------------------------------------------------PION NOIR
@Test
	public void testEstValide_PionNoir_Avance()
	{
		Position depart = new Position(1,1);
		Position arrivee = new Position(2,1);
	assertEquals (true, pNoir.estValide(depart, arrivee));
	}

@Test
	public void testEstValide_PionNoir_Recule()			
	{
		Position depart = new Position(0,1);
		Position arrivee = new Position(2,1);
	assertEquals (false, pNoir.estValide(depart, arrivee));
	}

@Test
	public void testEstValide_PionNoir_Droite_Zone()						
	{
		Position depart = new Position(1,1);
		Position arrivee = new Position(1,2);
	assertEquals (false, pNoir.estValide(depart, arrivee));
	}

@Test
	public void testEstValide_PionNoir_Droite_NonZone()			
	{
		Position depart = new Position(5,1);
		Position arrivee = new Position(5,2);
	assertEquals (true, pNoir.estValide(depart, arrivee));
	}

@Test
	public void testEstValide_PionNoir_Droite_ET_Bas_NonZone()			
	{
		Position depart = new Position(5,1);
		Position arrivee = new Position(6,2);
	assertEquals (false, pNoir.estValide(depart, arrivee));
	}

@Test
	public void testEstValide_PionNoir_Pas_Deplacement()			
	{
		Position depart = new Position(2,1);
		Position arrivee = new Position(2,1);
	assertEquals (true, pNoir.estValide(depart, arrivee));
	}

//------------------------------------------------------------------------------PION ROUGE
@Test
	public void testEstValide_PionRouge()
	{
		Position depart = new Position(2,1);
		Position arrivee = new Position(2,2);
	assertEquals (true, pRouge.estValide(depart, arrivee));
	}

@Test
	public void testEstValide_PionRouge_Recule()
	{
		Position depart = new Position(7,4);
		Position arrivee = new Position(8,4);
	assertEquals (false, pRouge.estValide(depart, arrivee));
	}

//------------------------------------------------------------------------------ MANDARIN NOIR

@Test
	public void testEstValide_MandarinNoir()
	{
		Position depart = new Position(1,3);
		Position arrivee = new Position(2,4);
	assertEquals (true, mNoir.estValide(depart, arrivee));
	}

@Test
	public void testEstValide_MandarinNoir_HorsPalais()
	{
		Position depart = new Position(3,3);
		Position arrivee = new Position(4,4);
	assertEquals (false, mNoir.estValide(depart, arrivee));
	}


//------------------------------------------------------------------------------ MANDARIN ROUGE
@Test
	public void testEstValide_MandarinRouge()
	{
		Position depart = new Position(7,3);
		Position arrivee = new Position(8,4);
	assertEquals (true, mRouge.estValide(depart, arrivee));
	}

@Test
	public void testEstValide_MandarinRouge_Droite()
	{
		Position depart = new Position(7,3);
		Position arrivee = new Position(7,4);
	assertEquals (false, mRouge.estValide(depart, arrivee));
	}

@Test
	public void testEstValide_MandarinRouge_Gauche()
	{
		Position depart = new Position(7,3);
		Position arrivee = new Position(7,2);
	assertEquals (false, mRouge.estValide(depart, arrivee));
	}

//------------------------------------------------------------------------------ ROI NOIR
@Test
	public void testEstValide_RoiNoir()
	{
		Position depart = new Position(1,3);
		Position arrivee = new Position(1,4);
	assertEquals (true, rNoir.estValide(depart, arrivee));
	}

@Test
	public void testEstValide_RoiNoir2()
	{
		Position depart = new Position(1,3);
		Position arrivee = new Position(2,4);
	assertEquals (true, rNoir.estValide(depart, arrivee));
	}

//------------------------------------------------------------------------------ ROI ROUGE
@Test
	public void testEstValide_RoiRouge()
	{
		Position depart = new Position(8,3);
		Position arrivee = new Position(9,3);
	assertEquals (true, rRouge.estValide(depart, arrivee));
	}

@Test
	public void testEstValide_RoiRouge_Diagonale2Cases()
	{
		Position depart = new Position(7,3);
		Position arrivee = new Position(5,5);
	assertEquals (false, rRouge.estValide(depart, arrivee));
	}

@Test
	public void testEstValide_RoiRouge_HorsPalais()
	{
		Position depart = new Position(7,3);
		Position arrivee = new Position(7,2);
	assertEquals (false, rRouge.estValide(depart, arrivee));
	}


//------------------------------------------------------------------------------ CAVALIER NOIR
@Test
	public void testEstValide_CavalierNoir()
	{
		Position depart = new Position(8,9);
		Position arrivee = new Position(7,7);
	assertEquals (true, cNoir.estValide(depart, arrivee));
	}

@Test
	public void testEstValide_CavalierNoir2()
	{
		Position depart = new Position(3,6);
		Position arrivee = new Position(1,5);
	assertEquals (true, cNoir.estValide(depart, arrivee));
	}


@Test
	public void testEstValide_CavalierNoir3()
	{
		Position depart = new Position(9,4);
		Position arrivee = new Position(8,5);
	assertEquals (false, cNoir.estValide(depart, arrivee));
	}
//------------------------------------------------------------------------------ CAVALIER ROUGE
@Test
	public void testEstValide_CavalierRouge()
	{
		Position depart = new Position(8,9);
		Position arrivee = new Position(8,9);
	assertEquals (true, cRouge.estValide(depart, arrivee));
	}

//------------------------------------------------------------------------------ ELEPHANT NOIR
@Test
	public void testEstValide_ElephantNoir()
	{
		Position depart = new Position(4,9);
		Position arrivee = new Position(2,7);
	assertEquals (true, eNoir.estValide(depart, arrivee));
	}

@Test
	public void testEstValide_ElephantNoir2()
	{
		Position depart = new Position(3,9);
		Position arrivee = new Position(5,7);
	assertEquals (false, eNoir.estValide(depart, arrivee));
	}

//------------------------------------------------------------------------------ ELEPHANT ROUGE
@Test
	public void testEstValide_ElephantRouge()
	{
		Position depart = new Position(5,8);
		Position arrivee = new Position(3,6);
	assertEquals (false, eRouge.estValide(depart, arrivee));
	}

//------------------------------------------------------------------------------ BOMBARDE NOIR
@Test
	public void testEstValide_BombardeNoir()
	{
		Position depart = new Position(6,9);
		Position arrivee = new Position(6,3);
	assertEquals (true, bNoir.estValide(depart, arrivee));
	}

//------------------------------------------------------------------------------ BOMBARDE ROUGE
@Test
	public void testEstValide_BombardeRouge()
	{
		Position depart = new Position(2,3);
		Position arrivee = new Position(4,3);
	assertEquals (true, bRouge.estValide(depart, arrivee));
	}


}
