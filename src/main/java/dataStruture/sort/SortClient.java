package dataStruture.sort;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class SortClient {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 777, 8, 1, 23, 1, 0};
        ISort sort = new QuickSort();
        sort.sort(arr);
        System.out.println(JSON.toJSONString(arr));
    }
}
