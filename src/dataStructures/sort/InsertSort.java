package dataStructures.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr={101,34,119,1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr){
        int insertVal=0;
        int insertIndex=0;
        for (int i=1;i<arr.length;i++){
             insertVal=arr[i];
             insertIndex=i-1;
        // 给insertVal 找到插入的位置
        // 说明
        // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
        // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
        // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex>=0&&insertVal<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            //这里我们判断是否需要赋值
            if (insertIndex+1!=i)
                arr[insertIndex+1]=insertVal;
        }

    }
}
