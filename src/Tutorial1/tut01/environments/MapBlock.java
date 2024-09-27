package Tutorial1.tut01.environments;

public abstract class MapBlock {
    protected int x, y;
    protected String imageUrl;

    public MapBlock(int x, int y, String imageUrl) {
        this.x = x;
        this.y = y;
        this.imageUrl = imageUrl;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public abstract boolean canTankPass();
    public abstract boolean canBulletPass();
    public abstract boolean isDestructible();
}
