package org.mql.java.reflection;

import java.io.File;

import java.util.Vector;


public class ProjectExplorer {
	private Vector<String> packageNames = new Vector<>();
	private String rootPath;
	
	
	public ProjectExplorer(String projectName) {
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
	public Vector<String> getPackageNames() {
		return packageNames;
	}

}



