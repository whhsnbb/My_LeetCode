package 哈希表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//36. 有效的数独
//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
//
//数字 1-9 在每一行只能出现一次。
//数字 1-9 在每一列只能出现一次。
//数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
//
//
//上图是一个部分填充的有效的数独。
//
//数独部分空格内已填入了数字，空白格用 '.' 表示。

class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Set<Integer>> row = new HashMap<>();
        HashMap<Integer, Set<Integer>> col = new HashMap<>();
        HashMap<Integer, Set<Integer>> matrix = new HashMap<>();
        for (int i = 0 ; i < 9 ; i ++){
            row.put(i,new HashSet<>()); //行
            col.put(i,new HashSet<>()); //列
            matrix.put(i,new HashSet<>());  //总共分为九个中型方格，这个就代表方格
        }

        for(int i = 0 ; i < 9 ; i ++){
            for(int j = 0 ; j < 9 ; j ++){
                if(board[i][j] == '.'){     //如果是.  就不判断了，直接跳过
                    continue;
                }
                int x = board[i][j] - '0';      //如果是数字
                int idx = i/3*3 + j /3;         //这个数字所在的中型方格编号
                if(!row.get(i).contains(x) && !col.get(i).contains(x) && !matrix.get(idx).contains(x)){
                    //中型方格，列，行都没有这个元素的话，添加到这三个对应的set集合中
                    row.get(i).add(x);
                    col.get(i).add(x);
                    matrix.get(idx).add(x);
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}