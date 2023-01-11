package org.mql.java.examples;

import java.util.Set;

import org.mql.java.reflection.PackageExplorer;
import org.mql.java.reflection.ProjectExplorer;

public class Examples {

	public Examples() {
		exp01();
	}

	public void exp01() {

		ProjectExplorer projectExp = new ProjectExplorer("bin/");
		Set<String> packages = projectExp.getPackageNames();
		PackageExplorer packageExplorer = new PackageExplorer();
		for (String pcg : packages) {
			System.out.println(" \n=>POUR LE PACKAGE : " + pcg);
			String[] classesNames = packageExplorer.getClassList(pcg);
			for (String cls : classesNames) {
				System.out.println("\n\t LA CLASSE :" + cls);
			}

		}
	}

	public static void main(String[] args) {
		new Examples();
	}
}
