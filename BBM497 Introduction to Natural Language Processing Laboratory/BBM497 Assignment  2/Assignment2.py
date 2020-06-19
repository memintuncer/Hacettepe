import math

train_file = "train.txt"
test_file = "test.txt"


tag_counts = {}
bigr_tag_counts = {}
words_with_tags_counts = {}
first_tags = {}
all_tags = []


class HMM_model:
    initial_Probs = {}
    transition_Probs = {}
    emission_Probs = {}


def dataset(folderpath):
    sentences = []
    with open(folderpath) as file:
        sentence = []
        for line in file:
            if not line.strip():

                if (len(sentence) == 0):
                    continue
                else:
                    sentences.append(sentence)
                sentence = []

            else:

                line = line.split()
                if (line[0] == "-DOCSTART-"):
                    continue
                else:
                    word = (line[0].lower(), line[len(line) - 1].lower())
                    sentence.append(word)

        sentences.append(sentence)
    return sentences


def HMM(sentence_List):
    hMM = HMM_model
    for sentence in sentence_List:
        for i in range(len(sentence)):
            if sentence[i][1] in tag_counts:
                tag_counts[sentence[i][1]] = tag_counts[sentence[i][1]] + 1
            elif sentence[i][1] not in tag_counts:
                all_tags.append(sentence[i][1])
                tag_counts[sentence[i][1]] = 1

            try:
                bigr_tag = (sentence[i][1], sentence[i + 1][1])
                if bigr_tag in bigr_tag_counts:
                    bigr_tag_counts[bigr_tag] = bigr_tag_counts[bigr_tag] + 1
                else:
                    bigr_tag_counts[bigr_tag] = 1
            except:
                continue

            tag_words = (sentence[i][0], sentence[i][1])
            if tag_words in words_with_tags_counts:
                words_with_tags_counts[tag_words] = words_with_tags_counts[tag_words] + 1
            elif tag_words not in words_with_tags_counts:
                words_with_tags_counts[tag_words] = 1

            if i == 0:

                if sentence[i][1] in first_tags:
                    first_tags[sentence[i][1]] = first_tags[sentence[i][1]] + 1
                else:
                    first_tags[sentence[i][1]] = 1

    for key in bigr_tag_counts:
        hMM.transition_Probs[key] = bigr_tag_counts[key] / (tag_counts[key[1]])

    for key in first_tags:
        hMM.initial_Probs[key] = first_tags[key] / (len(sentence_List))

    for key in words_with_tags_counts:
        hMM.emission_Probs[key] = words_with_tags_counts[key] / (tag_counts[key[1]])
    return hMM


def create_matrix(row, col):
    matrix = [[0 for x in range(row)] for y in range(col)]

    return matrix


def viterbi(sentences, hmm):
    x = 0
    total = 0
    path = []
    for i in range(len(sentences)):
        matrix = create_matrix(len(sentences[i]), len(all_tags))

        for j in range(len(sentences[i])):
            x = x + 1
            for k in range(len(all_tags)):
                if j == 0:
                    tag = all_tags[k]
                    try:
                        initprob = hmm.initial_Probs[tag]
                        initprob = math.log(initprob, 2)

                    except:
                        initprob = -20
                    try:

                        emisprob = hmm.emission_Probs[(sentences[i][0][0], tag)]
                        emisprob = math.log(emisprob, 2)

                    except:
                        emisprob = -20

                    result = initprob + emisprob

                    matrix[k][0] = result

                else:
                    probs = []
                    for m in range(len(all_tags)):

                        prev = matrix[m][j - 1]
                        try:
                            trans = hmm.transition_Probs[all_tags[k], all_tags[m]]
                            trans = math.log(trans, 2)

                        except:
                            trans = -20
                        try:
                            word = (sentences[i][j][0])
                            emis = hmm.emission_Probs[(word, all_tags[m])]
                            emis = math.log(emis, 2)
                        except:
                            emis = -20
                        result = trans + prev + emis
                        probs.append(result)

                    maxm = max(probs)

                    matrix[k][j] = maxm

        for col in range(len(sentences[i])):
            maxm = matrix[0][col]
            index = 0
            for row in range(len(all_tags)):
                if matrix[row][col] > maxm:
                    maxm = matrix[row][col]
                    index = row
            pred_tag = all_tags[index]
            path.append(pred_tag)
            total = total + 1

    return (path)


def ACC(path, realtags):
    count = 0
    all_counts = len(path)

    for i in range(len(path)):
        if (path[i] == realtags[i]):
            count += 1
    acc = (count / all_counts) * 100
    return acc



#############################################

sentence_List = dataset(train_file)

test_sentences = dataset(test_file)

hmm = HMM(sentence_List)

path = viterbi(test_sentences, hmm)
real_tags = []
for sentence in test_sentences:
    for j in range(len(sentence)):
        real_tags.append(sentence[j][1])




accuracy = ACC(path, real_tags)
print("The accuracy is  %"+ str(accuracy))

