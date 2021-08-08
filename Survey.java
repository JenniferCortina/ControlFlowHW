import java.util.*;

public class Survey {
    public static boolean hasRedCar;
    public static String favoritePet;
    public static int petAge;
    public static int luckyNum;
    public static int QB;
    public static boolean hasQB;
    public static int modelYear;
    public static String actor;
    public static int randNum;

    static void begin() {
        hasRedCar = questionOne();
        favoritePet = questionTwo();
        petAge = questionThree(favoritePet);
        luckyNum = questionFour();
        System.out.println("Do you have a favorite quarterback?");
        String response = Question.scan.next();
        response = response.toLowerCase();
        if (response.equals("y") || response.equals("yes")) {
            QB = questionFive();
            hasQB = true;
        } else {
            QB = 0;
            hasQB = false;
        }
        modelYear = questionSix();
        actor = questionSeven();
        randNum = questionEight();

        output();
    }

    static boolean questionOne() {
        boolean valid;

        do {
            System.out.println("Do you have a red car? (y/n)");
            String redCar = Question.scan.next();
            redCar = redCar.toLowerCase();

            switch (redCar) {
                case "y", "yes" -> {
                    return true;
                }
                case "n", "no" -> {
                    return false;
                }
                default -> {
                    valid = false;
                }
            }

            if (!valid) System.out.println("Invalid response.");
        } while (!valid);

        return false;
    }

    static String questionTwo() {
        System.out.println("What is the name of your favorite pet?");
        Question.scan.nextLine();
        return Question.scan.nextLine();
    }

    static int questionThree(String name) {
        System.out.println("How old is " + name);
        return Question.scan.nextInt();
    }

    static int questionFour() {
        System.out.println("What is your lucky number?");
        return Question.scan.nextInt();
    }

    static int questionFive() {
        System.out.println("What is their number?");
        return Question.scan.nextInt();
    }

    static int questionSix() {
        boolean valid = false;
        do {
            System.out.println("What are the last two digits of your car's model year");
            int modelYear = Question.scan.nextInt();
            if (modelYear >= 0 && modelYear < 99) {
                return modelYear;
            } else {
                System.out.println("Invalid Response.");
            }
        } while (!valid);
        return 0;
    }

    static String questionSeven() {
        System.out.println("What is the first name of you favorite actress or actor?");
        return Question.scan.next();
    }

    static int questionEight() {
        boolean valid = false;
        do {
            System.out.println("Enter a random number between 1 and 50");
            int num = Question.scan.nextInt();
            if (num >= 0 && num < 50) {
                return num;
            } else {
                System.out.println("Invalid Response.");
            }
        } while (!valid);
        return 0;
    }

    static void output() {
        final int MAX_NUMBER = 65;
        final int MAX_MAGIC_NUMBER = 75;

        final int randOne = randomInt(1, 50);
        final int randTwo = randomInt(1, 50);
        final int randThree = randomInt(1, 50);

        int magicBall;

        if (hasQB) magicBall = (QB * randOne) % MAX_MAGIC_NUMBER;
        else magicBall = (luckyNum * randOne) % MAX_MAGIC_NUMBER;

        int numOne = ((int) favoritePet.charAt(2)) % MAX_NUMBER;
        int numTwo = (modelYear + luckyNum) % MAX_NUMBER;
        int numThree = (randNum - randTwo) % MAX_NUMBER;
        int numFour = ((int) actor.charAt(actor.length() - 1)) % MAX_NUMBER;
        int numFive = (QB + petAge + luckyNum) % MAX_NUMBER;

        String output = String.format("Lottery Numbers: %o, %o, %o, %o, and %o Magic Ball: %o", numOne, numTwo, numThree, numFour, numFive, magicBall);
        System.out.println(output);
    }

    static int randomInt(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min) + min);
    }
}
