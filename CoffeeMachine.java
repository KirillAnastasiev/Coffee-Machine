import java.util.Scanner;

public class CoffeeMachine {
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;
    static boolean isCancel = false;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String action = null;
        do {
            action = action();

            switch (action) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    showMachine();
                    break;
                case "exit":
                    isCancel = true;
                    break;
            }
        } while (!isCancel);
    }

    public static String action() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        return scan.next();
    }

    public static void showMachine() {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d of water\n", water);
        System.out.printf("%d of milk\n", milk);
        System.out.printf("%d of coffee beans\n", beans);
        System.out.printf("%d of disposable cups\n", cups);
        System.out.printf("$%d of money\n", money);
        System.out.println();
    }

    public static void buy() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffeeType = scan.next();

        switch (coffeeType) {
            case "1":
                makeEspresso();
                break;
            case "2":
                makeLatte();
                break;
            case "3":
                makeCappuccino();
                break;
            case "back":
                System.out.println();
                break;
        }
    }

    public static void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        water += scan.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scan.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += scan.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += scan.nextInt();
        System.out.println();
    }

    public static void take() {
        System.out.printf("\nI gave you $%d\n", money);
        money = 0;
        System.out.println();
    }

    public static void makeEspresso() {
        if (water < 250) {
            System.out.println("Sorry, not enough water!\n");
        } else if (beans < 16) {
            System.out.println("Sorry, not enough coffee beans!\n");
        } else if (cups == 0) {
            System.out.println("Sorry, not enough disposable cups\n");
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");
            water -= 250;
            beans -= 16;
            cups -= 1;
            money += 4;
        }
    }
    public static void makeLatte() {
        if (water < 350) {
            System.out.println("Sorry, not enough water!\n");
        } else if (milk < 75) {
            System.out.println("Sorry, not enough milk!\n");
        } else if (beans < 20) {
            System.out.println("Sorry, not enough coffee beans!\n");
        } else if (cups == 0) {
            System.out.println("Sorry, not enough disposable cups\n");
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");
            water -= 350;
            milk -= 75;
            beans -= 20;
            cups -= 1;
            money += 7;
        }
    }

    public static void makeCappuccino() {
        if (water < 200) {
            System.out.println("Sorry, not enough water!\n");
        } else if (milk < 100) {
            System.out.println("Sorry, not enough milk!\n");
        } else if (beans < 12) {
            System.out.println("Sorry, not enough coffee beans!\n");
        } else if (cups == 0) {
            System.out.println("Sorry, not enough disposable cups\n");
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");
            water -= 200;
            milk -= 100;
            beans -= 12;
            cups -= 1;
            money += 6;
        }
    }
}
