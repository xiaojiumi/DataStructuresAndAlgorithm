package dataStructures.sort;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
//        int[] arr={8,4,5,7,1,3,6,2};
//        int[] temp=new int[arr.length];
//        mergeSort(arr,0,arr.length-1,temp);
//        System.out.println(Arrays.toString(arr));
        int[] arr = new int[80000];
        int[] temp=new int[arr.length];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }
        System.out.println("排序前");
        Instant i1=Instant.now();
        mergeSort(arr,0,arr.length-1,temp);;//移位方式
        Instant i2=Instant.now();
        Duration dur= Duration.between(i1,i2);
        System.out.println(dur.toMillis());
    }

    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if (left<right){
            int mid=(left+right)/2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid+1, right, temp);
            merge(arr,left,mid,right,temp);
        }
    }

    /**
     *
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 做中转的数组
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i=left;
        int j=mid+1;
        int t=0;//temp数组的索引
        //(一)
        //先把左右两边(有序)的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
         while (i<=mid&&j<=right){
             if (arr[i]<=arr[j]){
                 temp[t]=arr[i];
                 t+=1;
                 i+=1;
             }else {
                 temp[t]=arr[j];
                 t+=1;
                 j+=1;
             }
         }
        //(二)
        //把有剩余数据的一边的数据依次全部填充到temp
        while (i<=mid){
            temp[t++]=arr[i++];
        }
        while (j<=right){
            temp[t++]=arr[j++];
        }
        //(三)
        //将temp数组的元素拷贝到arr
        //注意，并不是每次都拷贝所有
        t=0;
        int templeft=left;
        while (templeft<=right)
            arr[templeft++]=temp[t++];
    }
}
