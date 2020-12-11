package huffman;

import java.util.HashMap;

public abstract class Arbre {
	
	public static HashMap<Character, String> encode = new HashMap<>();
	
	public void affiche() {afficheCode("");}
	public abstract void afficheCode(String s);
	public abstract void CompleterRacine(Arbre r);
	public abstract String Decoder(String encodage, int i);
	public abstract String Encoder(String chaine, int i);
}
