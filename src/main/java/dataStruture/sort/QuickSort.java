package dataStruture.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 快速排序
 */
public class QuickSort implements ISort {

    @Override
    public void sort(int[] a) {
        classicQuickSort1(a,0, a.length-1);
    }

    /**
     * 快速排序的基础
     * @param items
     */
    public static void quickSort(List<Integer> items){
        if(items.size() > 1){
            List<Integer> samller = new ArrayList<>();
            List<Integer> same = new ArrayList<>();
            List<Integer> larger = new ArrayList<>();

            Integer chosenItem = items.get(items.size()/2);
            for(Integer i : items){
                if(i < chosenItem){
                    samller.add(i);
                }else if( i > chosenItem){
                    larger.add(i);
                }else{
                    same.add(i);
                }
            }
            quickSort(samller);
            quickSort(larger);

            items.clear();
            items.addAll(samller);
            items.addAll(same);
            items.addAll(larger);
        }
    }

    public static void classicQuickSort1(int[] a, int left, int right){

        if(left < right){
            int pivot = a[right];
            int i = left, j = right;
            while (i <= j){
                while (a[i] <= pivot && i < right ){
                    i++;
                }
                while (a[j] >= pivot  ){
                    j--;
                }
                if(i < j ){
                    swap(a, i , j);
                }

            }
            swap(a, i, right);
            classicQuickSort1(a, left, i-1);
            classicQuickSort1(a, i+1,right);
        }
    }

    /**
     * 经典快排
     * 如果数组中元素的个数是0或者1，则返回
     * 取arr中任一元素v，称之为枢纽元pivot
     * 将arr中剩余缘分划分成两个不想交的集合 s1 < v, s2 > v
     * 返回 quickSort（s1）+ v + quickSort(v2)
     * @param arr
     */
    public static void classicQuickSort2(int[] arr, int left, int right){
        if(left <= right){
            int pivot = mid3(arr, left, right);
            int i = left , j = right-1;
            while (i < j ){
                while (arr[i] < pivot){
                    i++;
                }
                while (arr[j] > pivot){
                    j--;
                };
                if(i < j ){
                    swap(arr, i, j);
                }
            }
            swap(arr, i , right-1);
            classicQuickSort2(arr,left, i-1);
            classicQuickSort2(arr, i+1, right);
        }
    }

    /**
     * 三只分割法
     * @param a
     * @param left
     * @param right
     * @return
     */
    public static int mid3(int[] a, int left, int right){
        int mid = (left + right)/2;

        if(a[left] > a[mid]){
            swap(a, left, mid);
        }
        if(a[right] < a[left]){
            swap(a, left, right);
        }
        if(a[right] < a[mid]){
            swap(a, mid, right);
        }
        swap(a, mid, right-1);
        return a[right-1];
    }

    /**
     * 交换两个数组的值
     * @param arr
     * @param i1
     * @param i2
     */
    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

}
