import numpy as np
import random
import json,string
import re
import dynet as dy
import nltk
from nltk.util import ngrams 
from nltk import FreqDist

file_path="unim_poem.json"
vector_path="glove.6B.50d.txt" 
#vector_path="glove.6B.100d.txt" 
#vector_path="glove.6B.200d.txt"
#vector_path="glove.6B.300d.txt" 


def readfile(filepath):
    with open(file_path) as f:
        return json.load(f)


def freqs(data):
    bigram_counts=FreqDist()
    unigram_counts=FreqDist()
    for poem in data:
        line = re.findall(r'\S+|\n', poem["poem"])
        
        line.insert(0, "SOP")
        line.insert(len(line), "EOP")
        bigrams = ngrams(line, 2)
        bigram_counts.update(bigrams)
        unigrams = ngrams(line, 1)
        unigram_counts.update(unigrams)
        
    return unigram_counts,bigram_counts

def readVectors(vector_file):
    
    vector_dict={}
    with open(vector_file, 'r', encoding="utf-8") as datafile:
        for line in datafile:
            values = line.split()
            word = values[0]
            if word not  in string.punctuation:
                vector = np.asarray(values[1:], "float32")
                vector_dict[word] = vector
                shape=vector.shape[0]
                
    return vector_dict,shape

def create_index_dict(unigramdict,vectors):
 i = 0
 indexed_vocab = {}
 index=0
 new_vector=np.random.rand(50,)
 for key in unigramdict.keys():
 	indexed_vocab[index]=(key[0])

     #this part is used for creating new vectors for not seen words
     if key[0] not in vectors.keys():
         
         vectors[key[0]]=new_vector
     index=index+1
 return indexed_vocab




dataset=readfile(file_path)

#dataset=dataset[0:1000]

unigram_counts,bigram_counts=freqs(dataset)

vector_dict,shape=readVectors(vector_path)

indexed_vocab=create_index_dict(unigram_counts,vector_dict)

bigram_words=[]
unigram_words=[]

for k in bigram_counts.keys():
    bigram_words.append(k)


epoch_size=40
inpt=len(unigram_counts)
hidden= int(inpt/100)
out = len(unigram_counts)

model = dy.Model()
pW=model.add_parameters((hidden,shape))
pb = model.add_parameters((hidden))
pU = model.add_parameters((out,hidden))
pd = model.add_parameters((out))
trainer = dy.SimpleSGDTrainer(model)

for iteration in range(epoch_size):
    loss_value = 0
    random.shuffle(bigram_words)
    for bigram in bigram_words:
        dy.renew_cg()
        index1=0
        index2=0

        for key in indexed_vocab:
            if indexed_vocab[key]==bigram[0]:
                index1=key
            if indexed_vocab[key]==bigram[1]:
                index2=key

        x = dy.inputVector(vector_dict[indexed_vocab[index1]])
        y=pU*dy.tanh(pW*x+pb)+pd
        loss = dy.pickneglogsoftmax(y,index2)
        loss_value += loss.scalar_value()
        loss.backward()
        trainer.update()
    print("Iteration: ",iteration," Loss: ",loss_value)
model.save("FNN_model.model")
model.populate("FNN_model.model")

def generate(line_number,unigram_counts,vector_dict,indexed_vocab):

    for i in range(line_number):
        rand = random.randrange(len(unigram_counts))
        predict = ""
        poem = ""
        while predict != "EOP":
            x = dy.inputVector(vector_dict[indexed_vocab[rand]])
            y = pU * dy.tanh(pW * x + pb) + pd
            rand = np.argmax(y.value())
            key=np.argmax(y.value())
            predict=indexed_vocab[key]
            print(predict)
            #predicted_word = getWordFromIndexedVocab(indexed_vocab, np.argmax(y.value()))
            if predict == "\n":
                #print()
                poem = poem + "\n"
            else:
                print(predict,end = ' ')
                poem = poem + predict + " "

