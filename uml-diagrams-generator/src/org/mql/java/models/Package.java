package org.mql.java.models;

import java.util.List;
import java.util.Vector;

public class Package {
	
	public String packageName;
	private List<Classe> classesInfo;

	public Package() {
		this.classesInfo = new Vector<Classe>();
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

	public List<Classe> getClassInfo() {
		return classesInfo;
	}
	public void setClassInfo(List<Classe> classesInfo) {
		this.classesInfo= classesInfo;
	}
	public void addClassInfo(Classe classInfo) {
		this.classesInfo.add(classInfo);
	}
}
