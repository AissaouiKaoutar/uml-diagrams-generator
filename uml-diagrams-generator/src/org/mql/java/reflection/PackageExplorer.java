package org.mql.java.reflection;

import java.io.File;
import java.util.Vector;

public class PackageExplorer {
	public PackageExplorer() {
		
	}
	public String[] getClassList(String packageName) {
		String classpath = System.getProperty("user.dir");
		
		String packagepath = packageName.replace(".", "/");
		
		File dir = new File(classpath + "/bin/" + packagepath);
		
	
		File f[] = dir.listFiles();//Fichiers du package
		Vector<String> v = new Vector<String>();
		for (int i = 0; i < f.length; i++) {
			String fileName = f[i].getName();
			if(f[i].isFile() && fileName.endsWith(".class")) {
				String name = fileName.replace(".class", "");
				v.add(packageName + "." + name);
			}
		}
		
		String t[] = new String[v.size()];
		v.toArray(t);
		
		return t;
	}
	
}
