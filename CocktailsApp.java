//Marcus Naess
//mjnaess19@ole.augie.edu

//Information on how to use the application is on GitHub
//https://github.com/0nab

import java.util.Collections;
import java.util.Scanner; 
import java.util.Vector; 
import java.util.ListIterator;
import java.util.Iterator;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.*;
import javax.swing.*;
import java.awt.*;


public class CocktailsApp extends JFrame {
	public static Scanner keyboard=new Scanner(System.in);
	//Desc:  Menu for the application. Entering the number will start the function related to the number
	//Input: Int from 1 - 6
	public static Vector<Cocktail> v=new Vector<Cocktail>();
	public static void main(String[] args) throws IOException {
		File f=new File("cocktails.txt");
		if (f.exists()) loadCocktails(v);
		else System.out.println("There is no txt file");

		printAllCocktailsGUI.handedV(v);
		searchCocktailsGUI.handedV(v);
		/** 
		int choice = 5;
		do {
			System.out.println("==========================");
			System.out.println("\t1. Search Cocktail"); 
			System.out.println("\t2. Coctails that contain ingredient"); 
			System.out.println("\t3. List of Coctails (A-Z)"); 
			System.out.println("\t4. Enter all ingredients you posses, recipe all you can make and coctails which you need one more ingredient for.");
			System.out.println("\t5. Add new cocktail"); 
			System.out.println("\t6. Quit");
 			choice= keyboard.nextInt(); 
 			System.out.println("==========================");
 			switch (choice) {
				case 1: searchCocktail(v); break; 
				case 2: containsIngredient(v); break; 
				case 3: printAllCocktails(v); break; 
				case 4: cocktailsContainIngredient(v); break; 
				case 5: addCocktail(v); break; 
				default: break;
			}
			
		} while (choice!=6); 
		
		


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 550);


        JPanel panel = new JPanel(); 
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 250, 30));
        JButton searchCocktail = new JButton("Search Cocktail");
		JButton containsIngredient = new JButton("Coctails that contain ingredient");
        JButton printAllCocktails = new JButton("List of Coctails (A-Z)");
        JButton cocktailsContainIngredient = new JButton("Add new cocktail");
        JButton addCocktail = new JButton("<html>" + "Enter all ingredients you posses" + "<html>");
		
		panel.add(searchCocktail);
		panel.add(containsIngredient);
		panel.add(printAllCocktails);
		panel.add(cocktailsContainIngredient);
		panel.add(addCocktail);
		panel.setLayout(new GridLayout(0,1));

		frame.add(panel, BorderLayout.CENTER); 
		frame.setTitle("Cocktail App");
		frame.setResizable(false);
		frame.setVisible(true);
		*/
		CocktailGUI frame = new CocktailGUI();
	}

	//Desc: Loads the Cocktail from txt file and adds Coctail objects to a vector
	public static void loadCocktails(Vector<Cocktail> v) throws FileNotFoundException {
		Scanner file = new Scanner(new File("cocktails.txt"));
		while (file.hasNextLine()){
			String name = file.nextLine();
			String[] ingredients = file.nextLine().split(",");
			String recipe = file.nextLine();
			Cocktail cotail = new Cocktail();
			cotail.setName(name);
			cotail.setIngredients(ingredients);
			cotail.setRecipe(recipe);
			v.add(cotail);
		}
	}

	public static Vector<Cocktail> getV() {
		System.out.println(v.size());
		return v;
	}


	//Choice 1
	//Desc: Search for a coctail in the system.
	//Input: Name (String) of the Coctail you are loooking for
	//Output: If found: Information about the cocktail
	//  	  If not found: text telling you that it does not exist
	public static String searchCocktail(Vector<Cocktail> v, String cocktailString) {
		String returnString;
		System.out.println("Enter the cocktail you wish to search for: ");
		String search = cocktailString;
		search.toLowerCase();
		Cocktail sCocktail = search(search,v);
		if (sCocktail.getName() == null) {
			returnString = "This Cocktail does not exist";
		}
		else {
			returnString = sCocktail.toCocktailStringReturn();
		}	
		return returnString;
	}

	//Desc: Searches for a Cocktail
	//Input: Name of Cocktail (String), The Vector of Cocktail objects
	//Output: Cocktail object
	public static Cocktail search(String n, Vector<Cocktail> v) {
		Cocktail ct = new Cocktail();
		for (Cocktail c:v){
			if (c.getName().compareTo(n) == 0) {
				ct = c;
			}
		}
		return ct;
	}
	
