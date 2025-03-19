import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            int a = sc.nextInt();
            int b = sc.nextInt();
        
            int c = a + b;
            int d = a - b;
            int e = a * b;
            double f = a / (b*1.0);

            System.out.println(c);
            System.out.println(d);
            System.out.println(e);
            System.out.println(f);
        }finally{
            sc.close();
        }
    }
}