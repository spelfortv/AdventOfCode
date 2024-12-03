import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        File file = new File("Datasets/data.txt");

        int i = -1;
        int[] column1 = new int[1000];
        int[] column2 = new int[1000];
        int distance = 0;

        try {

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                i++;
                column1[i] = Integer.parseInt(scanner.next());
                column2[i] = Integer.parseInt(scanner.next());

            }

            scanner.close();

        } catch(FileNotFoundException e) {

            System.out.println("El archivo no se encontró: " + e.getMessage());

        }

        System.out.println("Choose difficulty (1 or >1): ");
        Scanner scannerIn = new Scanner(System.in);

        if (scannerIn.nextInt() == 1) {

            Arrays.sort(column1);
            Arrays.sort(column2);

            while (i >= 0) {

                distance = Math.abs(column1[i] - column2[i]) + distance;
                i--;

            }

            System.out.println("Total distance is: " + distance);

        } else {

            int j;
            int count;
            while (i >= 0) {
                j = 0;
                count = 0;
                while (j < column2.length) {
                    if (column1[i] == column2[j])
                        count++;
                    j++;
                }
                column1[i] = column1[i] * count;
                i--;
            }
            System.out.println("The lists similarity score is: " + Arrays.stream(column1).sum());
        }

    }
}
