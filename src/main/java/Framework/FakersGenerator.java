package Framework;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import java.util.Locale;

public class FakersGenerator {
    private Faker fake;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
    private String password;

    public FakersGenerator(){
        fake = new Faker(new Locale("pt-BR"));
    }

    public String getFirstName(){
        firstName = fake.name().firstName();
        return firstName;
    }

    public String getLastName(){
        lastName = fake.name().lastName();
        return lastName;
    }

    public String getAddress(){
        address = fake.address().streetAddress();
        return address;
    }

    public String getEmail(){
        email = fake.internet().emailAddress();
        return email;
    }

    public String getPhone(){
        phone = fake.phoneNumber().phoneNumber();
        return phone;
    }

    public String getPassword(){
        password = fake.internet().password(6,10);
        FileOperation.setProperties("dadosDeEntradaParaoTeste","Password", password);
        return password;
    }
}
