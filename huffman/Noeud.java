package huffman;

public class Noeud extends Arbre {
	
	public Arbre feuilleG, feuilleD;
	
	public Noeud(Arbre Agauche, Arbre Adroit) {
		feuilleG = Agauche; 
		feuilleD = Adroit;
	}
	
	public void afficheCode(String code) {
		feuilleG.afficheCode(code + '0');
		feuilleD.afficheCode(code + '1');
	}
	
	public void CompleterRacine(Arbre racine) {
	    feuilleG.CompleterRacine(racine); 
	    feuilleD.CompleterRacine(racine); 
	}
	
	public String Decoder(String encodage, int i) {
	    if (i >= encodage.length()) return "";
	    return (encodage.charAt(i) == '0')? feuilleG.Decoder(encodage, i+1): feuilleD.Decoder(encodage, i+1);
	}

	public String Encoder(String chaine, int i) {
		if (i >= chaine.length()) return "";
		return Arbre.encode.get(chaine.charAt(i)) + this.Encoder(chaine, i+1);
	}
}
