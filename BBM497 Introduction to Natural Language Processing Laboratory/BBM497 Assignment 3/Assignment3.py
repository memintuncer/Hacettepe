import random

filepath="cfg.gr"
root="ROOT"

number_of_Sentences=10
sentence_length=20


def rules(folderpath):
    CFG_rules1={}
    datafile = open(folderpath, "r")
    lines=datafile.readlines()
    for line in lines:
        if not line[0]=="#" and line != "\n":
            rule = line.split("#")[0]
            rule = rule.replace("\n", "")
            rule=rule.split("\t")
            rule[0]=rule[0].strip(" ")
            if rule[0] not in CFG_rules1:
                CFG_rules1[rule[0]] =[]
                CFG_rules1[rule[0]].append(rule[1])
            else:
                CFG_rules1[rule[0]].append(rule[1])
    datafile.close()
    return CFG_rules1


sentence =[]

text_file= open("out.txt","w+")

def randsentence(rules,word,text_f):
    selected_word=""
    chose=len((rules[word]))
    rand = random.randint(0,chose-1)
    word1=rules[word][rand]
    if len(sentence) < sentence_length:
        try:
            word2=word1.split(" ")

            rand1 = random.randint(0, len(word2)- 1)
            for i in range(len(word2)):
                if word2[i] not in rules:
                    selected_word = word2[i]
                    if not selected_word=="":
                        sentence.append(selected_word)
                        text_file.write(selected_word+" ")
                elif word2[i] in rules:

                    randsentence(rules, word2[i],text_f)
        except:
            selected_word=word1

def CYKParser(gen_sentence,vocab):
    temp_sentence=gen_sentence.copy()

    if temp_sentence[len(temp_sentence)-1]=="?":
        temp_sentence=temp_sentence[4:]

    temp_sentence.pop(len(temp_sentence) - 1)
    table = createTable(temp_sentence)

    for i in range(len(temp_sentence)):
        table[0][i]=vocab[temp_sentence[i]]
        if table[0][i]=="Pronoun":
            table[0][i]="NP"

    for i in range(len(temp_sentence)-1):
        for j in range(len(temp_sentence)):
            try:
                token1=table[i][j]
                if(token1=="Pronoun"):
                    token1='NP'
                token2=table[i][j+1]

                if (token1+ " "+token2) in vocab:

                    token=vocab[token1+ " "+token2]
                    table[i + 1][j] = token

                if (token1+ " "+token2) not in vocab:
                    table[i + 1][j] = token1
                    if  token2 == "VP":
                        table[i + 1][j] = token2
                if(vocab[token1+ " "+token2]=='S'):
                    table[i + 1][j] = 'S'

            except:
                continue


    result= table[len(temp_sentence)-1][0]
    if result=='S':
        result="CORRECT"

    else:
        result = "NOT CORRECT"

    return result

def createTable(gen_sentence):
    N=len(gen_sentence)
    #print(N)
    table=[[[] for i in range(N)] for j in range(N)]
    #print(table)
    return table
CFG_rules=rules(filepath)
vocab={}

for key in CFG_rules:
    for x in CFG_rules[key]:
        vocab[x]=key

all_Sentences=[]
print("Generated Sentences\n")

for i in range(number_of_Sentences):
    randsentence(CFG_rules,root,text_file)
    text_file.write("\n")
    sent = ""
    for j in range(len(sentence)):
        sent = sent + sentence[j] + " "

    corect = CYKParser(sentence,vocab)
    print(str(sent)+"==>"+corect)
    sentence=[]
