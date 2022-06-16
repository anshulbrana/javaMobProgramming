package launchers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestSerialization {
    public static void test(){
        File file = new File("./src/test/resources/17-contacts.csv");

        try(Scanner scanner = new Scanner(file)){
            scanner.nextLine();

            List<String> lines = new ArrayList<>();

            while (scanner.hasNext()){
                lines.add(scanner.nextLine().trim());
            }

            System.out.println(lines.get(0));

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
