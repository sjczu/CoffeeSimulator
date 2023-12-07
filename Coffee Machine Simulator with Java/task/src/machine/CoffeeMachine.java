package machine;
import java.util.Objects;
import java.util.Scanner;







public class CoffeeMachine {
    public static void main(String[] args) {
//      set status
        String status = "running";
//      strings for printing out supplies
        String ml = " ml ";
        String g = " g ";
//      set the supplies
        int waterInside = 400;
        int milkInside = 540;
        int coffeeInside = 120;
        int moneyInside = 550;
        int cupsInside = 9;

        while(status.equals("running")) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Write action (buy, fill, take, remaining, exit)");
            String action = scanner.nextLine();

            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy?\n1 - espresso\n2 - latte\n3 - cappuccino");
                    String beverageChoice = scanner.nextLine();

                    if(Objects.equals(beverageChoice, "back")){
                        break;
                    }

                    Coffee coffee = new Coffee();
                    coffee.setIngredientsAmount(beverageChoice);

//                  check supplies
                    if(waterInside<coffee.getWaterAmount()){
                        System.out.println("Sorry, not enough water!");
                        break;
                    } else if(milkInside<coffee.getMilkAmount()){
                        System.out.println("Sorry, not enough milk!");
                        break;
                    } else if(coffeeInside<coffee.getCoffeeAmount()){
                        System.out.println("Sorry, not enough coffee beans!");
                        break;
                    } else if(cupsInside==0){
                        System.out.println("Sorry, not enough cups!");
                        break;
                    }

                    System.out.println("Making coffee!");

//                  update supplies
                    waterInside -= coffee.getWaterAmount();
                    milkInside -= coffee.getMilkAmount();
                    coffeeInside -= coffee.getCoffeeAmount();
                    cupsInside--;
                    moneyInside += coffee.getBeveragePrice();
                    break;

                case "fill":
                    System.out.println("Write how many ml of water you want to add:");
                    int waterAdded = scanner.nextInt();

                    System.out.println("Write how many ml of milk you want to add:");
                    int milkAdded = scanner.nextInt();

                    System.out.println("Write how many g of coffee beans you want to add:");
                    int coffeeAdded = scanner.nextInt();

                    System.out.println("Write how many disposable cups you want to add:");
                    int cupsAdded = scanner.nextInt();

//                  update supplies
                    waterInside += waterAdded;
                    milkInside += milkAdded;
                    coffeeInside += coffeeAdded;
                    cupsInside += cupsAdded;
                    break;

//                  taking out the money
                case "take":
                    System.out.println("I gave you $" + moneyInside);
                    moneyInside = 0;
                    break;

//                  checking supplies
                case "remaining":
                    System.out.println("The coffee machine has:\n" + waterInside + ml + "of water\n" + milkInside + ml + "of milk\n" + coffeeInside + g + "of coffee beans\n" + cupsInside + " disposable cups\n" + "$" + moneyInside + " of money");
                    break;

                case "exit":
                    status = "exit";
                    break;

                default:
                    System.out.println("No such action allowed");
                    status = "stopped";
                    break;
            }
        }
        System.exit(0); //exiting
    }
}


class Coffee {
    private int waterAmount;
    private int milkAmount;
    private int coffeeAmount;
    private int beveragePrice;

//  ingredients getters
    int getWaterAmount(){
        return this.waterAmount;
    }

    int getMilkAmount(){
        return this.milkAmount;
    }

    int getCoffeeAmount(){
        return this.coffeeAmount;
    }

    int getBeveragePrice(){
        return this.beveragePrice;
    }

//  setter for ingredients
    void setIngredientsAmount(String beverageChoice){
        if(Objects.equals(beverageChoice, "1")){
            waterAmount = 250;
            milkAmount = 0;
            coffeeAmount = 16;
            beveragePrice = 4;
        } else if(Objects.equals(beverageChoice, "2")){
            waterAmount = 350;
            milkAmount = 75;
            coffeeAmount = 20;
            beveragePrice = 7;
        } else if(Objects.equals(beverageChoice, "3")){
            waterAmount = 200;
            milkAmount = 100;
            coffeeAmount = 12;
            beveragePrice = 6;
        } else {
            waterAmount = 0;
            milkAmount = 0;
            coffeeAmount = 0;
            beveragePrice = 0;
        }
    }
}