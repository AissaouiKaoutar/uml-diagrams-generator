package org.mql.java.examples;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.mql.java.models.Classe;
import org.mql.java.reflection.ClassExplorer;
import org.mql.java.reflection.PackageExplorer;
import org.mql.java.reflection.ProjectParser;
import org.mql.java.ui.ClassSkeletonPanel;

public class Examples {

	public Examples() {
		exp01();
	}

	public void exp01() {
		ProjectParser projectParser = new ProjectParser("bin/");
		Set<String> packages = projectParser.getPackageNames();
		PackageExplorer packageExplorer = new PackageExplorer();
		for (String pcg : packages) {
			System.out.println(" \n=>POUR LE PACKAGE : "+ pcg );
			String[] classesNames = packageExplorer.getClassList(pcg);
			for (String cls : classesNames) {
				System.out.println("\n\t LA CLASSE :"+cls);
			}

		}
	}

	public static void main(String[] args) {
		new Examples();
	}
}
