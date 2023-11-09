#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Function prototypes
int getInt(char prompt[], int min, int max);
void fillBoard(int arr[], int len);
void printBoard(int arr[], int len);
void shuffleBoard(int arr[], int len);
void reverse(int arr[], int len, int amt);
int isSorted(int arr[], int len);

int main()
{
    // Seed the random number generator
    srandom(time(NULL));
        
    // Ask user for length of game, from 3-20
    int boardLength = getInt("Enter size of board: ", 3, 20);
    
    // Create board. Shuffle numbers.
    int board[boardLength];
    
    // Fill board in order with numbers 1..boardLength.
    fillBoard(board, boardLength);
    // Shuffle board.
    // I recommend initially only uncommenting the shuffleBoard line
    // so it doesn't get stuck in an infinite loop. Once shuffleBoard
    // is working, uncomment the rest of the loop.
    while (isSorted(board, boardLength))
    {
        shuffleBoard(board, boardLength);
    }
    
    // Print board
    printBoard(board, boardLength);
    
    int gameOver = 0;
    int moves = 0;
    while (!gameOver)
    {
        // Ask user for amount to reverse
        int amt = getInt("How many to reverse? ", 2, boardLength);
        
        // Reverse the first (amt) numbers
        reverse(board, boardLength, amt);
        
        // Print the board
        printBoard(board, boardLength);
        
        // Check to see if the game is over
        gameOver = isSorted(board, boardLength);
        
        moves++;
    }
    printf("You won in %d moves!\n", moves);
}

// Get an integer from the user.
//   Display the prompt.
//   Get input from user.
//   Check that the input is between the min and max, inclusive.
//   If not, display error message that includes the min and max,
//     then loop back to get input again.
int getInt(char prompt[], int min, int max)
{
    int size;
    printf("%s", prompt);
    scanf("%d", &size);
    while(size<min || size>max){
        printf("Please input a number between %d and %d, inclusive; also make sure it's within range of your board: ", min, max);
        scanf("%d", &size);
    }
    return size;
}

void fillBoard(int arr[], int len){
    int index = 0;
    while (index<=len){
        arr[index] = index + 1;
        index++;
    }
}

void printBoard(int arr[], int len){
    printf("Board: ");
    for(int i = 0; i<len; i++){
        printf("%d ", arr[i]);
    }
    printf("\n");
}

void shuffleBoard(int arr[], int len){
    for (int i = len-1; i!=1; i--){
        int j = random() %len;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

void reverse(int arr[], int len, int amt){
    for (int i = 0; i < amt/2; i++){
        int temp = arr[i];
        arr[i] = arr[amt-(1+i)];
        arr[amt-(1+i)] = temp;
    }
    
}

int isSorted(int arr[], int len){
    int status = 1;
    for(int i = 0; i<len; i++){
        if(arr[i]>arr[i+1]){
            status = 0;
        }
    }
    return status;
}

//Thank you Pra nd Sawyer for testing