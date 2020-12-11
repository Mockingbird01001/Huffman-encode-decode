package huffman;

public class Feuille_Arbre {
	
	public int freq;
	public Arbre arbre;
	
	public Feuille_Arbre(int occurances, Arbre arbre) {
		this.freq = occurances;
		this.arbre = arbre;
	}
}