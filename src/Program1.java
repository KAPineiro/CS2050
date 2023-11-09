import java.util.Scanner;
public class Program1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the album builder.");
        System.out.println("We allow you to create up to three albums at a time.");
        System.out.println("We have 5 genres: hip-hop, easy listening, orchestral, your parents, and theatre.");
        System.out.println("Each album must have at least 10 songs.");
        Album[] albums = new Album[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter details for Album " + (i + 1));
            System.out.println("Enter the title:");
            String title = getUserInputString(s);
            System.out.println("Enter one performer:");
            String performer = getUserInputString(s);
            System.out.println("Enter the genre (hip-hop, easy listening, orchestral, your parents, or theatre):");
            String genre = getUserInputString(s);
            System.out.println("Enter the number of songs (integer):");
            int numSongs = getUserInputInt(s);
            albums[i] = new Album(title, performer, genre, numSongs);
            System.out.println("Album " + (i + 1) + " created: " + albums[i]);
        }
    }

    private static String getUserInputString(Scanner s) {
        String input;
        do {
            input = s.nextLine().trim();
            if (input.matches(".*\\d+.*")) {
                System.out.println("Invalid input. Please enter a string (word) without numbers.");
            } else if (input.isEmpty()) {
                System.out.println("Invalid input. Please enter a non-empty string.");
            }
        } while (input.matches(".*\\d+.*") || input.isEmpty());
        return input;
    }

    private static int getUserInputInt(Scanner s) {
        int num = 0;
        boolean validInput = false;
        do {
            String input = s.nextLine();
            try {
                num = Integer.parseInt(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        } while (!validInput);
        return num;
    }
}






