import java.util.Arrays;
public class test4 {
    public static void main(String[] args){
        int number1[] = {1, 2, 6, 50, 60, 10};
        int number2[] = {10, 20, 63, 52, 16, 13};

        System.out.println(Arrays.toString(number1));

        System.arraycopy(number1,3,number2,3,number1.length - 3);
        System.out.println(Arrays.toString(number2));
    }
}
