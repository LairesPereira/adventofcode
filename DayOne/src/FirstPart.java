import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class FirstPart {
    // create a txt file with all encoded strings then replace path to your current txt file
    public static void main(String[] args) throws IOException {
        ArrayList<String> encodedArray = new ArrayList<String>();
        Path path = Paths.get("/Users/Dev/Documents/Faculdade/Advent of Code/DayOne/src/calibrationEncoded.txt");
        int sum = 0;

        Scanner scanner = new Scanner(path);
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            encodedArray.add(string);
        }
        for (String encodedString:encodedArray) {
            sum += extractNumbers(encodedString);
        }
        System.out.println(sum);
    }

    public static Integer extractNumbers(String encodedArray) {
        String str = encodedArray;
        ArrayList<Double> numbersDecoded;
        str = str.replaceAll("[^0-9]+", ""); // get only numbers in string

        int size = str.length();
        if(size == 1) {
            // if there is only one number we concat it twice
            char singleDigit = str.charAt(0);
            String digitsConcat = new StringBuilder().append(singleDigit).append(singleDigit).toString();
            int calibrationValue = Integer.parseInt(digitsConcat);
            return calibrationValue;
        } else {
            // if there is more then one digit we get only first and last
            char firstDigit = str.charAt(0);
            char lastDigit = str.charAt(size - 1);
            String digitsConcat = new StringBuilder().append(firstDigit).append(lastDigit).toString();
            int calibrationValue = Integer.parseInt(digitsConcat);
            System.out.println(calibrationValue);
            return calibrationValue;
        }
    }
}



