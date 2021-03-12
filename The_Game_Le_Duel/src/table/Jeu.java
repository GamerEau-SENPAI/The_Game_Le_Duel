package table;


import joueur.AttributsJoueur;
import joueur.Main;



public class Jeu {
	
	/**
	  * @brief V�rifie si une carte est jouable
	  * @param[in] joueur : le joueur � �tre v�rifi�
	  * @param[in] table : la table � �tre examin�
	  * @return true et false
	  */
	public static int CarteJouable(AttributsJoueur joueur, Table oppos�) {
		int retour = 0;
		boolean inv = true;
		for (int i = 0; i<6; i++) {
			if(AttributsJoueur.main(joueur,i)!=0 && (AttributsJoueur.main(joueur,i)<AttributsJoueur.tabledesc(joueur) || AttributsJoueur.main(joueur,i)>AttributsJoueur.tabledesc(joueur))) {
				retour += 1;
			}
			else if (AttributsJoueur.main(joueur,i)!=0 && inv && (AttributsJoueur.main(joueur,i)>oppos�.descpeek() || AttributsJoueur.main(joueur,i)<oppos�.ascpeek())) {
				inv=false;
				retour += 1;
			}
		}
		return retour;
		
	}
	
	/**
	  * @brief V�rifie la condition de d�faite (Joueur qui ne peut pas jouer)
	  * @param[in] joueur : le joueur � �tre v�rifi�
	  * @param[in] table : la table � �tre examin�
	  * @return true et false
	  */
	public static boolean ConditionDefaite(AttributsJoueur joueur, Table oppos�) {
		int nmbCarte = Main.nmbCarteMain(AttributsJoueur.main(joueur));
		int jouable = 0;
		if (nmbCarte==1) return true;
		jouable += CarteJouable(joueur, oppos�);
		if (jouable>1) return false;
		return true;
	}
	
	
	/**
	  * @brief V�rifie la condition de victoire 
	  * @param[in] joueur : le joueur � �tre v�rifi�
	  * @return true et false
	  */
	public static boolean ConditionVictoire(AttributsJoueur joueur) { 
		if(Main.nmbCarteMain(AttributsJoueur.main(joueur))==0) return true;
		return false;
	}
	

}
