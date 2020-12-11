package huffman;

import java.util.Scanner;

public class Test_Huffman {

	public static void main(String arg[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Donner une chaine a encoder: ");
		String chaine = sc.nextLine();
		sc.close();
		
		Huffman huffman = new Huffman(chaine);
		
		System.out.println("lettres: " + huffman.huffman.toString()+"\n");
		
		Arbre arbre = huffman.CodeHuffman(huffman.getKeys(huffman.huffman.keySet()), huffman.getValues(huffman.huffman.values()));
		
		System.out.println("Generation de l'arbre...");
		arbre.affiche();
		
		String codeChaine = huffman.Encoder(chaine, arbre);
		
		//############## ENCODAGE ###############
		System.out.println("\nEncodage de la chaine...");
		System.out.println("Chaine:   " + chaine);
		System.out.println("Encodage: " + codeChaine);
		
		//############## DECODAGE ###############
		System.out.println("\nTest de decodage...");
		System.out.println("Decodage: " + codeChaine);
		System.out.println("resultat: " + huffman.Decoder(codeChaine, arbre));
	}
}