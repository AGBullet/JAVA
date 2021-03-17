public class MyArrayDataException extends Exception
{
    public int j;
    public int i;
    public MyArrayDataException(int i , int j)
    {
        this.i=i;
        this.j=j;
    }
}
