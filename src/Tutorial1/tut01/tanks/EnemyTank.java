package Tutorial1.tut01.tanks;

import Tutorial1.tut01.tanks.enums.EnemyTankType;

public class EnemyTank extends BaseTank{
    private int deltaX;
    private int deltaY;
    private EnemyTankType type;
    public EnemyTank(String color, int health, int movementSpeed, int bulletSpeed) {
        super(color, health, movementSpeed, bulletSpeed);
    }

    public int getDeltaX() {
        return deltaX;
    }

    public void setDeltaX(int deltaX) {
        this.deltaX = deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    public void setDeltaY(int deltaY) {
        this.deltaY = deltaY;
    }

    public EnemyTankType getType() {
        return type;
    }

    public void setType(EnemyTankType type) {
        this.type = type;
    }

    @Override
    public void move(String direction) {

    }

    @Override
    public void fire() {

    }

    @Override
    public String toString() {
        return "EnemyTank{" +
                "deltaX=" + deltaX +
                ", deltaY=" + deltaY +
                ", type=" + type +
                ", color='" + color + '\'' +
                ", health=" + health +
                ", x=" + x +
                ", y=" + y +
                ", movementSpeed=" + movementSpeed +
                ", bulletSpeed=" + bulletSpeed +
                ", direction=" + direction +
                '}';
    }
}
