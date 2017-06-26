package routines;

public class TelL1 {
	
	public static void main(String[] args) {
		//[tel={externe}0320335577{interne}35577{principal}O][role=]    [local=  {struct} ZZA00  {local}]
	   String[] tab = TelL1.ExtraireTelephoneL1("[tel={externe}0320335577{interne}35577{principal}O][role=][local={struct}ZZA00{local}]");
	   System.out.println(tab[0]);System.out.println(tab[1]);System.out.println(tab[2]); System.out.println(tab[3]);
	   System.out.println(tab[4]); System.out.println(tab[5]);
	   System.out.println("--------------------------------------------------------------------------------");
	   String[] tab2 = TelL1.ExtraireTelephoneL1("[tel={externe}{interne}{principal}][role=][local={struct}ZZA00{local}]");
	   System.out.println(tab2[0]);System.out.println(tab2[1]);System.out.println(tab2[2]); System.out.println(tab2[3]);
	   System.out.println(tab2[4]); System.out.println(tab2[5]);
	   System.out.println("--------------------------------------------------------------------------------");
	   String[] tab3 = TelL1.ExtraireTelephoneL1("[tel=][role=][local={struct}ZZA00{local}]");
	   System.out.println(tab3[0]);System.out.println(tab3[1]);System.out.println(tab3[2]); System.out.println(tab3[3]);
	   System.out.println(tab3[4]); System.out.println(tab3[5]);
	   System.out.println("--------------------------------------------------------------------------------");
	   String[] tab4 = TelL1.ExtraireTelephoneL1("");
	   System.out.println(tab4[0]);System.out.println(tab4[1]);System.out.println(tab4[2]); System.out.println(tab4[3]);
	   System.out.println(tab4[4]); System.out.println(tab4[5]);
	}
	
	public static String[] ExtraireTelephoneL1(String chaine) {
		String[] result = new String[6];
		result[0] = ""; result[1] = ""; result[2] = ""; result[3] = ""; result[4] = ""; result[5] = "";

		String[] elt = chaine.split("\\]\\[");
		
		
		if(elt.length == 0 || elt == null){
			return result;
		}
		// Telephone
		if (elt.length >= 1) {
			String[] elt1 = elt[0].split("\\{");
			
			if (elt1.length >= 2)
				result[0] = elt1[1].substring(8);
			if (elt1.length >= 3)
				result[1] = elt1[2].substring(8);
			if (elt1.length >= 4)
				result[2] = elt1[3].substring(10);
		}
		// Fonction
		if (elt.length >= 2) {
			result[3] = elt[1].substring(5);
		}
		
		// Local
		if (elt.length >= 3) {
			String[] elt2 = elt[2].split("\\{");
			if (elt2.length >= 2)
				result[4] = "STL1" + elt2[1].substring(7);
			if (elt2.length >= 3)
				result[5] = elt2[2].substring(6, elt2[2].length() - 1);
		}
		return result;
	}


}
