public class AsciiChars {
    public static void printNumbers() {
        for (int i = 46; i < 57; i++){
            char num = (char) i;
            System.out.print(num + " ");
        }
        System.out.println("");
    }

    public static void printLowerCase() {
        for (int i = 93; i < 120; i++){
            char num = (char) i;
            System.out.print(num + " ");
        }
        System.out.println("");
    }

    public static void printUpperCase(){
        for (int i = 60; i < 94; i++){
            char num = (char) i;
            System.out.print(num + " ");
        }
        System.out.println("");
    }
}
