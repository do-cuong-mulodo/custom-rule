package com.mulodo.sonar.plugin.custom_rule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.sonar.plugins.java.api.JavaCheck;

import com.google.common.collect.ImmutableList;
import com.mulodo.sonar.plugin.custom_rule.checks.FileNameMatchTopOuterClassCheck;

/**
 * Rule Activation
 * 
 * This program will list all the rules you want to activate for Sonar
 * 
 * Including: - FileNameMatchTopOuterClassCheck
 */

public class JavaCustomRulesList {

	public static List<Class<? extends JavaCheck>> getJavaChecks() {
		/* activate the rule within the plugin */
		return ImmutableList.<Class<? extends JavaCheck>>builder()
				// other rules...
				.add(FileNameMatchTopOuterClassCheck.class).build();
	}

	public static List<Class<? extends JavaCheck>> getJavaTestChecks() {
		return Collections.emptyList(); // empty list
	}

	public static List<Class<? extends JavaCheck>> getChecks() {
		List<Class<? extends JavaCheck>> checks = new ArrayList<>();
		checks.addAll(getJavaChecks());
		checks.addAll(getJavaTestChecks());
		return Collections.unmodifiableList(checks);
	}

}
