package demo_tests_unitaires.demo_tests_unitaires;

import fr.dev.util.StringUtils;
import fr.test.util.StringUtilsTest;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println(StringUtils.levenshteinDistance("", "instance"));
		new StringUtilsTest();
    }
}
