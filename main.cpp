#include <stdio.h>
#include <stdlib.h>

void swap(int a[],int i,int j){
    int temp=a[i];
    a[i]=a[j];
    a[j]=temp;
}

void SelectSort(int a[],int n){
    int min;
    for(int i=1;i<n;i++){
        min=i;
        for(int j=i+1;j<=n;j++){
            if(a[j]<a[min])
                min=j;
        }
        if(i!=min)
            swap(a,i,min);
    }
}

void HeapAdjust(int a[],int k,int n){
    a[0]=a[k];
    for(int i=2*k;i<=n;i++){
        if(i<n&&a[i]<a[i+1])
            i++;
        if(a[0]>=a[i])
            break;
        else{
            a[k]=a[i];
            k=i;
        }
    }
    a[k]=a[0];
}

void BuildMaxHeap(int a[],int n){
    for(int i=n/2;i>=1;i--)
        HeapAdjust(a,i,n);
}

void HeapSort(int a[],int n){
    BuildMaxHeap(a,n);
    for(int i=n;i>1;i--){
        swap(a,i,1);
        HeapAdjust(a,1,i-1);
    }
}

int main()
{
    int a[11]={-999,5,4,3,2,1,10,8,6,4,2};
    int b[11]={-999,5,4,3,2,1,10,8,6,4,2};
    printf("¥˝≈≈–Ú¡–£∫");
    for(int i=1;i<=10;i++)
        printf("%3d",a[i]);
    printf("\n");
    SelectSort(a,10);
    printf("ºÚµ•—°‘Ò≈≈–Ú£∫");
    for(int i=1;i<=10;i++)
        printf("%3d",a[i]);
    printf("\n");
    HeapSort(b,10);
    printf("(¥Û∏˘)∂—≈≈–Ú£∫");
    for(int i=1;i<=10;i++)
        printf("%3d",b[i]);
    printf("\n");
    return 0;
}