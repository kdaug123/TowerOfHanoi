/**
 *  A Runner class to implement all requirements for the Tower of Hanoi problem
@author Kaitlyn Daugherty
*/
public class TowerOfHanoiRunner {

    public static void main(String[] args) {

        // calculates the number of files from the command line
        // arguments
        int numOfFiles = args.length - 1;

        try {
            // change the data type from string to int (surrounded by a
            // try catch block to catch non-digit inputs
            int numOfDiscs = Integer.parseInt(args[0]);
            TowerOfHanoi[] towerOfHanoiImps = createImplementations();

            TowerOfHanoiHandler handler;

            if (numOfFiles == 2) {
                // if the commmand line arguments equals 2, it only runs the
                // times output for both iterative and recursive without
                // building the movementOutput string

                for (int i = 1; i <= towerOfHanoiImps.length; i++) {
                    handler = new TowerOfHanoiHandler(numOfDiscs, towerOfHanoiImps[i-1]);
                    handler.runAllSimulations(false);
                    // Because of the naming convention of the filenames, the
                    // position to append the "without_movement_" at the correct
                    // location. More specifically, at the underscore after the word
                    // output
                    int position = 12;
                    String newFileName = String.format("%swithout_movement_%s", args[i].substring(0, position),
                            args[i].substring(position));
                    handler.writeTimeFile(newFileName);
                }
            } else if (numOfFiles == 4) {
                // if the commmand line arguments equals 4, run movement and
                // time output files for both iterative and recursive with
                // building the movementOutput string

                for (int i = 1; i <= towerOfHanoiImps.length; i++) {
                    handler = new TowerOfHanoiHandler(numOfDiscs, towerOfHanoiImps[i-1]);
                    handler.runAllSimulations();
                    // Because of the ordering of the output files, both time output files
                    // corresponds to an odd index, and both movement output files corresponds
                    // to an event index;
                    handler.writeTimeFile(args[2*i-1]);
                    handler.writeMovementFile(args[2*i]);
                }
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /**
     * Populates an array of TowerOfHanoi implementations
     * @return TowerOfHanoi[] This returns the implementations iterative and recursive respectively
     */
    public static TowerOfHanoi[] createImplementations() {
        TowerOfHanoi[] towerOfHanoiImps = new TowerOfHanoi[2];
        towerOfHanoiImps[0] = new TowerOfHanoiIterative();
        towerOfHanoiImps[1] = new TowerOfHanoiRecursive();
        return towerOfHanoiImps;
    }
}
