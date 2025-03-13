package algstudent.s3.championship;


public class Calendar {
    private int[][] scheduleTable;
    private int numPlayers;

    public Calendar(int n) {
        this.numPlayers = n;
        this.scheduleTable = new int[n][n];
    }

    public void schedule(int first, int last) {
    	schedule(last - first+1);
    }
    
    private void schedule(int n) {
        if (n > 0) {
            schedule(n/2);
            if (n == 1)
                scheduleTable[0][0] = 0;
            else {
                for (int i = 0; i < n/2; i++)
                    for (int j = 0; j < n/2; j++) {
                    	scheduleTable[i][j+(n/2)] = scheduleTable[i][j] + (n/2);
                    	scheduleTable[i+(n/2)][j] = scheduleTable[i][j] + (n/2);
                    	scheduleTable[i+(n/2)][j+(n/2)] = scheduleTable[i][j];
                    }
            }
        }
    }

    public int[][] getTable() {
        return scheduleTable;
    }

    public void printBoard() {
        System.out.println("PLAYER/OPPONENT");
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Player " + i + " | ");
            for (int j = 0; j < numPlayers - 1; j++) {
                System.out.print(scheduleTable[i][j+1] + " ");
            }
            System.out.println();
        }
    }

    public void printBoardWithNames(String[] names) {
        System.out.println("PLAYER/OPPONENT");

        System.out.printf("%-15s", " ");
        for (int day = 0; day < numPlayers - 1; day++) {
            System.out.printf("DAY %d   ", day + 1);
        }
        System.out.println();

        for (int i = 0; i < numPlayers; i++) {
            System.out.printf("%-15s", names[i]);
            for (int j = 0; j < numPlayers - 1; j++) {
                System.out.printf("%-10s", names[scheduleTable[i][j+1]]);
            }
            System.out.println();
        }
    }
}
