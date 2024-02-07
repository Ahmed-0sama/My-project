import queue as q

def uniform_cost(graph,start,target):
    queue =q.PriorityQueue() 
    queue.put((0,[start]))
    while not queue.empty():
        node=queue.get() 
        current=node[1][-1]
        if target==current:
            print('path found'+ str(node[1]),'cost='+str(node[0]))
            break
        cost=node[0]
        for child in graph[current] :
            path=node[1][:]
            path.append(child)
            queue.put((cost+graph[current][child],path))

graph={
    'S':{'A':5 ,'B':2,'C':4},
    'A':{'D':9,'E':4},
    'B':{'G':6},
    'C':{'F':2},
    'D':{'H':7},
    'E':{'G':6},
    'G':{},
    'F':{'G':1},
    'H':{}
}
uniform_cost(graph,'S','G')
