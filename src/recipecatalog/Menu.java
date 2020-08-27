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
 * @author BTANC
 */
public class Menu{
    private Scanner input = new Scanner(System.in);  
    
    public void displayMainMenu(RecipeCatalog myRecipeCatalog){
            display: while(true) {
    System.out.println(" -- Main Menui -- \n");
    System.out.println(
        "Select an option: \n\n" +
        "   1) Add New Recipe\n" +
        "   2) Print Recipe Details\n" + 
        "   3) Print All Recipe Names\n" +
        "   4) Delete or Modify Existing Recipe\n" +
        "   5) Exit\n"
    );
    int selection = input.nextInt();
    input.nextLine();
    switch (selection) {
    case 1:
        myRecipeCatalog.AddRecipe();
        break;
        
    case 2:
        System.out.println("Which recipe?\n");
        Scanner recipeScnr = new Scanner(System.in);
        String selectedRecipeName = recipeScnr.next();
        myRecipeCatalog.printAllRecipeDetails(selectedRecipeName);
        break;
        
    case 3:
        for (int j = 0; j < myRecipeCatalog.recipeCatalog.size(); j++) {
        System.out.println((j + 1) + ": " +
        myRecipeCatalog.recipeCatalog.get(j).getRecipeName());
        }
        
        break;
    case 4:
        displayModifyRecipeMenu(myRecipeCatalog);
        break;
    case 5:
        break;
    default:
  System.out.println("Invalid selection.");
  break;
}
    }
            }
    
    public void displayModifyRecipeMenu(RecipeCatalog myRecipeCatalog){
        
        
        display: while(true) {
     
    System.out.println(" -- Modify Existing Recipe -- ");
    System.out.println(
        "   Select an option: \n" +
        "   1) Change Recipe Name\n" +
        "   2) Change Recipe Servings\n" +
        "   3) Change Recipe Calories\n " +
        "   4) View/Change Recipe Ingredients\n" +
        "   5) View/Change Recipe Instructions\n" +
        "   6) Return to Main Menu"
    );
    int selection = input.nextInt();
    input.nextLine();
     
    switch (selection) {
    case 1:
        System.out.println("Which recipe name would you like to change?");
        String selectedRecipeName;
        Scanner recipeScnr = new Scanner(System.in);
        selectedRecipeName = recipeScnr.nextLine();
        myRecipeCatalog.ChangeRecipeName(selectedRecipeName);
      break;
    case 2:
//
      break;
    case 3:
      System.out.println("Returning...");
      break display;
    case 4:
      System.out.println("Returning...");
      break display;
    case 5:
      System.out.println("Returning...");
      break display;
    case 6:
      System.out.println("Returning...");
      break display;
    }
     
  }
   
}
}


    
   
