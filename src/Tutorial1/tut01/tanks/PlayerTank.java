package Tutorial1.tut01.tanks;

import Tutorial1.tut01.powerups.PowerUp;

public class PlayerTank extends BaseTank{

    public PlayerTank(String color, int health, int movementSpeed, int bulletSpeed) {
        super(color, health, movementSpeed, bulletSpeed);
    }

    @Override
    public void move(String direction) {

    }

    @Override
    public void fire() {

    }

    public void upgradeTier() {

    }

    public void getPowerUp(PowerUp powerUp) {

    }

    @Override
    public String toString() {
        return "PlayerTank{" +
                "color='" + color + '\'' +
                ", health=" + health +
                ", x=" + x +
                ", y=" + y +
                ", movementSpeed=" + movementSpeed +
                ", bulletSpeed=" + bulletSpeed +
                ", direction=" + direction +
                '}';
    }
}
