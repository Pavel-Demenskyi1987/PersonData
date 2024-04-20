import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите данные в формате: Фамилия Имя Отчество дата_рождения номер_телефона пол");
            String input = scanner.nextLine();

            String[] data = input.split(" ");
            if (data.length != 6) {
                System.out.println("Ошибка: введено неверное количество данных.");
                return;
            }

            String surname = data[0];
            String firstName = data[1];
            String middleName = data[2];

            LocalDate birthDate;
            try {
                birthDate = LocalDate.parse(data[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            } catch (Exception e) {
                System.out.println("Ошибка: неверный формат даты рождения.");
                return;
            }

            long phoneNumber;
            try {
                phoneNumber = Long.parseLong(data[4]);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: неверный формат номера телефона.");
                return;
            }

            char gender;
            if (data[5].length() != 1 || !(data[5].equalsIgnoreCase("f") || data[5].equalsIgnoreCase("m"))) {
                System.out.println("Ошибка: неверный формат пола.");
                return;
            }
            gender = data[5].charAt(0);

            PersonData person = new PersonData(surname, firstName, middleName, birthDate, phoneNumber, gender);
            writeToTextFile(person);
            System.out.println("Данные успешно записаны в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void writeToTextFile(PersonData person) throws IOException {
        String filename = person.getFullName().replaceAll(" ", "_") + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(person.getFullName() + " ");
            writer.write(person.getFormattedBirthDate() + " ");
            writer.write(Long.toString(person.getPhoneNumber()) + " ");
            writer.write(Character.toString(person.getGender()));
            writer.newLine();
        }
    }
}