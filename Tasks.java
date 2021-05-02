import java.lang.reflect.Array;
import java.util.Arrays;



public class Tasks {
    public static void main(String[] args) {

    }
    public static int[] task1(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                return Arrays.copyOfRange(arr, i + 1, arr.length);
            }
        }
        throw new RuntimeException("НЕТ 4");
    }

    public static boolean task2(int[] arr) {
        boolean flag1 = false;
        boolean flag2 = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 1 && arr[i] != 4) {
                return false;
            }
            if (arr[i] == 1) {
                flag1 = true;
            }
            if (arr[i] == 1) {
                flag2 = true;
            }
        }
        return flag1 && flag2;
    }
}
