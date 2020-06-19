import os

def Find_Direction(direction):
    direction1=os.getcwd()
    files_dictionary={}
    road=os.path.join(direction1,direction)
    try :
        os.chdir(road)
        files=os.listdir(road)
        for file in files:
            try:
                inside_file=open(file,"r")
                files_dictionary[file]=inside_file.read()
                inside_file.close()
            except:
                pass
        os.chdir(direction1)
    except:
        pass
    return files_dictionary
file1=open("stopwords.txt","r")
data_file=open("u.data","r")
genre_File=open("u.genre","r")
item_File=open("u.item","r")
occupation_file=open("u.occupation","r")
user_file=open("u.user","r")
output_file1=open("review.txt ","w")
item_list=[]
item_dict={}
genre_list=[]
genre_dict={}
movie_title={}
movie_date={}
movie_imdbLink={}
movie_Genre={}
user_list=[]
user_dict={}
id_List=[]
list1=[]
occupation_List=[]
occupation_dict={}
data_list=[]
data_dict={}

for line in item_File:
    line=line.rstrip("\n")
    i=line.split("|")
    item_list.append(i)
for i in item_list:
    item_dict[i[0]]=i[1:]

for lines in genre_File.readlines():
    lines=lines.rstrip("\n")
    i=lines.split("|")
    genre_list.append(i)

for i in genre_list:
    genre_dict[i[1]]=i[0]
list2=[]
list3=[]
for i in item_dict.values():
    list2.append(i[3:])
for k in item_dict.keys():
    list1=item_dict[k][3:]
    list3= [i for i,x in enumerate(list1) if x == "1"]
for line in occupation_file.readlines():
    line=line.rstrip("\n")
    i=line.split("|")
    occupation_List.append(i)
for i in occupation_List:
    occupation_dict[i[0]]=i[1]

#print(occupation_dict)
for line in user_file.readlines():
    line=line.rstrip("\n")
    i=line.split("|")
    user_list.append(i)
for i in user_list:
    user_dict[i[0]]=i[1:]
for i in user_dict.values():
    i[2]=occupation_dict[i[2]]

for i in data_file.readlines():
    i=i.rstrip("\n")
    j=i.split("\t")
    data_key=j[1]
    j.remove(data_key)
    value=j
    if data_key not in data_dict.keys():
        data_dict[data_key]=[]
        data_dict[data_key].append(value)
    else:
        data_dict[data_key].append(value)
file_dictionary=Find_Direction("film")
review_list=[]
review_list1=[]
for i in file_dictionary.values():
    i=i.split("(")
    review_list.append(i)

for j in review_list:
    review_list1.extend(j)
for k in item_dict.keys():
    x=item_dict[k][0][:-6]
    x=x.upper()
    for i in range(14):
        if x in review_list[i]:

            output_file1.write(k+" "+x+ "is found in folder\n")

    if x not in review_list1:
        output_file1.write(k+" "+x+" is not found in folder. Look at "+item_dict[k][2]+"\n" )

item_list=[]
movie_namelist=[]
for item in item_dict.keys():
    item1=item_dict[item][0][:-6]
    item_list.append(item1)
for i in item_list:
    if i.upper() in review_list1:
        movie_namelist.append(i)
imdb_list=[]
imdb_dict={}
for i in item_dict.keys():
    x=item_dict[i][0][:-6]
    if x.upper() in review_list1:
        imdb_dict[x]=item_dict[i][2]

imdb_dict['']=" "

vote_dict={}
for i in item_dict.keys():
    x=item_dict[i][0][:-6]
    if x.upper() in review_list1:
        vote_dict[x]=data_dict[i]

total_votedict={}
total_userdict={}
total_votelist=[]
total_ratedict={}
for i in vote_dict.keys():
    total_userdict[i]=len(vote_dict[i])

movie_users={}
for i in vote_dict.keys():
    for j in range(len(vote_dict[i])):
        total_votedict[i]=(vote_dict[i][j][1])

total_votelist1=[]
total_votelist2=[]

votes_list=[]

for i in movie_namelist:
    for j in vote_dict[i]:
        votes_list.append(int(j[1]))
for i in movie_namelist:
    total_ratedict[i]=votes_list[:len(vote_dict[i])]
    votes_list=votes_list[len(vote_dict[i]):]

for i in total_ratedict.keys():
    total_ratedict[i]=sum(total_ratedict[i])/len(total_ratedict[i])
total_ratedict['']=" "
total_userdict['']=" "

genre_Dictionary={}
genre_dict1={}
for i in item_dict.keys():
    genre_dict1[i]=item_dict[i][-19:]

for i in genre_dict1.keys():

    list5=genre_dict1[i]
    list6= [str(i) for i,x in enumerate(list5) if x == "1"]
    genre_dict1[i]=list6
