//Marcus Naess
//mjnaess19@ole.augie.edu

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Vector;
import java.util.function.Function;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CocktailGUI extends JFrame implements ActionListener {
	JButton searchCocktailButton;
	JButton containsIngredientButton;
	JButton printAllCocktailsButton;
	JButton cocktailsContainIngredientButton;
	JButton addCocktailButton;
	JButton Submit;
	JButton IngButton;
	JTextField textField;
	Vector<String> ingArray = new Vector<String>(); 
	int choice;
	
	public CocktailGUI() {
		
		//Buttom: Search Cocktail
		searchCocktailButton = new JButton();
		searchCocktailButton.setBounds(100, 100, 250, 50);
		searchCocktailButton.addActionListener(this);
		searchCocktailButton.setText("Search Cocktail");
		searchCocktailButton.setFocusable(false);

		//Buttom: Coctails that contain ingredient
		containsIngredientButton = new JButton();
		containsIngredientButton.setBounds(100, 150, 250, 50);
		containsIngredientButton.addActionListener(this);
		containsIngredientButton.setText("Coctails that contain ingredient");
		containsIngredientButton.setFocusable(false);

		//Buttom: List of Coctails (A-Z)
		printAllCocktailsButton = new JButton();
		printAllCocktailsButton.setBounds(100, 200, 250, 50);
		printAllCocktailsButton.addActionListener(this);
		printAllCocktailsButton.setText("List of Coctails (A-Z)");
		printAllCocktailsButton.setFocusable(false);

		//Buttom: Enter all ingredients you posses, recipe all you can make and coctails which you need one more ingredient for.
		cocktailsContainIngredientButton = new JButton();
		cocktailsContainIngredientButton.setBounds(100, 250, 250, 50);
		cocktailsContainIngredientButton.addActionListener(this);
		cocktailsContainIngredientButton.setText("Enter all ingredients you posses");
		cocktailsContainIngredientButton.setFocusable(false);

		//Buttom: Add new cocktail
		addCocktailButton = new JButton();
		addCocktailButton.setBounds(100, 300, 250, 50);
		addCocktailButton.addActionListener(this);
		addCocktailButton.setText("Add new cocktail");
		addCocktailButton.setFocusable(false);

		//Ingredient Button
		IngButton = new JButton();
		IngButton.setBounds(290, 400, 150, 25);
		IngButton.addActionListener(this);
		IngButton.setText("Add Ingridient");
		IngButton.setFocusable(false);

		//Submit Button
		Submit = new JButton();
		Submit.setBounds(315, 425, 100, 25);
		Submit.addActionListener(this);
		Submit.setText("Submit");
		Submit.setFocusable(false);

		//Text Field
		textField = new JTextField();
		textField.setBounds(65, 425, 250, 25);

		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(450,500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.add(searchCocktailButton);
		this.add(containsIngredientButton);
		this.add(printAllCocktailsButton);
		this.add(cocktailsContainIngredientButton);
		this.add(addCocktailButton);
		this.add(Submit);
		this.add(IngButton);
		this.add(textField);
		this.setResizable(false);
		textField.setVisible(false);
		Submit.setVisible(false);
		IngButton.setVisible(false);
		
	}

	public void printAllCocktailsGUI() {

		addCocktailButton = new JButton();
		addCocktailButton.setBounds(100, 300, 250, 50);
		addCocktailButton.addActionListener(this);
		addCocktailButton.setText("Add new cocktail");
		addCocktailButton.setFocusable(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(450,500);
		this.setVisible(true);
		this.add(addCocktailButton);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == searchCocktailButton) {
			visable();
			choice = 0;
		}
		if(e.getSource() == containsIngredientButton) {
			visable();
			choice = 1;
		}
		if(e.getSource() == printAllCocktailsButton) {
			invisable();
			printAllCocktailsGUI frame = new printAllCocktailsGUI();
		}
		if(e.getSource() == cocktailsContainIngredientButton) {
			Ingvisable();
			choice = 2;
		}
		if(e.getSource() == addCocktailButton) {
			visable();
			choice = 3;
		}
		if(e.getSource() == Submit) {
			Submited(choice);
		}
		if(e.getSource() == IngButton) {
			IngSubmitted(choice);
		}
	}
	public void visable() {
		textField.setVisible(true);
		Submit.setVisible(true);
		IngButton.setVisible(false);
	}
	public void invisable() {
		textField.setVisible(false);
		textField.setText("");
		Submit.setVisible(false);
		IngButton.setVisible(false);
	}
	public void Ingvisable() {
		textField.setVisible(true);
		IngButton.setVisible(true);
		Submit.setVisible(true);
	}

	public void Submited(int choice) {
		if(choice == 0) {
			searchCocktailsGUI frame = new searchCocktailsGUI(textField.getText());
			textField.setText("");
		}
		else if(choice == 1) {
			containsIngredientGUI frame = new containsIngredientGUI(textField.getText());
			textField.setText("");
		}
		else if(choice == 2) {
			cocktailsContainIngredientGUI frame = new cocktailsContainIngredientGUI(ingArray);
			textField.setText("");
		}
	}

	public void IngSubmitted(int choice) {
		if(choice == 2) {
			System.out.println("in IngSubmitted");
			ingArray.add(textField.getText()); 
			textField.setText("");
		}
	}
}