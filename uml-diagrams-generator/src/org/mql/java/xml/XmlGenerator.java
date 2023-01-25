package org.mql.java.xml;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

import org.mql.java.models.Classe;
import org.mql.java.models.Package;
import org.mql.java.models.Project;
import org.mql.java.models.Property;

public class XmlGenerator {
	private Project projet;

	public XmlGenerator(String FileName, Project projet) {
		this.projet = projet;
		String data=XmlProjet(projet);
		try {
			FileWriter out=new FileWriter(FileName);
			out.write(data);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("erreur"+e.getMessage());
		}
		
		

	}

	public String XmlProperties(Property prop) {
		String xmlData = "<property>";
		xmlData += "<name>" + prop.getName() + "</name>";
		xmlData += "<type>" + prop.getType().getName() + "</type>";
		xmlData += "<visibilite>" + prop.getModifier() + "</visibilite></property> ";
		return xmlData;

	}

	public String XmlMethodes(org.mql.java.models.Method method) {
		String xmlData = "<methode>";
		xmlData += "<name>" + method.getName() + "</name>";
		xmlData += "<type>" + method.getReturnType().getName() + "</type>";
		xmlData += "<visibilite>" + method.getModifier() + "</visibilite>";
		for (int i = 0; i < method.getParameters().size(); i++) {
			xmlData += XmlProperties(method.getParameters().get(i));

		}
		xmlData += "</methode>";

		return xmlData;

	}

	public String XmlConstructeur(org.mql.java.models.Constructor cons) {
		String xmlData = "<constructeur>";
		xmlData += "<name>" + cons.getName() + "</name>";
		xmlData += "<visibilite>" + cons.getModifier() + "</visibilite>";
		for (int i = 0; i < cons.getParameters().size(); i++) {
			xmlData += XmlProperties(cons.getParameters().get(i));

		}
		xmlData += "</constructeur>";

		return xmlData;

	}

	public String XmlClasses(Classe cls) {
		String xmlData = "<classe>";
		xmlData += "<name>" + cls.getClassName() + "</name>";

		for (int i = 0; i < cls.getProperties().size(); i++) {
			xmlData += XmlProperties(cls.getProperties().get(i));

		}
		for (int i = 0; i < cls.getConstructors().size(); i++) {
			xmlData += XmlConstructeur(cls.getConstructors().get(i));

		}
		for (int i = 0; i < cls.getMethods().size(); i++) {
			xmlData += XmlMethodes(cls.getMethods().get(i));

		}
		//for (int i = 0; i < cls.getInterfaces().size(); i++) {
		//	xmlData += "<interface>" + cls.getInterfaces().get(i) + "</interfaces>";

	//	}
		xmlData += "<superClass>" + cls.getSuperClass() + "</superClass>";

		xmlData += "</classe>";
		return xmlData;
	}

	public String XmlPackage(Package pack) {

		String xmlData = "<package>";
		xmlData += "<name>" + pack.getPackageName() + "</name>";
		
		for (int i = 0; i < pack.getClasses().size(); i++) {
			xmlData += XmlClasses(pack.getClasses().get(i));

		}

		xmlData += "</package>";
		return xmlData;

	}

	public String XmlProjet(Project proj) {

		String xmlData = "<projet>";
		xmlData += "<name>" + proj.getProjectName() + "</name>";
		
		for (int i = 0; i < proj.getPackages().size(); i++) {
			xmlData += XmlPackage(proj.getPackages().get(i));

		}

		xmlData += "</projet>";
		return xmlData;

	}

}
