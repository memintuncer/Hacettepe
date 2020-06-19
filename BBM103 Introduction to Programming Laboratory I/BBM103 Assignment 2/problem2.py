from sys import argv

infile=open(argv[1],"r")
BulletList = []
resultList = []


for line in infile.readlines():

    i=line.split(" ");
    BulletList.append(i)

def CalculateTotalCost(BulletList):

    for item in BulletList:
        house_value=item[0]
        fuel_value=item[1]
        tax_value=item[2]

        total_value=int(house_value)+int(fuel_value)*10+int(house_value)*float(tax_value)*10
        resultList.append(total_value)

    return resultList

def displayCost(resultList):

    element = 0
    for value in resultList:
        element +=1
        print (element, ".house's total cost is:", value)


def BestSelectBuy():

    houseNumber=resultList.index(min(resultList))
    min_Value=min(resultList)
    print("You should select",houseNumber+1,"house whose total cost is", min_Value)


print ("The total cost of each house : ")
CalculateTotalCost(BulletList)
displayCost(resultList)
BestSelectBuy()













