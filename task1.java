import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.*;



// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Добавить функции 1) Добавление номера
// 2) Вывод всего
public class task1{
     public static void main(String[] args) {
        File file = new File("phonBook.txt"); 
        HashMap<Integer, String> phonBook = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("-----------------------------");
            System.out.println("1 - Добавление номера");
            System.out.println("2 - вывести все контакты");
            System.out.println("3 - выход");
            System.out.println("-----------------------------");

            System.out.print("Выберите действие: ");
            choice = sc.nextInt();
            if (choice > 3){
               System.out.println("Вы ошиблись");
            } 
            if (choice == 3){
               System.out.println("До свидания");
            } 
            switch (choice) {          
               case 1:
                  addition();
                  break;
               case 2:
                  readAll();
                  break;
                  default:
                  break;
            };

        } while (choice != 3);
        try {
         Scanner scanner = new Scanner(file);
         while (scanner.hasNextLine()) {
             String line = scanner.nextLine();
             String[] parts = line.split(":");
             Integer key = Integer.parseInt(parts[0]);
             String value = parts[1];
             phonBook.put(key, value);
         }
         scanner.close();
        } 
        catch (FileNotFoundException e) {
           System.out.println("Ошибка: файл не найден.");
        }
        
      }
      public static void addition() {
         Scanner sc = new Scanner(System.in);
         System.out.print("Введите фамилию: ");
         String name = sc.nextLine().trim();
         System.out.print("Введите телефон: ");
         String phone = sc.nextLine().trim();
         String newLine = name + " " + phone;
         try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("phonBook.txt"), "UTF-8"));) {
             writer.write(newLine + "\n");
             System.out.println("Запись добавлена: " + newLine);
         } catch (IOException e) {
             System.err.println("Ошибка при записи в файл: " + e.getMessage());
         }
     }
     
     public static void readAll() {
         try (Scanner scanner = new Scanner(new File("phonBook.txt"), "UTF-8")) {
             while (scanner.hasNextLine()) {
                 String line = scanner.nextLine();
                 System.out.println(line);
             }
         } catch (FileNotFoundException e) {
             System.out.println("Ошибка: файл не найден.");
         }
     }
   }