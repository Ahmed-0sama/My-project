graph={
    'S' : {'A':1,'B':5,'C':8},
    'A':{'D':3,'E':7,'G':9},
    'B':{'G':4},
    'C':{'G':5},
    'D':{},
    'E':{},
    'G':{}
}
h={
    'S':8, 'A':8,'B':4,'C':3,'D':100,'E':100,'G':0
}

import queue as q
def astar_search(graph,start,end):
    queue =q.PriorityQueue()
    queue.put(8,([start]))
    while not queue.empty():
        node=queue.get()
        current=node [1][-1]
        if current==end:
            print('path found',node[1],'cost',node[0])
            break
        queue=q.clear()
        cost=node[0]
        for child in graph[current]:
            path=node[1][ : ]
            path.append(child)
            queue.put((h[path[-2]])+graph[current][child]+h[child],path)
        
        
        
print(astar_search(graph,'S','G'))