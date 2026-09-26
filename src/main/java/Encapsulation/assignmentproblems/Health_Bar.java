package Encapsulation.assignmentproblems;

import java.util.Scanner;

public class Health_Bar {

   
    private int health;
    private final int maxHealth;

    
    public Health_Bar(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    
    public void takeDamage(int amount) {

        health = health - amount;

        
        if (health < 0) {
            health = 0;
        }
    }

    
    public void heal(int amount) {

        health = health + amount;

       
        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    
    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum health: ");
        int maxHealth = sc.nextInt();

        Health_Bar c = new Health_Bar(maxHealth);

        System.out.print("Enter damage: ");
        int damage = sc.nextInt();

        c.takeDamage(damage);

        System.out.println("Health after damage: " + c.getHealth());

        System.out.print("Enter healing amount: ");
        int healing = sc.nextInt();

        c.heal(healing);

        System.out.println("Health after healing: " + c.getHealth());

        sc.close();
    }
}