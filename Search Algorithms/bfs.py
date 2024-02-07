intput_graph={1:[2,3],2:[4,5],3:[5],4:[6],5:[ ],6:[7],7:[]}
def bredth(graph,start,goal):
    queue,path=[start],[ ]
    while queue:
        vertex=queue.pop(0)
        if vertex in path:
            continue
        path.append(vertex)
        if vertex ==goal:
            return path 
        for child in graph[vertex]:
            queue.append(child)
    return path            

print(bredth(intput_graph,1,5))