package huffman;

public class Feuille extends Arbre {
	
	public char lettre;
	public Arbre racine;
	
	public Feuille(char lettre) {
		this.lettre = lettre;
		this.racine = null;
	}
	
	public void afficheCode(String code) {
		Arbre.encode.put(lettre, code);
	    System.out.println(this.lettre + " --> " + code);
	}
	
	public void CompleterRacine(Arbre racine) {
	    this.racine = racine; 
	}
	
	public String Decoder(String encodage, int i) {
	    return (this.lettre + this.racine.Decoder(encodage, i));
	}

	public String Encoder(String chaine, int i) {
		return (this.lettre + this.racine.Encoder(chaine, i));
	}
}