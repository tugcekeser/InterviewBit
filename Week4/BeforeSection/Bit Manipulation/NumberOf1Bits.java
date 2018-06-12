/*
 Write a function that takes an unsigned integer and returns the number of 1 bits it has.
 
 Example:
 
 The 32-bit integer 11 has binary representation
 
 00000000000000000000000000001011
 so the function should return 3.
 
 Note that since Java does not have unsigned int, use long for Java
 */

public class Solution {
    public int numSetBits(long a) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((a & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
}
