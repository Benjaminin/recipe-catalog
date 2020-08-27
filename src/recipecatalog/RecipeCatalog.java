/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipecatalog;

import java.util.Scanner;
import java.util.ArrayList;


/**
 *
 * @author Benjamin Tancl
 */
public class RecipeCatalog {

public ArrayList<Recipe> recipeCatalog;

public ArrayList<Recipe> getRecipeCatalog(){
    return recipeCatalog;
}

public void setRecipeCatalog(ArrayList<Recipe> recipeCatalog){
    this.recipeCatalog = recipeCatalog;
}
public RecipeCatalog(){
    this.recipeCatalog = new ArrayList();
}
public RecipeCatalog(ArrayList<Recipe> recipeCatalog){
    this.recipeCatalog = recipeCatalog;
}
public void printAllRecipeDetails (String selectedRecipeName){
    for (int i = 0; i < recipeCatalog.size(); i++){
        if(recipeCatalog.get(i).getRecipeName().equals(selectedRecipeName)){
                recipeCatalog.get(i).printRecipe();
        }
    }
}
public void printAllRecipeNames(){
    recipeCatalog.forEach((Recipe) -> {
       System.out.println(Recipe.getRecipeName());
    });
}
public void AddRecipe(){
    recipeCatalog.add(new Recipe().addNewRecipe());
} 
public void RemoveRecipe(String selectedRecipeName){
    for(int i = 0; i < recipeCatalog.size(); i++){
            if (recipeCatalog.get(i).recipeName.equals(selectedRecipeName)){
                recipeCatalog.remove(i);
            }
    }
}

    /**
     *
     * @param selectedRecipeName
     */
    public void ChangeRecipeName(String selectedRecipeName){
    Scanner nameIn = new Scanner(System.in);
    String oldName;
    String newName;
    for(int i = 0; i < recipeCatalog.size(); i++){
            if (recipeCatalog.get(i).recipeName.equals(selectedRecipeName)){
            oldName = recipeCatalog.get(i).getRecipeName();
            System.out.println("What would you like to change " + oldName + 
                    " to?");
            newName = nameIn.next();
            System.out.println("Changing Recipe Name From " + oldName + 
                    " to " + newName);
            recipeCatalog.get(i).setRecipeName(newName);
            System.out.print("Name Successfully Changed");
                
        
            }    
    }
    
            
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RecipeCatalog myRecipeCatalog = new RecipeCatalog();
    Menu menu = new Menu();
    while (true)
        menu.displayMainMenu(myRecipeCatalog);
        
        
/**

    while (menuScnr.hasNextInt()) {
        int input = menuScnr.nextInt();
        
        if (input == 1){
            myRecipeCatalog.AddRecipe();
        } else if (input == 2){
            System.out.println("Which recipe?\n");
            Scanner recipeScnr = new Scanner(System.in);
            String selectedRecipeName = recipeScnr.next();
            myRecipeCatalog.printAllRecipeDetails(selectedRecipeName);
        } else if (input == 3){
           for (int j = 0; j < myRecipeCatalog.recipeCatalog.size(); j++) {
            System.out.println((j + 1) + ": " +
                    myRecipeCatalog.recipeCatalog.get(j).getRecipeName());
           }
        } else if (input == 4){
            System.out.println("Which recipe would you like to remove?\n");
            String selectedRecipeName = menuScnr.nextLine();
            myRecipeCatalog.RemoveRecipe(selectedRecipeName);
        }else if (input == 5){
            System.out.println("Which recipe would you like to edit?\n");
            String selectedRecipeName = menuScnr.nextLine();
            myRecipeCatalog.printAllRecipeDetails(selectedRecipeName);
            System.out.println("Please select an item to edit:");
            System.out.print("1. Recipe Name\n" + "2. Recipe Servings\n" + 
                    "3. Recipe Calories\n" + "4. Modify Ingredients\n" + 
                    "5. Modify Instructions");
        }else if (input == 0){
            break;
        } else {
            System.out.println("Menu\n" + "Please Select one of the following" +
    " menu options.\n"+ "1. Add Recipe\n" + "2. Print All Recipe Details\n" +
    "3. Print All Recipe Names\n" + "4. Delete Recipe\n" + "5. Edit Recipe");
        }
        System.out.println("Menu\n" + "Please Select one of the following" +
    " menu options.\n"+ "1. Add Recipe\n" + "2. Print All Recipe Details\n" +
    "3. Print All Recipe Names\n" + "4. Delete Recipe\n" + "5. Edit Recipe");
    }
    }
    */
}
}

