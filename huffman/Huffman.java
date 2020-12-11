package huffman;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class Huffman {
	
	HashMap<Character, Integer> huffman;
	HashMap<Character, String> encode;
	
	public Huffman(String chaine) {
		this.huffman = this.lecteurChaine(chaine);
	}
	
	private HashMap<Character, Integer> lecteurChaine(String chaine) {
		System.out.println("Detections des lettres & probas d'appritions...");
		HashMap<Character, Integer> hc = new HashMap<>();
		for(int i=0; i< chaine.length(); i++) {
			hc.put(chaine.charAt(i), countOccurences(chaine, chaine.charAt(i), 0));
		}
		return hc;
	}
	
	private int countOccurences(String chaine, char lettre, int index) {
		if (index >= chaine.length()) {return 0;}
		int count = (chaine.charAt(index) == lettre) ? 1 : 0;
		return count + countOccurences(chaine, lettre, index + 1);
	}

	public Arbre CodeHuffman(char[] keys, int[] values) {
    	Code liste = new Code();
		
    	/*######### AJOUT DES NOEUDS ##################*/
		for (int i=0; i<keys.length; i++) {liste.Ajouter(new Feuille(keys[i]), values[i]);}
		
		Feuille_Arbre paire1, paire2;
		
		while (liste.taille > 1) {
		    paire1 = liste.ExtraireMin();
		    paire2 = liste.ExtraireMin();
		    liste.Ajouter(new Noeud(paire1.arbre, paire2.arbre), paire1.freq + paire2.freq);
		}
		
		paire1 = liste.ExtraireMin();
		Arbre arbre_Final = paire1.arbre; 
		arbre_Final.CompleterRacine(arbre_Final);
		return arbre_Final;
    }
	
	public String Decoder(String codeBinaire,Arbre code) {
    	return code.Decoder(codeBinaire, 0);
    }
	
	public String Encoder(String chaine,Arbre code) {
    	return code.Encoder(chaine, 0);
    }

	public int[] getValues(Collection<Integer> chaine) {
		String str = Arrays.toString(chaine.stream().mapToInt(Integer::intValue).toArray());
		return Arrays.stream(str.substring(1, str.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
	}

	public char[] getKeys(Set<Character> keySet) {
		return keySet.stream().map(String::valueOf).collect(Collectors.joining()).toCharArray();
	}
	
}