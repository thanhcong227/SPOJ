import java.util.Scanner;

public class ACMNEW1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int candidateNumber = sc.nextInt();
            int[] arrWeight = new int[candidateNumber];
            for (int j = 0; j < candidateNumber; j++) {
                arrWeight[j] = sc.nextInt();
            }
            int limit = sc.nextInt();
            System.out.println(select(arrWeight,limit));
        }
    }
    public static int select(int[] arr, int limit) {
        int sumMax = 0;
        int sum ;
        for (int i = 0; i < arr.length-2; i++) {
            for (int j = i+1; j < arr.length-1; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    if (arr[i]+arr[j]+arr[k]<limit) {
                        sum = arr[i] + arr[j] + arr[k];
                        sumMax = Math.max(sum, sumMax);
                    }
                }
            }
        }
        return sumMax;
    }
}
