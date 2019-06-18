package dataStruture.sort;

import com.alibaba.fastjson.JSON;

public class SortClient {
    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        ISort sort = new QuickSort();
        sort.sort(arr);
        System.out.println(JSON.toJSONString(arr));
    }
}
