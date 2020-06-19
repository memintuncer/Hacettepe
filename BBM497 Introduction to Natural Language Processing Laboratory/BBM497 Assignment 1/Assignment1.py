import collections
import string

file_name = "assignment1-dataset.txt"

unigramDict = {}
unigramList = []
bigramDict = {}
bigramList = []
trigramList = []
trigramDict = {}
all_word_freqs = {}
two_words_freqs = {}


def dataset(folderpath):
    lines = []
    with open(folderpath) as file:
        for line in file:
            if not line.strip():
                continue
            else:
                lines.append(line)

    sentencesList = []
    counter = 0
    """Here, all sentences taken line by line. I edited the sentences, 
    deleted the punctuations and empty characters, 
    added tokens at the beginning and end of the sentence. (<s> and </s>), and splitted them with respect to space character"""
    for line in lines:

        if counter == 20:
            line = findXXX(line)
            sentencesList.append(line)
            counter = 0
            # print(line)

        else:
            line = "".join(char for char in line if char not in string.punctuation)
            line = line.split(" ")
            line = list(filter(None, line))
            line[0] = "<s>"
            line[len(line) - 1] = "</s>"
            # print(line)
            sentencesList.append(line)
            counter += 1
    # datafile.close()
    return sentencesList


def findXXX(line):  # I used this function for replacing the XXXXX words with true ones.
    line1 = line.split("\t")
    sentence = line1[0]
    sentence = "".join(char for char in sentence if char not in string.punctuation)
    sentence = sentence.split(" ")
    sentence = list(filter(None, sentence))
    for i in range(len(sentence)):
        if sentence[i] == "XXXXX":
            sentence[i] = line1[1]
    sentence[0] = "<s>"
    line1[1] = "</s>"
    sentence.append("</s>")
    return sentence


sentence_list = dataset(file_name)

for sentence in sentence_list:
    for i in range(len(sentence)):
        try:
            unigramList.append(sentence[i].lower())
        except:
            continue
        try:
            bi_word = (sentence[i].lower(), sentence[i + 1].lower())

            if bi_word in bigramDict:
                bigramDict[bi_word] = bigramDict[bi_word] + 1

            else:
                bigramDict[bi_word] = 1
        except:
            continue
        try:
            tri_word = ((sentence[i].lower(), sentence[i + 1].lower(), sentence[i + 2].lower()))
            if tri_word in trigramDict:
                trigramDict[tri_word] = trigramDict[tri_word] + 1

            else:
                trigramDict[tri_word] = 1
        except:
            continue

print("finished")


class UnigramModel:
    unigramCounter = collections.Counter(unigramList)
    for key in unigramCounter.keys():
        unigramDict[key] = unigramCounter[key] / len(unigramList)
        all_word_freqs[key] = unigramCounter[key]
    uniGramProbs = unigramDict


class BigramModel:
    bigramCounter = bigramDict


class TrigramModel:
    trigramCounter = trigramDict


import string
import math
# import NgramModels

import random

global modelName
generatedSentences = []
global ungr
global bigr
global trigr


# This function is used for the reading the sentences in the dataset. It reads the files and returns a list with the cleaned sentences

def Ngram(n):
    unigram = UnigramModel
    bigram = BigramModel
    trigram = TrigramModel
    if n == 1:
        return unigram
    elif n == 2:
        return bigram
    elif n == 3:
        return trigram


def next(word):
    next_word = ""
    if modelName == "Bigram":
        next_word = next_for_Bigr(word)

    if modelName == "Trigram":
        next_word = next_for_Trigr(word)

    return next_word


def next_for_Bigr(word):
    next_word = ""
    rand = random.uniform(0, 1)
    table = tablesForBigr(word)
    # print(table)

    for key in table.keys():
        if rand > table[key][0] and rand < table[key][1]:
            next_word = key
            # print(key)

    return next_word


