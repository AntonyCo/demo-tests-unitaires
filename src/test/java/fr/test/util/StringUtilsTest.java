package fr.test.util;

import fr.dev.util.StringUtils;

/**
 * 	a) Votre classe de tests doit générer une exception dès qu’un test ne passe pas.
	b) Ne mettez votre classe de tests dans les livrables du projet.
	a. Pensez à une configuration MAVEN spécifique pour les classes de tests.
	c) Couvrez un maximum d’exemples (i.e. cas de tests)
	d) Intéressez-vous également à la robustesse de cette classe. Que se passe t’il si on passe à cette
	classe des paramètres NULL ? Proposez un correctif pour rendre cette classe plus robuste.
 * @author Antony
 *
 */
public class StringUtilsTest {
	private CharSequence rightCharSequence;
	private CharSequence leftCharSequence;
	
	private int count;
	private int validCount;
	
	public StringUtilsTest() throws Exception{
		count = 0;
		validCount = 0;
		
		rightCharSequence = "chat";
		leftCharSequence = "chats";
		validTest(StringUtils.levenshteinDistance(leftCharSequence, rightCharSequence), 1);
		//--------------------------------------------------------------------
		rightCharSequence = "machins";
		leftCharSequence = "machine";
		validTest(StringUtils.levenshteinDistance(leftCharSequence, rightCharSequence), 1);
		//--------------------------------------------------------------------
		rightCharSequence = "aviron";
		leftCharSequence = "avion";
		validTest(StringUtils.levenshteinDistance(leftCharSequence, rightCharSequence), 1);
		//--------------------------------------------------------------------
		rightCharSequence = "truc";
		leftCharSequence = "#ru-";
		validTest(StringUtils.levenshteinDistance(leftCharSequence, rightCharSequence), 2);
		//--------------------------------------------------------------------
		rightCharSequence = "distance";
		leftCharSequence = "instance";
		validTest(StringUtils.levenshteinDistance(leftCharSequence, rightCharSequence), 2);
		//--------------------------------------------------------------------
		rightCharSequence = "Chien";
		leftCharSequence = "Chine";
		validTest(StringUtils.levenshteinDistance(leftCharSequence, rightCharSequence), 2);
		//--------------------------------------------------------------------
		rightCharSequence = null;
		leftCharSequence = "Chine";
		validTest(StringUtils.levenshteinDistance(leftCharSequence, rightCharSequence), 5);
		//--------------------------------------------------------------------
		rightCharSequence = "Chien";
		leftCharSequence = null;
		validTest(StringUtils.levenshteinDistance(leftCharSequence, rightCharSequence), 5);
		//--------------------------------------------------------------------
		rightCharSequence = null;
		leftCharSequence = null;
		validTest(StringUtils.levenshteinDistance(leftCharSequence, rightCharSequence), 0);
		//--------------------------------------------------------------------
		rightCharSequence = "aaaa";
		leftCharSequence = "aaab";
		validTest(StringUtils.levenshteinDistance(leftCharSequence, rightCharSequence), 0);
		//--------------------------------------------------------------------
		rightCharSequence = "aze";
		leftCharSequence = "aze";
		validTest(StringUtils.levenshteinDistance(leftCharSequence, rightCharSequence), 1);
		
		System.out.println("NUMBER OF TEST "+count+" :: "+validCount+" TESTS PASSED !");
	}
	
	private void validTest(int range, int expectedValue) throws Exception{
		count++;
		//CHANGE NULL TO ""
		if(leftCharSequence == null){
			leftCharSequence ="";
		}
		if(rightCharSequence == null){
			rightCharSequence = "";
		}
		StringBuilder strb = new StringBuilder();
		strb.append(count);
		strb.append(" - TEST levenshtein distance with values: [");
		strb.append(leftCharSequence);
		strb.append(",");
		strb.append(rightCharSequence);
		strb.append("] :: ");
		
		if(range != expectedValue){
			strb.append("TEST IS NOT VALID !");
			System.err.println(strb);
			
			strb.setLength(0);
			strb.append("Range is ");
			strb.append(range);
			strb.append(" Expected value : ");
			strb.append(expectedValue);
			System.err.println(strb);
			throw new Exception("Failed test !");
		}else{
			validCount++;
			strb.append("TEST IS VALID.");
		}
		System.out.println(strb);
	}
}
