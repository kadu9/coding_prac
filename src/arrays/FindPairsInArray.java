package arrays;

public class FindPairsInArray {

    public static int findPairs(int[] arr,int k){
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1 ; j < arr.length; j++) {
                if(arr[i]+arr[j]==k){
                    System.out.println(arr[i]+":"+arr[j]);
                    count++;
                }
            }
        }
        return count;

    }

    public static void main(String[] args){
        int arr[] = {1, 5, 7, -1, 5};
        System.out.println(findPairs(arr,6));
    }
}
