import csv
import matplotlib.pyplot as plot
import numpy as np
import sys
import random
output_File1=open("retrievedData.txt","w")
output_File2=open("myAnswer.txt","w")
global filename
global nomi_list

filename = sys.argv[1]
x = sys.argv[2].strip('"')
nomi_list = x.split(",")

def retrieveData(file,list):
    file_list = []
    for i in list:
        file_list.extend(create_dictionary(file,i))

    output_File1.write(str(file_list))
    return file_list



def get_header(file):
    liste=[]
    with open(filename) as csvfile1:
        file=csv.reader(csvfile1)
        for i in file:
            liste.append(i)
        return liste[0]

def create_dictionary(file_3,name):
    list = []
    with open(file_3) as csvfile2:
        file_4=csv.DictReader(csvfile2)
        for row in file_4:
            if row[name].isnumeric():
                list.append(int(row[name]))
            else:
                list.append(row[name])
    return list

def DispBarPlot():
    liste=get_header(filename)
    liste2=nomi_list

    liste3=[]
    a_dict = {}
    d_dict={}
    for name in liste2:
        if name in liste:
            a_dict[name] = create_dictionary(filename,name)

    b_dict={}
    c_dict={}
    for i in range(len(liste2)):
        total=0
        for j in a_dict[liste2[i]]:
            total=total+int(j)
        b_dict[liste2[i]]=total
        liste3.append(total)
        liste3.sort()
        max_vote_list=liste3[-2:]

    for i in b_dict.keys():
        for j in range(len(max_vote_list)):
            if b_dict[i] in max_vote_list:
                c_dict[i]=max_vote_list[j]

    Legend_Box=[]
    for i in c_dict:
        Legend_Box.append(i)

    liste3=[liste[0]]
    for name1 in liste:
        if name1 in liste3:
            d_dict[name1]=create_dictionary(filename,name1)

    states_List=[]
    for i in d_dict.values():
        states_List.extend(i)

    votes_list = []
    for i in a_dict.keys():
        if i in Legend_Box:
            votes_list.append(a_dict[i])

    x_axes=np.arange(len(states_List))
    y_axes_1=create_dictionary(filename,Legend_Box[1])
    y_axes_2=create_dictionary(filename,Legend_Box[0])
    width=0.20
    ax=plot.subplot()
    ax.bar(x_axes,y_axes_1,width,color="red",label=Legend_Box[1])
    ax.bar(x_axes+width,y_axes_2,width,color="blue",label=Legend_Box[0])
    ax.set_xlim(-width,len(x_axes))
    votes=states_List
    ax.set_xticks(x_axes)
    ax.set_ylabel("Vote Count")
    ax.set_xlabel("States")
    votes_changes=ax.set_xticklabels(votes)
    plot.setp(votes_changes,rotation=90)
    ax.legend()
    plot.savefig("ComparativeVotes.pdf")
    plot.close()

def compareVoteonBar():
    file=filename
    list=nomi_list
    volue_List = []
    max_Volue_List=[]
    percent_List=[]
    a_dict={}
    b_dict={}
    for name in list:
        if name in list:
            a_dict[name] = create_dictionary(filename,name)
    for i in list:
        volue_List.extend(create_dictionary(file,i))
    for i in range(len(list)):
        total=0
        for j in a_dict[list[i]]:
            total=total+int(j)
        b_dict[list[i]]=total
        max_Volue_List.append(total)


    for i in max_Volue_List:
        a=sum(volue_List)

        percent=(i/a)*100
        percent_List.append(round(percent,3))

    colors=["red","blue","yellow","cyan"]
    xTickMarks=[str(i)+"%" for i in percent_List]
    x_pos=[i for i in range(len(list))]
    Legend=plot.bar(x_pos,percent_List,align='center',color=colors,alpha=0.8)
    plot.xticks(x_pos,xTickMarks)
    plot.ylabel("Vote percentages")
    plot.xlabel("Nominees")
    plot.legend((Legend),(list))
    plot.close()

def obtainHistogram(liste123):

    vote_List1=[]

    liste=[]
    number=["0","1","2","3","4","5","6","7","8","9"]
    Repeat_List=[]
    list_2=[]
    for i in liste123:
        if i<10:
            k=str(i)
            vote_List1.append("0"+k)
        else :
            j=str(i)
            vote_List1.append(j[-2:])

    for i in number:
        for j in vote_List1:
            for x in j:
                if x==i:
                    liste.append(i)

    for i in number:
        Repeat_List.append(liste.count(i))

    for i in Repeat_List:
        j=i/sum(Repeat_List)
        list_2.append(round(j,3))
    return list_2


