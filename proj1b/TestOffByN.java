import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.Assert.assertTrue;

public class TestOffByN {
    static CharacterComparator com1 = new OffByN(5);

    @Test
    public void testEqualChars(){
        assertTrue(com1.equalChars('a', 'f'));
        assertTrue(com1.equalChars('f', 'a'));
        assertFalse(com1.equalChars('a', 'b'));
    }
}
