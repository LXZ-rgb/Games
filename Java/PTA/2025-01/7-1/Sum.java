import java.util.Scanner;
public class Sum{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int a;
        int b;

        while(in.hasNextInt()){
            a = in.nextInt();
            b = in.nextInt();
            if(a > 1000||a < -1000){
                System.out.println("|a|>1000");
            }else{
                System.out.println(a + b);
            }
        }
    }
}