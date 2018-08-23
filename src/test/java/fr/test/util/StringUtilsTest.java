package fr.test.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import fr.dev.util.StringUtils;
@RunWith(Parameterized.class)
public class StringUtilsTest {

	@Parameters
	public static Collection<Object[]> datas(){
		List<Object[]> datas = new ArrayList<Object[]>();
		datas.add(new Object[]{1, "chat", "chats"});
		datas.add(new Object[]{0, null, null});
		datas.add(new Object[]{5, null, "chats"});
		datas.add(new Object[]{2, "abaa", "aaab"});
		return datas;
	}
	
	@Parameter
	public int expectedValue;
	@Parameter(value = 1)
	public CharSequence lch;
	@Parameter(value = 2)
	public CharSequence rch;
	
	@Test
	public void testLevenshteinDistance(){
		Assert.assertEquals(expectedValue, StringUtils.levenshteinDistance(lch, rch));
	}
}
