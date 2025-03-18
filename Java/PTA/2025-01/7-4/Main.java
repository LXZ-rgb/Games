import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner num = new Scanner(System.in);
        int i;
        double sum;
        sum = 0;
        for(i = 0;i < 10;i++){
            int numbers = num.nextInt();
            sum += numbers;
        }
        double result;
        result = (sum / 10.0);
        System.out.printf("%.2f",result);
    }
}
