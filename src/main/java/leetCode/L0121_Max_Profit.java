package leetCode;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/9/26
 * 121. 买卖股票的最佳时机
 */



//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//        如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
//        注意你不能在买入股票前卖出股票。
//
//        示例 1:
//        输入: [7,1,5,3,6,4]
//        输出: 5
//        解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//        注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。

//        示例 2:
//        输入: [7,6,4,3,1]
//        输出: 0
//        解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
public class L0121_Max_Profit {
    public int maxProfit(int[] prices){
        int result = 0;

        //处理极端情况
        if(prices == null || prices.length <= 1){
            return 0;
        }

        //保存买入时的金额
        int curMin = prices[0];

        for(int i = 1; i < prices.length; i++){
            if(prices[i] < curMin){
                //当前金额小于最小金额，则不会出售股票，并且将最小金额进行更新
                curMin = prices[i];
            }else{
                //计算如果当前卖出的收益，和既有的利益相比较
                result = Math.max(result,prices[i] - curMin);
            }
        }

        return result;
    }
}
