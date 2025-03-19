import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()){
            String choice = input.nextLine();
            switch(choice){
                case "double":
                System.out.println("choice=double");
                double first = input.nextDouble();
                double second = input.nextDouble();
                double third = input.nextDouble();
                System.out.printf("%-5.2f,%5.2f,%.2f%n",first,second,third);
                input.nextLine();
                break;

                case "int":   
                System.out.println("choice=int");
                int a = input.nextInt();
                int b = input.nextInt();
                int c = input.nextInt();
                int result = a+b+c;
                System.out.printf("%d%n",result);
                input.nextLine();
                break;

                case "str":
                System.out.println("choice=str");
                String str = input.nextLine();
                String strs[] = str.split("\\s+");
                int j;
                for(j = strs.length - 1;j >= 0;j--){
                    System.out.print(strs[j]);
                }
                System.out.printf("\n");
                break;

                case "line":
                System.out.println("choice=line");
                String chars = input.nextLine();
                char ch[] = chars.toCharArray();
                int i;
                for(i = 0;i <= ch.length-1;i++){
                    System.out.printf("%c",ch[i] - 32);
                }
                System.out.println();
                break;
                default:
                System.out.println("choice="+choice);
                System.out.print("other");
            }
        }
        input.close();
    }
} 