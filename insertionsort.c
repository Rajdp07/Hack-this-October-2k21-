#include <stdio.h>


void insertionSort(int [], int);

int main(){
    int ch, array[] = {34,23,177,87,67,44,3};
    
        
            insertionSort(array,7);
      
    return 0;
}

void insertionSort(int arr[], int size){
    int i,j,key;
    for(i=0;i<size-1;i++){
        key = arr[i];
        for(j=i-1;j>=0&&arr[j]>key;j--){
            arr[j+1] = arr[j];
        }
        arr[j+1] = key;
    }
    printf("Modified array is as follows ==> \n");
    for(i=0;i<size;i++){
        printf("%d ", arr[i]);
    }
}
