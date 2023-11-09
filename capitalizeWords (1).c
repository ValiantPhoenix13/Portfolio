#include <stdio.h>
#define limit 100
void capitalize(char str[]);

int main(){
    char user[limit];
    printf("Please input a string for the program to capitalize the first letter in each word. \nThe string may not be more than 100 characters.\n");
    fgets (user, limit, stdin);
    capitalize(user);
    printf ("%s\n", user);    
}

void capitalize(char str[]){
    int temp = 0;

    if(str[temp]>='a' && str[temp]<='z'){
        str[temp] = str[temp] - 32;
        temp++;
    }
        
    while(temp<=limit){
        if(str[temp-1]==' ' && (str[temp]>='a' && str[temp]<='z')){
            str[temp] = str[temp] - 32;
        }
        temp++;
    }
    
}
