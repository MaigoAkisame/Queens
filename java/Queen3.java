public class Queen3 {
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
        for (int col = 0; col < n; col++) {
            int i = row + col, j = n - 1 + col - row;
            if ((((shu >> col) | (pie >> i) | (na >> j)) & 1) != 0) {
                continue;
            }
            if (row == n - 1) {
                count++;
            }
            else {
                shu ^= (1 << col); pie ^= (1 << i); na ^= (1 << j);
                DFS(row + 1);
                shu ^= (1 << col); pie ^= (1 << i); na ^= (1 << j);
            }
        }
    }
}