	//Choice 2
	//Desc: Enter a ingredient and it gives you all the drinks that uses it
	//Input: Ingredient (String)
	//Output: List of cocktails and their description that include the ingredient
	public static void containsIngredient(Vector<Cocktail> v) {
		System.out.println("Enter the ingredient you are looking for in drinks");
		keyboard.nextLine();
		String ing = keyboard.nextLine().toLowerCase();
		boolean firstPrint = true;
		for (Cocktail c: v) {
			String[] ingList = c.getIngredients();
			for (String s: ingList) {
				if (s.compareTo(ing)==0) {
					if(firstPrint == true) System.out.println("These are the Cocktails that contain " + ing + "\n" + "--------------------------");
					firstPrint = false;
					c.toCocktailString();
					System.out.println("--------------------------");
				}
			}
		}
		if(firstPrint == true) System.out.print("There are no Cocktails that contain " + ing);
	}
	
	//Choice 3
	//Desc: Prints all Cocktails
	//Input: Vector with all Cocktails objects
	//Return: A String that is ready to be printed
	public static String printAllCocktails(Vector<Cocktail> v) {
		String returnStringList = "<html>";
		System.out.println(v.size());
		String[] names = new String[v.size()];
		int i =0;
		for (Cocktail c:v) {
			names[i] = c.getName();
			i++;
		}
		char first = '-';
		Arrays.sort(names);
		for (String name:names){
			char firstChar = name.charAt(0);
			if (first != firstChar) {
				returnStringList = returnStringList + Character.toUpperCase(firstChar) + "<br/>";
				first = firstChar;
			}
			returnStringList = returnStringList + name + "<br/>";
		}
		return returnStringList + "<html/>";
	}

	
	//Choice 4
	//Desc: You enter all the ingredients you have and it gives a list of all coctails that 
	//		you have all the ingredients for and all the ones that need one more ingredient
	public static void cocktailsContainIngredient(Vector<Cocktail> v) {
	boolean run = true;
	Vector<String> ingredients = new Vector<String>();
	String ing;
		while(run == true){
			System.out.print("Enter your ingredient or 'N' to look for coctails.");
			ing = keyboard.nextLine().toLowerCase();
			if (ing.compareTo("n")==0) run = false;
			else ingredients.add(ing);
		}
		int count = 0;
		Vector<Cocktail> allIng = new Vector<Cocktail>();
		Vector<Cocktail> missingIng = new Vector<Cocktail>();
		for (Cocktail c:v) {
			count = 0;
			for (String n:c.getIngredients()) {
				for (String s:ingredients){
					if (s.compareTo(n)==0) count++;
				}
			}
			if (count == c.getIngredients().length) allIng.add(c);
			if (count == c.getIngredients().length-1) missingIng.add(c);
		}
		System.out.println("These are the cocktails you posses all ingredients to: \n--------------------------");
		for (Cocktail ct:allIng) {
				ct.toCocktailString();
				System.out.println("--------------------------");
		}
		System.out.println("These are the cocktails that you are missing one ingredient to: \n--------------------------");
		for (Cocktail ctMiss:missingIng) {
				ctMiss.toCocktailString();
				System.out.println("--------------------------");
		}
	}
	
	//Choice 5
	//Desc: You can add new Cocktail to the System
	//Input: You enter the name, ingredients, and the recipe. (Strings)
	public static void addCocktail(Vector<Cocktail> v) throws FileNotFoundException {
		try {
		File txt = new File("cocktails.txt");
		boolean run = true;
		write("","\n",txt);
		System.out.println("Name: ");
		keyboard.nextLine();
		String name = keyboard.nextLine().toLowerCase();
		write(name, "\n",txt);
		while (run == true) {
		System.out.println("Ingredient or 'n' to end");
		String ingredient = keyboard.nextLine().toLowerCase();
		if (ingredient.compareTo("n") == 0) {
			run = false;
			write("","\n",txt);
		}
		else write(ingredient, ",",txt);
		}
		System.out.println("Recipe: ");
		String recipe = keyboard.nextLine();
		write(recipe, "", txt);
		} catch (IOException e) {
		}
		v.clear();
		loadCocktails(v);
	}

	//Desc: Writes the Cocktail information to a txt file
	public static void write(String s, String del, File f) throws IOException {
		FileWriter fr = new FileWriter(f,true);
		fr.write(s + del);
		fr.close();
	}
}

