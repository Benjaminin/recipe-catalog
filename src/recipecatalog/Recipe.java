/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipecatalog;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;


/**
 *
 * @author Benjamin Tancl
 */
public class Recipe {
   
    //variables
    
    String recipeName;
    private int recipeServings;
    private ArrayList<Ingredient> recipeIngredients;
    private ArrayList<String> recipeInstructions;
    private double recipeCalories;
    private double recipeCaloriesPerServing;
    
    //Accessors & Mutators

    /**
     *
     * @return recipeName the name of the recipe
     */
    
    public String getRecipeName(){
            return recipeName;
                    }

    /**
     *
     * @param name the name of the recipe
     */
    public void setRecipeName(String name){
            this.recipeName = name;        
    }
    
    /**
     *
     * @return recipeServings the number of servings in the recipe
     */
    public int getRecipeServings(){
            return recipeServings;
    }
    
    /**
     *
     * @param servings the number of servings in the recipe
     */
    public void setRecipeServings(int servings){
            this.recipeServings = servings;
    }
    
    /**
     *
     * @return recipeIngredients the list of ingredients in the given recipe
     */
    public ArrayList<Ingredient> getRecipeIngredients(){
        return recipeIngredients;
    }
    
    /**
     *
     * @param ingredients the list of ingredients for the given recipe
     */
    public void setRecipeIngredients(ArrayList<Ingredient> ingredients){
        this.recipeIngredients = ingredients;
    }

    /**
     *
     * @return recipeInstructions the array list containing instructions for the recipe
     */
    public ArrayList<String> getRecipeInstructions(){
        return recipeInstructions;
    }
    
    /**
     *
     * @param instructions the arraylist containing instructions
     */
    public void setRecipeInstructions(ArrayList<String> instructions){
        this.recipeInstructions = instructions;
    }
    
    public double getRecipeCalories(){
        return recipeCalories;
    }
    public void setRecipeCalories(double calories){
        this.recipeCalories = calories;
    }
    public double getRecipeCaloriesPerServing(){
        return recipeCaloriesPerServing;
    }
    //default constructor
    public Recipe(){
        this.recipeName = "";
        this.recipeServings = 0;
        this.recipeIngredients = new ArrayList<>();
        this.recipeInstructions = new ArrayList<>();
        this.recipeCalories = 0.0;
        this.recipeCaloriesPerServing = 0.0;
    }
    
    //overloaded constructor
    
    public Recipe(String recipeName, int recipeServings,
            ArrayList<Ingredient> recipeIngredients, ArrayList<String> recipeInstructions,
            double recipeCalories,
            double recipeCaloriesPerServing){
        
        this.recipeName = recipeName;
        this.recipeServings = recipeServings;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstructions = recipeInstructions;
        this.recipeCalories = recipeCalories;
        this.recipeCaloriesPerServing = recipeCaloriesPerServing;              
    }
   
   public double calculateRecipeCalories(Recipe recipeIn){
       double calories = 0.0;
       double sumcalories = 0.0;
       for (int i = 0; i < this.recipeIngredients.size();i++){
           calories = this.recipeIngredients.get(i).getIngredientCalories();
           
           sumcalories = sumcalories + calories;
       }
       return sumcalories;
   } 
    
