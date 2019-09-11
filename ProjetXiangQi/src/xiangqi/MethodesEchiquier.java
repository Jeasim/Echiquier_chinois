package xiangqi;

public interface MethodesEchiquier 
{
public abstract void debuter();
public abstract Intersection getIntersection( int ligne, int colonne );
public abstract boolean cheminPossible ( Position  depart , Position arrivee);
public abstract boolean roisNePouvantPasEtreFaceAFace ( Position depart,Position arrivee );
}