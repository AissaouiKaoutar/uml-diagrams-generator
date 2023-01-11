package org.mql.java.reflection;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class ProjectExplorer {
	private String path;
	private Set<String> packageNames = new HashSet<>();

	public ProjectExplorer(String projectName) {
		String path = System.getProperty("java.class.path");
		File dir = new File(path);
		path = dir.getPath();
		getPackage(dir);

	}

	public void getPackage(File dir) {

		File[] files = dir.listFiles();

		for (File file : files) {
			if (file.isDirectory()) {

				getPackage(file);
			} else {
				String s = dir.getPath().replace(path, "");
				packageNames.add(s.replace("\\", ".").replaceFirst(".", ""));

			}
		}

	}

	public Set<String> getPackageNames() {
		return packageNames;
	}

}
