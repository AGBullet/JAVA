 class Dog extends Animal
{
    String name = "Бобик";
    private int rl=500;
    private int jh=1;
    private int sl=10;

    @Override
    void run(int lenght) {
        if ((lenght>=0)&& (lenght <= rl))
        {
            System.out.println(name +" пробежал " +lenght +" м." );
        }
        else System.out.println(name +" не может бегать такое расстояние.");
    }

    @Override
    void jump(int height) {
        if ((height>=0)&& (height <= jh))
        {
            System.out.println(name +" прыгнул на высоту "+ height+ " м.");
        }
        else System.out.println(name + "Не может прыгнуть на такую высоту.");

    }

    @Override
    void swim(int lenght) {
        if ((lenght>=0)&& (lenght <= rl))
        {
            System.out.println(name + " проплыл "+lenght +" м." );
        }
        else System.out.println(name + "Не может проплыть такое расстояние " );
    }
}
