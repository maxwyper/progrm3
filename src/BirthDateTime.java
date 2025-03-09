import java.util.Scanner;

public class BirthDateTime {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the year
        int year = getRangedInt(scanner, "Enter your birth year (1950-2015): ", 1950, 2015);

        // Get the month
        int month = getRangedInt(scanner, "Enter your birth month (1-12): ", 1, 12);

        // Get the day based on the month
        int day = getDayForMonth(scanner, month);

        // Get the hour (1-24)
        int hour = getRangedInt(scanner, "Enter the hour of your birth (1-24): ", 1, 24);

        // Get the minute (1-59)
        int minute = getRangedInt(scanner, "Enter the minute of your birth (1-59): ", 1, 59);

        // Display the entered date and time
        System.out.printf("Your birth date and time is: %d-%02d-%02d %02d:%02d\n", year, month, day, hour, minute);
    }

    // Method to get a valid integer within a range
    public static int getRangedInt(Scanner scanner, String prompt, int min, int max) {
        int input;
        while (true) {
            System.out.print(prompt);
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("Input out of range. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    // Method to get a valid day based on the month
    public static int getDayForMonth(Scanner scanner, int month) {
        int day;
        int maxDays;

        // Determine the maximum days based on the month
        switch (month) {
            case 1:  // January
            case 3:  // March
            case 5:  // May
            case 7:  // July
            case 8:  // August
            case 10: // October
            case 12: // December
                maxDays = 31;
                break;
            case 4:  // April
            case 6:  // June
            case 9:  // September
            case 11: // November
                maxDays = 30;
                break;
            case 2:  // February
                maxDays = 29; // Leap year consideration
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + month);
        }

        // Get the day within the valid range for the month
        while (true) {
            day = getRangedInt(scanner, "Enter the day of the month (1-" + maxDays + "): ", 1, maxDays);
            return day;
        }
    }
}
