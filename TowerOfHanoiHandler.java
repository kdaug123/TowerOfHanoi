import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * This class handles all Tower of Hanoi problems from 1,2,3,...,totalNumDiscs
 @author Kaitlyn Daugherty
 */
public class TowerOfHanoiHandler {

    private ArrayList<TowerOfHanoiInfo> infos;
    private TowerOfHanoi towerOfHanoi;
    private int totalNumDiscs;

    public TowerOfHanoiHandler(int totalNumDiscs, TowerOfHanoi towerOfHanoi) {
        infos = new ArrayList<>();
        this.totalNumDiscs = totalNumDiscs;
        this.towerOfHanoi = towerOfHanoi;
    }

    /**
     * run all simulation problems start at n = 1,2,3,...,totalNumDiscs
     * this defaults to building the string of movements
     */
    public void runAllSimulations() {
        for (int disc = 1; disc <= totalNumDiscs; disc++) {
            TowerOfHanoiInfo towerInfo = new TowerOfHanoiInfo(disc);
            towerOfHanoi.setInfo(towerInfo);
            towerOfHanoi.runSimulation();
            // storing the info object populated in a TowerOfHanoi implementation
            // into the infos ArrayList
            infos.add(towerOfHanoi.getInfo());
        }
    }

    /**
     * run all simulation problems start at n = 1,2,3,...,totalNumDiscs
     * initializing the moveDisplay attribute in TowerOfHanoi info
     * to false, therefore not building the movementOutput string
     */
    public void runAllSimulations(boolean moveDisplay) {
        for (int disc = 1; disc <= totalNumDiscs; disc++) {
            TowerOfHanoiInfo towerInfo = new TowerOfHanoiInfo(disc, moveDisplay);
            towerOfHanoi.setInfo(towerInfo);
            towerOfHanoi.runSimulation();
            // storing the info object populated in a TowerOfHanoi implementation
            // into the infos ArrayList
            infos.add(towerOfHanoi.getInfo());
        }
    }

    /**
     * writes each movement to a file
     */
    public void writeMovementFile(String fileName) {
        try {
            PrintWriter fileWriter = new PrintWriter(new File(fileName));
            for (int i = 0; i < infos.getSize(); i++) {
                fileWriter.write(infos.get(i).getMovementOutput());
            }
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * writes the time it took the problem it finished in a file
     */
    public void writeTimeFile(String fileName) {
        try {
            PrintWriter fileWriter = new PrintWriter(new File(fileName));
            fileWriter.write(String.format("%s,%s\n", "Disc", "Time"));
            for (int i = 0; i < infos.getSize(); i++) {
                String line = String.format("%d,%d\n",i+1, infos.get(i).getTime());
                fileWriter.write(line);
            }
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
