package huffman;

public class Code {
	
	Cell premier;
	int taille;

	public Code() {
		this.premier = null; 
		this.taille = 0;
	}
	
	private void setTaille(int i) {
		this.taille = i;
	}
	
	public int getTaille() {
		return this.taille;
	}
	
	public void Ajouter(Arbre arbre, int occurance) {
	    this.setTaille(this.getTaille()+1);
	    
	    if (premier == null) {
	    	premier = new Cell(occurance, arbre, null);
	    }else if (this.premier.paire.freq >= occurance) {
	    	premier = new Cell(occurance, arbre, this.premier);
	    	return;
	    }else { 
	    	Cell prec = null, aux = this.premier;
	    	while (aux != null && aux.paire.freq < occurance) {
	    		prec = aux;
	    		aux = aux.suiv;
	    	}
	    	prec.suiv = new Cell(occurance, arbre, aux);
	    }
	}

	public Feuille_Arbre ExtraireMin() {
	    if (this.premier == null) {
	    	System.out.println("La liste est vide !");
	    	return new Feuille_Arbre(0,null);
	    }
	    this.setTaille(this.getTaille()-1);
	    Feuille_Arbre paire = this.premier.paire;
	    this.premier = this.premier.suiv;
	    return paire;
	    
	}
}