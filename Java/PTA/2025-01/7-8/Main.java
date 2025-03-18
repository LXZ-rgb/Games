import java.util.Scanner;
//判断闰年
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int year = input.nextInt();
        boolean result = judge(year);

        if(result == true){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
        input.close();
    }

    public static boolean judge(int year){
        return ((year%4==0 && year%100!=0)||(year%400==0));
        //直接返回，可以使代码更加简洁
    }
}