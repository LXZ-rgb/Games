import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int month = input.nextInt();

        int result = judge(month);
        System.out.println(result);

        input.close();
    }
    //迭代
    public static int judge(int month){
        int result;
        if(month > 2){
            result = judge(month - 1) + judge(month - 2);
            return result;
        }else if(month == 2){
            return 2;
        }else{
            return 1;
        }
    }
}