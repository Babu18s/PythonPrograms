package PracticePrograms;

public class PrintingNumbersOfArray {
    public static void arrayNumbers(){
        int array[] ={7,9,5,88,99,4,3,9,8,6};
        for(int i=0;i<array.length;i++){
            if (i<array.length-1){
                System.out.print(array[i]+",");
            }
            else {
                System.out.print(array[i]);
            }
        }

    }

    public static void main(String[] args) {
        arrayNumbers();
    }
}
