import com.tms.domain.User;
import com.tms.domain.Wallet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyFirstTest {
    static User user;
    @BeforeAll
    static void initTest() {
        User user = new User(new Wallet());
        user.setFirstName("Vladimir");
        System.out.println("Hello!");
    }
    @Test
    @DisplayName("SuperTest")
    void getSummaTest() {
        System.out.println("First test!");
    }

    @Test
    void getSummaSecondTest() {
        System.out.println("Second test!");
    }
}
