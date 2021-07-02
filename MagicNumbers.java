import java.util.Scanner;

public class MagicNumbers {
    static Scanner scanner = new Scanner(System.in);

    /**
     * Purpose : Main method of the class,defines range and calls magicNumber method
     * @param args
     */
    public static void main(String[] args) {

        MagicNumbers mg = new MagicNumbers();
        System.out.println("Enter the number to define range : ");
        int n = scanner.nextInt();

        int range = (int) Math.pow(2, n);
        System.out.println("Your range is from 0 to " + range);

        mg.magicNumber(range);

    }

    /**
     * Purpose : Asks user to guess number in mind and using binary search it asks
     *  user whether number is between high and low values till final number is found
     *  and prints the guessed number
     *
     * @param range  taken input to define range for user to guess number
     */
    public void magicNumber(int range) {
        int leftIndex = 0;
        int rightIndex = range - 1;
        int middleIndex = (leftIndex + rightIndex) / 2;

        System.out.println();
        System.out.println("Think of number  in your mind between 0 and " + (range - 1));

        // performing binary search
        while (leftIndex < rightIndex) {

            System.out.println("Press 1 - if number is between " + leftIndex + " and " + middleIndex);
            System.out.println("Press 2 - if number is between " + (middleIndex + 1) + " and " + rightIndex);
            int userChoice = scanner.nextInt();

            if (userChoice == 1) {

                rightIndex = middleIndex;
                middleIndex = (leftIndex + rightIndex) / 2;

            } else if (userChoice == 2) {

                leftIndex = middleIndex + 1;
                middleIndex = (leftIndex + rightIndex) / 2;

            } else {

                System.out.println("Invalid Input!!!");

            }
        }

        System.out.println("Your number is : " + middleIndex);
    }
}