for i in genre_dict1.values():
    if len(i)==1:
        i[0]=genre_dict[i[0]]
    elif len(i)==2:
        i[0]=genre_dict[i[0]]
        i[1]=genre_dict[i[1]]
    elif len(i)==3:
        i[0]=genre_dict[i[0]]
        i[1]=genre_dict[i[1]]
        i[2]=genre_dict[i[2]]
    elif len(i)==4:
        i[0]=genre_dict[i[0]]
        i[1]=genre_dict[i[1]]
        i[2]=genre_dict[i[2]]
        i[3]=genre_dict[i[3]]
    elif len(i)==5:
        i[0]=genre_dict[i[0]]
        i[1]=genre_dict[i[1]]
        i[2]=genre_dict[i[2]]
        i[3]=genre_dict[i[3]]
        i[4]=genre_dict[i[4]]
    elif len(i)==6:
        i[0]=genre_dict[i[0]]
        i[1]=genre_dict[i[1]]
        i[2]=genre_dict[i[2]]
        i[3]=genre_dict[i[3]]
        i[4]=genre_dict[i[4]]
        i[5]=genre_dict[i[5]]
    elif len(i)==7:
        i[0]=genre_dict[i[0]]
        i[1]=genre_dict[i[1]]
        i[2]=genre_dict[i[2]]
        i[3]=genre_dict[i[3]]
        i[4]=genre_dict[i[4]]
        i[5]=genre_dict[i[5]]
        i[6]=genre_dict[i[6]]
    elif len(i)==8:
        i[0]=genre_dict[i[0]]
        i[1]=genre_dict[i[1]]
        i[2]=genre_dict[i[2]]
        i[3]=genre_dict[i[3]]
        i[4]=genre_dict[i[4]]
        i[5]=genre_dict[i[5]]
        i[6]=genre_dict[i[6]]
        i[7]=genre_dict[i[7]]
    elif len(i)==9:
        i[0]=genre_dict[i[0]]
        i[1]=genre_dict[i[1]]
        i[2]=genre_dict[i[2]]
        i[3]=genre_dict[i[3]]
        i[4]=genre_dict[i[4]]
        i[5]=genre_dict[i[5]]
        i[6]=genre_dict[i[6]]
        i[7]=genre_dict[i[7]]
        i[8]=genre_dict[i[8]]
    elif len(i)==10:
        i[0]=genre_dict[i[0]]
        i[1]=genre_dict[i[1]]
        i[2]=genre_dict[i[2]]
        i[3]=genre_dict[i[3]]
        i[4]=genre_dict[i[4]]
        i[5]=genre_dict[i[5]]
        i[6]=genre_dict[i[6]]
        i[7]=genre_dict[i[7]]
        i[8]=genre_dict[i[8]]
        i[9]=genre_dict[i[9]]
    elif len(i)==11:
        i[0]=genre_dict[i[0]]
        i[1]=genre_dict[i[1]]
        i[2]=genre_dict[i[2]]
        i[3]=genre_dict[i[3]]
        i[4]=genre_dict[i[4]]
        i[5]=genre_dict[i[5]]
        i[6]=genre_dict[i[6]]
        i[7]=genre_dict[i[7]]
        i[8]=genre_dict[i[8]]
        i[9]=genre_dict[i[9]]
        i[10]=genre_dict[i[10]]

genre_dict2={}
for i in genre_dict1.keys():
    genre_dict2[item_dict[i][0][:-6]]=genre_dict1[i]

for i in genre_dict2.keys():
    if i.upper() in review_list1:
        genre_Dictionary[i]=genre_dict2[i]
movie_item={}
file_dictionary1={}
for i in file_dictionary.keys():
    x=file_dictionary[i]
    x=x.split('(')
    y=x[0]

    file_dictionary1[y]=file_dictionary[i]


rev_lis=[]
txt_list=[]
review_dict={}
for i in file_dictionary.keys():
    txt_list.append(i)
for i in file_dictionary.keys():
    rev_lis.append(file_dictionary[i])

for i in rev_lis:
    i=i.split("\n")
    x=i[0].split("(")[0]
    if x in review_list1:
        review_dict[x]=" ".join(i[1:])

review_dict1={}
for i in item_dict.keys():
    x=item_dict[i][0][:-6]
    if x.upper() in review_list1:
        review_dict1[x]=review_dict[x.upper()]

review_dict1['']=" "

vote_dict1={}
for i in vote_dict.keys():
    user_id=[]
    for j in vote_dict[i]:
        user_id.append(j[0])

        vote_dict1[i]=user_id

rate_dict={}
for  i in vote_dict.keys():
    user_vote=[]
    for j in vote_dict[i]:
        user_vote.append(j[1])
        rate_dict[i]=user_vote
