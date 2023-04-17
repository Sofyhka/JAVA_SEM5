import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности Имени.

public class task2 {
   public static void main(String[] args) {
      HashMap<String, Integer> nameCount = new HashMap<>();
      try (Scanner scanner = new Scanner(new File("listEmployees.txt"), "UTF-8")) {
         while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(":");
            String name = parts[0].trim();
            Integer count = nameCount.getOrDefault(name, 0);
            nameCount.put(name, count + 1);
         }
      } catch (FileNotFoundException e) {
         System.out.println("Ошибка: файл не найден.");
         return;
      }
      List<Map.Entry<String, Integer>> sortList = new ArrayList<>(nameCount.entrySet());
      sortList.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
      for (Map.Entry<String, Integer> entry : sortList) {
         if (entry.getValue() > 1) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
         }
      }
   }
}
