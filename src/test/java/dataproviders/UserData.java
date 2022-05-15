package dataproviders;

import lombok.Getter;
import org.testng.annotations.DataProvider;
import pojo.User;

import java.util.Random;

public class UserData {

    private static User user;

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private static final String ALPHABET_PASSWORD = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?";

    public void randomUser() {
        if (user == null){
            user = User.builder()
                    .firstName(randomTextGenerator(7))
                    .lastName(randomTextGenerator(8))
                    .email(randomTextGenerator(10) + "@randomuser.com")
                    .password(randomPasswordGenerator(15))
                    .build();
        }
    }

    @DataProvider(name = "randomUser")
    public Object[][] randomUserDataProvider() {
        randomUser();
        return new Object[][] {{user}};
    }

    private String randomTextGenerator(int textLength) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder(textLength);
        for (int i = 0; i < textLength; i++) {
            builder.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return builder.toString();
    }

    private String randomPasswordGenerator(int passwordLength) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder(passwordLength);
        for (int i = 0; i < passwordLength; i++) {
            builder.append(ALPHABET_PASSWORD.charAt(random.nextInt(ALPHABET_PASSWORD.length())));
        }
        return builder.toString();
    }

    public User getUser() {
        randomUser();
        return user;
    }
}
