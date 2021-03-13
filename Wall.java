public class Wall extends Barrier {

    private int height;

    public Wall(int height) {

        this.height = height;
    }
    public int getHeight()
    {
        return height;
    }

    @Override
    protected boolean moving(All all) {
        System.out.println("The wall height: "+this.height );
        all.jump();
        if (getHeight() <= all.getJumpHeight())
        {
            System.out.println("jump success");
            return true;
        }
        else
            {
                System.out.println("jump unsuccessfully");
                return false;
            }

    }
}
