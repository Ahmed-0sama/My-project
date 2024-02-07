intput_graph={1:[2,3],2:[4,5],3:[5],4:[6],5:[ ],6:[7],7:[]}
def depth(graph,start,goal):
    stack,path=[start ],[ ]
    while stack:
        vertex=stack.pop()
        if vertex in path:
            continue
        path.append(vertex)
        if vertex ==goal:
            return path 
        for child in reversed (graph[vertex]):
            stack.append(child)
    return path            

print(depth(intput_graph,1,5))