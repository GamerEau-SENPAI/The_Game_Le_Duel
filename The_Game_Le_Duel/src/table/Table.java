package table;
import java.util.Stack;







public class Table {
	private Stack<Integer> asc;
	private Stack<Integer> desc;
	private int carteasc;
	private int cartedesc;
	
	
	
	/**
	  * @brief Initialise une table
	  * @param[in-out] table : La table 
	  */
	public static void initialiseTable(Table table) {		
		table.asc = new Stack<Integer>();
		table.desc = new Stack<Integer>();
		table.asc.add(1);
		table.desc.add(60);	
		table.carteasc=0;
		table.cartedesc=0;
	}
	
	/**
	  * @brief ajoute une valeur � la pile descendante
	  * @param[in] value : la valeur � �tre ajout�
	  */
	public void descadd(int value) {
		this.desc.add(value);
	}
	
	
	/**
	  * @brief permet de voir la valeur en haut de la pile descendante
	  * @return La valeur en haut de la pile 
	  */
	public int descpeek() {
		return this.desc.peek();
	}
	
	
	/**
	  * @brief ajoute une valeur � la pile ascendente
	  * @param[in] value : la valeur � �tre ajout�
	  */
	public void ascadd(int value) {
		this.asc.add(value);
	}
	
	/**
	  * @brief permet de voir la valeur en haut de la pile ascendente
	  * @return La valeur en haut de la pile 
	  */
	public int ascpeek() {
		return this.asc.peek();
	}
	
	/**
	  * @brief Carte � �tre ajout� � la pile ascendente
	  * @param[in] value : la carte � �tre ajout�
	  */
	public void Lacarteascadd(int value) {
		this.carteasc= +value;
	}
	
	
	/**
	  * @brief Carte � �tre ajout� � la pile descendente
	  * @param[in] value : la carte � �tre ajout�
	  */
	public void Lacartedescadd(int value) {
		this.cartedesc= +value;
	}
	
	
	
	/**
	  * @brief V�rifie si on peut poser une carte(+10, ou -10 d'�cart) dans une table donn�
	  * @param[in] nombre : La carte � �tre pos�e
	  * @param[in] table : La table � prendre comme r�ference
	  * @param[in] asc : Si on cherche � incr�menter ou decrementer, si c'est ascendent ou pas
	  * @return True ou false
	  */
	public static boolean Verifpose (int nombre, Table table, boolean asc) { /**/
		
		if (asc) {
			int nombreverif = table.asc.peek();
			if(nombre>nombreverif || nombre==nombreverif-10) {
				return true;
			}
			return false;
		}
		int nombreverif = table.desc.peek();
		
		if(nombre<nombreverif || nombre==nombreverif+10) {
			
			return true;
		}
		return false;
	}
	
	
	
	
	/**
	  * @brief V�rifie si on peut poser une carte dans une table donn�
	  * @param[in] nombre : La carte � �tre pos�e
	  * @param[in] table : La table � prendre comme r�ference
	  * @param[in] asc : Si on cherche � incr�menter ou decrementer, si c'est ascendent ou pas
	  * @return True ou false
	  */
	public static boolean VerifposeInv (int nombre, Table table, boolean asc) {		
	if (asc) {			
		int nombreverif = table.asc.peek();			
		if(nombre<nombreverif) {				
			return true;
		}
		return false;
	}
	int nombreverif = table.desc.peek();			
	if(nombre>nombreverif) {			
		return true;
	}
	return false;
}
	
	
	/**
	  * @brief mets les cartes ascendentes et descendentes � 0
	  * @param[in] table : La table � prendre comme r�ference
	  */
	public static void Valider (Table table) { /**/
		table.carteasc=0;
		table.cartedesc=0;
	}
	
	
	
	/**
	  * @brief Pioche les cartes jou�es dans la table
	  * @param[in] table : La table � prendre comme r�ference
	  */
	public static void enlevercarte (Table table) {
		for(int i=0; i < table.carteasc; i++) {
			Pioche.piocher(table.asc);
		}
		for(int i=0; i < table.cartedesc; i++) {
			Pioche.piocher(table.desc);
		}
		Valider(table);	//Et � la fin on les mets � 0
	}
}
