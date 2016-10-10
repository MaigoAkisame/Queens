import time

n = 13
shu = pie = na = 0
count = 0

def DFS(row):
    global count, shu, pie, na
    available = ((1 << n) - 1) & ~(shu | (pie >> row) | (na >> (n - 1 - row)))
    while available:
        p = available & -available
        available ^= p
        if row == n - 1:
            count += 1
        else:
            shu ^= p; pie ^= (p << row); na ^= (p << (n - 1 - row))
            DFS(row + 1)
            shu ^= p; pie ^= (p << row); na ^= (p << (n - 1 - row))

tic = time.time()
DFS(0)
toc = time.time()
print "Total solutions: %d" % count
print "Elapsed time: %f seconds" % (toc - tic)
