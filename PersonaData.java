
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


class PersonData {
    private String surname;
    private String firstName;
    private String middleName;
    private LocalDate birthDate;
    private long phoneNumber;
    private char gender;

    public PersonData(String surname, String firstName, String middleName, LocalDate birthDate, long phoneNumber, char gender) {
        this.surname = surname;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getFullName() {
        return surname + " " + firstName + " " + middleName;
    }

    public String getFormattedBirthDate() {
        return birthDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public char getGender() {
        return gender;
    }
}


