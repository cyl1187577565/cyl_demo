package dataStruture.sort;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class SortClient {
    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        ISort sort = new BubSort();
        sort.sort(arr);
        System.out.println(JSON.toJSONString(arr));
    }
}
