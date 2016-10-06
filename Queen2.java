public class Queen2 {
    private static int n = 15;
    private static int count = 0;
    private static boolean[] shu, pie, na;

    public static void main(String[] args) {
        shu = new boolean[n];
        pie = new boolean[2 * n - 1];
        na = new boolean[2 * n - 1];
        count = 0;
        long tic = System.currentTimeMillis();
        DFS(0);
        long toc = System.currentTimeMillis();
        System.out.println("Total solutions: " + count);
        System.out.println("Elapsed time: " + (toc - tic) + " ms");
    }

    private static void DFS(int row) {
        for (int col = 0; col < n; col++) {
            int i = row + col, j = n - 1 + col - row;
            if (shu[col] || pie[i] || na[j]) {
                continue;
            }
            if (row == n - 1) {
                count++;
            }
            else {
                shu[col] = pie[i] = na[j] = true;
                DFS(row + 1);
                shu[col] = pie[i] = na[j] = false;
            }
        }
    }
}
