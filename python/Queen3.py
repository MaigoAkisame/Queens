import time

n = 13
shu = pie = na = 0
count = 0

def DFS(row):
    global count, shu, pie, na
    for col in range(n):
        j = row + col; k = n - 1 - row + col
        if ((shu >> col) | (pie >> j) | (na >> k)) & 1:
            continue
        if row == n - 1:
            count += 1
        else:
            shu ^= (1 << col); pie ^= (1 << j); na ^= (1 << k)
            DFS(row + 1)
            shu ^= (1 << col); pie ^= (1 << j); na ^= (1 << k)

tic = time.time()
DFS(0)
toc = time.time()
print "Total solutions: %d" % count
print "Elapsed time: %f seconds" % (toc - tic)
