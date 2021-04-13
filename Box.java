import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box <T extends  Fruit>
{
    private List<T> box;


    public Box() {
        this.box = new ArrayList<>();
    }
     public Box(T... fruits)
     {
         this.box=new ArrayList(Arrays.asList(fruits));
     }

     public float getWeight()
     {
         float w= 0.0f;
         for (T fruit: box)
         {
             w+=fruit.getWeight();
         }
         return w;
     }
     public boolean compare(Box anotherBox)
     {
         if (getWeight()==anotherBox.getWeight())
         {
             return true;
         }
         return false;
     }
     public void To(Box <T>anotherBox)
     {
         anotherBox.box.addAll(box);
         box.clear();
     }
     public void addFruit(T fruit , int am)
     {
         for (int i = 0; i < am; i++) {
             box.add(fruit);
         }
     }



}
