import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MeltingIceberg {

    private static Scanner scanner = null;

    public static int countingTime(Scanner scanner) throws FileNotFoundException {
        scanner = new Scanner(new FileInputStream("D:\\ModisJavaAcademy\\git\\modis-java-spring\\homeworks\\src\\iceberg.txt"));
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        long icecubesCount = 0;

        while (scanner.hasNextLine()){

            for (int row = 0; row < n; row++) {
                String line = scanner.nextLine();
                matrix[row] = line.toCharArray();
                char icecube = '*';
                icecubesCount += line.chars().filter(ch -> ch == icecube).count();
            }
        }

        int hours = 0;
        char[][] nextMatrix = new char[n][n];
        while (icecubesCount > 0) {
            boolean somethingMelted = false;

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    char currentCell = matrix[row][col];
                    if (currentCell == '0') {
                        nextMatrix[row][col] = '0';
                    }

                    if (currentCell == '*') {
                        if (isMelting(matrix, row, col)) {
                            nextMatrix[row][col] = '0';
                            icecubesCount--;
                            somethingMelted = true;
                        } else {
                            nextMatrix[row][col] = '*';
                        }
                    }
                }
            }
            if (somethingMelted) {
                hours++;
            }
            updateMyMatrix(matrix, nextMatrix);
        }

        return hours;
    }
    private static void updateMyMatrix(char[][] matrix, char[][] nextMatrix) {
        for (int row = 0; row < nextMatrix.length; row++) {
            for (int col = 0; col < nextMatrix[row].length; col++) {
                matrix[row][col] = nextMatrix[row][col];
            }
        }
    }

    private static boolean isMelting(char[][] matrix, int row, int col) {
        int countZeros = 0;
        if (matrix[row + 1][col] == '0') {
            countZeros++;
        }
        if (matrix[row - 1][col] == '0') {
            countZeros++;
        }
        if (matrix[row][col + 1] == '0') {
            countZeros++;
        }
        if (matrix[row][col - 1] == '0') {
            countZeros++;
        }
        if (countZeros >= 2) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(countingTime(scanner));

    }


}

