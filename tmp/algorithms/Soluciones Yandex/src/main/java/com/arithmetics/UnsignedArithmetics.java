/**
 * http://habrahabr.ru/post/225901/
 */
public class UnsignedArithmetics {
    public static void main(String[] args) {
        System.out.println(0x80000000);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.compareUnsigned(0xf0000000, 0x00000000));
    }
}
