values = [2, 8, 9, -10]
mini, maxi = 1000, -1000
nlevels = 2

def minmax(depth, nodeIndex, maxplayer, beta, alpha):
    if depth == nlevels:
        return values[nodeIndex]

    if maxplayer:
        best = maxi
        for i in range(0, 2):
            val = minmax(depth + 1, nodeIndex * 2 + i, False, beta, alpha)
            best = max(best, val)
            alpha = max(best, alpha)

            if alpha >= beta:
                break

        return best
    else:
        best = mini
        for i in range(0, 2):
            val = minmax(depth + 1, nodeIndex * 2 + i, True, beta, alpha)
            best = min(best, val)
            beta = min(best, beta)

            if alpha >= beta:
                break

        return best

print("optimal", minmax(0, 0, False, mini, maxi))
