from sys import argv

infile=open(argv[1],"r")
ListIntegers=[]
for i in infile.readline().split(';'):
    ListIntegers.append(int(i))

def avgFirstThreeDigit(IntegersList):

    mylist=[]
    for i in IntegersList:

        if i>=10000:
            a = 0
            b = i

            a+=int(b/10000)
            b=int(b%10000)

            a+=int(b/1000)
            b=int(b%1000)

            a+=int(b/100)
            b=int(b%100)

            mylist.append(float(a/3))

        elif i>=1000:
            a=0
            b=i

            a+=int(b/1000)
            b=int(b%1000)

            a+=int(b/100)
            b=int(b%100)

            a+=int(b/10)
            b=int(b%10)

            mylist.append(float(a/3))


        elif i>=100:
            a=0
            b=i

            a+=int(b/100)
            b=int(b%100)

            a+=int(b/10)
            b=int(b%10)

            a+=int(b)
            b=int(b)

            mylist.append(float(a/3))


    return mylist

mylist=avgFirstThreeDigit(ListIntegers)

def rev(mylist):
    x=[]
    for i in mylist:
        x.insert(0,i)

    return  x


print(rev(mylist))






















