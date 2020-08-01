package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PalindromeTest {

    @Spy
    private Palindrome palindrome;

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
        palindrome.check("aa");
        verify(palindrome, times(2)).check(anyString());
    }


}
