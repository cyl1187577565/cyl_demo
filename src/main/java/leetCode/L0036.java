package leetCode;

import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/10/1
 * 36. 有效的数独
 */

/*判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
        数字 1-9 在每一行只能出现一次。
        数字 1-9 在每一列只能出现一次。
        数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。*/

public class L0036 {
    static  Character temp = 0;
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = Collections.unmodifiableSet(new HashSet<Character>() {{
            add('.');
            add('1');
            add('2');
            add('3');
            add('4');
            add('5');
            add('6');
            add('7');
            add('8');
            add('9');
        }});
        //第一个循环检测每一行
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!isValid(board, i, j, set)) {
                    return false;
                }
            }
        }

        //第二个循环，判断每一列是否 符合
        for (int i = 0; i < 9; i++) {
            Character temp = '0';
            for (int j = 0; j < 9; j++) {
                if (set.contains(board[j][i])) {
                    if (!isValid(board, j, i, set)) {
                        return false;
                    }
                }
            }
        }

        //第三个循环，判断每个小格是符合规范
        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {
                if (j >= 0 && j < 3 && i >= 0 && i < 3) {
                    temp = '0';
                    if (!isValid(board, i, j, set)) {
                        return false;
                    }
                } else if (j >= 3 && j < 6 && i >= 3 && i < 6) {
                    temp = '0';
                    if (!isValid(board, i, j, set)) {
                        return false;
                    }
                } else {
                    char temp = '0';
                    if (!isValid(board, i, j, set)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] chars, int i, int j, Set<Character> set) {
        //判断是否数字只出现一次
        if (set.contains(chars[i][j])) {
            if ('.' != chars[i][j]) {
                //判断是否只出现一次
                if (temp == chars[i][j]) {
                    return false;
                } else {
                    temp = chars[i][j];
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
