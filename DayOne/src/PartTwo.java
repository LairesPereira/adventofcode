import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class PartTwo {
    // verificar se o primeiro carctere é um digito
    // verificar se o ultimo carctere é um digito
    // criar uma array de multiplos valores que ira receber todos os matchs de numeros e strings sequencialmente
    // pegar o primeiro e o ultimo elemento e fazer as conversoes necessaris se forem strings

   public static void main(String[] args) throws IOException {
       Path path = Paths.get("/Users/Dev/Documents/Faculdade/Advent of Code/DayOne/src/calibrationEncoded.txt");
       Scanner scanner = new Scanner(path);

       int totalSum = 0;
       Map<String, Integer> convertionMap = Map.ofEntries(
               Map.entry("one", 1),
               Map.entry("two", 2),
               Map.entry("three", 3),
               Map.entry("four", 4),
               Map.entry("five", 5),
               Map.entry("six", 6),
               Map.entry("seven", 7),
               Map.entry("eight", 8),
               Map.entry("nine", 9),
               Map.entry("1", 1),
               Map.entry("2", 2),
               Map.entry("3", 3),
               Map.entry("4", 4),
               Map.entry("5", 5),
               Map.entry("6", 6),
               Map.entry("7", 7),
               Map.entry("8", 8),
               Map.entry("9", 9)
       );

     while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            Map<Integer, String> extraction = destructureString(nextLine);
            System.out.println(nextLine);
            System.out.println(extraction);
            int min = Collections.min(extraction.keySet());
            int max = Collections.max(extraction.keySet());

            System.out.println("mapa de conversao: " + convertionMap.get(extraction.get(min)));
            System.out.println("mapa de conversao: " + convertionMap.get(extraction.get(max)));

            String concatValues = Integer.toString(convertionMap.get(extraction.get(min))) + Integer.toString(convertionMap.get(extraction.get(max)));

            totalSum += Integer.parseInt(concatValues);
        }
     System.out.println(totalSum);
   }

   public static Map<Integer, String> destructureString(String encodedString) {

       String[] numbersAsString = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

       Map<Integer, String> map = new HashMap<>(){};

       char firstChar = encodedString.charAt(0);
       String firstCharString = String.valueOf(firstChar);
       char lastChar = encodedString.charAt(encodedString.length() - 1);
       String lastCharString = String.valueOf(lastChar);

       if(Character.isDigit(firstChar) || Character.isDigit(lastChar)) {
           if(Character.isDigit(firstChar) && Character.isDigit(lastChar)) {
               map.put(0, firstCharString);
               map.put(100, lastCharString);
               return map;
           }

           if (Character.isDigit(firstChar)) {
               map.put(0, firstCharString);
           } else if (Character.isDigit(lastChar)) {
               map.put(100, lastCharString);
           }
           for (String number:numbersAsString) {
               if(encodedString.indexOf(number) == -1) {
                    continue; // ignore cases that dont match
               }
               map.put(encodedString.indexOf(number), number);
               map.put(encodedString.lastIndexOf(number), number);
           }
       } else {
           for (String number:numbersAsString) {
               if(encodedString.indexOf(number) == -1) {
                   continue;
               }
               map.put(encodedString.indexOf(number), number);
               map.put(encodedString.lastIndexOf(number), number);
           }
       }
       return map;
   }



}
