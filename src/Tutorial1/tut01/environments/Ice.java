package Tutorial1.tut01.environments;

public class Ice extends MapBlock{

    public Ice(int x, int y, String imageUrl) {
        super(x, y, imageUrl);
    }

    public boolean obfuscatesObjects() {
        return true;
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
}
