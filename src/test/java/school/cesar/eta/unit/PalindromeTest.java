package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PalindromeTest {

    private Palindrome palindrome;

    @BeforeEach
    public void setupTest(){
        palindrome = new Palindrome();
    }

    @Test
    public void check_oneCharWord_true() {
        boolean actual = palindrome.check("a");
        Assertions.assertTrue(actual);
    }

    @Test
    public void check_differentStartEndChar_false() {
        boolean actual = palindrome.check("ab");
        Assertions.assertFalse(actual);
    }

    @Test
    public void check_equalStartEndChar_true() {
        Assertions.assertTrue(palindrome.check("aa"));
    }


}
