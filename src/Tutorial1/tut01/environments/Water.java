package Tutorial1.tut01.environments;

public class Water extends MapBlock{
    public Water(int x, int y, String imageUrl) {
        super(x, y, imageUrl);
    }

    @Override
    public boolean canTankPass() {
        return false;
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
