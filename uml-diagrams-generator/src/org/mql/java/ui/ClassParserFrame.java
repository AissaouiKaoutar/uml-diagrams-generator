package org.mql.java.ui;


import javax.swing.JFrame;
import javax.swing.JPanel;

import org.mql.java.models.Classe;
import org.mql.java.reflection.ClassExplorer;

import java.awt.Color;
import java.awt.TextArea;

import javax.swing.*;


public class ClassParserFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public ClassParserFrame() {
		init();
		config();
	}

	private void init() {
		System.out.println("Squellete De Notre Classe");
		JPanel panel = new JPanel();
		setContentPane(panel);
		panel.setBackground(Color.pink);
		ClassExplorer classexp = new ClassExplorer("org.mql.java.models.Personne");
		Classe classe = classexp.getSkeleton();
		ClassSkeletonPanel skeletonPanel = new ClassSkeletonPanel(classe);
		TextArea x = new TextArea(skeletonPanel .getSkeleton());
		x.setRows(28);
		x.setColumns(100);
		panel.add(x);
		

	}
	private void config() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ClassParserFrame();
	}

}
