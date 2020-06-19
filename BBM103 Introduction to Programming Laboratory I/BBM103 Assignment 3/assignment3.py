from sys import argv
file1=open(argv[1],"r")
file2=open(argv[2],"r")
file3=open(argv[3],"r")
file4=open(argv[4],"w")
file5=open(argv[6],"w")
file6=open(argv[5],"w")
dictionary={}
list_1=[]
list_2=[]
information_list = []

for i in file1.readlines():
    i=i.rstrip('\n')
    words=i.split(' ')
    dictionary[words[0]]=words[1]

for i in file2.readlines():

    i = i.rstrip('\n')
    list_1.append(i)

for i in list_1:
    if i[0] == '+':

        list_1.remove(i)
        information_list.append(i)
    elif i[0] == '#':
        list_1.remove(i)

def translation_1():
    for i in list_1:
        templist=i.split(" ")
        keeper = ''
        for i in templist:
            if i in dictionary.keys():

                keeper = keeper + dictionary[i]+ ' '
        for i in templist:
            if i not in dictionary.keys():
                keeper=keeper+i+" "

        file4.write(keeper + " \n" )
        print(keeper)

for i in file3.readlines():
        i = i.rstrip('\n')
        list_2.append(i)

def translation_2():

    dictionary_2 = {}
    reverse_list_1=[]
    reverse_list_2=[]
    for i in dictionary.keys():
        reverse_list_1.append(i)

    for i in dictionary.values():
        reverse_list_2.append(i)

    count=0
    while count<len(reverse_list_1):
        dictionary_2[reverse_list_2[count]]=reverse_list_1[count]
        count+=1



    for i in list_2:
        tempList=i.split(" ")
        keeper=''


        for i in tempList:
            i = i.lower()

            for x in [',', '.', '?','!']:
                if x in i:
                    i = i.replace(x,"")

            if i in dictionary_2.keys():
                keeper=keeper+dictionary_2[i]+" "

            elif i.isnumeric():
                int_value = int(i)
                binary_value = bin(int_value)[2:]
                keeper = keeper+binary_value+" "

            elif i not in dictionary_2.keys():
                keeper=keeper+i+" "




        file5.write(keeper+ "\n")
        print(keeper)

def information():
    file6.write("Data about Binarian planet:"+"\n")
    print("Data about Binarian planet:")
    dictionary_3 = {}
    reverse_list_1=[]
    reverse_list_2=[]
    for i in dictionary.keys():
        reverse_list_1.append(i)

    for i in dictionary.values():
        reverse_list_2.append(i)

    count=0
    while count<len(reverse_list_1):
        dictionary_3[reverse_list_2[count]]=reverse_list_1[count]
        count+=1

    for i in information_list:
        if dictionary_3["distance"] in i:
            tempList=i.split(" ")
            for control in tempList:

                if control.isnumeric():
                    number=int(control,2)
                    distance="%e"%(number*9.4607e+12)
                    file6.write("Distance from the Earth: "+distance+ " km\n")
                    print("Distance from the Earth: "+distance+ " km")
        elif dictionary_3["temperature"] in i:
            tempList=i.split(" ")
            for control in tempList:
                if control.isnumeric():
                    number=int(control,2)
                    number=float(number)


                    file6.write("Planet temperature: "+str(number)+ " degrees Celsius\n")
                    print("Planet temperature: "+str(number)+ " degrees Celsius")
        elif dictionary_3["orbital-speed"] in i:
            tempList=i.split(" ")
            for control in tempList:
                if control.isnumeric():
                    number=int(control,2)
                    number=float(number)


                    file6.write("Orbital speed: "+str(number)+" km/s\n")
                    print("Orbital speed: "+str(number)+" km/s")


translation_1()
print("\n")
information()
print("\n")
translation_2()
file1.close()
file2.close()
file3.close()
file4.close()
file5.close()
file6.close()
