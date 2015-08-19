import static org.junit.Assert.*;

import org.junit.Test;


public class TestPalindrome {

    @Test
    public void test1() {
        assertTrue(Palindrome.checkForPalindrome("aabaa"));
    }
    
    @Test
    public void test2() {
        assertFalse(Palindrome.checkForPalindrome("abaa"));
    }
    
    @Test
    public void test3() {
        assertTrue(Palindrome.checkForPalindrome("+aba+"));
    }
    
    @Test
    public void test4() {
        assertTrue(Palindrome.checkForPalindrome("aabbaa"));
    }
    
    @Test
    public void test5() {
        assertTrue(Palindrome.checkForPalindrome("aabaA"));
    }
    
    @Test
    public void test6() {
        assertTrue(Palindrome.checkForPalindrome("AabaA"));
    }

}
