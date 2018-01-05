package recurssive;

public class RotatedArray {


    public static void main(String[] args) {
        int arr[] = {3, 4, 6, 8, 11, 11, 13, 0, 1, 2, 3};
        int element = 0;

        System.out.println(find(0, arr.length, arr, element));
        System.out.println(find(0, arr.length-1, arr, 2));
    }

    private static int find(int start, int end, int[] arr, int element) {

        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (arr[mid] == element) {
            return mid;
        }

        if (arr[start] < arr[mid]) {
            if (element >= arr[start] && element < arr[mid]) {
                return find(start, mid - 1, arr, element);
            } else {
                return find(mid + 1, end, arr, element);
            }

        } else if (arr[start] > arr[mid]) {
            if (element > arr[mid] && element <= arr[end]) {
                return find(mid + 1, end, arr, element);
            } else {
                return find(start, mid - 1, arr, element);
            }

        } else {
            if (arr[mid] != arr[end]) {
                return find(mid + 1, end, arr, element);
            }
            int result = find(start, mid - 1, arr, element);
            if (result == -1) {
                return find(mid + 1, end, arr, element);
            }
            return result;

        }
    }
}
