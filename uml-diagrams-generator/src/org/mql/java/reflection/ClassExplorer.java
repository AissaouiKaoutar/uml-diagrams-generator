package org.mql.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Vector;

import org.mql.java.models.Classe;
import org.mql.java.models.Property;

public class ClassExplorer {

	private Classe skeleton;
	private Class<?> cls;

	public ClassExplorer() {

	}

	public ClassExplorer(String className) {

		try {
			cls = Class.forName(className);
			skeleton = new Classe(cls.getSimpleName());
			skeleton.setProperties(getProperties());
			skeleton.setConstructors(getConstructor());
			skeleton.setMethods(getMethodes());

		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}

	public List<Property> getProperties() {
		List<Property> properties = new Vector<>();

		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			String nom = field.getName();
			Class<?> type = field.getType();
			String modifier = getModifier(field.getModifiers());
			Property p = new Property(nom, type, modifier);
			properties.add(p);
		}
		return properties;
	}

	public List<org.mql.java.models.Constructor> getConstructor() {

		List<org.mql.java.models.Constructor> constructors = new Vector<>();
		Constructor<?> cstrs[] = cls.getDeclaredConstructors();

		for (Constructor<?> constructor : cstrs) {
			String nom = cls.getSimpleName();
			String modifier = getModifier(constructor.getModifiers());
			org.mql.java.models.Constructor c = new org.mql.java.models.Constructor(modifier, nom);
			Parameter[] params = constructor.getParameters();
			for (Parameter p : params) {
				String nomParm = p.getName();
				Class<?> typeParm = p.getType();
				c.addParameter(new Property(nomParm, typeParm));
			}
			constructors.add(c);
		}
		return constructors;

	}

	public List<org.mql.java.models.Method> getMethodes() {
		List<org.mql.java.models.Method> methods = new Vector<>();

		Method[] methodes = cls.getDeclaredMethods();
		for (Method method : methodes) {
			String nom = method.getName();
			Class<?> type = method.getReturnType();
			String modifier = getModifier(method.getModifiers());
			org.mql.java.models.Method m = new org.mql.java.models.Method(modifier, type, nom);
			Parameter[] params = method.getParameters();
			for (Parameter p : params) {		
				m.addParameter(new Property(p.getName(), p.getType()));
			}
			methods.add(m);
		}
		return methods;
	}

	public String getSuperClass() {
		return cls.getSuperclass().getSimpleName();
	}

	public List<String> getInterfaces() {
		List<String> interfaces = new Vector<>();
		Class<?>[] inters = cls.getInterfaces();

		for (Class<?> inter : inters) {
			interfaces.add(inter.getSimpleName());
		}
		return interfaces;
	}

	public List<String> getInternClasses() {
		List<String> internClasses = new Vector<>();
		Class<?>[] interns = cls.getDeclaredClasses();

		for (Class<?> intern : interns) {
			internClasses.add(intern.getSimpleName());
		}
		return internClasses;
	}

	public String getModifier(int m) {
		return Modifier.toString(m);
	}

	public Classe getSkeleton() {
		return skeleton;
	}

	public void setSkeleton(Classe skeleton) {
		this.skeleton = skeleton;
	}

}
