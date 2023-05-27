package spacechallenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author juan
 */
public class Simulation {
    
    private ArrayList<Item> loadItems(File file) {
        ArrayList<Item> items = new ArrayList<>();
        Scanner sc;
        String item[];
        
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return null;
        }
        
        while (sc.hasNext()) {
            item = sc.nextLine().split("=");
            items.add(new Item(item[0], Integer.parseInt(item[1])));
        }
        
        return items;
    }
    
    public ArrayList<Rocket> loadU1() {
        ArrayList<Rocket> loadedU1 = new ArrayList<>();
        ArrayList<Item> items = loadItems(new File("src/spacechallenge/resources/phase-1.txt"));
        U1 rocket = new U1();

        for (Item i : items) {
            if (rocket.canCarry(i)) {
                rocket.carry(i);
            } else {
                loadedU1.add(rocket);
                rocket = new U1();
                rocket.carry(i);
            }
        }

        return loadedU1;
    }
    
    public ArrayList<Rocket> loadU2() {
        ArrayList<Rocket> loadedU2 = new ArrayList<>();
        ArrayList<Item> items = loadItems(new File("src/spacechallenge/resources/phase-2.txt"));
        U2 rocket = new U2();

        for (Item i : items) {
            if (rocket.canCarry(i)) {
                rocket.carry(i);
            } else {
                loadedU2.add(rocket);
                rocket = new U2();
                rocket.carry(i);
            }
        }

        return loadedU2;
    }
    
    public int runSimulation(ArrayList<Rocket> rockets) {
        int budget = 0;
        
        System.out.printf("\033[1;34mInitializing simulation...\033[0m%n");
        
        for (Rocket r : rockets) {
            do {
                budget += r.cost;
            } while (!r.launch() || !r.land());
        }
        
        return budget;
    }
    
}
