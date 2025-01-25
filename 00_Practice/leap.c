#include <stdio.h>

int main(){
    int yr;
    printf("Enter a year: ");
    scanf("%d", &yr);

    int temp = yr;

    if (temp % 2 == 0){
        if ((temp % 4 == 0 && temp % 100 != 0) || temp % 400 == 0)
            printf("Leap Year");
    }
    else
        printf("Not Leap Year");
}