public class MergeSort {
    public static void main(String[] args) {

        int[] a = {2, 1, 3, 2, 7, 8};
        int[] m = new int[a.length];
        sort(a, m);
        for (int value : m) {
            System.out.println(value);
        }
    }
    public static void merge(int[] a, int[] m, int start, int mid, int end) {
        int start1 = start;
        int end1 = mid;
        int start2 = mid+1;
        int end2 = end;

        int i = start1;
        int j = start2;
        int k = start1;
        while (i <= end1 && j <= end2) {
            if (a[i] < a[j]) {
                m[k] = a[i];
                i++;
            } else {
                m[k] = a[j];
                j++;
            }
            k++;
        }
        while (i <= end1) {
            m[k] = a[i];
            i++;
            k++;
        }
        while (j <= end2) {
            m[k] = a[j];
            j++;
            k++;
        }

    }


    public static void sort(int[] a, int[] s) {
        if (a.length == 1) {
            s[0] = a[0];
        }

        for (int width = 2; width/2 < a.length; width = width * 2) {

           int i = 0;
            for (i = 0; width/2 < a.length - i; i = i+width) {
                int mid = width/2+i-1;
                int end = Math.min(width, a.length)+i - 1;
                merge(a, s, i,  width/2+i-1, Math.min(width, a.length)+i - 1);
            }
            for (int j = 0; j < Math.min(a.length, i); j++) {
                a[j] = s[j];
            }

        }
    }
}
