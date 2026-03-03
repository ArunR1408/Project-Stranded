package arunR.project_stranded;

import wow.ishit.v2_stable_keimenoUI.Alignment;
import wow.ishit.v2_stable_keimenoUI.CoreState;
import wow.ishit.v2_stable_keimenoUI.Formatter;
import java.util.Random;
import java.util.Scanner;

//IDK WTF is wrong with keimenoUI.
// I am too lazy to make a jar of the latest version
// and i dont remember the syntax....
// Just tryna help you. Dont be a coder like me...

public class GameEngine {
    public static Random random = new Random();
    public static CoreState coreState = new CoreState();
    public static Formatter formatter = new Formatter(coreState);
    public static Scanner scanner = new Scanner(System.in);

    public static void shitPrint(String content) {
        formatter.formatIntoBuffer(content);
        coreState.flush();
    }

    public void prologue() {
        coreState.clearScreen();
        formatter.setAlignment(Alignment.LEFT).setWidth(70);
        formatter.header("Stranded");
        String[] dialogs = new String[] { "The storm hit without warning.",
                "You wake up on a silent shore.",
                "The wreckage of your boat scattered across the sand.",
                "Your emergency radio is damaged... but salvageable.",
                "", "", "It needs 7 days of steady sunlight to charge.",
                "Survive until then.",
                "If any of your vital reserves fail... rescue won't matter.",
                "Press Space to Start..." };

        for (String dialog : dialogs) {
            shitPrint(dialog);
            coreState.delay(1800);
        }
        scanner.nextLine();
    }

    private Player decay(Player player, int day) {
        shitPrint("Day" + day);
        coreState.delay(800);
        player.changeEnergy(-5);
        player.changeFood(-7);
        player.changeMorale(-4);
        return player;
    }

    private int decisionMaking() {
        coreState.delay(800);
        shitPrint("Choose your action:");

        coreState.delay(400);
        shitPrint("1. Hunt");

        coreState.delay(350);
        shitPrint("2. Rest");

        coreState.delay(350);
        shitPrint("3. Explore");
        return scanner.nextInt();

    }

    
    public void GameLoop() {
        Player player = new Player();
        printStats(player, 0);
        coreState.delay(800);

        int day = 1;
        boolean alive = true;

        while (day <= 7 && alive) {
            player = decay(player, day);
            if (player.getFood() < 15) {
                player.changeEnergy(-3);
            }
            printStats(player, day);
            if (!player.isAlive()) {
                alive = false;
                break;
            }
            int choice = decisionMaking();

            if (choice == 1) {
                player.hunt();
            } else if (choice == 2) {
                player.rest();
            } else if (choice == 3) {
                player.explore();
            } else {
                shitPrint("Invalid choice. You hesitate and waste time.");
            }

            // Check vitals after action
            if (!player.isAlive()) {
                alive = false;
                break;
            }
            // Advance to next day
            day++;
        }

        ending(player, day, alive);

    }
    void ending(Player player, int day, boolean alive){
        // End of game with dramatic pauses
        shitPrint("");
        coreState.delay(1200);
        if (alive) {
             coreState.delay(800);
            shitPrint("Seven days pass. The radio is charged. Rescue beacon sent!");
             coreState.delay(1200);
            shitPrint("You survived. Congratulations.");
        } else {
             coreState.delay(800);
            shitPrint("Your vitals failed. You did not survive.");
        }

        // Final status
        coreState.delay(1000);
        shitPrint("FINAL STATUS");
        coreState.delay(2000);
        printStats(player, day);
    }
    private void printStats(Player player, int day) {
        coreState.clearScreen();
        if (day == 0) {
            formatter.header("Current Status");
        } else {
            formatter.header("Current Status | Day:" + day);
        }
        shitPrint("Energy : " + player.getEnergy());
        shitPrint("Food   : " + player.getFood());
        shitPrint("Morale : " + player.getMorale());
    }
}