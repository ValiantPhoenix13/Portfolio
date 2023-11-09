#include <stdio.h>

int getStart();
int nextCollatz(int x);

int main(){
    printf("The program will return the Collatz sequence for a positive integer.\n");
    int begin = getStart();
    int temp;
    printf("The collatz sequence is: ");
    if (begin == 1 ){
        printf("1\n");
    } else {
        temp = begin;
        while (temp!=1){
            printf("%d, ", temp);
            temp = nextCollatz(temp);
        }
        printf("1\n");
    }
}

/**************************************************
Will prompt the user for the starting point in the sequence,
asks for a positive integer.
*//////////////////////////////////////////////////
int getStart(){
    int input;
    printf("What positive integer would you like to see the sequence for?: ");
    scanf("%d", &input);
    while (input<=0){
        printf("Please provide a positive integer: ");
        scanf("%d", &input);
    }
    return input;
}

/*************************************************
The following function calculates the next integer
in the collatz sequence, based on the starting integer
from getStart.
*/////////////////////////////////////////////////
int nextCollatz(int x){
    if (x % 2 == 0){
        return x/2;
    } else {
        return (x*3)+1;
    }
}
