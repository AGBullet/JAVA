public class Main {

    public static void main(String[] args)
    {
        Cat[] cats= new Cat[3];
        cats[0]=new Cat("Дуся", 10);
        cats[1]=new Cat("Шустрик", 5);
        cats[2]=new Cat("Бася", 7);

        Plate plate = new Plate(20);
        for (int cat = 0; cat<cats.length; cat++)
        {
            cats[cat].eat(plate);
        }
        appendFoodTo(plate,50);

        for(int cat = 0; cat < cats.length;cat++)
        {
            cats[cat].eat(plate);
        }


    }
    static  void appendFoodTo(Plate plate, int food)
    {
        plate.increaseFood(food);
    }
}
