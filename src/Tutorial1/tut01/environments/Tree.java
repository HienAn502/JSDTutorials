package Tutorial1.tut01.environments;

public class Tree extends MapBlock{
    public Tree(int x, int y, String imageUrl) {
        super(x, y, imageUrl);
    }

    @Override
    public boolean canTankPass() {
        return true;
    }

    @Override
    public boolean canBulletPass() {
        return true;
    }

    @Override
    public boolean isDestructible() {
        return false;
    }


    public boolean obfuscatesObjects() {
        return true;
    }
}
