import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {
        Integer arr1[] = {1, 2, 3, 4, 5, 6, 7};
        swap(arr1,0,2);
        String arr2[] = {"e", "faf","qe"};
        System.out.println(arrayToList(arr2));

        Box<Orange> or = new Box<>();
        Box<Orange> or1 = new Box<>();
        Box<Apple> ap = new Box<>();
        Box<Apple> ap1 = new Box<>();

        or.addFruit(new Orange(),10);
        or1.addFruit(new Orange(),12);
        ap.addFruit(new Apple(),8);
        ap1.addFruit(new Apple(),4);

        System.out.println("Box 1: "+or.getWeight());
        System.out.println("Box 2: "+or1.getWeight());
        System.out.println("Box 3: "+ap.getWeight());
        System.out.println("Box 4: "+ap1.getWeight());

    



    }
    public static void swap(Object[] arr, int i,int g)
    {
        Object obj= arr[i];
        arr[i]= arr[g];
        arr[g]=obj;
        System.out.println(Arrays.toString(arr));
    }
    public static <T> ArrayList <T> arrayToList(T[] arr)
    {
        return new ArrayList<>(Arrays.asList(arr));
    }
}
