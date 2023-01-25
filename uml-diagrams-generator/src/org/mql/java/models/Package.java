package org.mql.java.models;

import java.util.List;
import java.util.Vector;

public class Package {
	
	public String packageName;
	private List<Classe> classes;

	public Package() {
		this.classes = new Vector<Classe>();
	}
	
	public Package(String packageName) {
		this();
		this.packageName = packageName;
	} 
	
	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public List<Classe> getClasses() {
		return classes;
	}
	public void setClass(List<Classe> classes) {
		this.classes= classes;
	}
	public void addClass(Classe classes) {
		this.classes.add(classes);
	}
}
