package xiangqi;

public class Intersection 
{
	private Piece piece;
	


	public Intersection()
	{
		piece = null;
	}
	
	public Intersection(Piece piece)
	{
		this.piece = piece;		
	}

	
	public boolean estOccupee()
	{
		if(piece != null)
			return false;
		else
			return true;
	}
	
	public boolean estOccupeeAdversaire(String couleur)
	{
		if(piece != null && piece.getCouleur() != piece.getCouleur())
			return true;
		else 
			return false;
	}
	
	public void setPiece(Piece piece) 
	{
		this.piece = piece;
	}
	
	public Piece getPiece() 
	{
		return piece;
	}
	
}
