import java.util.*;

public class test5 {
    public static void main(String[] args){
        int Numbers[] = new int[20];
        int i;
        for(i = 0;i < 10;i++)
        {
            Scanner number = new Scanner(System.in);
            int x = number.nextInt();
            Numbers[i] = x;
        }
        int b[] = Arrays.copyOf(Numbers,9);
        int c[] = Arrays.copyOfRange(Numbers,3,9);
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
    }
}
