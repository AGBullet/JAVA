public class Main {
    private static final int size = 10000000;
    private static final int h = size / 2;


    public static void main(String[] args)
    {
        Main o = new Main();
        o.firstThread();
        o.secondThread();

    }
    public float[] zn(float[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr;
    }

    public void firstThread()
    {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++)
        {
         arr[i]=1;
        }
        long a =System.currentTimeMillis();
        zn(arr);
        System.out.println("(1) End: "+(System.currentTimeMillis() - a));
    }

    public void secondThread()
    {
        float[] arr = new  float[size];
        float[] arr1 = new  float[h];
        float[] arr2 = new  float[h];

        for (int i = 0; i < arr.length; i++)
        {
         arr[i]=1;
        }

        long a =System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        new Thread()
        {
            public void run()
            {
                float[] a1= zn(arr1);
                System.arraycopy(a1, 0, arr1, 0, a1.length);
            }
        }.start();

        new Thread()
        {
            public void run()
            {
                float[] a2= zn(arr2);
                System.arraycopy(a2, 0, arr2, 0, a2.length);
            }
        }.start();

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);

        System.out.println("(2) End: "+(System.currentTimeMillis() - a));
    }
}

