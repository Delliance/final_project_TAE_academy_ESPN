package dataproviders;

import dataproviders.pojos.PageRequiredData;
import org.testng.annotations.DataProvider;
import dataproviders.pojos.User;

import java.util.Random;

public class PageDataProvider {

    private static User user;

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private static final String ALPHABET_PASSWORD = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?";

    /**
     * Information required for the test of the webpage for more info check PageRequiredData.java
     *
     * @author Daniel.Gonzalez
     *
     * @return data provider for the test with the page information
     */
    @DataProvider(name = "pageData")
    public Object[][] tesPageDataProvider() {
        randomUser();
        PageRequiredData data = PageRequiredData.builder()
                .user(user)
                .webPageName("ESPN")
                .iFrameLogoName("Disney account")
                .singUpTitle("Create Account")
                .userMenuHeaderLoggedIn("Welcome" + user.getFirstName() + "!")
                .userMenuHeaderLoggedOut("Welcome!")
                .build();
        return new Object[][] {{data}};
    }

    /**
     * Method to create a user with random information
     */
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

    /**
     * Method to generate a random String with the alphabet and numbers
     *
     * @author Daniel.Gonzalez
     *
     * @param textLength length of the random String
     * @return random String of specified length
     */
    private String randomTextGenerator(int textLength) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder(textLength);
        for (int i = 0; i < textLength; i++) {
            builder.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return builder.toString();
    }

    /**
     * Method to generate a random String with all letters and symbols available for passwords
     *
     * @author Daniel.Gonzalez
     *
     * @param passwordLength length of the random String
     * @return random String of specified length
     */
    private String randomPasswordGenerator(int passwordLength) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder(passwordLength);
        for (int i = 0; i < passwordLength; i++) {
            builder.append(ALPHABET_PASSWORD.charAt(random.nextInt(ALPHABET_PASSWORD.length())));
        }
        return builder.toString();
    }
}
