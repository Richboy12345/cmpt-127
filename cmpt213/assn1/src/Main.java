/*
 * Tokimon main file by Richard Zhang, 301402349
 *
 * Main class
 * contains main function, as well as other functions for editing the tokimon arraylist
 *
 */

import java.util.*;
import java.lang.*;

public class Main {

     //global variable declarations
     Scanner scan = new Scanner(System.in);
     ArrayList<Tokimon> tokimons = new ArrayList<Tokimon>();

     public void displayMainMenu() {
          System.out.print("*************\n * Main Menu *\n *************\n 1. List Tokimons\n 2. Add a new Tokimon\n 3. Remove a Tokimon\n 4. Change Tokimon strength\n 5. DEBUG: Dump objects toString\n 6. Exit\n Which operation should be performed? ");
          int choice = scan.nextInt();
          while (choice < 1 || 6 < choice) {
               System.out.print("User entry was invalid, please try again: ");
               choice = scan.nextInt();
          }
          scan.nextLine();
          switch(choice) {
               case 1:
                    displayAllTokis();
                    break;
               case 2:
                    addNewToki();
                    break;
               case 3:
                    deleteToki();
                    break;
               case 4:
                    alterToki();
                    break;
               case 5:
                    debug();
                    break;
               case 6:
                    return;
          }
     }

     public void displayAllTokis() {
          System.out.println("*********************\n * List of Tokimons: *\n *********************");
          for (int i = 0; i < tokimons.size(); i++) {
               System.out.println((i + 1) + ". " + tokimons.get(i).getName() + "; Type: " + tokimons.get(i).getType() + ", Size: " + tokimons.get(i).getSize() + "m, Strength: " + tokimons.get(i).getStrength() + ".");
          }
          System.out.print("Press enter to return to the main menu...");
          scan.nextLine();
          displayMainMenu();
     }

     public void addNewToki() {
          System.out.println("Adding new Tokimon to the database.");
          System.out.print("Enter its name: ");
          String name = scan.nextLine();
          System.out.print("Enter its type: ");
          String type = scan.nextLine();
          System.out.print("Enter its size: ");
          double size = scan.nextDouble();
          scan.nextLine();
          Tokimon toki = new Tokimon(name, type, size);
          tokimons.add(toki);
          displayMainMenu();
     }

     public void deleteToki() {
          displayAllTokis();
          System.out.print("Which entry should be removed? Enter 0 to cancel: ");
          int choice = scan.nextInt();
          while (choice < 0 || tokimons.size() < choice) {
               System.out.print("User entry was invalid, please try again: ");
               choice = scan.nextInt();
          }
          scan.nextLine();
          if (choice == 0) {
               System.out.println("Operation cancelled, returning to menu.");
          }
          else {
               String name = tokimons.get(choice - 1).getName();
               tokimons.remove(choice - 1);
               System.out.println(name + "was removed from the list, returning to menu.");
          }
          displayMainMenu();
     }

     public void alterToki() {
          displayAllTokis();
          System.out.print("Which entry should be changed? Enter 0 to cancel: ");
          int choice = scan.nextInt();
          while (choice < 0 || tokimons.size() < choice) {
               System.out.print("User entry was invalid, please try again: ");
               choice = scan.nextInt();
          }
          scan.nextLine();
          if (choice == 0) {
               System.out.println("Operation cancelled, returning to menu.");
          }
          else {
               String name = tokimons.get(choice - 1).getName();
               int strength = tokimons.get(choice - 1).getStrength();
               System.out.print(name + " currently has a strength of " + strength + ". By how much should it change? ");
               int change = scan.nextInt();
               change += strength;
               while (change < 0 || change > 100) {
                    System.out.print("User entry was invalid, please try again: ");
                    change = scan.nextInt();
                    change += strength;
               }
               scan.nextLine();
               tokimons.get(choice - 1).setStrength(change);
               System.out.println(name + " had their strength changed from " + strength + " to " + change + ", returning to menu.");
          }
          displayMainMenu();
     }

     public void debug() {
          for (int i = 0; i < tokimons.size(); i++) {
               System.out.println(tokimons.get(i).toString());
          }
     }
     public static void main(String[] args) {
          System.out.println("***********************************************\n * Tokimon Tracker by Richard Zhang, 301402349 *\n ***********************************************");
          displayMainMenu();
     }
}
