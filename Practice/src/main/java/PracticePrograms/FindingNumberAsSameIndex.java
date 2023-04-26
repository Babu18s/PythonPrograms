package PracticePrograms;

public class FindingNumberAsSameIndex {
    public static void arrayNumbers(){
        int array[] ={7,9,2,3,5,5,6,7,8,10};
        for(int i=0;i<array.length;i++){
            if (i==array[i]){
                System.out.println("The Number same as index is :"+i);
            }
        }
        System.out.println(array.length);
    }

    public static void main(String[] args) {
        arrayNumbers();
    }
}
