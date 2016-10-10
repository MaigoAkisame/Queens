import time

n = 13
sol = [0] * n
count = 0

def DFS(row):
    global count
    for col in range(n):
        if any(col == sol[i] or
               col - sol[i] == row - i or
               col - sol[i] == i - row for i in range(row)): continue
        if row == n - 1:
            count += 1
        else:
            sol[row] = col
            DFS(row + 1)

tic = time.time()
DFS(0)
toc = time.time()
print "Total solutions: %d" % count
print "Elapsed time: %f seconds" % (toc - tic)
