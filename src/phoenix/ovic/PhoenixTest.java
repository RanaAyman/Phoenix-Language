package phoenix.ovic;

import static org.junit.jupiter.api.Assertions.*;

import java.io.StringReader;

import org.junit.jupiter.api.Test;

class PhoenixTest {

	public boolean Validate(String str) {
		StringReader sr = new StringReader(str);
		Phoenix Test= new Phoenix(sr);
		boolean flag=false;
		try {
	           Test.start();
	           flag= true;
	         }catch(ParseException e){
	        	flag = false;
	         }
		return flag;
	}
	
	@Test
	void test1() {
		System.out.println("Test 1");
		PhoenixTest Test = new PhoenixTest();
		String str ="if (!ff^tt) then skip else skip";
		assertTrue(Test.Validate(str));
	}
	
	@Test
	void test2() {
		System.out.println("Test 2");
		PhoenixTest Test = new PhoenixTest();
		String str ="a:=5 ; b:=(5 + 7)";
		assertTrue(Test.Validate(str));
	}
	
	@Test
	void test3() {
		System.out.println("Test 3");
		PhoenixTest Test = new PhoenixTest();
		String str ="a:=5 ; while ((a == 5) ^ !ff ^ tt) do skip";
		assertTrue(Test.Validate(str));
	}
	
	@Test
	void test4() {
		System.out.println("Test 4");
		PhoenixTest Test = new PhoenixTest();
		String str ="a:=5 ; if (a == 9) then b:=3 else d:=2 ; c:=(a-d)";
		assertTrue(Test.Validate(str));
	}
	
	@Test
	void test5() {
		System.out.println("Test 5");
		PhoenixTest Test = new PhoenixTest();
		String str ="f:=2 ; c:=(7 - 5) ; while ((f == c) ^ !ff) do c:=(c-2)";
		assertTrue(Test.Validate(str));
	}
	
	@Test
	void test6() {
		System.out.println("Test 6");
		PhoenixTest Test = new PhoenixTest();
		String str1 ="fa:=442 ; ca:=fa ";
		assertTrue(Test.Validate(str1));

	}
	
	@Test
	void test7() {
		System.out.println("Test 7");
		PhoenixTest Test = new PhoenixTest();
		String str1 ="b:=3 ; d:= ((a) - (b+c))";
		String str2 ="b:=3 ; d:= ((b+d) - (b+c))";
		assertTrue(Test.Validate(str1));
		assertTrue(Test.Validate(str2));
	}
	
	@Test
	void test8() {
		System.out.println("Test 8");
		PhoenixTest Test = new PhoenixTest();
		String str1 ="skip;skip";
		String str2 ="skip;";
		assertTrue(Test.Validate(str1));
		assertFalse(Test.Validate(str2));
	}

	@Test
	void test9() {
		System.out.println("Test 9");
		PhoenixTest Test = new PhoenixTest();
		String str1 ="d:=5 ; e:=(5 + 7);";
		String str3 ="d:=5   e:= (5 + 7)";
		String str4 ="d =5 ;  e:= (5 + 7)";
		String str5 ="d: 5 ;  e:= (5 + 7)";
		assertFalse(Test.Validate(str1));

		assertFalse(Test.Validate(str3));
		assertThrows(TokenMgrError.class, () -> {
			Test.Validate(str4);
	    });
		assertThrows(TokenMgrError.class, () -> {
			Test.Validate(str5);
	    });
	}
	@Test
	void test10() {
		System.out.println("Test 10");
		PhoenixTest Test = new PhoenixTest();
		String str ="z:= (5 + 5)";
		assertThrows(TokenMgrError.class, () -> {
			Test.Validate(str);
	    });
	}
	
	@Test
	void test11() {
		System.out.println("Test 11");
		PhoenixTest Test = new PhoenixTest();
		String str ="a:= (5 + - 5)";
		assertFalse(Test.Validate(str));
	}
	
	@Test
	void test12() {
		System.out.println("Test 12");
		PhoenixTest Test = new PhoenixTest();
		String str ="if (tt) else skip";
		assertFalse(Test.Validate(str));
	}
	
	@Test
	void test13() {
		System.out.println("Test 13");
		PhoenixTest Test = new PhoenixTest();
		String str1 ="if (!ff^tt) then skip";
		String str2 ="if (!ff^tt) then skip else skiip";
		String str3 ="iff (!ff^tt) then skip else skip";
		assertFalse(Test.Validate(str1));
		assertThrows(TokenMgrError.class, () -> {
			Test.Validate(str2);
	    });
		assertFalse(Test.Validate(str3));
	}
	@Test
	void test14() {
		System.out.println("Test 14");
		PhoenixTest Test = new PhoenixTest();
		String str1 ="a:=5 ; whlie (tt) do skip";
		String str2 ="a:=5 ; while (ff) od skip";
		assertThrows(TokenMgrError.class, () -> {
			Test.Validate(str1);
	    });
		assertThrows(TokenMgrError.class, () -> {
			Test.Validate(str2);
	    });
	}
	@Test
	void test15() {
		System.out.println("Test 15");
		PhoenixTest Test = new PhoenixTest();
		String str3 ="while ((a == 5))";
		assertFalse(Test.Validate(str3));
	}


}
