package apj.p2;

public class Ville {

	protected String nomVille, nomPays;
	protected char categorie;
	protected int nbreHabitants;
	
	
	public Ville () {
		
		this.nomVille = "Inconnu";
		this.nomPays = "Inconnu";
		this.nbreHabitants = 0;
		this.setCategorie();
		
	}
	
	public Ville(String nomVille,int nbreHabitants,String nomPays)  throws  NombreHabitantException, NomVilleException
	{  
		  if(nbreHabitants < 0)
		    throw new NombreHabitantException(nbreHabitants);
		          
		  if(nomVille.length() < 3)
		    throw new NomVilleException("le nom de la ville est inf�rieur � 3 caract�res ! nom = " + nomVille);
		  else
		  {
		    this.nomVille = nomVille;
		    this.nomPays = nomPays;
		    this.nbreHabitants = nbreHabitants;
		    this.setCategorie();
		  }          
		}
	
	public String getNomVille() {
	
		return this.nomVille;
	}
	
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	
	public String getNomPays() {
		
		return this.nomPays;
	}
	
	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}
	
	public int getNbreHabitants() {
		return this.nbreHabitants;
	}
	
	public void setNbreHabitants(int nbreHabitants) {
		this.nbreHabitants = nbreHabitants;
	}

	
	
	  //D�finit la cat�gorie de la ville
	  private void setCategorie() {
	 
	    int bornesSuperieures[] = {0, 1000, 10000, 100000, 500000, 1000000, 5000000, 10000000};
	    char categories[] = {'?', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

	    int i = 0;
	    while (i < bornesSuperieures.length && this.nbreHabitants > bornesSuperieures[i])
	      i++;

	    this.categorie = categories[i];
	  }

	  //Retourne la description de la ville
	  public String decrisToi() {
	    return "\t"+this.nomVille+" est une ville de "+this.nomPays+ ", elle comporte : "+this.nbreHabitants+" habitant(s) => elle est donc de cat�gorie : "+this.categorie;
	  }
	  public String toString(){
		  return "\t"+this.nomVille+" est une ville de "+this.nomPays+", elle comporte : "+this.nbreHabitants+" => elle est donc de cat�gorie : "+this.categorie;
	  }	  

	  //Retourne une cha�ne de caract�res selon le r�sultat de la comparaison
	  public String comparer(Ville v1){
	    String str = new String();

	    if (v1.getNbreHabitants() > this.nbreHabitants)
	      str = v1.getNomVille()+" est une ville plus peupl�e que "+this.nomVille;
	     
	    else
	      str = this.nomVille+" est une ville plus peupl�e que "+v1.getNomVille();
	     
	    return str;
	  }
}
