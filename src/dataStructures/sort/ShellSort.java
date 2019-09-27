package dataStructures.sort;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {


    public static void main(String[] args) {
//        int[] arr={8,9,1,7,2,3,5,4,6,0};
//        shellSort(arr);


        // 创建要给80000个的随机的数组
        int[] arr = new int[800000];
        for (int i = 0; i < 800000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        System.out.println("排序前");
        Instant i1=Instant.now();
//        Date data1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1Str = simpleDateFormat.format(data1);
//        System.out.println("排序前的时间是=" + date1Str);

        //shellSort(arr); //交换式
        shellSort2(arr);//移位方式
        Instant i2=Instant.now();
        Duration dur= Duration.between(i1,i2);
//        Date data2 = new Date();
//        String date2Str = simpleDateFormat.format(data2);
//        System.out.println("排序前的时间是=" + date2Str);
        System.out.println(dur.toMillis());
        //        System.out.println(Arrays.toString(arr));
    }

    //交换法
    public static void shellSort(int[] arr){
        int temp=0;
        for (int gap=arr.length/2;gap>0;gap/=2){
            for (int i=gap;i<arr.length;i++){
                // 遍历各组中所有的元素(共gap组，每组有个元素), 步长gap
                for (int j=i-gap;j>=0;j-=gap){
                    if (arr[j]>arr[j+gap]){
                        // 如果当前元素大于加上步长后的那个元素，说明交换
                        temp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }
            }
        }
    }

    //移动法
    public static void shellSort2(int[] arr){
        for (int gap=arr.length/2;gap>0;gap/=2){
            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i=gap;i<arr.length;i++){
                int j=i;
                int temp=arr[i];
                if (arr[i]<arr[j-gap]){
                    while (j-gap>=0&&temp<arr[j-gap]){
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    arr[j]=temp;
                }

            }
        }
    }
}

