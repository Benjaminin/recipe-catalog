package recipecatalog;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Benjamin Tancl
 */
public class Ingredient {
    
    //Declare Variables
    private String ingredientName;
    private String ingredientMeasure;
    private double ingredientAmount;
    private double ingredientCalories;
    
    
    //accessor & Muator Methods//
    
    public String getIngredientName(){
        return ingredientName;
    }
    
    public void setIngredientName(){
        this.ingredientName = ingredientName;
    }
    
    public String getIngredientMeasure(){
        return ingredientMeasure;
    }
    public void setIngredientMeasrue(){
        this.ingredientMeasure = ingredientMeasure;
    }
    public double getIngredientAmount(){
        return ingredientAmount;
    }
    public void setIngredientAmount(){
        this.ingredientAmount = ingredientAmount;
    }
    public double getIngredientCalories(){
        return ingredientCalories;
    }
    
    public void setIngredientCalories(){
        this.ingredientCalories = ingredientCalories;
    }
    //end methods
    
    
    //default constructor
    
    public Ingredient(){
        ingredientName = "";
        ingredientMeasure = "";
        ingredientAmount = 0.0;
        ingredientCalories = 0.0;
    }
    
    public Ingredient(String ingredientName, String ingredientMeasure, double
            ingredientAmount, double ingredientCalories){
        this.ingredientName = ingredientName;
        this.ingredientMeasure = ingredientMeasure;
        this.ingredientAmount = ingredientAmount;
        this.ingredientCalories = ingredientCalories;
    }
    
    public Ingredient addIngredient(String tempIngredientName){
        Scanner ingIn = new Scanner(System.in);
        
        tempIngredientName = tempIngredientName;
        
        String tempIngredientMeasure;
        double tempIngredientAmount;
        double tempIngredientCalories;
        
        //prompt user for input
        System.out.println("Pleaes enter a unit of measure for this inredient." +
                "(cups, lbs, grams, tspn, etc.)");
                tempIngredientMeasure = ingIn.nextLine();
        System.out.println("Please enter the number of " + tempIngredientMeasure +
                " of " + tempIngredientName + ".");
                tempIngredientAmount = ingIn.nextDouble();
        System.out.println("How many calories are in " + tempIngredientAmount + 
                " " + tempIngredientMeasure + " of " + tempIngredientName + "?");
                tempIngredientCalories = ingIn.nextDouble();
                
        Ingredient tempNewIngredient = new Ingredient(tempIngredientName,
            tempIngredientMeasure, tempIngredientAmount, tempIngredientCalories);
        
        return tempNewIngredient;
    }
}
