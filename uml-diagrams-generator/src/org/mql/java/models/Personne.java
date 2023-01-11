package org.mql.java.models;

public class Personne {

	private int id;
	private String FirtName;
	private String LastName;

	public Personne() {
	}

	public Personne(int id, String name, String FirtName, String LastName) {
		super();
		this.id = id;
		this.FirtName = FirtName;
		this.LastName = LastName;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirtName() {
		return FirtName;
	}

	public void setFirtName(String firtName) {
		FirtName = firtName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
	public String toString() {
		return "Personne [id=" + id + ", FirtName=" + FirtName + ", LastName=" + LastName + "]";
	}

}
