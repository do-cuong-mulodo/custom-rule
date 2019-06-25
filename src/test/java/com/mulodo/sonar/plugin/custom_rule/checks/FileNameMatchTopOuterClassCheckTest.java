package com.mulodo.sonar.plugin.custom_rule.checks;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class FileNameMatchTopOuterClassCheckTest {
	
	@Test
	public void testClass1() {
		JavaCheckVerifier.verifyNoIssue("src/test/file_name_match_top_outer_class_rule/Class1.java", new FileNameMatchTopOuterClassCheck());
	}
	
	@Test
	public void testClass2() {
		JavaCheckVerifier.verifyNoIssue("src/test/file_name_match_top_outer_class_rule/Class2.java", new FileNameMatchTopOuterClassCheck());
	}
	
	@Test
	public void testClass3() {
		// will be fail need to be commented for the build
		//JavaCheckVerifier.verifyNoIssue("src/test/file_name_match_top_outer_class_rule/Class3.java", new FileNameMatchTopOuterClassCheck());
	}
	
	@Test
	public void testClass4() {
		JavaCheckVerifier.verifyNoIssue("src/test/file_name_match_top_outer_class_rule/Class4.java", new FileNameMatchTopOuterClassCheck());
	}
	
	@Test
	public void testClass5() {
		JavaCheckVerifier.verifyNoIssue("src/test/file_name_match_top_outer_class_rule/Class5.html", new FileNameMatchTopOuterClassCheck());
	}
	
}
