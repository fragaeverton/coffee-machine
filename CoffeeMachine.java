package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static Scanner scanner = new Scanner(System.in);
    final static int WATER_RECIPE = 200;
    final static int MILK_RECIPE = 50;
    final static int COFFEE_BEANS_RECIPE = 15;
    static int waterStock;
    static int milkStock;
    static int coffeeBeansStock;
    static int disposableCupsStock;
    static int moneyAmount;

    public static void main(String[] args) {
        waterStock = 400;
        milkStock = 540;
        coffeeBeansStock = 120;
        disposableCupsStock = 9;
        moneyAmount = 550;
        showSupply();
        showMenu();
    }

    private static void showMenu(){
        System.out.println();
        System.out.println("Write action (buy, fill, take): ");
        String action = scanner.nextLine();
        switch (action){
            case "buy" :
                buyCoffee();
                break;
            case "fill" :
                fillSupply();
                break;
            case "take" :
                takeMoney();
                break;
        }
    }

    private static void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        switch (scanner.nextInt()){
            case 1 :
                waterStock -= 250;
                coffeeBeansStock -= 16;
                disposableCupsStock -= 1;
                moneyAmount += 4;
                break;
            case 2 :
                waterStock -= 350;
                milkStock -= 75;
                coffeeBeansStock -= 20;
                disposableCupsStock -= 1;
                moneyAmount += 7;
                break;
            case 3 :
                waterStock -= 200;
                milkStock -= 100;
                coffeeBeansStock -= 12;
                disposableCupsStock -= 1;
                moneyAmount += 6;
                break;
        }
        showSupply();
    }

    private static void fillSupply() {
        System.out.println("Write how many ml of water you want to add: ");
        waterStock += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milkStock += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        coffeeBeansStock += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        disposableCupsStock += scanner.nextInt();
        showSupply();
    }

    private static void takeMoney() {
        System.out.println("I gave you $" + moneyAmount);
        moneyAmount = 0;
        showSupply();
    }

    private static void showSupply(){
        System.out.println();
        System.out.println("The coffee machine has: ");
        System.out.println(waterStock + " ml of water");
        System.out.println(milkStock + " ml of milk");
        System.out.println(coffeeBeansStock + " g of coffee beans");
        System.out.println(disposableCupsStock + " disposable cups");
        System.out.println("$" + moneyAmount + " of money");
    }

    private static void checkSupply() {
        System.out.println("Write how many ml of water the coffee machine has: ");
        int qttWater = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int qttMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int qttCoffee = scanner.nextInt();
        checkRecipe(qttWater, qttMilk, qttCoffee);

    }

    private static void checkRecipe(int qttWater, int qttMilk, int qttCoffee) {
        System.out.println("Write how many cups of coffee you will need: ");
        int qttCups = scanner.nextInt();
        int availableCups = qttWater;
        int[] conj = new int[]{
                qttWater / WATER_RECIPE, qttMilk / MILK_RECIPE, qttCoffee / COFFEE_BEANS_RECIPE
        };
        for (int qtt : conj) {
            availableCups = Math.min(availableCups, qtt);
        }
        if (qttCups == availableCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (qttCups > availableCups) {
            System.out.println("No, I can make only " + availableCups + " cup(s) of coffee");
        } else {
            System.out.println("Yes, I can make that amount of coffee (and even " + (availableCups - qttCups) + " more than that)");
        }

    }

    private static void orderCoffee() {
        System.out.println("Write how many cups of coffee you will need: ");
        int qttCups = scanner.nextInt();

        String[] myRecipe = getRecipeNeeds(qttCups);
        System.out.printf("For %d cups of coffee you will need: ", qttCups);
        System.out.println();
        for (String ingredient : myRecipe) {
            System.out.println(ingredient);
        }
    }

    private static String[] getRecipeNeeds(int qttCups) {

        return new String[]{
                WATER_RECIPE * qttCups + " ml of water",
                MILK_RECIPE * qttCups + " ml of milk",
                COFFEE_BEANS_RECIPE * qttCups + " g of coffee beans"
        };
    }
}
