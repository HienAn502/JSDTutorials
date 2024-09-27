package Tutorial1.tut01.environments;

import Tutorial1.tut01.tanks.Bullet;

public class BrickWall extends MapBlock{
    protected int health = 4;

    public BrickWall(int x, int y, String imageUrl) {
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
