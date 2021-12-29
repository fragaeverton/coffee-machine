package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static Scanner scanner = new Scanner(System.in);
    final static int WATER_RECIPE = 200;
    final static int MILK_RECIPE = 50;
    final static int COFFEE_BEANS_RECIPE = 15;
    final static String MSG_OUT_OF_WATER = "Sorry, not enough water!";
    final static String MSG_OUT_OF_MILK = "Sorry, not enough milk!";
    final static String MSG_OUT_OF_COFFEE_BEANS = "Sorry, not enough coffee beans!";
    final static String MSG_OUT_OF_CUPS = "Sorry, not enough disposable cups!";
    final static String MSG_ENOUGH_RESOURCES = "I have enough resources, making you a coffee!";
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
        showMenu();
    }

    private static void showMenu(){
        System.out.println();
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        switch (scanner.nextLine()){
            case "buy" :
                buyCoffee();
                break;
            case "fill" :
                fillSupply();
                break;
            case "take" :
                takeMoney();
                break;
            case "remaining" :
                remaining();
                break;
            case "exit" :
                break;
        }
    }

    private static void buyCoffee() {
        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        switch (scanner.nextLine()){
            case "1" :
                if (waterStock >= 250) {
                    if (coffeeBeansStock >= 16) {
                        if (disposableCupsStock >= 1) {
                            System.out.println(MSG_ENOUGH_RESOURCES);
                            waterStock -= 250;
                            coffeeBeansStock -= 16;
                            disposableCupsStock -= 1;
                            moneyAmount += 4;
                            showMenu();
                        } else {
                            System.out.println(MSG_OUT_OF_CUPS);
                            showMenu();
                        }
                    } else {
                        System.out.println(MSG_OUT_OF_COFFEE_BEANS);
                        showMenu();
                    }
                } else {
                    System.out.println(MSG_OUT_OF_WATER);
                    showMenu();
                }
                break;
            case "2" :
                if (waterStock >= 350) {
                    if (milkStock >= 75) {
                        if (coffeeBeansStock >= 20) {
                            if (disposableCupsStock >= 1) {
                                System.out.println(MSG_ENOUGH_RESOURCES);
                                waterStock -= 350;
                                milkStock -= 75;
                                coffeeBeansStock -= 20;
                                disposableCupsStock -= 1;
                                moneyAmount += 7;
                                showMenu();
                            } else {
                                System.out.println(MSG_OUT_OF_CUPS);
                                showMenu();
                            }
                        } else {
                            System.out.println(MSG_OUT_OF_COFFEE_BEANS);
                            showMenu();
                        }
                    } else {
                        System.out.println(MSG_OUT_OF_MILK);
                        showMenu();
                    }
                } else {
                    System.out.println(MSG_OUT_OF_WATER);
                    showMenu();
                }
                break;
            case "3" :
                if (waterStock >= 200) {
                    if (milkStock >= 100) {
                        if (coffeeBeansStock >= 12) {
                            if (disposableCupsStock >= 1) {
                                System.out.println(MSG_ENOUGH_RESOURCES);
                                waterStock -= 200;
                                milkStock -= 100;
                                coffeeBeansStock -= 12;
                                disposableCupsStock -= 1;
                                moneyAmount += 6;
                                showMenu();
                            } else {
                                System.out.println(MSG_OUT_OF_CUPS);
                                showMenu();
                            }
                        } else {
                            System.out.println(MSG_OUT_OF_COFFEE_BEANS);
                            showMenu();
                        }
                    } else {
                        System.out.println(MSG_OUT_OF_MILK);
                        showMenu();
                    }
                } else {
                    System.out.println(MSG_OUT_OF_WATER);
                    showMenu();
                }
                break;
            case "back" :
                showMenu();
                break;
        }
    }

    private static void fillSupply() {
        System.out.println();
        System.out.println("Write how many ml of water you want to add: ");
        Scanner sc = new Scanner(System.in);
        waterStock += sc.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milkStock += sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        coffeeBeansStock += sc.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        disposableCupsStock += sc.nextInt();
        showMenu();
    }

    private static void takeMoney() {
        System.out.println();
        System.out.println("I gave you $" + moneyAmount);
        moneyAmount = 0;
        showMenu();
    }

    private static void remaining(){
        System.out.println();
        System.out.println("The coffee machine has: ");
        System.out.println(waterStock + " ml of water");
        System.out.println(milkStock + " ml of milk");
        System.out.println(coffeeBeansStock + " g of coffee beans");
        System.out.println(disposableCupsStock + " disposable cups");
        System.out.println("$" + moneyAmount + " of money");
        showMenu();
    }

    private static void checkSupply(int qttWater, int qttMilk, int qttCoffee) {
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
}
