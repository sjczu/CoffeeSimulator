package machine;

import java.util.Objects;

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