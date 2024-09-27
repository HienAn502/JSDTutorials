package Tutorial1.tut01.tanks;

import Tutorial1.tut01.tanks.enums.Speed;
import Tutorial1.tut01.tanks.enums.TankDirection;

public abstract class BaseTank {
    protected String color;
    protected int health;
    protected int x, y; // position
    protected Speed movementSpeed;
    protected Speed bulletSpeed;
    protected TankDirection direction;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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

    public Speed getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(Speed movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public Speed getBulletSpeed() {
        return bulletSpeed;
    }

    public void setBulletSpeed(Speed bulletSpeed) {
        this.bulletSpeed = bulletSpeed;
    }

    public TankDirection getDirection() {
        return direction;
    }

    public void setDirection(TankDirection direction) {
        this.direction = direction;
    }

    public BaseTank(String color, int health, int movementSpeed, int bulletSpeed) {
        this.color = color;
        this.health = health;
        this.movementSpeed = Speed.getSpeed(movementSpeed);
        this.bulletSpeed = Speed.getSpeed(bulletSpeed);
        this.direction = TankDirection.UP;
    }

    public abstract void move(String direction);

    public abstract void fire();

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            destroy();
        }
    }

    public void destroy() {
        // TODO
    }
}

