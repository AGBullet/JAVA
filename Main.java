import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random ran = new Random();
        All[] all = new All[3];

        int distance = ran.nextInt(10);
        int height = ran.nextInt(10);
        all[0] = new Human("Ivan", distance, height);

        distance = ran.nextInt(10);
        height = ran.nextInt(10);
        all[1] = new Robot("T-800", distance, height);

        distance = ran.nextInt(10);
        height = ran.nextInt(10);
        all[2] = new Cat("Barsik", distance, height);
        Barrier[] barrier = new Barrier[6];

        boolean isRoad;
        for (int i = 0; i < barrier.length;i++)
        {
            distance = ran.nextInt(10);
            isRoad = ran.nextBoolean();
            if (isRoad)
            {
                barrier[i]= new Road(distance);
            }
            else
                {
                    barrier[i]= new Wall(distance);
                }
        }
        for(int i=0; i < all.length;i++)
        {
            boolean result =true;
            for (int j = 0; j< barrier.length;j++)
            {
                result = barrier[j].moving(all[i]);
                if (!result)
                {
                    break;
                }
            }
            if (result) System.out.println("Obstacle course is success");
            else
                {
                    System.out.println("Obstacle course is unsuccessfully");
                }
        }

    }
}