   public Recipe addNewRecipe(){
    
    //initialize lists
    ArrayList<Ingredient> addRecipeIngredients = new ArrayList();
    ArrayList<String> addRecipeInstructions = new ArrayList();
    //initialize boolean variables
    boolean addMoreIngredients = true;
    boolean addMoreInstructions = true;
    //intiailize scanner
    
    Scanner scnr = new Scanner(System.in);
    
    //prompt user for a recipe name
    System.out.println("Please enter the recipe name: ");
    //set addRecipeName to user input
    String addRecipeName = scnr.nextLine();
    //prompt user for number of servings
    System.out.println("How many servings in " + addRecipeName + "?");
    //set addRecipeServings to user input
    int addRecipeServings = scnr.nextInt();
    //prompt user for ingredients
    
    do {
        System.out.println("Please enter an ingredient name, or type 'x' if you" +
                " are done: ");
        String addIngredientName = scnr.next();
            if(addIngredientName.equalsIgnoreCase("x")) {
                    addMoreIngredients = false;
            }
            else {
                Ingredient tempIngredient = new Ingredient().addIngredient(addIngredientName);
                addRecipeIngredients.add(tempIngredient);
            }
    }   while (addMoreIngredients);
            double calorieCount = 0.0;
    for (int i = 0; i < addRecipeIngredients.size(); i++){
            Ingredient currentIngredient = addRecipeIngredients.get(i);
            /*
            double ingredientAmount = currentIngredient.getIngredientAmount();
            */
            double ingredientCalories = currentIngredient.getIngredientCalories();
            calorieCount = calorieCount + ingredientCalories;
    }
            Double addRecipeCalories = calorieCount;
            Double addRecipeCaloriesPerServing = addRecipeCalories / addRecipeServings;
             
    do {
        System.out.println("Please type an instruction for " + addRecipeName + 
                ", or type 'done' to save this recipe and return to the main menu");
        String addInstruction = scnr.nextLine();
        if (addInstruction.equalsIgnoreCase("done")){
            addMoreInstructions = false;
            break;
        }
        else {
            addRecipeInstructions.add(addInstruction);
        }
    }   while (addMoreInstructions);
         /*
   
        for (int i = 0; i < recipeInstructions.size(); i++){
            String currentInstruction = recipeInstructions.get(i);
    }
        */
        Recipe newRecipe = new Recipe(addRecipeName, addRecipeServings, addRecipeIngredients,
                addRecipeInstructions, addRecipeCalories, addRecipeCaloriesPerServing);
        return newRecipe;
    }
   
        

   
   

    /*//validate servings
    int validateServings = scnr.nextInt();
        if (validateServings == (int) validateServings){
            if (validateServings <= 0 || validateServings >=100){
            System.out.println("Error: The number of servings must be between" + 
                    " 1 and 99");}
            else {
                int addServings = validateServings;
            }
        }
        else {
            System.out.println("Error: Please elect a number of servings between" + 
                    " 1 and 99.");
        }
        
            
            
                
                
                
                
                
             
            else if (validateServings == (int) validateServings){
                System.out.print("Error: Invalid type, ensure you entered an integer" + 
                        "(whole number) between 1 and 99.");
                        }
     
            
                    }
  
   }
    int addRecipeServings = scnr.nextInt();
     */  
    
    
    /**
     * The printRecipe Method prints to screen the recipe name, calories, servings 
     * and calories per serving by calling their corresponding attributes from the 
     * recipe. 
     * 
     * The printRecipe Method then prints recipeIngredients by iterating through
     * the recipeIngredientsList for the given recipe. The iteration relies
     * on initializing an Ingredient "currentIngredient", and variables
     * currentIngredientName, currentIngredient Measure, and currentIngredientAmount.
     * Each of these variables is then set using the respective get method for each
     * attribute of the Ingredient Object "currentIngredient". For each iteration
     * the ingredient is printed as (AMOUNT MEASURE OF INGREDIENTNAME \N) ie. 
     * (5) (Pounds) of (Cheese) NEW LINE
     * 
     * The printRecipe Method then prints recipeInstructions by iterating through 
     * the recipeInstructions list for the given recipe. Variable Instruction is initialized
     * and set to recipeInstructions.get(i). The Instruction string is printed
     * followed by a new line. Given that ArrayList<> recipeInstructions is not referencing a
     * list of objects (like the ingredients above)with multiple attributes, 
     * the only return for each call is the string as keyed by the user.
     */
 
    public void printRecipe(){
     
        DecimalFormat df = new DecimalFormat("0.00");
        
        System.out.println("Recipe Name: " + recipeName + "\nCalories: " +
                df.format(recipeCalories) + "\nServings: " + recipeServings + "\n" +
                "Calories Per Serving: " + df.format(recipeCaloriesPerServing) + "\nIngredients: ");

        for(int i = 0; i < recipeIngredients.size(); i++){
           Ingredient currentIngredient = recipeIngredients.get(i);
           String currentIngredientName = currentIngredient.getIngredientName();
           String currentIngredientMeasure = currentIngredient.getIngredientMeasure();
           Double currentIngredientAmount = currentIngredient.getIngredientAmount();
           
                System.out.print(currentIngredientAmount + " " + currentIngredientMeasure +
                        " of " + currentIngredientName + "\n");
        }
        //end print ingredients
        //begin print instructions
        System.out.print("Instructions: ");
        for (int i = 0; i <recipeInstructions.size(); i++){
            String Instruction = recipeInstructions.get(i);
            System.out.println(Instruction);
        }
    }
}