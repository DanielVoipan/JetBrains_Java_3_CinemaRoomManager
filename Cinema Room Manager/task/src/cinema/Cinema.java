package cinema;

import java.util.*;
public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // making the
        System.out.println("Enter the number of rows:");
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeats = scanner.nextInt();
        String[][] cinema = new String[numberOfRows][numberOfSeats];
        // show the choices
        getChoice();
        // get the choice
        int decision = scanner.nextInt();

        int rowNumber = 0;
        int seatNumber = 0;

        int[][] tickets = new int[numberOfRows][numberOfSeats];

        // having a loop allows us to not end the program and buy more tickets
        while (decision != 0) {
            switch (decision) {
                case 0:
                    // decision = 0, it means the loop will end, program exit.
                    decision = 0;
                    break;
                case 1:
                    // output the cinema based on structure and tickets bought
                    outputCinema(cinema, numberOfSeats, numberOfRows, tickets);
                    // show the choices
                    getChoice();
                    decision = scanner.nextInt();
                    break;
                case 2:
                    // in the loop, buy the ticket
                    System.out.println("Enter a row number:");
                    rowNumber = scanner.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    seatNumber = scanner.nextInt();
                    // save the bought ticket in an array
                    tickets[rowNumber - 1][seatNumber - 1] = 1;
                    // calculate the price ticket
                    int seatPrice = calculatePrice(rowNumber, seatNumber, numberOfSeats, numberOfRows);
                    System.out.println("Ticket price: $" +seatPrice);
                    System.out.println();
                    // show the choices
                    getChoice();
                    decision = scanner.nextInt();
                    break;
                default:
                    // if any other number is entered, show the choices again.
                    getChoice();
                    decision = scanner.nextInt();
                    break;
            }
        }
    }
    public static void outputCinema(String[][] cinema, int numberOfSeats, int numberOfRows, int[][] tickets) {
        System.out.println("Cinema:");
        // showing the first line of the cinema that contains the number of the collumns
        for (int k = 0; k <= numberOfSeats; k++) {
            if (k == 0) {
                System.out.print("  ");
            } else if (k == numberOfSeats) {
                System.out.print(k + "\n");
            } else {
                System.out.print(k + " ");
            }
        }
        // showing the rest of the lines
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfSeats; j++) {
                // if is the first collumn, show the number of the lines
                if (j == 0) {
                    System.out.print(i + 1 + " ");
                }
                // if the array tickets contains 1 where the ticket was bought (number of line and number of collumn)
                // put B instead of S
                if (tickets[i][j] == 1) {
                    cinema[i][j] = "B";
                } else {
                    cinema[i][j] = "S";
                }
                // if is the last collumn of the line, output a newline else just a space
                if (j == numberOfSeats - 1) {
                    System.out.print(cinema[i][j] + "\n");
                } else {
                    System.out.print(cinema[i][j] + " ");
                }
            }
        }
    }
    public static int calculatePrice(int rowNumber, int seatNumber, int numberOfSeats, int numberOfRows) {
        int seatPrice = 0;
        int totalNumberSeats = numberOfSeats * numberOfRows;
        if (totalNumberSeats <= 60) {
            seatPrice = 10;
        } else {
            // split the cinema in two pieces
            int splitRows = numberOfRows / 2;
            int firsthalf = splitRows;
            // if row number is in the first half, the price is 10 else is 8
            if (rowNumber <= firsthalf) {
                seatPrice = 10;
            } else {
                seatPrice = 8;
            }
        }
        return seatPrice;
    }

    public static void getChoice() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("0. Exit");
    }
}