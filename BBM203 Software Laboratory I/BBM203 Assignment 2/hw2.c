#include <stdio.h>
#include <stdlib.h>
typedef struct {
    int queue_size;
    int stack_size;
    int top;
    char *stack ;
    int front;
    int rear;
    char *queue;
    char *commandc;
    int command;
}client;

int isFull(client *client1){
    if (client1->top==client1->stack_size-1){
        return 1;
    }
    else
        return -1;
}

int isEmpty(client *client1){
    if (client1->top==-1){
        return 1;
    }
    else
        return -1;
}

void push(client *client1, char x){
    ++client1->top;
    client1->stack[client1->top]=x;
}

void pop(client *client1){
        client1->top=client1->top-1;
}

char top(client *client1){
    return client1->stack[client1->top];
}


void enqueue(client *client1, char x){
    if (client1->front==-1) client1->front=0;
    client1->rear=(client1->rear+1)%client1->queue_size;
    client1->queue[client1->rear]=x;


}
void dequeue(client *client1){
    if (client1->front==client1->rear){
        client1->front=-1;
        client1->rear=-1;
    }
    else{
     client1->front=(client1->front+1)%client1->queue_size;
    }

}

int emptyqueue(client *client1){
    if (client1->front==-1){
        return 1;
    } else
        return -1;
}

int fullqueue(client *client1){
    if((client1->rear+1==client1->front)||(client1->front==0&&client1->rear==client1->queue_size-1)){
        return 1;
    }
    else
        return -1;
}

char front(client *client1){
    return client1->queue[client1->front];
}

int main(int argc,char *argv[]) {
    int y,i,j;
    int **qs_size;
    FILE *o;
    o=fopen(argv[1],"r");
    if((o!=NULL))
    {
        fscanf(o,"%d\n",&y);

    }
    qs_size=(int **)malloc(sizeof(int*)*y);
    for (i = 0; i < y; i++) {
        qs_size[i] = malloc(2 * sizeof(int));
    }


    FILE *input1;
    int size;
    input1=fopen(argv[1],"r");
    fscanf(input1, "%d", &size);
    for ( i = 0; i <y ; ++i) {
        for ( j = 0; j <2 ; ++j) {
            if (fscanf(input1, "%d", &size) != EOF){
                qs_size[i][j]=size;
            }
        }
    }

    int size3;
    FILE *input3;
    input3=fopen(argv[2],"r");
    fscanf(input3,"%d\n",&size3);
    client *clients;
    clients=(client*)malloc(sizeof(client)*(y));

    for (i=0;i<y;++i){
        client client1;
        client1.stack_size=qs_size[i][1];
        client1.queue_size=qs_size[i][0];
        client1.top=-1;
        client1.rear=-1;
        client1.front=-1;
        client1.stack=(char*)malloc(sizeof(char)*qs_size[i][1]);
        client1.queue=(char*)malloc(sizeof(char)*qs_size[i][0]);
        client1.commandc=(char*)malloc(sizeof(char)*size3);
        client1.command=0;
        clients[i]=client1;
    }

    int size2;
    FILE *input2;
    input2=fopen(argv[2],"r");
    fscanf(input2,"%d\n",&size2);

    char command,ch;
    int number;

while(!feof(input2)){
    fscanf(input2,"%c ",&command);
    if(command=='O'){

        if(isEmpty(&clients[y-1])==1&&emptyqueue(&clients[y-1])==1){
            clients[y-1].commandc[clients[y-1].command]='3';
            clients[y-1].command++;
        }
        else if(isEmpty(&clients[y-1])!=1){
            clients[y-1].commandc[clients[y-1].command]=top(&clients[y-1]);
            clients[y-1].command++;
            pop(&clients[y-1]);
        }
        else if(isEmpty(&clients[y-1])==1&&emptyqueue(&clients[y-1])!=1){
            clients[y-1].commandc[clients[y-1].command]=front(&clients[y-1]);
            clients[y-1].command++;
            dequeue(&clients[y-1]);
        }

    }
    else{
        fscanf(input2,"%d %c\n",&number,&ch);
        if (command=='I'){
            if(isFull(&clients[number-1])==1){
                clients[number-1].commandc[clients[number-1].command]='2';
                clients[number-1].command++;
            }
            else if(isFull(&clients[number-1])!=1){
                push(&clients[number-1],ch);
            }

        }
        else if(command=='A'){
            if (fullqueue(&clients[number-1])==1){
                clients[number-1].commandc[clients[number-1].command]='1';
                clients[number-1].command++;
            }
            else if(fullqueue(&clients[number-1])!=1){
                enqueue(&clients[number-1],ch);
            }

        }

        else if(command=='S'){
            if(isEmpty(&clients[number-1])==1&&emptyqueue(&clients[number-1])==1){
                clients[number-1].commandc[clients[number-1].command]='3';
                clients[number-1].command++;
            }
            else if(isEmpty(&clients[number-1])!=1){
                clients[number-1].commandc[clients[number-1].command]=top(&clients[number-1]);
                clients[number-1].command++;
                if(fullqueue(&clients[y-1])!=1){
                    enqueue(&clients[y-1],top(&clients[number-1]));
                }
                else if (fullqueue(&clients[y-1])==1){
                    clients[y-1].commandc[clients[y-1].command]='1';
                    clients[y-1].command++;
                }
                pop(&clients[number-1]);


            }
            else if(isEmpty(&clients[number-1])==1&&emptyqueue(&clients[number-1])!=1){
                clients[number-1].commandc[clients[number-1].command]=front(&clients[number-1]);
                clients[number-1].command++;
                if(fullqueue(&clients[y-1])!=1){
                    enqueue(&clients[y-1],front(&clients[number-1]));
                }
                else if (fullqueue(&clients[y-1])==1){
                    clients[y-1].commandc[clients[y-1].command]='1';
                    clients[y-1].command++;
                }
                dequeue(&clients[number-1]);
            }
        }

    }
}
    FILE *output1;
    output1 = fopen(argv[3], "w");
    for(i=0; i<y;i++){
        for(j=0; j<clients[i].command;j++){
            fprintf(output1,"%c ",clients[i].commandc[j]);
        }
        fprintf(output1,"\n");
    }
    fclose(input1);
    fclose(input2);
    fclose(input3);
    fclose(o);
    return 0;
}