public class Cat {
    private String name;
    private int appetite;
    private  boolean Full;
    public Cat(String name, int appetite)
    {
        this.name=name;
        this.appetite=appetite;
        Full = false;
    }
    public void eat(Plate plate)
    {
        if (plate.hasEnoughFood(appetite) && !Full)
        {
            plate.decreaseFood(appetite);
            Full=true;
            System.out.println(name + " покушал");
        }
        else if ( Full) System.out.println(name + " не хочет кушать");
        else System.out.println("Мало еды в тарелке для "+ name);


    }
}
