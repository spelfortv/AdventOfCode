import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File file = new File("Datasets/data.txt");
        int count = 0;
        int levelA;
        int levelB;
        boolean check;
        int i;
        int increase = 0;
        String line = new String();

        try {

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                check = true;
                i = 0;
                increase = 0;
                line = scanner.nextLine();
                String[] parts = line.split(" ");
                levelA = Integer.parseInt(parts[i]);

                while (i + 1 < parts.length && check) {

                    i++;
                    levelB = Integer.parseInt(parts[i]);
                    if (levelA - levelB == 0 || Math.abs(levelA - levelB) > 3)
                        check = false;
                    if (increase == 0)
                        increase = levelB - levelA;
                    if ((increase > 0 && levelB - levelA < 0) || (increase < 0 && levelB - levelA > 0))
                        check = false;
                    levelA = levelB;

                }

                count += check ? 1 : 0;

            }

            scanner.close();

        } catch (Exception e) {

            System.out.println("File not found");
            e.printStackTrace();

        }

        System.out.println("Count = " + count);
    }
}
