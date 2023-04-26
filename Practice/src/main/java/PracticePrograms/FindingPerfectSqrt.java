package PracticePrograms;

public class FindingPerfectSqrt {
    public static int sqrtOfNum(){
        int number=37;
        for (int i=1;i<=number;i++){
            if(i*i==number){
                int sqtofNum=i;
                return i;
            }
            System.out.println("Index : "+i);
            if(i*i > number) {
                return -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();
        System.out.println(sqrtOfNum());
    }
}
