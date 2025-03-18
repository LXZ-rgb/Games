public class Method1 {
    public static void main(String[] args){
        int month1 = 0;
        int month2 = 0;
        int month3 = 0;
        int month4 = 0;

        int result = getSum(month1,month2,month3,month4);
        System.out.println(result);
    }
    public static int getSum(int m,int n,int i,int j){
        int sum = m + n + i + j;
        return sum;
    }
}