def next_for_Trigr(word):
    next_word = ""
    rand = random.uniform(0, 1)
    table = tableForTrigr(word)

    for key in table.keys():

        if rand > table[key][0] and rand < table[key][1]:
            next_word = key
            # print("Selected word===>>>"+next_word)

    return next_word


def generate(len, count):
    len1 = 0

    "I am generating sentences for each model, and I call the different generate functions for every model"

    if (modelName == "Unigram"):
        print("Generating sentences with UniGram Model\n")
        for c in range(count):
            # uniGramSentence = ""
            uniGramSentence = generateUnigramSentences(len)
            print(str(c + 1) + ". Sentence:   " + uniGramSentence)

        print()
    elif (modelName == "Bigram"):
        print("Generating sentences with BiGram Model\n")
        for c in range(count):
            biGramSentence = generateBigramSentences(len)
            print(str(c + 1) + ".Sentence:  " + biGramSentence)

        print()
    elif (modelName == "Trigram"):
        print("Generating sentences with Trigram Model\n")

        for c in range(count):
            triGramSentence = "<s>"
            second_word = next_for_Bigr("<s>")
            firs_words = ("<s>", second_word)

            triGramSentence = generateTrigramSentences(len, firs_words)
            print(str(c + 1) + ".Sentence:  " + triGramSentence)


"I created the dictionaries for each model probabilities from 0 to 1"

def tablesForUngr(dict):
    probs = 0
    table = {}
    for key in dict.keys():
        table[key] = (probs, probs + dict[key])
        probs = probs + dict[key]
    return table


def tablesForBigr(word):
    probs = 0
    table = {}
    for key in bigr.bigramCounter.keys():
        if word == key[0]:
            table[key[1]] = (probs, probs + (bigr.bigramCounter[key] / ungr.unigramCounter[word]))
            probs = probs + (bigr.bigramCounter[key] / ungr.unigramCounter[word])
    # print(table)
    return table


def tableForTrigr(word):
    probs = 0
    table = {}
    for key in trigr.trigramCounter.keys():
        if ((word[0], word[1]) == (key[0], key[1])):
            table[key[2]] = (probs, probs + (trigr.trigramCounter[key] / bigr.bigramCounter[word]))
            probs = probs + (trigr.trigramCounter[key] / bigr.bigramCounter[word])

    return table


def generateUnigramSentences(len):
    uniGramSentence = ""
    ungTable = tablesForUngr(ungr.uniGramProbs)
    # for the starting the sentence with <s>:
    rand = random.uniform(0, 1)
    for key in ungTable.keys():
        if rand > ungTable[key][0] and rand < ungTable[key][1]:
            if (key == "<s>"):
                uniGramSentence = uniGramSentence + key + " "
            else:
                uniGramSentence = uniGramSentence + "<s>" + " "
    for i in range(len + 1):
        rand = random.uniform(0, 1)

        for key in ungTable.keys():
            if rand > ungTable[key][0] and rand < ungTable[key][1]:
                if (key == "</s>"):
                    break
                elif (not key == "<s>"):
                    uniGramSentence = uniGramSentence + key + " "
                elif (key == "<s>"):
                    i = i - 1
    uniGramSentence = uniGramSentence + "</s>"
    generatedSentences.append(uniGramSentence)
    return uniGramSentence


def generateBigramSentences(len):
    biGramSentence = ""
    next_word = "<s>"
    for i in range(len):

        if (next_word == "</s>"):
            break
        else:
            biGramSentence = biGramSentence + next_word + " "
            next_word = next(next_word)

    biGramSentence = biGramSentence + "</s>"

    generatedSentences.append(biGramSentence)
    return biGramSentence


def generateTrigramSentences(len, first_words):
    triGramSentence = first_words[0] + " " + first_words[1]

    next_word = next(first_words)
    other_words = (next_word, first_words[1])
    for i in range(len - 1):

        if (next_word == "</s>"):
            break
        else:
            other_words = (other_words[1], next_word)
            triGramSentence = triGramSentence + " " + next_word
            next_word = next(other_words)

    triGramSentence = triGramSentence + " </s>"
    generatedSentences.append(triGramSentence)

    return triGramSentence


