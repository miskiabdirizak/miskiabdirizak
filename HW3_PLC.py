list1, list2 = [], []

with open("HarryPotter.txt") as text: 
    for line in text:
        for word in line.split():
            list1.append(word)

for i in range (len(list1)):
        if ('a' in list1[i] or 'A' in list1[i]) and (list1[i].count('a')%2!=0 or list1[i].count('A')%2!=0):
            list2.append(list1[i])


print("Number of odd number of a's is: ", len(list2),end="\n\n")

#print("The words with odd number of A's/a's are :")
#for i in range (len(list2)):
   # print(list2[i])