package com.mulodo.sonar.plugin.custom_rule.checks;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.semantic.Symbol;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.ClassTree;

import com.mulodo.sonar.plugin.custom_rule.checks.helper.FileNameHelper;

@Rule(key = "FileNameMatchTopOuterClass")
public class FileNameMatchTopOuterClassCheck extends BaseTreeVisitor implements JavaFileScanner {

	private static final String MESSAGE = "Change this class name into ";
	private String fileNameNoExtension;
	private boolean isMostTopLineClassScanned;
	private JavaFileScannerContext context;

	@Override
	public void scanFile(JavaFileScannerContext context) {
		// the first scanned class is the most top line class
		isMostTopLineClassScanned = false;
		String fileName = FileNameHelper.getFileName(context);
		String fileExtension = FileNameHelper.getFileExtension(fileName);

		/*
		 * if file extension is java then get the file name without extension and
		 * continue to check visitClass
		 */
		if (fileExtension != null && fileExtension.equals("java")) {
			fileNameNoExtension = FileNameHelper.getFileNameNoExtension(fileName);
			this.context = context;
			scan(context.getTree());
		}
	}

	@Override
	public void visitClass(ClassTree classTree) {
		Symbol.TypeSymbol symbol = classTree.symbol();

		/*
		 * if class is outer and also the first class in the file has not been scanned
		 * then scan it and will not scan the next class
		 */
		if (!isMostTopLineClassScanned) {
			// if file name without extension is different from the most top line class name
			if (!fileNameNoExtension.equals(symbol.name())) {
				// report error in sonar
				context.reportIssue(this, classTree.simpleName(), MESSAGE + fileNameNoExtension);
			}
			isMostTopLineClassScanned = true;
		}
	}

}
