package xiangqi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPartie1Prof {

	Roi r1, r2;
	Mandarin m1, m2;
	Cavalier c1;
	Elephant e1, e2;
	Bombarde b1;
	Pion p1, p2;

	 @Before
	   public void initialisation () {
	     r1 = new Roi ( "r", "noir");
	     r2 = new Roi ( "r", "rouge");
	     m1 = new Mandarin("m1", "noir");
	     m2 = new Mandarin ( "m2", "rouge");
	     e1 = new Elephant("e1", "rouge");
	     e2 = new Elephant("e2", "noir");
	     b1 = new Bombarde("b1", "noir");
	     p1 = new Pion("p1", "noir");
	     c1 = new Cavalier("c1", "noir");
	     p2 = new Pion("p3", "rouge");
	   }
	 
	 @Test 
	 public void testRoi1() //roi ne peut pas sortir du palais
	 {
		 Position depart = new Position ( 2, 4);
		 Position arrivee = new Position ( 3, 4);
		 assertEquals ( false, r1.estValide(depart, arrivee));
	 }
	 @Test 
	 public void testRoi2() //roi ne peut pas se déplacer en diagonale
	 {
		 Position depart = new Position ( 0, 4);
		 Position arrivee = new Position ( 1, 5);
		 assertEquals ( false, r1.estValide(depart, arrivee));
	 } 
	 @Test 
	 public void testRoi3() //roi se déplace dans son palais
	 {
		 Position depart = new Position ( 9, 3);
		 Position arrivee = new Position ( 8, 3);
		 assertEquals ( true, r2.estValide(depart, arrivee));
	 }
	 
	 @Test 
	 public void testRoiNeBougePas()  // Roi ne se déplace pas
	 {
		 Position depart = new Position ( 8, 4);
		 Position arrivee = new Position ( 8, 4);
		 assertEquals ( true, r2.estValide(depart, arrivee));
	 }
	 
	 @Test 
	 public void testMandarin1()  // Mandarin doit demeurer dans le palais 
	 {
		 Position depart = new Position ( 2, 6);
		 Position arrivee = new Position ( 1, 7);
		 assertEquals ( false, m1.estValide(depart, arrivee));
	 }
	 @Test 
	 public void testMandarin2()  // Mandarin doit se déplacer en diagonale
	 {
		 Position depart = new Position ( 9, 3);
		 Position arrivee = new Position ( 8, 4);
		 assertEquals ( true, m2.estValide(depart, arrivee));
	 }
	 @Test 
	 public void testCavalier1()  // bon déplacement du Cavalier
	 {
		 Position depart = new Position ( 3, 6);
		 Position arrivee = new Position ( 1, 7);
		 assertEquals ( true, c1.estValide(depart, arrivee));
	 }
	 @Test 
	 public void testCavalier2()  // déplacement nul = bon
	 {
		 Position depart = new Position ( 8, 4);
		 Position arrivee = new Position (8 , 4);
		 assertEquals ( true, c1.estValide(depart, arrivee));
	 }
	 
	 @Test 
	 public void testElephant1()  // bon déplacement de l'Elephant
	 {
		 Position depart = new Position ( 9, 2);
		 Position arrivee = new Position ( 7, 0);
		 assertEquals ( true, e1.estValide(depart, arrivee));
	 }
	 @Test 
	 public void testElephant2()  // mauvais déplacement 
	 {
		 Position depart = new Position ( 0, 6);
		 Position arrivee = new Position (1 , 5);
		 assertEquals ( false, e2.estValide(depart, arrivee));
	 }
	 
	 @Test 
	 public void testBombarde()  // bon déplacement 
	 {
		 Position depart = new Position ( 4, 6);
		 Position arrivee = new Position (1 , 6);
		 assertEquals ( true, b1.estValide(depart, arrivee));
	 }
	 @Test 
	 public void testPion1()  // pion ne peut pas reculer
	 {
		 Position depart = new Position ( 4, 2);
		 Position arrivee = new Position (3 , 2);
		 assertEquals ( false, p1.estValide(depart, arrivee));
	 }
	 @Test 
	 public void testPion2()  // pion doit demeurer dans la même colonne de son côté
	 {
		 Position depart = new Position ( 2, 1);
		 Position arrivee = new Position (3 , 2);
		 assertEquals ( false, p1.estValide(depart, arrivee));
	 }
	 @Test 
	 public void testPion3()  //déplacement latéral de l'autre côté
	 {
		 Position depart = new Position ( 5, 6);
		 Position arrivee = new Position (5 , 7);
		 assertEquals ( true, p1.estValide(depart, arrivee));
	 }
	 @Test 
	 public void testPion4()  // ne peut pas se déplacer latéralemeent de son côté
	 {
		 Position depart = new Position ( 7, 1);
		 Position arrivee = new Position (7 , 2);
		 assertEquals ( false, p2.estValide(depart, arrivee));
	 }
	 @Test 
	 public void testPion5()  // bon déplacement 
	 {
		 Position depart = new Position (6,7);
		 Position arrivee = new Position (5,7);
		 assertEquals ( true, p2.estValide(depart, arrivee));
	 }
	 @Test 
	 public void testPionNeBougePas()  // bon déplacement 
	 {
		 Position depart = new Position ( 6, 4);
		 Position arrivee = new Position (6 , 4);
		 assertEquals ( true, p2.estValide(depart, arrivee));
	 }
	 
	 
	 
	 
	 




}
