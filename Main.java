public class Main {
    static Object mon = new Object();
    static volatile int c = 1;
    static final int num=10;



    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (int i = 0; i < num; i++) {
                    synchronized (mon) {
                        while (c != 1) {
                            mon.wait();
                        }
                        System.out.print("A");
                        c = 2;
                        mon.notifyAll();
                    }
                }
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < num; i++) {
                    synchronized (mon) {
                        while (c != 2) {
                            mon.wait();
                        }
                        System.out.print("B");
                        c = 3;
                        mon.notifyAll();
                    }
                }
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < num; i++) {
                    synchronized (mon) {
                        while (c != 3) {
                            mon.wait();
                        }
                        System.out.print("C");
                        c = 1;
                        mon.notifyAll();
                    }
                }
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }).start();
    }
}
