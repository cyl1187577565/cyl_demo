package dataStruture.sort;

import com.alibaba.fastjson.JSON;

public class SortClient {
    public static void main(String[] args) {
        int[] arr = {23,78,1,96,48,2,46,89};
        ISort sort = new MergeSort();
        sort.sort(arr);
        System.out.println(JSON.toJSONString(arr));
    }
}
