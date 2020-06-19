#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <math.h>
#define MAX_SIZE 25
struct strings{
    int size;
    char *str;
    int count;
    char *afterword;
    char **afterarray;
    struct strings *next;
    struct strings *down;

};
typedef struct strings node;


void append1(char* s, char c)
{
    size_t len = strlen(s);
    s[len] = c;
    s[len+1] = '\0';
}

void readfile(char *s,int x,int y,char string1[x][y]){
    char str[50];
    char ch;
    FILE *fptr= fopen(s, "r");
    int loc=0;
    while (!feof(fptr)){
        ch=(char)fgetc(fptr);
        if(isalnum(ch)){
            append1(str,(char)tolower(ch));
        }
        else if(!isalnum(ch)) {
            if(str[0]!='\0'){
                strcpy(string1[loc], str);
                loc++;
                str[0] = '\0';
            }
        }
    }
    fclose(fptr);
}

void readfile1(char *s,int x,int y,char string1[x][y]){
    char str[50];
    char ch;
    FILE *fptr1= fopen(s, "r");
    int loc=0;
    while (!feof(fptr1)){
        ch=(char)fgetc(fptr1);
        if(isalnum(ch)){
            append1(str,(char)tolower(ch));
        }
        else if(!isalnum(ch)) {
            if(str[0]!='\0'){
                strcpy(string1[loc], str);
                loc++;
                str[0] = '\0';
            }
        }
    }
    fclose(fptr1);
}
int findwordscount(char *s){
    char ch;
    FILE *fptr= fopen(s,"r");
    int loc=0;
    int size=0;
    char str[50];
    while (!feof(fptr)){
        ch=(char)fgetc(fptr);
        if(isalnum(ch)){
            append1(str,(char)tolower(ch));
        }
        else if(!isalnum(ch)) {
            if(str[0]!='\0'){
                loc++;
                str[0] = '\0';
                size++;
            }
        }
    }
    fclose(fptr);
    return size;

}

void insert(node *iter,char * s,int dup) {
    int i;
    while(iter->next!=NULL){
        iter=iter->next;
    }
    iter->str=strcpy(iter->str,s);
    iter->count=dup;
    iter->next=(node*)malloc(sizeof(node));
    iter->next->str=(char*)malloc(sizeof(char)*(MAX_SIZE));
    iter->next->afterword=(char*)malloc(sizeof(char)*(MAX_SIZE));
    iter->next->next=NULL;
}

void sortArray(int x,int y,char string1[x][y]){
    int i,j;
    char temp[25];
    for(i=0;i<=x-1;i++)
        for(j=i+1;j<=x-1;j++){
            if(strcmp(string1[i],string1[j])>0){
                strcpy(temp,string1[i]);
                strcpy(string1[i],string1[j]);
                strcpy(string1[j],temp);
            }
        }
}

void bSortLink(node *head){
    node *i,*j;
    int temp;
    char temps[25];
    for(i=head;i->next!=NULL;i=i->next){
        for(j=i->next;j->next!=NULL;j=j->next){
            if(i->count<j->count){
                temp=i->count;
                strcpy(temps,i->str);
                i->count=j->count;
                strcpy(i->str,j->str);
                strcpy(j->str,temps);
                j->count=temp;
            }
        }
    }
}
void insert1(node *iter,int size,int y,char string1[size][y] ){
    int i;
    char prev[25];
    int dup=1;
    strcpy(prev,string1[0]);
    for(i=1;i<size+1;i++){
        if(strcmp(string1[i],prev)==0)
            dup++;
        else
        {
            insert(iter,prev,dup);
            strcpy(prev,string1[i]);
            dup = 1;
        }
    }

}

node * delete(node *r,char *string){
    node *iter,*temp;
    iter=r;
    if(strcmp(r->str,string)==0){
        temp=r;
        r=r->next;
        free(temp);
        return r;

    }
    else{
        while (iter->next!=NULL&&strcmp(iter->next->str,string)!=0){
            iter=iter->next;
        }
        temp=iter->next;
        iter->next=iter->next->next;
        free(temp);
        return  r;
    }
}


void  similarity(node *root1,node *root2,char *s1,char *s2){
    int i,j;
    int count=0;
    node *temp1,*temp2,*temp3;
    temp1=root1;
    temp2=root2;
    int counts[20][2];
    for(i=0;i<10;i++){
        while(temp2->next!=NULL){
            if(strcmp(temp1->str,temp2->str)==0){
                counts[count][0]=temp1->count;
                counts[count][1]=temp2->count;
                count++;
            }
            temp2=temp2->next;
        }
        temp2=root2;
        temp1=temp1->next;
    }
    temp2=root2;
    temp3=temp1;
    for(i=0;i<10;i++){
        while(temp3->next!=NULL){
            if(strcmp(temp3->str,temp2->str)==0){
                counts[count][0]=temp3->count;
                counts[count][1]=temp2->count;
                count++;
            }
            temp3=temp3->next;
        }
        temp3=temp1;
        temp2=temp2->next;
    }
    float r1=0,r2=0,r3=0;
    float cos,r4,r5;
    for(i=0;i<count;i++){
        r1=r1+(counts[i][0]*counts[i][1]);
    }
    for(i=0;i<count;i++){
        r2=r2+(counts[i][0]*counts[i][0]);
    }
    for(i=0;i<count;i++){
        r3=r3+(counts[i][1]*counts[i][1]);
    }
    r4=sqrtf(r2);
    r5=sqrtf(r3);
    cos=r1/(r4*r5);
    printf("Cosine Similarity of %s and %s = %.3f",s1,s2,cos);
}

