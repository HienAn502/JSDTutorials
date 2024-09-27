package Tutorial1.tut01.environments;

import Tutorial1.tut01.tanks.Bullet;

public class SteelWall extends MapBlock{
    protected int health = 2;

    public SteelWall(int x, int y, String imageUrl) {
        super(x, y, imageUrl);
    }

    @Override
    public boolean canTankPass() {
        return false;
    }

    @Override
    public boolean canBulletPass() {
        return false;
    }

    @Override
    public boolean isDestructible() {
        return true;
    }

    public void hit(Bullet bullet) {

    }
}
