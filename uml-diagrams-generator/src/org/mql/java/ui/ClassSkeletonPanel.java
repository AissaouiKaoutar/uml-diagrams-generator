package org.mql.java.ui;

import javax.swing.JPanel;

import org.mql.java.models.Classe;
import org.mql.java.models.Constructor;
import org.mql.java.models.Method;
import org.mql.java.models.Property;

public class ClassSkeletonPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Classe skeleton;
	public ClassSkeletonPanel(Classe skeleton) {
		this.skeleton = skeleton;
	}
	
	public String getSkeleton() {
		String stringSkeleton = "\npublic class " + skeleton.getClassName() + " {\n\n";
		for (Property p : skeleton.getProperties()) {
			stringSkeleton += "\t" + p.getModifier() +" " + p.getType().getSimpleName() + " "+ p.getName() +";\n";
		}
		stringSkeleton += "\n\n";
		
		for (Constructor c : skeleton.getConstructors()) {
			stringSkeleton += "\t" + c.getModifier() +" "+ c.getName() +"(";
			for (Property p : c.getParameters()) {
				stringSkeleton += p.getType().getSimpleName() + " "+ p.getName() +", ";
			}
			stringSkeleton += ") {\n\t}\n\n";
		}	
		
		stringSkeleton += "\n";
		int i = 0;
		for (Method m : skeleton.getMethods()) {
			stringSkeleton += "\t" + m.getModifier() +" "+ m.getReturnType().getSimpleName()+ " "+ m.getName() +" (";
			for (Property p : m.getParameters()) {
				i++;
				stringSkeleton += p.getType().getSimpleName() + " "+ p.getName() +", ";
			}
			//Remove the last comma
			stringSkeleton.replace(stringSkeleton.substring(stringSkeleton.length()-2), " ");
			stringSkeleton += ") {\n\t}\n\n";
		}

		return stringSkeleton + "}";
	}
}
