import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String words = input.nextLine();
        
        char word[] = words.toCharArray();

        for(char ch : word){
            int unicode = (int) ch;
            System.out.print(ch+""+unicode);
        }
        input.close();
    }
}
