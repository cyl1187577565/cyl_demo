package dataStruture.sort;

import org.hamcrest.core.Is;

/**
 * 归并排序
 */
public class MergeSort implements ISort {

    @Override
    public void sort(int[] a) {
        int[] temp = new int[a.length];
        mergeSort(a, temp, 0, a.length-1);
    }

    private void mergeSort(int[] a, int[] tempArr, int left, int right){
        if(left < right){
            int center = (left + right)/2;
            mergeSort(a,tempArr, left, center);
            mergeSort(a, tempArr, center+1, right);
            merge(a,tempArr, left, center+1, right);
        }
    }

    private void merge(int[] a, int[] tempArr, int leftPos, int rightPos, int rightEnd){
        int leftEnd = rightPos-1;
        int tempPos = leftPos;
        int numElements = rightEnd-leftPos+1;

        //main loop
        while (leftPos <= leftEnd && rightPos<= rightEnd){
            if(a[leftPos] <= a[rightPos]){
                tempArr[tempPos++] = a[leftPos++];
            }else{
                tempArr[tempPos++] = a[rightPos++];
            }
        }

        while (leftPos <= leftEnd){
            tempArr[tempPos++] = a[leftPos++];
        }
        while (rightPos <= rightEnd){
            tempArr[tempPos++] = a[rightPos++];
        }

        //copy tempArr back
        for(int i = 0; i < numElements; i++, rightEnd--){
            a[rightEnd] = tempArr[rightEnd];
        }
    }
}
