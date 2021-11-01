//Marcus Naess
//mjnaess19@ole.augie.edu

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Function;
import java.util.Vector; 
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.io.*;
import java.util.*;

public class containsIngredientGUI extends JFrame {
	JLabel searchCocktailsTextField;
	String cocktailsList;
	JScrollPane scroll;
	static Vector<Cocktail> vc;

	public containsIngredientGUI(String cocktailString) 
	{
		cocktailsList = CocktailsApp.containsIngredient(vc, cocktailString);
		searchCocktailsTextField = new JLabel();
		scroll = new JScrollPane(searchCocktailsTextField);
		searchCocktailsTextField.setText(cocktailsList);
		searchCocktailsTextField.setVerticalAlignment(JLabel.TOP);
		scroll.setBounds(10, 10, 980, 450);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setSize(1000,500);
		this.add(scroll);
		this.setLocation(400,400);
		this.setResizable(false);
		this.setVisible(true);	
		scroll.setVisible(true);	
	}

	public static void handedV(Vector<Cocktail> v) {
		vc = v;
	}
}