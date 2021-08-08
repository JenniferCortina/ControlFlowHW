import java.util.*;

public class Question {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        AsciiChars.printNumbers();
		AsciiChars.printLowerCase();
		AsciiChars.printUpperCase();
        enterName();
		System.out.println("Hello, would you like to complete a survey? y/n");
        String response = scan.next();
        response = response.toLowerCase();
		if (response.equals("y") || response.equals("yes")) {
        Survey.begin();
    } else {
        System.out.println("Okay, maybe next time. Have a great day!");
    }

}

    public static void enterName() {
        System.out.println("Please enter your first name.");
        String name = scan.nextLine();
        System.out.println("Hello " + name);
    }
}

