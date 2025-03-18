import java.util.Arrays;
import java.util.Scanner;

//这里编写泛型类WeekDay的定义
enum WeekDay{
    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //这里包含一些用于统计的初始化代码        
        try {
            while(sc.hasNext()) {
                String weekDayStr = sc.next();
                //这里编写将weekDayStr转化为WeekDay类型变量x的代码
                int x;
                switch(weekDayStr){
                    case "MONDAY":   x = 1;break;
                    case "TUESDAY":  x = 3;break;
                    case "WEDNESDAY":x = 7;break;
                    case "THURSDAY": x = 5;break;
                    case "FRIDAY":   x = 4;break;
                    case "SATURDAY": x = 6;break;
                    case "SUNDAY":   x = 0;break;
                    default :        x = 8;break;
                }
                //这里编写使用switch根据x类型输出对应信息并统计的代码
                switch(x){
                    case 1:
                }
                }
            }
        } catch (Exception e) {
            System.out.println("输入错误");
            
        }
        //这里输出统计信息
        //这里编写获得WeekDay常量数组并将其转化为String数组a的代码
        //这里编写将a数组排序并打印出来的代码

        sc.close();
    }
}
