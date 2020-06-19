#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>

int quit(){
    exit(0);

}

int writefile(char way,FILE *output1){
    fprintf(output1,"%s"," ");
    fprintf(output1,"%c",way);

}
int writefile1(FILE *output1){
    fprintf(output1,"%s","START");
}

int endfile(FILE *output1){
    fprintf(output1,"%s"," ");
    fprintf(output1,"%s","EXIT");
}


int mazeWay(int y,int x,int i,int k,char maze[i][k],char keys [50], int j,FILE *output,int p_w, char path[250]){

    if (x>=0&&y>=0){

        if(maze[y+1][x]=='E'){
            writefile('S',output);
            endfile(output);
            quit();
        }
        if (maze[y][x+1]=='E'){
            writefile( 'E', output);
            endfile(output);
            quit();
        }

        if (maze[y][x-1]=='E'){

            writefile('W',output);
            path[p_w]='W';
            p_w=p_w+1;
            endfile(output);
            quit();
        }

                            //DOORS
            // South
         if (isupper(maze[y+1][x])){
            int q;
            for ( q = 0; q <j ; ++q) {

                if(keys[q]==tolower(maze[y+1][x])){
                    writefile('S',output);
                    writefile(maze[y+1][x],output);
                    maze[y+1][x]='*';
                    y=y+1;
                    mazeWay(y,x,i,k,maze,keys,j,output,p_w,path);

                }


                //Come AGAIN


            }
        }

            //East

         if (isupper(maze[y][x+1])){
            int v;
            for ( v = 0; v <j ; ++v) {
                if(keys[v]==tolower(maze[y][x+1])){
                    writefile('E',output);
                    writefile(maze[y][x+1],output);
                    maze[y][x+1]='*';
                    x=x+1;
                    mazeWay(y,x,i,k,maze,keys,j,output,p_w,path);

                }
            }
        }

            //West
         if (isupper(maze[y][x-1])){
            int c;
            for ( c = 0; c <j ; ++c) {
                if(keys[c]==tolower(maze[y][x-1])){
                    writefile('W',output);
                    writefile(maze[y][x-1],output);
                    maze[y][x-1]='*';
                    x=x-1;
                    mazeWay(y,x,i,k,maze,keys,j,output,p_w,path);

                }
            }
        }

            //KEYS
            //South
         if (islower(maze[y+1][x])){
            writefile('S',output);
            keys[j]=maze[y+1][x];
            writefile(keys[j],output);
            j=j+1;
            maze[y+1][x]='*';
            y=y+1;
            mazeWay(y,x,i,k,maze,keys,j,output,p_w,path);
        }

            //East

         if (islower(maze[y][x+1])){
            writefile('E',output);
            keys[j]=maze[y][x+1];
            writefile(keys[j],output);
            j=j+1;
            maze[y][x+1]='*';
            x=x+1;
            mazeWay(y,x,i,k,maze,keys,j,output,p_w,path);
        }

            //West

        if(islower(maze[y][x-1])){
            writefile('W',output);
            keys[j]=maze[y][x-1];
            writefile(keys[j],output);
            j=j+1;
            maze[y][x-1]='*';
            x=x-1;
            mazeWay(y,x,i,k,maze,keys,j,output,p_w,path);
        }

            //North
        if(islower(maze[y-1][x])){
            writefile('N',output);
            keys[j]=maze[y-1][x];
            writefile(keys[j],output);
            j=j+1;
            maze[y-1][x]='*';
            y=y-1;
            mazeWay(y,x,i,k,maze,keys,j,output,p_w,path);
        }



            //WAY

            //South

        if(maze[y+1][x]=='0'){
            writefile('S',output);
            maze[y+1][x]='*';
            y=y+1;
            mazeWay(y,x,i,k,maze,keys,j,output,p_w,path);
        }

            //East

        if (maze[y][x+1]=='0'){
            writefile('E',output);
            maze[y][x+1]='*';
            x=x+1;
            mazeWay(y,x,i,k,maze,keys,j,output,p_w,path);
        }

            //West


        if (maze[y][x-1]=='0') {
            writefile('W',output);
            maze[y][x-1]='*';
            x=x-1;
            mazeWay(y,x,i,k,maze,keys,j,output,p_w,path);

        }

            //North
        if (maze[y-1][x]=='0'){
            writefile('N',output);
            maze[y-1][x]='*';
            y=y-1;
            mazeWay(y,x,i,k,maze,keys,j,output,p_w,path);
        }

            //TURN BACK


        if (maze[y-1][x]=='*'){
            writefile('N',output);
            maze[y-1][x]='!';
            y=y-1;
            mazeWay(y,x,i,k,maze,keys,j,output,p_w,path);
        }

        if (maze[y][x-1]=='*'){
            writefile('W',output);
            maze[y][x-1]='!';
            x=x-1;
            mazeWay(y,x,i,k,maze,keys,j,output,p_w,path);
        }

        if (maze[y][x+1]=='*'){
            writefile('E',output);
            maze[y][x+1]='!';
            x=x+1;
            mazeWay(y,x,i,k,maze,keys,j,output,p_w,path);
        }

        if(maze[y+1][x]=='*'){
            writefile('S',output);
            maze[y+1][x]='!';
            y=y+1;
            mazeWay(y,x,i,k,maze,keys,j,output,p_w,path);
        }


            //GO AGAIN

        if (maze[y-1][x]=='!'){
            writefile('N',output);
            maze[y-1][x]='+';
            y=y-1;
            mazeWay(y,x,i,k,maze,keys,j,output,p_w,path);
        }


        if (maze[y][x-1]=='!'){
            writefile('W',output);
            maze[y][x-1]='+';
            x=x-1;
            mazeWay(y,x,i,k,maze,keys,j,output,p_w,path);
        }

        if (maze[y][x+1]=='!'){
            writefile('E',output);
            maze[y][x+1]='+';

            x=x+1;
            mazeWay(y,x,i,k,maze,keys,j,output,p_w,path);
        }

        if(maze[y+1][x]=='!'){
            writefile('S',output);
            maze[y+1][x]='+';
            y=y+1;
            mazeWay(y,x,i,k,maze,keys,j,output,p_w,path);
        }



    }

}

