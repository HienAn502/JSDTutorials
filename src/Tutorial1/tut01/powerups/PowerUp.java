package Tutorial1.tut01.powerups;

public class PowerUp {
    private String type;
    private long appearTime;
    private String imageUrl;
    protected int x, y;
    protected static final int POINTS = 500;

    public PowerUp(String type, long appearTime, String imageUrl, int x, int y) {
        this.type = type;
        this.appearTime = appearTime;
        this.imageUrl = imageUrl;
        this.x = x;
        this.y = y;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getAppearTime() {
        return appearTime;
    }

    public void setAppearTime(long appearTime) {
        this.appearTime = appearTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
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

    @Override
    public String toString() {
        return "PowerUp{" +
                "type='" + type + '\'' +
                ", appearTime=" + appearTime +
                ", imageUrl='" + imageUrl + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
