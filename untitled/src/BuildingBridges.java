import java.io.*;

public class BuildingBridges {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos = new BufferedOutputStream(System.out);
        int n = Integer.parseInt(br.readLine());
        int[] arr1,arr2,arr;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr = new int[num];
            arr1 = new int[num];
            arr2 = new int[num];
            String[] line1 = br.readLine().split(" ");
            String[] line2 = br.readLine().split(" ");
            for (int j = 0; j < num; j++) {
                arr1[j] = Integer.parseInt(line1[j]);
                arr2[j] = Integer.parseInt(line2[j]);
            }
            sort(arr1, arr2);
            for (int m:arr1) {
                bos.write((m+" ").getBytes());
            }
            bos.write(("\n").getBytes());
            for (int m:arr2) {
                bos.write((m+" ").getBytes());
            }
            bos.write(("\n").getBytes());
//            int[] newArr1 = LIS(arr1);
//            int[] newArr2 = LIS(arr2);
//            int cnt = num;
//            if (newArr1[num - 1] != 0 && newArr2[num - 1] != 0) {
//                bos.write((cnt + "\n").getBytes());
//            } else {
//                for (int j = newArr1.length - 1; j >= 0; j--) {
//                    if (newArr1[j] == 0 || newArr2[j] == 0) {
//                        cnt--;
//                    } else {
//                        break;
//                    }
//                }
//                bos.write((cnt + "\n").getBytes());
//            }
            for (int k = 0; k < num; k++) {
                int count = 0;
                int a1 = arr1[k];
                int a2 = arr2[k];
                for (int j = k; j < num; j++) {
                    if (arr1[j] >= a1 && arr2[j] >= a2) {
                        count++;
                        a1 = arr1[j];
                        a2 = arr2[j];
                    }
                }
                arr[k] = count;
            }
            int max = arr[0];
            for (int j = 1; j < num; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            bos.write((max + "\n").getBytes());
        }
        bos.flush();
    }

    public static void sort(int[] arr1, int[] arr2) {
        int n = arr1.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr1[j] > arr1[j + 1]) {
                    int temp1 = arr1[j];
                    int temp2 = arr2[j];
                    arr1[j] = arr1[j + 1];
                    arr2[j] = arr2[j + 1];
                    arr1[j + 1] = temp1;
                    arr2[j + 1] = temp2;
                }
                else if (arr1[j] == arr1[j + 1]) {
                    if (arr2[j] > arr2[j + 1]) {
                        int temp1 = arr1[j];
                        int temp2 = arr2[j];
                        arr1[j] = arr1[j + 1];
                        arr2[j] = arr2[j + 1];
                        arr1[j + 1] = temp1;
                        arr2[j + 1] = temp2;
                    }
                }
            }
        }
    }

//    public static int[] LIS(int[] arr1) {
//        int n = arr1.length;
//        int[] newArr = new int[n];
//        int[] dp = new int[n];
//        int[] prev = new int[n];
//        int max = 0;
//        int maxIndex = 0;
//        for (int i = 0; i < n; i++) {
//            dp[i] = 1;
//            prev[i] = -1;
//            for (int j = 0; j < i; j++) {
//                if (arr1[j] <= arr1[i] && dp[j] + 1 >= dp[i]) {
//                    dp[i] = dp[j] + 1;
//                    prev[i] = j;
//                }
//            }
//            if (dp[i] >= max) {
//                max = dp[i];
//                maxIndex = i;
//            }
//        }
//        int k = maxIndex;
//        for (int i = max - 1; i >= 0; i--) {
//            newArr[i] = arr1[k];
//            k = prev[k];
//        }
//        return newArr;
//    }
}