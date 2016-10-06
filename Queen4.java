public class Queen4 {
    private static int n = 15;
    private static int count = 0;
    private static int shu, pie, na;

    public static void main(String[] args) {
        shu = pie = na = 0;
        count = 0;
        long tic = System.currentTimeMillis();
        DFS(0);
        long toc = System.currentTimeMillis();
        System.out.println("Total solutions: " + count);
        System.out.println("Elapsed time: " + (toc - tic) + " ms");
    }

    private static void DFS(int row) {
        int available = ((1 << n) - 1) & ~(shu | (pie >> row) | (na >> (n - 1 - row)));
        while (available != 0) {
            int p = available & -available;
            available ^= p;
            if (row == n - 1) {
                count++;
            }
            else {
                shu ^= p; pie ^= (p << row); na ^= (p << (n - 1 - row));
                DFS(row + 1);
                shu ^= p; pie ^= (p << row); na ^= (p << (n - 1 - row));
            }
        }
    }
}
