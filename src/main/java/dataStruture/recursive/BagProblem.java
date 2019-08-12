package dataStruture.recursive;

import java.util.*;

/**
 * @Description
 * 背包问题
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/26
 */
public class BagProblem {
    //物品的重量
    private int n = 5;
    private static int[] weights = {2,2,6,5,4};
    private static int[] prices = {6,3,5,4,6};

    //背包最大能容的重量
    private int packageWeight = 10;

    int conValue = 0;
    int conWeight = 0;
    //最大价值
    int maxValue = 0;
    //最终结果
    int[] result = new int[8];

    public static void main(String[] args) {

    }

    /**
     * 修剪函数
     * @return
     */
    public boolean check(){
        return true;
    }


}
