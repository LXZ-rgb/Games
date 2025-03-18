import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner num = new Scanner(System.in);
        try{
            int Num = num.nextInt();
            int number[] = new int[100];

            int i = 0;

            while(Num  > 0){
                number[i] = Num % 10;
                Num /= 10;
                i++;
            }

            for(int j = 0;j < i;j++){
                System.out.print(number[j]);
            }
        }finally{
            num.close();
        }
    }
}