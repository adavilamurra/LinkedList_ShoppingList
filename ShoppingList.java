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
import java.util.*;
import java.text.*;

public class ShoppingList {
  public Item[] newItem;
  public Item head;
  public Item prev;
  public Item temp;
  
  //default constructor
  public ShoppingList(){
    head = null;
  }
  
  //list constructor
  public ShoppingList(int numItems){
    Scanner reader = new Scanner(System.in);
    newItem = new Item[numItems];
    
    for(int i = 0; i < newItem.length; i++){
      newItem[i] = new Item();
      System.out.println("Enter name of item " + (i+1) + " : ");
      newItem[i].setName(reader.nextLine());
      while(true){          //check for input errors
        try{
          System.out.println("Enter quantity of items being purchased: ");
          newItem[i].setQuantity(reader.nextInt());
          break;
        }
        catch(InputMismatchException error){
          System.out.println("ERROR. Invalid number, try again. Can only use integers.");
          reader.next();
          continue;
        }
      }
      while(true){          //check for input errors
        try{
          System.out.println("Enter price of item: ");
          newItem[i].setPrice(reader.nextDouble());
          reader.nextLine();
          break;
        }
        catch(InputMismatchException error){
          System.out.println("ERROR. Invalid number, try again.");
          reader.next();
          continue;
        }
      }
    }
    for(int i = 0; i < newItem.length; i++){
      if(i == newItem.length-1){
        newItem[i].setNextItem(null);
      }
      else{
        newItem[i].setNextItem(newItem[i+1]);
      }
    }
    reader.close();
    head = newItem[0];
  }
  
  
    public static void main (String[]args){
    //initialize empty list
    ShoppingList list = new ShoppingList();   
        
    System.out.println();      //print empty line
    
    //print empty list
    list.printList();
    
    System.out.println();      //print empty line
    
    int numItems = 0;
    
    //Ask for number of items
    Scanner reader = new Scanner(System.in);
    while(true){
      try{
        System.out.println("Enter number of items (you need at least 5): ");
        numItems = reader.nextInt();
        if(4 < numItems){
           break;
        }
        System.out.println("Invalid number.");
      }
      catch(InputMismatchException error){
        System.out.println("ERROR. Invalid number, try again. Can only use integers.");
        reader.next();
        continue;
      }
    }
    reader.close();
    
    //list with at least 5 items
    list = new ShoppingList(numItems);
    
    System.out.println();      //print empty line
    
    //print list
    list.printList();
    
    System.out.println("-     -     -     -     -     -     -     -     -     ");
    System.out.println();      //print empty line
    
    //insert new Item (position 2) and get new head
    list.head = list.insertItem(2, "chocolate", 3, 6.0);
    
    //print list
    list.printList();
    
    System.out.println("-     -     -     -     -     -     -     -     -     ");
    System.out.println();      //print empty line
    
    //delete item from list (position 4)
    boolean itemDeleted = list.deleteItem(4);
    
    //print list
    list.printList();
    
    System.out.println("-     -     -     -     -     -     -     -     -     ");
    System.out.println();      //print empty line
    
    //search for item
    String searchee = "eggs";
    if(list.searchItem(searchee) == -1){
      System.out.println("The position of the item '" + searchee + "' was not found");
    }
    else{
      System.out.println("The position of the item '" + searchee + "' is " + list.searchItem(searchee));
    }
    
    System.out.println();      //print empty line   
    System.out.println("-     -     -     -     -     -     -     -     -     ");
    System.out.println();      //print empty line
    
    System.out.println("The total cost of the shopping list is: $" + list.totalCost());
  }
    
  //print shopping list
  public void printList(){
    temp = head;
    if(temp == null){
      System.out.println("This list is empty.");
    }
    while(temp != null){
      System.out.println("Item name: " + temp.name);
      System.out.println("Quantity: " + temp.quantity);
      System.out.println("Price: " + temp.price);
      if(temp.nextItem != null){
        System.out.println("Next Item: " + temp.nextItem.name);
      }
      System.out.println();
      temp = temp.nextItem;
    }
  }
  
  //insert an item to the list
  public Item insertItem(int position, String name, int qty, double price){
    Item insertee = new Item(name, qty, price);
    if(position < 0) {
      System.out.println("Invalid position given");
      return head;
    }
    System.out.println("Inserting item in position: " + position);
    if (head == null){
      insertee.nextItem = null;
      return insertee;
    }
    if (position == 0){
      insertee.nextItem = head;
      return insertee;
    }
    
    temp = head;
    int i = 0;
    while(temp != null){
      if(i == position){
        prev.nextItem = insertee;
        insertee.nextItem = temp;
        return head;
      }
      prev = temp;
      temp = temp.nextItem;
      i++;
    }
    if(i < position){
      prev.nextItem = insertee;
    }
    return head;
  }
  
  //delete an item from the list
  public boolean deleteItem(int position){
    if(position == 0){
      head = head.nextItem;
      System.out.println("Deleting item from position " + position);
      return true;
    }
    temp = head.nextItem;
    prev = head;
    int i=1;
    while(temp != null){
      if(i == position){
       prev.nextItem = temp.nextItem;
       System.out.println("Deleting item from position " + position);
       return true;
      }
      prev = temp;
      temp = temp.nextItem;
      i++;
    }
    System.out.println("Invalid position, no item was deleted.");
    return false;
  }
  
  //search for an item based on the name
  public int searchItem(String searchee){
    int i = 0;
    temp = head;
    while(temp != null){
      if(searchee.equals(temp.name)){
        return i;
      }
      temp = temp.nextItem;
      i++;
    }
      return -1;
  }
  
  //calculate total cost of shopping list
  public double totalCost(){
    double total = 0;
    temp = head;
    while(temp != null){
      total += (temp.quantity * temp.price);
      
      temp = temp.nextItem;
    }
    return total;
  }
}