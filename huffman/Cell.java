package huffman;

public class Cell {
	Feuille_Arbre paire;
    Cell suiv;
    
    public Cell(int occurance, Arbre arbre, Cell nextUp) {
    	this.paire = new Feuille_Arbre(occurance, arbre); 
    	this.suiv = nextUp;
    }
}