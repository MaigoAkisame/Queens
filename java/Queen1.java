public class Queen1 {
    private static int n = 15;
    private static int count = 0;
    private static int[] sol;

    public static void main(String[] args) {
        sol = new int[n];
        count = 0;
        long tic = System.currentTimeMillis();
        DFS(0);
        long toc = System.currentTimeMillis();
        System.out.println("Total solutions: " + count);
        System.out.println("Elapsed time: " + (toc - tic) + " ms");
    }

    private static void DFS(int row) {
        for (int col = 0; col < n; col++) {
            boolean ok = true;
            for (int r = 0; r < row; r++) {
                if (sol[r] == col || sol[r] == col + r - row || sol[r] == col - r + row) {
                    ok = false;
                    break;
                }
            }
            if (!ok) continue;
            sol[row] = col;
            if (row == n - 1) {
                count++;
//                print();
            }
            else {
                DFS(row + 1);
            }
        }
    }

    private static void print() {
        System.out.print("Solution " + count + ":");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + sol[i]);
        }
        System.out.println();
    }
}
