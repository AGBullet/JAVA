import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ArrTest {


    @Test
    public void test1Task1() {
        int[] in = new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] out = new int[]{1,7};
        Assertions.assertArrayEquals(out, Tasks.task1(in));
    }

    @Test
    public void test2Task1() {
        int[] in = new int[]{1, 2, 44, 24, 3, 7};
        Assertions.assertThrows(RuntimeException.class, () -> {
            Tasks.task1(in);
        });
    }

    @Test
    public void test1Task2() {
        int[] in = new int[]{1, 1, 1, 4, 4, 1, 3, 4};
        Assertions.assertFalse(Tasks.task2(in));
    }

    @Test
    public void test2Task2() {
        int[] in = new int[]{1, 1 ,1 ,1,1 ,1};
        Assertions.assertTrue(Tasks.task2(in));
    }


}