def plotHistogram():
    abc=retrieveData(filename,nomi_list)
    asd=obtainHistogram(abc)

    mean=[1/len(asd) for i in range(10)]
    x_ax=[0,1,2,3,4,5,6,7,8,9]
    y_ax=asd
    plot.plot(x_ax,y_ax,"-",linewidth=2,color="red",label="Digit Dist.")
    plot.plot(x_ax,mean,"--",linewidth=2,color="green",label="Mean")
    plot.xlabel("Digits")
    plot.ylabel("Distribution")
    plot.title("Histogram of least sign. digits")
    plot.legend()
    plot.savefig("Histogram.pdf")
    plot.close()


def plotHistogramWithSample():
    list1=[]
    list2=[]
    list3=[]
    list4=[]
    list5=[]
    list1_1=[]
    list2_1=[]
    list3_1=[]
    list4_1=[]
    list5_1=[]
    a_list=[]
    b_list=[]
    c_list=[]
    d_list=[]
    e_list=[]
    repeat_List1=[]
    repeat_List2=[]
    repeat_List3=[]
    repeat_List4=[]
    repeat_List5=[]
    countlis1=[]
    countlis2=[]
    countlis3=[]
    countlis4=[]
    countlis5=[]

    numbers1=["0","1","2","3","4","5","6","7","8","9"]

    for i in range(5):
        list1.append(random.randrange(1,100))
    for i in range(10):
        list2.append(random.randrange(1,100))
    for i in range(100):
        list3.append(random.randrange(1,100))
    for i in range(1000):
        list4.append(random.randrange(1,100))
    for i in range(10000):
        list5.append(random.randrange(1,100))

    for i in list1:
        if i<10:
                k=str(i)
                list1_1.append("0"+k)
        else:
                j=str(i)
                list1_1.append(j)
    for i in list2:
        if i<10:
            k=str(i)
            list2_1.append("0"+k)
        else:
            j=str(i)
            list2_1.append(j)
    for i in list3:
        if i<10:
            k=str(i)
            list3_1.append("0"+k)
        else:
            j=str(i)
            list3_1.append(j)
    for i in list4:
        if i<10:
            k=str(i)
            list4_1.append("0"+k)
        else:
            j=str(i)
            list4_1.append(j)
    for i in list5:
        if i<10:
            k=str(i)
            list5_1.append("0"+k)
        else:
            j=str(i)
            list5_1.append(j)
    for i in numbers1:
        for j in list1_1:
            for x in j:
                if x==i:
                    a_list.append(i)
    for i in numbers1:
        for j in list2_1:
            for x in j:
                if x==i:
                    b_list.append(i)
    for i in numbers1:
        for j in list3_1:
            for x in j:
                if x==i:
                    c_list.append(i)
    for i in numbers1:
        for j in list4_1:
            for x in j:
                if x==i:
                    d_list.append(i)
    for i in numbers1:
        for j in list5_1:
            for x in j:
                if x==i:
                    e_list.append(i)
    for i in numbers1:
        repeat_List1.append(a_list.count(i))
    for i in numbers1:
        repeat_List2.append(b_list.count(i))
    for i in numbers1:
        repeat_List3.append(c_list.count(i))

    for i in numbers1:
        repeat_List4.append(d_list.count(i))
    for i in numbers1:
        repeat_List5.append(e_list.count(i))

    for i in repeat_List1:
        j=i/sum(repeat_List1)
        countlis1.append(round(j,3))
    for i in repeat_List2:
        j=i/sum(repeat_List2)
        countlis2.append(round(j,3))
    for i in repeat_List3:
        j=i/sum(repeat_List3)
        countlis3.append(round(j,3))
    for i in repeat_List4:
        j=i/sum(repeat_List4)
        countlis4.append(round(j,3))
    for i in repeat_List5:
        j=i/sum(repeat_List5)
        countlis5.append(round(j,3))

    mean=[1/len(countlis1) for i in range(10)]
    x_ax=["0","1","2","3","4","5","6","7","8","9"]
    y_ax=countlis1
    plot.plot(x_ax,y_ax,"-",linewidth=2,color="red",label="Digit Dist.")
    plot.plot(x_ax,mean,"--",linewidth=2,color="green",label="Mean")
    plot.xlabel("Digits")
    plot.ylabel("Distribution")
    plot.title("Histogram of least sign. digits -Sample:1")
    plot.legend(loc="upper left")
    plot.savefig("HistogramofSample1.pdf")
    plot.close()


    mean=[1/len(countlis2) for i in range(10)]
    x_ax=["0","1","2","3","4","5","6","7","8","9"]
    y_ax=countlis2
    plot.plot(x_ax,y_ax,"-",linewidth=2,color="blue",label="Digit Dist.")
    plot.plot(x_ax,mean,"--",linewidth=2,color="green",label="Mean")
    plot.xlabel("Digits")
    plot.ylabel("Distribution")
    plot.title("Histogram of least sign. digits -Sample:2")
    plot.legend(loc="upper left")
    plot.savefig("HistogramofSample2.pdf")
    plot.close()

    mean1=[1/len(countlis3) for i in range(10)]
    x_ax1=["0","1","2","3","4","5","6","7","8","9"]
    y_ax1=countlis3
    plot.plot(x_ax1,y_ax1,"-",linewidth=2,color="yellow",label="Digit Dist.")
    plot.plot(x_ax1,mean1,"--",linewidth=2,color="green",label="Mean")
    plot.xlabel("Digits")
    plot.ylabel("Distribution")
    plot.title("Histogram of least sign. digits -Sample:3")
    plot.legend(loc="upper left")
    plot.savefig("HistogramofSample3.pdf")
    plot.close()

    mean1=[1/len(countlis4) for i in range(10)]
    x_ax1=["0","1","2","3","4","5","6","7","8","9"]
    y_ax1=countlis4
    plot.plot(x_ax1,y_ax1,"-",linewidth=2,color="cyan",label="Digit Dist.")
    plot.plot(x_ax1,mean1,"--",linewidth=2,color="green",label="Mean")
    plot.xlabel("Digits")
    plot.ylabel("Distribution")
    plot.title("Histogram of least sign. digits -Sample:4")
    plot.legend(loc="upper left")
    plot.savefig("HistogramofSample4.pdf")
    plot.close()

    mean1=[1/len(countlis5) for i in range(10)]
    x_ax1=["0","1","2","3","4","5","6","7","8","9"]
    y_ax1=countlis5
    plot.plot(x_ax1,y_ax1,"-",linewidth=2,color="purple",label="Digit Dist.")
    plot.plot(x_ax1,mean1,"--",linewidth=2,color="green",label="Mean")
    plot.xlabel("Digits")
    plot.ylabel("Distribution")
    plot.title("Histogram of least sign. digits -Sample:5")
    plot.legend(loc="upper left")
    plot.savefig("HistogramofSample5.pdf")
    plot.close()


