package utilities;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataGenerateHelper {
    private static volatile DataGenerateHelper dataGenerateHelper;
    private Locale locale = new Locale("en");
    private Faker faker = new Faker(locale);

    public static DataGenerateHelper getData() {
        if (dataGenerateHelper == null) {
            dataGenerateHelper = new DataGenerateHelper();
        }
        return dataGenerateHelper;
    }

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getFullName() {
        return faker.name().fullName();
    }

    public String getAddress() {
        return faker.address().streetAddress();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getPhone() {
        return faker.phoneNumber().phoneNumber();
    }

    public String getCity() {
        return faker.address().city();
    }

    public String getCityName() {
        return faker.address().cityName();
    }

    public String getPassword() {
        return faker.internet().password(6, 20);
    }

    public int getNumber() {
        return faker.random().nextInt(9999);
    }
}