rate_dict['']=" "
vote_dict1['']=" "
genre_dict2['']=" "
imdb_dict['']=" "
review_dict['']=" "
if "''" in rate_dict:
    del rate_dict["''"]
user_who_rate={}
for i in data_dict.keys():
    x=item_dict[i][0][:-6]
    for j in data_dict[i]:
        user_who_rate[j[0],x]=j[1]

savepat1=(os.getcwd())
def create_path(file):
    try:
        os.mkdir(file)
        return str(os.mkdir(file))
    except:
        return str(file)

filmfile=create_path("filmList")
mainfile=os.chdir(filmfile)

for i in item_dict.keys():
    x=item_dict[i][0][:-6]
    if x.upper() in review_list1:

        name_of_file =i+".html"

        file1 = open(name_of_file, "w")
        file1.write("<html>\n"+"<head>\n"+"<title>"+x+"</title>\n"+"</head>\n"+"<body>\n"
                +"<font face='Times New Roman' font size='6' color='red'<b></b>"+x
                +"</font><br>"
                +"<b>Genre: "+"</b>" +" ".join((genre_dict2[x]))+  "<br>"
                +"<b>IMDB Link: </b>"+"<a href="+imdb_dict[x]+">"+x+"</a><br>\n"+"</body>"
                +"<font face='Times New Roman' font size='4' color='black'>"+"<b>"+"Review:<br>"+"</b>"+review_dict1[x]+
                "<br>"+"</font><br><br>"
                +"<b>Total User: "+" </b>"+str(total_userdict[x])+"/"+ "<b>Total Rate: "+"</b>"+str(total_ratedict[x])


                +"<br><br><b>User who rate the film: " +"</b>")

        for i in vote_dict1[x]:
            #print(rate_dict[x])

            file1.write("<br><b>"+"User:" +"</b>"
                    + i+"  " +"<b>Rate: " +"</b>" +user_who_rate[i,x] +"<br>"
                    +"<b>"+"User Detail:"+"Age:"+"</b>"+user_dict[i][0]
                    +"<b>"+"Genre:"+"</b>"+user_dict[i][1]+  "</b>"
                    +"<b>"+" Occupation :"+"</b>"+user_dict[i][2]
                    +"<b>"+" Zip code :"+"</b>"+user_dict[i][3]
                    )
os.chdir(savepat1)


######                 STAGE 2 ##################

genre_list=[]
for i in genre_dict.keys():
    genre_list.append(genre_dict[i])
file_genre={}
for i in genre_dict2.keys():
    if i.upper() in review_list1:
        file_genre[i.upper()]=genre_dict2[i]

genres_review={}
for i in genre_list:
    genres_review[i] = []

for i in file_genre.keys():
    for j in range(len(file_genre[i])):
        listem=[]
        if file_genre[i][j] in genre_list:
            listem =  genres_review[file_genre[i][j]]
            listem.append(review_dict[i])
            genres_review[file_genre[i][j]] = listem

for i in genres_review.keys():
    j=((" ".join(genres_review[i])).lower()).split(" ")
    #print(j)
    genres_review[i]=j
guess_dict=Find_Direction("filmGuess")
guess_dict1={}
guess_dict2={}

guess_list=[]
guess_list1=[]
for i in guess_dict.values():
    i=i.split("(")
    guess_list.append(i)
for i in guess_list:
    guess_list1.extend(i)

rev_lis1=[]
txt_list1=[]
for i in guess_dict.keys():
    txt_list1.append(i)
for i in guess_dict.keys():
    rev_lis1.append(guess_dict[i])
for i in rev_lis1:
    i=i.split("\n")
    x=i[0].split("(")[0]

    if x in guess_list1:
        guess_dict1[x]=" ".join(i[1:])

for i in guess_dict1.keys():
    x=guess_dict1[i]
    x = x.lower()
    x=x.split(" ")
    guess_dict2[i]=set(x)

words=open("stopwords.txt","r",encoding="UTF-8")
words_list=[]
for i in words.readlines():
    i=i.rstrip("\n")
    words_list.append(i)
d_genre = {}
for i in genres_review.keys():
    list152=[]
    for j in genres_review[i]:
        if j.lower() in words_list:
            #print(j)
            #list152.append(j)
            genres_review[i].remove(j)
        else:
            list152.append(j)
        d_genre[i] = list152

compare_dict={}
for i in guess_dict2.keys():
    genre_list_2 = []
    for j in d_genre.keys():
        x=list(set(d_genre[j]).intersection(guess_dict2[i]))
        #print(x)
        if len(x)>=16:
            genre_list_2.append(j)
    compare_dict[i] = genre_list_2
output_file2=open("filmGenre.txt","w")
output_file2.write("Guess Genres of Movie based on Movies\n")
for i in compare_dict.keys():
    output_file2.write(i+": "+" "   " ".join(compare_dict[i])+"\n")
