package leetCode;

import com.alibaba.fastjson.JSON;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/9/24
 */
public class CylDemo {


    public static void main(String[] args) {
        String text = "lri amaktfpync uyb uyb uyb lri rriralwkw rriralwkw rriralwkw rriralwkw uyb rriralwkw uyb uyb amaktfpync rriralwkw amaktfpync uyb uyb lri uyb rriralwkw amaktfpync amaktfpync rriralwkw";
        String first = "uyb";
        String second = "lri";
        String[] ocurrences = findOcurrences(text, first, second);
        System.out.println(JSON.toJSONString(ocurrences));
    }

   /* 给定两个数组，编写一个函数来计算它们的交集。

    示例 1:

    输入: nums1 = [1,2,2,1], nums2 = [2,2]
    输出: [2]
    示例 2:

    输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    输出: [9,4]
    说明:

    输出结果中的每个元素一定是唯一的。
    我们可以不考虑输出结果的顺序。*/
    public static int[] intersection(int[] nums1, int[] nums2){
        Set<Integer> set = new HashSet<>();
        Set<Integer> temp = new HashSet<>();
        int[] resTemp = new int[nums1.length];
        int j = 0;

        for(int i = 0; i <= nums1.length - 1; i++){
            set.add(nums1[i]);
        }

        for(int i = 0; i <= nums2.length-1; i++){
            if(set.contains(nums2[i])){
                if(!temp.contains(nums2[i])){
                    temp.add(nums2[i]);
                    resTemp[j] = nums2[i];
                    j++;
                }
            }
        }

        int[] res = new int[j];
        for(int i = 0; i < j ; i++){
            res[i] = resTemp[i];
        }

        return res;
    }




   /* 给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现。

    对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。*/

    /*示例 1：

    输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
    输出：["girl","student"]
    示例 2：

    输入：text = "we will we will rock you", first = "we", second = "will"
    输出：["we","rock"]

    提示：
         1 <= text.length <= 1000
        text 由一些用空格分隔的单词组成，每个单词都由小写英文字母组成
        1 <= first.length, second.length <= 10
        first 和 second 由小写英文字母组成*/
    public static String[] findOcurrences(String text, String first, String second) {
        StringBuilder sb = new StringBuilder();
        String[] s = text.split(" ");
        for (int i = 0; i < s.length - 1;) {
            int offset = 1;
            if(first.equals(s[i])){
                if(second.equals(s[i + 1])){
                    sb.append(s[i+2]);
                    sb.append(" ");
                    offset = 2;
                }
            }
            i += offset;
        }

        String[] res = sb.toString().split(" ");
        return res;
    }
}
