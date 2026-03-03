// Working Title: STRANDED
package arunR.project_stranded;
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to my First Java Project-Game!");
        // Initializing game components
        GameEngine engine = new GameEngine();
        newGame(engine);

    }
    private static void newGame(GameEngine gameEngine){
        gameEngine.prologue();
        gameEngine.GameLoop();
    
    }
}
