import time

n = 13
shu = [False] * n
pie = [False] * (2 * n - 1)
na = [False] * (2 * n - 1)
count = 0

def DFS(row):
    global count
    for col in range(n):
        j = row + col; k = n - 1 - row + col
        if shu[col] or pie[j] or na[k]:
            continue
        if row == n - 1:
            count += 1
        else:
            shu[col] = pie[j] = na[k] = True
            DFS(row + 1)
            shu[col] = pie[j] = na[k] = False

tic = time.time()
DFS(0)
toc = time.time()
print "Total solutions: %d" % count
print "Elapsed time: %f seconds" % (toc - tic)
