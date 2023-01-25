package org.mql.java.examples;

import java.util.List;
import java.util.Vector;

import org.mql.java.models.Classe;
import org.mql.java.models.Package;
import org.mql.java.models.Project;
import org.mql.java.reflection.ClassExplorer;
import org.mql.java.reflection.PackageExplorer;
import org.mql.java.reflection.ProjectExplorer;
import org.mql.java.xml.XmlGenerator;

public class Examples {

	public Examples() {
		exp02();
	}

	public void exp01() {

		ProjectExplorer projectExp = new ProjectExplorer("bin/");
		Vector<String> packages = projectExp.getPackageNames();
		PackageExplorer packageExplorer = new PackageExplorer();
		for (String pcg : packages) {
			System.out.println(" \n=>POUR LE PACKAGE : " + pcg);
			String[] classesNames = packageExplorer.getClassList(pcg);
			for (String cls : classesNames) {
				System.out.println("\n\t LA CLASSE :" + cls);
			}

		}
	}

	public void exp02() {

		ProjectExplorer projectExp = new ProjectExplorer("bin/");
		List<String> packages = projectExp.getPackageNames();
		Project pr = new Project();
		pr.setProjectName("uml-diagrams-generator");
		List<Package> pack = new Vector<>();
		for (int i = 0; i < packages.size(); i++) {
			Package pk = new Package(packages.get(i));	
			List<Classe> cls = new Vector<>();
		    PackageExplorer packageExplorer = new PackageExplorer();

			for (int j = 0; j < packageExplorer.getClassList(packages.get(i)).length; j++) {
				ClassExplorer exp = new ClassExplorer( packageExplorer.getClassList(packages.get(i))[j]);
				cls.add(exp.getSkeleton());
			}
			pk.setClass(cls);
			pack.add(pk);

		}
		pr.setPackages(pack);
		XmlGenerator gener= new XmlGenerator("resources/xmlProjet.xml", pr);

	}

	public static void main(String[] args) {
		new Examples();
	}
}
