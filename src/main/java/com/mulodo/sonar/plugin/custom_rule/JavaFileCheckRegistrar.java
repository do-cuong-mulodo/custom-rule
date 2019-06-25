package com.mulodo.sonar.plugin.custom_rule;

import java.util.List;

import org.sonar.plugins.java.api.CheckRegistrar;
import org.sonar.plugins.java.api.JavaCheck;
import org.sonarsource.api.sonarlint.SonarLintSide;

/**
 * 
 * Rule Registrar
 * 
 * Because your rules are relying on the SonarJava API, you also need to tell the 
 * SonarJava parent plugin that some new rules have to be retrieved. If you are 
 * using the template custom plugin as a base of this tutorial, you should have 
 * everything done already, but feel free to have a look at the 
 * MyJavaFileCheckRegistrar.java class, which connects the dots. 
 * Finally, be sure that this registrar class is also correctly added as an 
 * extension for your custom plugin, by adding it to your Plugin definition class 
 * (MyJavaRulesPlugin.java)
 *
 */

/**
 * Provide the "checks" (implementations of rules) classes that are going be
 * executed during source code analysis.
 *
 * This class is a batch extension by implementing the
 * {@link org.sonar.plugins.java.api.CheckRegistrar} interface.
 */
@SonarLintSide
public class JavaFileCheckRegistrar implements CheckRegistrar {

	/**
	 * Register the classes that will be used to instantiate checks during analysis.
	 */
	@Override
	public void register(RegistrarContext registrarContext) {
		// Call to registerClassesForRepository to associate the classes with the
		// correct repository key
		registrarContext.registerClassesForRepository(JavaRulesDefinition.REPOSITORY_KEY, checkClasses(),
				testCheckClasses());
	}

	/**
	 * Lists all the main checks provided by the plugin
	 */
	public static List<Class<? extends JavaCheck>> checkClasses() {
		return JavaCustomRulesList.getJavaChecks();
	}

	/**
	 * Lists all the test checks provided by the plugin
	 */
	public static List<Class<? extends JavaCheck>> testCheckClasses() {
		return JavaCustomRulesList.getJavaTestChecks();
	}

}
