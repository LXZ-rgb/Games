import java.util.*;

enum Weekday {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count_weekend = 0;
        int count_workday = 0;

        try {
            while (sc.hasNext()) {
                String weekDayStr = sc.next();
                Weekday x = Weekday.valueOf(weekDayStr);
                switch (x) {
                    case SUNDAY:
                        System.out.println("SUNDAY是休息日, 序号为0");
                        count_weekend++;
                        break;
                    case MONDAY:
                        System.out.println("MONDAY是工作日, 序号为1");
                        count_workday++;
                        break;
                    case TUESDAY:
                        System.out.println("TUESDAY是工作日, 序号为3");
                        count_workday++;
                        break;
                    case WEDNESDAY:
                        System.out.println("WEDNESDAY是工作日, 序号为2");
                        count_workday++;
                        break;
                    case THURSDAY:
                        System.out.println("THURSDAY是工作日, 序号为5");
                        count_workday++;
                        break;
                    case FRIDAY:
                        System.out.println("FRIDAY是工作日, 序号为4");
                        count_workday++;
                        break;
                    case SATURDAY:
                        System.out.println("SATURDAY是休息日, 序号为6");
                        count_weekend++;
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("输入错误");
        }

        System.out.printf("工作日共%d天\n休息日共%d天\n", count_workday, count_weekend);

        Weekday[] weekdays = Weekday.values();//转换为数组
        String[] a = new String[weekdays.length];//定义数组长度
        for (int i = 0; i < weekdays.length; i++) {
            a[i] = weekdays[i].name();
        }
        Arrays.sort(a);//数组排序
        System.out.println(Arrays.toString(a));

        sc.close();
    }
}
