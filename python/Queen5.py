import time

n = 13
count = 0

def DFS(row, shu, pie, na):
    global count
    available = ((1 << n) - 1) & ~(shu | pie | na)
    while available:
        p = available & -available
        available ^= p
        if row == n - 1:
            count += 1
        else:
            DFS(row + 1, shu | p, (pie | p) >> 1, (na | p) << 1)

tic = time.time()
DFS(0, 0, 0, 0)
toc = time.time()
print "Total solutions: %d" % count
print "Elapsed time: %f seconds" % (toc - tic)
