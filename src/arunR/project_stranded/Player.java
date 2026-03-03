package arunR.project_stranded;
public class Player{
    private int energy;
    private int food;
    private int morale;
    public Player() {
        this.energy = 60;
        this.food = 50;
        this.morale = 55;
    }
    public int getEnergy() {
        return energy;
    }

    public int getFood() {
        return food;
    }

    public int getMorale() {
        return morale;
    }

    public void changeEnergy(int amount) {
        energy += amount;
        if (energy < 0) energy = 0;
    }

    public void changeFood(int amount) {
        food += amount;
        if (food < 0) food = 0;
    }

    public void changeMorale(int amount) {
        morale += amount;
        if (morale < 0) morale = 0;
    }

    public boolean isAlive() {
        return energy > 0 && food > 0 && morale > 0;
    }

    public Player hunt() {
        GameEngine.shitPrint("You go hunting...");
        GameEngine.coreState.delay(1500);
        int foodGain;
        if (this.getEnergy() < 20) {
            foodGain = 8; // weak hunt
        } else {
            foodGain = 15; // strong hunt
        }
        this.changeFood(foodGain);
        this.changeEnergy(-10);

        int injuryChance;

        if (this.getEnergy() < 20) {
            injuryChance = 30;
        } else {
            injuryChance = 20;
        }

        int randomNumber = GameEngine.random.nextInt(100);

        if (randomNumber < injuryChance) {
            GameEngine.shitPrint("You got injured during the hunt!");
            GameEngine.coreState.delay(1500);
            this.changeEnergy(-10);
        }
        return this;
    }

    public Player rest(){
                GameEngine.shitPrint("You rest for the day...");
                GameEngine.coreState.delay(1500);

                this.changeEnergy(15);
                this.changeFood(-5);
                this.changeMorale(-3);
                return this;
    }
    public Player explore(){
        GameEngine.shitPrint("You explore the island...");
                GameEngine.coreState.delay(1500);

                int event = GameEngine.random.nextInt(4);

                if (event == 0) {
                    GameEngine.shitPrint("You found wild berries!");
                    this.changeFood(10);
                } else if (event == 1) {
                    GameEngine.shitPrint("You discover a beautiful cliff view.");
                    this.changeMorale(10);
                } else if (event == 2) {
                    GameEngine.shitPrint("You slipped on rough terrain.");
                    this.changeEnergy(-12);
                } else {
                    GameEngine.shitPrint("Nothing significant happens.");
                }

                GameEngine.coreState.delay(1500);
                return this;
    }
}

