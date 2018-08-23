package demo_tests_unitaires.demo_tests_unitaires;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.test.util.StringUtilsTest;

@RunWith(Suite.class)
@SuiteClasses(value = {StringUtilsTest.class})
public class AppTest{
	
}
