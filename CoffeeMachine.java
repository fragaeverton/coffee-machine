package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static Scanner scanner = new Scanner(System.in);
    final static int WATER = 200;
    final static int MILK = 50;
    final static int COFFEE_BEANS = 15;

    public static void main(String[] args) {
        checkSupply();
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
                qttWater / WATER, qttMilk / MILK, qttCoffee / COFFEE_BEANS
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
                WATER * qttCups + " ml of water",
                MILK * qttCups + " ml of milk",
                COFFEE_BEANS * qttCups + " g of coffee beans"
        };
    }
}
