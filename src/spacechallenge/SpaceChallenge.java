package spacechallenge;

import java.util.ArrayList;

/**
 * Final project from the Java Object Oriented Programming course.
 * 
 * @author juan
 */
public class SpaceChallenge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Simulation sim = new Simulation();
        ArrayList<Rocket> loadedRockets;
        int totalBudgetU1;
        int totalBudgetU2;
        
        // Simulation of U1 rockets.
        loadedRockets = sim.loadU1();
        totalBudgetU1 = sim.runSimulation(loadedRockets);
        
        // Simulation of U2 rockets.
        loadedRockets = sim.loadU2();
        totalBudgetU2 = sim.runSimulation(loadedRockets);
        
        System.out.println("Total budget using U1 rockets: " + totalBudgetU1);
        System.out.println("Total budget using U2 rockets: " + totalBudgetU2);
    }
    
}
