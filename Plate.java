public class Plate
{
    private int food;

    public Plate(int food){
        this.food=food;
    }

    public  void info()
    {
        System.out.println("plate: " + food);
    }
    void decreaseFood(int appetite)
    {
        if (appetite > food)
        {
            return;
        }
        food = food - appetite;
    }
    public void increaseFood(int food)
    {
        this.food+=food;
    }
    public boolean hasEnoughFood(int appetite)
    {
        return appetite<=food;
    }

}
