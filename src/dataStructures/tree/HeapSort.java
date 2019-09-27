package dataStructures.tree;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int arr[]){
        int temp=0;
        for (int i=arr.length/2-1;i>=0;i--){
            adjustHeapp(arr,i,arr.length);
        }
        for (int j=arr.length-1;j>0;j--){
            //交换
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            adjustHeapp(arr,0,j);
        }
    }

    //i非叶子结点索引，length要调整的长度
    public static void adjustHeapp(int arr[],int i,int length){
        int temp=arr[i];
        for (int k=i*2+1;k<length;k=k*2+1){
            if (k+1<length && arr[k]<arr[k+1]){
                k++;
            }
            if (arr[k]>temp){
                arr[i]=arr[k];
                i=k;
            }else {
                break;
            }
        }//循环结束后，最大值已经放在局部最顶部
        arr[i]=temp;
    }
}