def calculateMSE(list1,list2):

    calculat_List=[(i-j)**2 for i in list1  for j in list2 ]
    result=sum(calculat_List)
    return result



def compareMSEs(x):
    list1=[]
    for i in range(10000):
        list2=[]
        for k in range(len(retrieveData(filename,nomi_list))):
            list2.append(random.randrange(0,100))
        list1.append(list2)

    count=0
    count1=0
    for i in range(10000):
        mean1=obtainHistogram(list1[i])
        mean2=[1/len(mean1) for i in range(len(mean1))]
        abc=calculateMSE(mean1,mean2)


        if abc>=x:
            count+=1
        else:
            count1+=1
    p_value=count1/10000


    x=obtainHistogram(retrieveData(filename,nomi_list))
    mse=calculateMSE(x,[1/len(x) for i in range(10)])
    print("MSE value of 2012 USA election is " +str(mse))
    output_File2.write("MSE value of 2012 USA election is " +str(mse)+"\n")
    print(("The number of MSE of random samples which are larger than or equal to USA election MSE is "+str(count)))
    output_File2.write("The number of MSE of random samples which are larger than or equal to USA election MSE is "+str(count)+"\n")
    print("The number of MSE of random samples which are smaller than USA election MSE is "+ str(count1))
    output_File2.write("The number of MSE of random samples which are smaller than USA election MSE is "+ str(count1)+"\n")
    print("2012 USA election rejection level p is "+str(p_value))
    output_File2.write("2012 USA election rejection level p is "+str(p_value)+"\n")
    if p_value<=0.05:
        print("Finding: We reject the null hypothesis at the p= "+str(p_value))
        output_File2.write("Finding: We reject the null hypothesis at the p= "+str(p_value)+"\n")
    else:
        print("Finding: There is no statistical evidence to reject null hypothesis")
        output_File2.write("Finding: There is no statistical evidence to reject null hypothesis")


for name in nomi_list:

    list_Histogram=obtainHistogram(create_dictionary(filename,name))
    mean=[1/len(obtainHistogram(create_dictionary(filename,name))) for i in range(10)]

MSE=(calculateMSE(obtainHistogram(retrieveData(filename,nomi_list)),[1/len(obtainHistogram(create_dictionary(filename,name))) for i in range(10)]))
retrieveData(filename,nomi_list)
get_header(filename)
DispBarPlot()
compareVoteonBar()
plotHistogram()
plotHistogramWithSample()
compareMSEs(MSE)
output_File1.close()
output_File2.close()
