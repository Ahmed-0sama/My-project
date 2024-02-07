list=[ ]
res =[ ]
for i in range (1,11):
    list.append(i)
for ele in list:
     res.append(ele**2)
print (res)
#   comment list =list(range (1,11))
# res=[e**2 for e in list]
#   print (res)
mySet ={x for x in "abracdabra" if x not in "abc"}
print (mySet)
# s="abracdabra"
#st1=set(s)
#st2{'a','b','c'}
#print (st1+st2)