int startMaze(int i,int x,int y,char maze[x][y],char keys [50], int j,FILE *output,int p_w, char path[250]){
    int m,k;
    for ( m = 0; m <y ; ++m) {
        if(maze[i][m]=='S'){
            writefile1(output);
            k=m;
            mazeWay(i,k,x,y,maze,keys,j,output,p_w,path);
        }
    }

}
int main(int argc,char *argv[]) {
    FILE *f;
    char c;
    char d;
    char ch;
    int lines=1;
    f=fopen(argv[1],"r");
    while((c=fgetc(f))!=EOF) {
        if(c=='\n'){
            lines++;
        }
    }
    char maze[lines][lines+2];

    f=fopen(argv[1],"r");
    int i,j;
    for ( i = 0; i <lines ; ++i) {
        for ( j = 1; j <lines +2; ++j) {
            ch =(char)fgetc(f);
            if(ch!='\n' || ch!=EOF){
                maze[i][j]=ch;
            }

        }
    }
    int m,n;
    for ( m = 0; m < lines; ++m) {
        maze[m][0]='+';
    }
    for ( n = 0; n <lines ; ++n) {
        maze[n][lines+1]='+';
    }

    int k;


    fclose(f);
    int h,y;

    char keys [50];
    int l;
    for ( l = 0; l <50 ; ++l) {
        keys[l]='0';
    }
    char path[250];
    int pw;
    int p_w=0;
    for ( pw = 0; pw <250 ; ++pw) {
        path[pw]='0';
    }
    int z=0;
    int sp=0;
    FILE *output1;
    output1 = fopen("path.txt", "a");
    startMaze(sp,lines,lines+2,maze,keys,z,output1,p_w,path);
    fclose(output1);

    return 0;
}