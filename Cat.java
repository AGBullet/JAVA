class Cat extends  Animal
{
    String name = "Барсик";
    private int rl=200;
    private int jh=2;

    @Override
    void run(int lenght) {
        if ((lenght>=0)&& (lenght <= rl))
        {
            System.out.println(name +" пробежал " +lenght +" м." );
        }
        else System.out.println(name +" не может пробежать такое расстояние. ");
    }

    @Override
    void jump(int height) {
        if ((height>=0)&& (height <= jh))
        {
            System.out.println(name +" прыгнул на высоту "+ height+ " м.");
        }
        else System.out.println(name + "Не может прыгнуть на такую высоту ");

    }

    @Override
    void swim(int lenght) {
        System.out.println(name + " не умеет плавать.");
    }
}
