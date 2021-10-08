//Marcus Naess
//mjnaess19@ole.augie.edu

//Information on how to use the application is on GitHub
//https://github.com/0nab

import java.util.Scanner; 
import java.util.Vector; 
import java.io.*;
import java.util.*;
public class Cocktail {
	private String name;
	private String[] ingredients;
	private String recipe;
		
	//Post: name, ingredients, recipe. 
	public void Cocktail() {
		name = "unknown";
		ingredients[0] = "unknown";
		recipe = "unknown";
 	}
 	public void Cocktail(String name, String[] ingredients, String recipe) {
 		this.name = name;
		this.ingredients = ingredients;
		this.recipe = recipe;
 	}
 	
 	public void setName(String name){
 		this.name = name;
 	}
 	public void setIngredients(String[] ingredients){
 		this.ingredients = ingredients;
 	}
 	public void setRecipe(String recipe){
 		this.recipe = recipe;
 	}
 	
 	public String getName(){
 		return name;
 	}
 	public String[] getIngredients(){
 		return ingredients;
 	}
 	public String getRecipe(){
 		return recipe;
 	}
 	
 	public void toCocktailString() {
 		System.out.println("Name: " + this.name);
 		System.out.println("Ingredients: " + Arrays.toString(this.ingredients));
 		System.out.println("Recipe: " + this.recipe);
 	}

	 public String toCocktailStringReturn() {
		return "<html>Name: " + this.name + "<br/>" + "Ingredients: " + Arrays.toString(this.ingredients) + "<br/>" + "Recipe: " + this.recipe + "<br/><br/><html/>";
	}

 	public boolean doesContain(String str) {
 		for(String ingredient: this.ingredients){
 			if(ingredient.compareTo(str) == 0) return true;
 		}
 		return false;
 	}
}