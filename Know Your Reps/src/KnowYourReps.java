import java.util.Scanner;

public class KnowYourReps {

    public static void main(String[] args) {
        System.out.println("Welcome to Know Your Reps!");
        menu();

        Scanner scnr = new Scanner(System.in);     
        String input = (scnr.next()).toLowerCase();
        System.out.println(input);        
        while (!input.equalsIgnoreCase("q")) {
            if (input.equalsIgnoreCase("l")) { 
                System.out.print("Enter Address: ");
                String address = scnr.nextLine(); 
                
            }
            else if (input.equalsIgnoreCase("f")) {
                System.out.println("Yay federal");
            }
            else {
                System.out.println("Invalid menu option.");
                menu();
                input = scnr.next();
            }
        }
        System.out.println("You have now quit the program.");
    }

    public static void menu() {
        System.out.print("Would you like to learn more information about your local or federal representatives or quit?");
        System.out.print(" - Local (L) ");
        System.out.print(" - Federal (F) ");
        System.out.println(" - Quit (Q) ");
        System.out.print("Option: ");
    }

}