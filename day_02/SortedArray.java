import java.util.Arrays;

public class SortedArray {
    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6};
        int[] arr2 = {1, 3, 5, 8, 9};

        System.out.println(Arrays.toString(mergerArray(arr1, arr2)));
    }

    public static int[] mergerArray(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int k = 0;

        int[] result = new int[arr1.length + arr2.length];

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                i++;
                k++;
            } else {
                result[k] = arr2[j];
                j++;
                k++;
            }
        }

        while (i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            result[k] = arr2[j];
            j++;
            k++;
        }

        return result;
    }
}