int main() {
    int i,j;
    node *root=malloc(sizeof(node)) ;
    node *iter=root;
    iter->count=1;
    iter->next=NULL;
    iter->down=NULL;
    iter->str=(char*)malloc(sizeof(char)*(MAX_SIZE));
    iter->afterword=(char*)malloc(sizeof(char)*(MAX_SIZE));
    node *root1=malloc(sizeof(node)) ;
    node *iter1=root1;
    iter1->count=1;
    iter1->next=NULL;
    iter1->down=NULL;
    iter1->str=(char*)malloc(sizeof(char)*(MAX_SIZE));
    iter1->afterword=(char*)malloc(sizeof(char)*(MAX_SIZE));
    int loc=0;
    int check=0;
    int acount = 0;
    char *file1=(char*)malloc(sizeof(char)*500);
    char *file2=(char*)malloc(sizeof(char)*500);
    char *input=(char*)malloc(sizeof(char)*500);
    char *input1=(char*)malloc(sizeof(char)*500);
    char *input2=(char*)malloc(sizeof(char)*500);
    char *input3=(char*)malloc(sizeof(char)*500);
    int y=0;
    int y1=0;
    while (scanf("%s",input)){
        if(input[1]!='q'){
            if(input[1]=='r'){
                if(check==1){
                    scanf("%s",input2);
                    int x=strlen(input2);
                    input[x]='\0';
                    for(i=0;i<strlen(input2);i++){
                        if(input2[i]=='\\'||input2[i]=='/'){
                            loc=i;
                        }
                    }
                    char *name1=(char*)malloc(sizeof(char)*100);
                    for(i=loc+1;i<strlen(input2);i++){
                        name1[y1]=input2[i];
                        y1++;
                    }
                    name1[y1]='\0';
                    strcpy(file2,name1);
                    int size1;
                    size1=findwordscount(file2);
                    char string3[size1][MAX_SIZE];
                    char string4[size1][MAX_SIZE];
                    readfile1(file2, size1, MAX_SIZE,string4);
                    readfile1(file2, size1, MAX_SIZE,string3);
                    sortArray(size1,MAX_SIZE,string3);
                    insert1(iter1,size1,MAX_SIZE,string3);
                    bSortLink(root1);
                } else{
                    scanf("%s",input1);
                    int x=strlen(input1);
                    input[x]='\0';
                    for(i=0;i<strlen(input1);i++){
                        if(input1[i]=='\\'||input1[i]=='/'){
                            loc=i;
                        }
                    }
                    char *name=(char*)malloc(sizeof(char)*100);
                    for(i=loc+1;i<strlen(input1);i++){
                        name[y]=input1[i];
                        y++;
                    }
                    name[y]='\0';
                    strcpy(file1,name);
                    int size;
                    size=findwordscount(file1);
                    char string1[size][MAX_SIZE];
                    char string2[size][MAX_SIZE];
                    readfile(file1, size, MAX_SIZE,string2);
                    readfile(file1, size, MAX_SIZE,string1);
                    sortArray(size,MAX_SIZE,string1);
                    insert1(iter,size,MAX_SIZE,string1);
                    bSortLink(root);
                    check=1;

                }
            }
            else if(input[1]=='a'){
                scanf("%s %d %s",input1,&acount,input3);
                if(strcmp(input3,file1)==0){
                    insert(iter,input1,acount);
                    bSortLink(root);
                }
            }
            else if(input[1]=='d'){
                scanf("%s %s ",input1,input2);
                if(strcmp(input2,file1)==0){
                    root=delete(root,input1);
                }
                else if(strcmp(input2,file2)==0){
                    root1=delete(root1,input1);
                }
            }
            else if(input[1]=='s'){
                scanf("%s %s",input1,input2);
                if(strcmp(input1,file1)==0){
                    similarity(root,root1,file1,file2);
                }
                else if(strcmp(input1,file2)==0){
                    similarity(root1,root,file1,file2);
                }
            }
            /*else if(input[1]=='n'){
                bastir(root);
            }*/
        }
        if(input[1]=='q'){
            break;
        }
    }
    return 0;
}