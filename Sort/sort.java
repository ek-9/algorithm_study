import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        n = sc.nextInt(); // n > 10000
        int[] arr = new int[n];

        // 삽입정렬
        makeArray(arr, n);
        printArray(arr);
        insertSort(arr, n);
        //삽입정렬 결과
        System.out.printf("insertion sort : ");
        printArray(arr);

        // 버블정렬
        makeArray(arr, n);
        printArray(arr);
        bubbleSort(arr, n);
        //버븝정렬 결과
        System.out.print("bubble sort : ");
        printArray(arr);

        // 퀵정렬
        makeArray(arr, n);
        printArray(arr);
        quickSort(arr,0,n-1);
        //퀵정렬 결과
        System.out.print("quick sort : ");
        printArray(arr);

        // 병합정렬
        makeArray(arr, n);
        printArray(arr);
        mergeSort(arr,0,n-1);
        //퀵정렬 결과
        System.out.print("merge sort : ");
        printArray(arr);

    }
    public static void makeArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }
    }
    public static void printArray(int[] arr) {
        for (int i = 0; i< 20; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }
    public static void insertSort(int[] arr, int n) {
        for (int i=1; i < n; i++) {
            int k = arr[i];
            for (int j = i-1; j >= 0; j--) {
                if (arr[j] > k) {
                    arr[j + 1] = arr[j];
                }
                arr[j] = k;
            }
        }
    }

    public static void bubbleSort(int[] arr, int n) {
        for (int i = 0; i< n; i++) {
            for (int j = 1; j < n-i; j ++) {
                if (arr[j  - 1] > arr[j]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp;
        tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static int partition(int[] arr, int l, int r) {
        int mid = (l + r)/2;
        int pivot = arr[mid];

        while (r > l) {
            while (arr[pivot] < arr[r]) {
                r--;
            }
            while (arr[pivot] > arr[l]) {
                l++;
            }
            if (arr[r] < arr[l]) {
                swap(arr,l,r);
            }
        }

        return r;
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int pivot = partition(arr, l, r);
            quickSort(arr, l, pivot-1);
            quickSort(arr, pivot + 1, r);
        }
    }

    public static void merge(int[] arr, int l, int r, int mid) {
        int i = l;
        int k = l;
        int j = mid + 1;
        int[] sorted = new int[r+1];

        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                sorted[k] = arr[i];
                k++;
                i++;
            }
            else {
                sorted[k] = arr[j];
                k++;
                j++;
            }
        }
        while (i <= mid) {
            sorted[k] = arr[i];
            k++;
            i++;
        }
        while (j <= mid) {
            sorted[k] = arr[j];
            k++;
            j++;
        }

        for (int m = l; m<=r; m++) {
            arr[m] = sorted[m];
        }

    }
    public static void mergeSort(int[] arr, int l, int r) {
        int mid;
        mid = (l + r)/2;
        if(l < r) {
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,r,mid);
        }
    }
}
