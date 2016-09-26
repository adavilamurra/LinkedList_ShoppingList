/************************************************************************************
 **                                                                                **
 **    Code by: Alejandro Davila Murra                                             **
 **                                                                                **
 **    CS 2401: Elementary Data Structures and Algorithms                          **
 **    Instructor: Mahmud Shahriar Hossain                                         **
 **    TAs: Debakar Shamanta, Anthony M. Ortiz Cepeda, Andres H Olivas Aguilar     **
 **    Lab Assignment #4                                                           **
 **    Objective: The goal of this assignment is to practice implementing and      **
 **               using linked list data structures.                               **
 **    Background: You will design a basic program for keeping track of a shopping **
 **                list. Each item in the shopping list will be represented by a   **
 **                node in a linked list data structure.                           **
 **    Due Date: Sunday, March 6                                                   **
 **    Last modification: 3/06/2016                                                **
 **                                                                                **
 ************************************************************************************/

package ShoppingList_Lab;

public class Item {
  
  //declare variables
  String name;
  int quantity;
  double price;
  Item nextItem;
  
  //default constructor
  public Item(){
    
  }
  
  //constructors
  public Item(String name, int quantity, double price, Item nextItem){
    this.name = name;
    this.quantity = quantity;
    this.price = price;
    this.nextItem = nextItem;
  }
  
  public Item(String name, int quantity, double price){
    this.name = name;
    this.quantity = quantity;
    this.price = price;
  }
  
  //setters for all variables 
  public void setName(String name){
    this.name = name; 
  }
  
  public void setQuantity(int quantity){
    this.quantity = quantity; 
  }
  
  public void setPrice(double price){
    this.price = price; 
  }
  
  public void setNextItem(Item nextItem){
    this.nextItem = nextItem; 
  }
  
  //getters for all variables
  public String getName(){
    return name;
  }
  
  public int getQuantity(){
    return quantity;
  }
  
  public double getPrice(){
    return price;
  }
  
  public Item getNext(){
    return nextItem;
  }
  
}

