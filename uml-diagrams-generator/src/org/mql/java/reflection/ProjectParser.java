package org.mql.java.reflection;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;


public class ProjectParser {
	private Set<String> packageNames = new HashSet<>();
	private String rootPath;
	
	
	public ProjectParser(String projectName) {
		String classpath = System.getProperty("java.class.path");
		File dir = new File(classpath);
		rootPath= dir.getPath();
		getPackage(dir);
		
		
	}
	public void getPackage(File dir){
		

		File[] files = dir.listFiles();
		
		for (File file : files) {
			if (file.isDirectory()){
				
				getPackage(file);
			}
			else {
				String s =dir.getPath().replace(rootPath, "");
				packageNames.add(s.replace("\\",".").replaceFirst(".", ""));
				
			}
		}
		
	
	}
	public Set<String> getPackageNames() {
		return packageNames;
	}

}