def prob(sentence, ungr, bigr, trigr):
    # For calculating the probability of sentences for each model, again i used different functions for different cases(models)
    print(sentence)
    print()
    u_prob = uniProbs(sentence, ungr)
    bi_prob = biProbs(sentence, bigr)
    tri_prob = triProbs(sentence, trigr)
    u_ppl = ppl(u_prob, sentence)
    bi_ppl = ppl(bi_prob, sentence)
    tri_ppl = ppl(tri_prob, sentence)
    print("Probability for Unigram is ==>>  " + str(u_prob))
    print("Probability of for Bigram is ==>>    " + str(bi_prob))
    print("Probability of for Trigram is ==>>    " + str(tri_prob))
    print("Perplex for Unigram is ==>>  " + str(u_ppl))
    print("Perplex for Bigram is ==>>  " + str(bi_ppl))
    print("Perplex for Trigram is ==>>  " + str(tri_ppl))
    print()


def uniProbs(sentence, ungr):
    prob = 0
    words = sentence.split(" ")
    for word in words:
        prob = prob + math.log(ungr.uniGramProbs[word], 2)
    return prob


def biProbs(sentence, bigr):
    error = 0
    prob = 0
    words = sentence.split(" ")
    for i in range(len(words) - 1):

        try:
            prob = prob + math.log(bigr.bigramCounter[(words[i], words[i + 1])] / ungr.unigramCounter[words[i]])
        except:
            # If probability is zero, then go to sprob
            error = 1
            prob = sprob(sentence, error)

            break
    return prob


def triProbs(sentence, trigr):
    error = 0
    prob = 0
    words = sentence.split(" ")

    for i in range(len(words) - 2):
        try:
            prob = prob + math.log(trigr.trigramCounter[(words[i], words[i + 1], words[i + 2])] / bigr.bigramCounter[
                (words[i], words[i + 1])])
        except:
            # If probability is zero, then go to sprob
            error = 2
            prob = sprob(sentence, error)
    return prob


def sprob(sentence, error):
    prob = 0
    if (error == 1):
        prob = bi_sprob(sentence)

    elif (error == 2):
        prob = tri_sprob(sentence)
    return prob


def bi_sprob(sentence):
    prob = 0
    words = sentence.split(" ")
    for i in range(len(words) - 1):
        try:
            prob = prob + math.log((bigr.bigramCounter[(words[i], words[i + 1])] + 1) / (
                        ungr.unigramCounter[words[i]] + len(ungr.unigramCounter)))
        except:
            prob = prob + math.log((1) / (ungr.unigramCounter[words[i]] + len(ungr.unigramCounter)))
    return prob


def tri_sprob(sentence):
    prob = 0
    words = sentence.split(" ")
    for i in range(len(words) - 2):
        try:
            prob = prob + math.log((trigr.trigramCounter[(words[i], words[i + 1], words[i + 2])] + 1) / (
                        bigr.bigramCounter[(words[i], words[i + 1])] + len(bigr.bigramCounter)))
        except:
            try:

                prob = prob + math.log((1) / (bigr.bigramCounter[(words[i], words[i + 1])] + len(bigr.bigramCounter)))
            except:
                prob = prob + math.log((1) / (1 + len(bigr.bigramCounter)))

    return prob


def ppl(prob, sentence):
    words = sentence.split(" ")

    power = -(prob / len(words) - 2)
    perp = math.pow(2, power)

    return perp

"Here I created the models "
ungr = Ngram(1)
bigr = Ngram(2)
trigr = Ngram(3)

modelName = "Unigram"
generate(10, 2)

modelName = "Bigram"
generate(10, 2)

modelName = "Trigram"
generate(10, 2)

for sentence in generatedSentences:
    prob(sentence, ungr, bigr, trigr)

