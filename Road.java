public class Road extends Barrier
{
    private String name;
    private int length;

    public Road(int length) {

        this.length = length;
    }
    public int getLength()
    {
        return length;
    }

    @Override
    protected boolean moving(All all) {
        System.out.println("The road length: "+this.length );
        all.run();
        if (getLength() <= all.getRunDistance())
        {
            System.out.println("run success");
            return true;
        }
        else
        {
            System.out.println("run unsuccessfully");
            return false;
        }
    }
}
