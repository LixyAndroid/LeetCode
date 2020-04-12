package com.xuyang.leetcode.offer;

/**
 * @author Li Xuyang
 * @date 2020/4/12 16:08
 * 矩阵中的路径
 */
public class HasPath64 {

    /*
    请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，
    向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
    例如 a b c e s f c s a d e e

 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。

     */


    /*

首先看到这个题目，思路很明确，使用DFS递归的回溯剪枝思想，即添加一些判断条件使得程序不再递归下去。
首先对于matrix中的每一个都可能是起点，需要遍历。由题可知，只要找到一条路径，即可返回true，最后的0表示从str的第0个字符开始。代码如下：

for(int i = 0; i < rows; i++)
    for(int j = 0; j < cols; j++)
        if(subHasPath(matrix,rows,cols,str,i,j,0))
            return true;
对于从每一个点开始的子路径，因为使用递归，我们只需知道在这一步该怎么做即可，不用管之后该怎么做。同时找到一个递归的出口即可。代码如下：

    if(matrix[row*cols+col] != str[len]) return false;
    if(len == str.length-1) return true;
    if(row > 0 && subHasPath(matrix,rows,cols,str,row-1,col,len+1)) return true;
    if(row < rows-1 && subHasPath(matrix,rows,cols,str,row+1,col,len+1)) return true;
    if(col > 0 && subHasPath(matrix,rows,cols,str,row,col-1,len+1)) return true;
    if(col < cols-1 && subHasPath(matrix,rows,cols,str,row,col+1,len+1)) return true;
    return false;
    其实如果没有str的长度限制，上面的代码会陷入死循环，但是该题中有str的长度限制，导致dfs最深的深度为str的长度。（类似于TCP中的TTL的作用）但是该题中规定不能访问重复的字符。于是需要一个记录访问的数组visited。完整的代码如下：
     */
    boolean[] visited = null;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        visited = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (subHasPath(matrix,rows,cols,str,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean subHasPath(char[] matrix, int rows, int cols, char[] str,int row, int col, int len){

        if (matrix[row*cols+col]!=str[len]|| visited[row * cols + col]){
            return false;
        }
        if (len==str.length-1){
            return true;
        }
        visited[row*cols+col]=true;
        if (row>0&&subHasPath(matrix, rows, cols, str, row-1, col, len+1)){
            return true;
        }
        if (row<rows-1&&subHasPath(matrix, rows, cols, str, row+1, col, len+1)){
            return true;
        }

        if (col>0&&subHasPath(matrix, rows, cols, str, row, col-1, len+1)){
            return true;
        }

        if (col<cols-1&&subHasPath(matrix, rows, cols, str, row, col+1, len+1)){
            return true;
        }

        visited[row*cols+col]=false;

        return false;

    }
}
