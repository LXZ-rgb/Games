import java.util.Scanner;
public class test3 {
    public static void main(String[] args){
        try (Scanner number = new Scanner(System.in)) { // 自动关闭
            for(int i = 0; i < 3; i++){
                int x = number.nextInt();
                System.out.println(x + "100");
            }
        } // 此处自动调用 number.close()
    }
}