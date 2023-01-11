package org.mql.java.models;

import java.util.List;
import java.util.Vector;

public class Project {
	public String projectName;
	private List<Package> packages;
	
	
	public Project() {
		this.packages= new Vector<Package>();
	}
			
	public Project(String projectName) {
		this();
		this.projectName = projectName;
	}
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Package> getPackages() {
		return packages;
	}

	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}
	
	public void addPackage(Package pckg) {
		this.packages.add(pckg);
	}


	

}
