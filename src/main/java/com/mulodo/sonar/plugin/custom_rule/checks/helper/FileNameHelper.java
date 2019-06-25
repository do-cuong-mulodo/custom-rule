package com.mulodo.sonar.plugin.custom_rule.checks.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.plugins.java.api.JavaFileScannerContext;

public class FileNameHelper {

	// Logger
	private static final Logger LOG = LoggerFactory.getLogger(FileNameHelper.class);

	public static String getFileName(JavaFileScannerContext context) {
		String name = context.getFile().getName();
		LOG.debug(name);
		return name;
	}

	public static String getFileExtension(String fileName) {
		String[] fileNameSplitedDots = fileName.split("\\.");
		String fileExtension = fileNameSplitedDots[fileNameSplitedDots.length - 1];
		LOG.debug(fileExtension);
		return fileExtension;
	}

	public static String getFileNameNoExtension(String fileName) {
		String fileNameNoExtension = fileName.substring(0, fileName.length() - 5);
		LOG.debug(fileNameNoExtension);
		return fileNameNoExtension;
	}

}
