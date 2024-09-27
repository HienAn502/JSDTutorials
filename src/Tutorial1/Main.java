package Tutorial1;

import Tutorial1.tut01.tanks.BaseTank;
import Tutorial1.tut01.tanks.EnemyTank;
import Tutorial1.tut01.tanks.PlayerTank;
import Tutorial1.tut01.tanks.enums.EnemyTankType;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<BaseTank> tanks = new ArrayList<>();

        // Create player tanks
        PlayerTank player1 = new PlayerTank("Yellow", 1, 2, 2);
        PlayerTank player2 = new PlayerTank("Green", 1, 2, 2);

        // Create enemy tanks
        EnemyTank basicTank = new EnemyTank("Gray", 1, 1, 1);
        basicTank.setType(EnemyTankType.BASIC);

        EnemyTank fastTank = new EnemyTank("Red", 1, 3, 2);
        fastTank.setType(EnemyTankType.FAST);

        EnemyTank powerTank = new EnemyTank("Green", 1, 2, 3);
        powerTank.setType(EnemyTankType.POWER);

        EnemyTank armorTank = new EnemyTank("Silver", 4, 2, 2);
        armorTank.setType(EnemyTankType.ARMOR);

        // Add all tanks to the list
        tanks.add(player1);
        tanks.add(player2);
        tanks.add(basicTank);
        tanks.add(fastTank);
        tanks.add(powerTank);
        tanks.add(armorTank);

        // Demonstrate tank attributes and behaviors
        for (BaseTank tank : tanks) {
            System.out.println("\nDemonstrating tank: " + tank.getClass().getSimpleName());
            System.out.println(tank);

            // Simulate movement
            tank.setX(10);
            tank.setY(10);
            tank.move("RIGHT");
            System.out.println("After moving right: X=" + tank.getX() + ", Y=" + tank.getY());

            // Simulate firing
            tank.fire();

            // Simulate taking damage
            int damageAmount = 1;
            System.out.println("Health before damage: " + tank.getHealth());
            tank.takeDamage(damageAmount);
            System.out.println("Health after taking " + damageAmount + " damage: " + tank.getHealth());

        }
    }
}