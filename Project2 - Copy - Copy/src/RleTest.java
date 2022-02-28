import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


public class RleTest {
    @Test
    public void toHexString () {

        byte[] output = {3, 15, 6, 4};
        byte[] input = {15, 15, 15, 4, 4, 4, 4, 4, 4};
        String input3 = "19:12:10:1f:10:1f:10:1f";
        byte[] output2 = {2,4,15,1,15,1,5,1,1,8,1,7};
        byte[] output1 = {1, 9, 12, 10, 1, 15, 10, 1, 15, 10, 1, 15};
        //19:12:10:1f:10:1f:10:1f:10:1f:10:1f:10:1f:10:1f:10:1f:10:1f
        //19:12:10:1f:10:1f:10:1f:10:1f:10:1f:10:1f:10:1f:10:1f:10:115
        assertArrayEquals(output1, RleProgram.stringToRle(input3));

    }
}
