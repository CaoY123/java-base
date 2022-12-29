package com.mine.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CaoY
 * @date 2022-12-29 15:47
 * @description 递归和字符串相关的算法题
 * 说明：请编写一个函数，计算把“KFMd播报”变成“KFM.d”需要最小操作次数。
 * 输入：源字符串,目标字符串
 * 输出：最小操作次数
 * 操作只能是以下2种：
 * 1.在给定位置插入一个字(中文或英文,下同)
 * 2.删除任意一个字
 * 注意：
 * 1、保证程序健壮性，给定任意源字符串和任意目标字符串,都能输出最小值。
 * 2、写好主函数，方便测试运行。
 * 3、将源代码和可执行程序分别保存在src和bin目录下，打包提交。
 */
public class RecursionDemoTestFirst {

    public static void main(String[] args) {
        String origin = "KFMd播报";
        String aim = "KFM.d";
        Integer result = calcMin(origin, aim);
        System.out.println("结果为：" + result);

    }
    // 策略：找到两个字符串中最长的一对公共子串,这个最长的公共子串是不用做任何变化的，即我们可以分别将其从
    // 两个字符串中删除掉，接着再考虑剩下的字符串（公共子串的左边和右边的情况），运用递归的思想，可以将所有
    // 相同的字符排除出去，进而剩下的字符是双方特有的或是某一个字符串独有的
    public static Integer calcMin(String origin, String aim) {
        if(origin == null || origin.length() == 0) {
            return aim == null ? 0 : aim.length();
        }
        // 能到这一步origin的长度不为null和0
        if(aim == null || aim.length() == 0) {
            return origin.length();
        }

        // 查找最短的长度
        // 寻找二者公共的最长子串，并分别返回子串所在的开始和结尾处，将其放到一个集合中
        List<Integer> indexes = findMaxSubStrIndex(origin, aim);
        if (indexes.size() == 0) {
            // 没有公共子字符串
            return origin.length() + aim.length();
        }

        String subOriginLeft = origin.substring(0, indexes.get(0));
        String subAimLeft = aim.substring(0, indexes.get(2));
        String subOriginRight = origin.substring(indexes.get(1));
        String subAimRight = aim.substring(indexes.get(3));

        // 找出 subOriginLeft 和 subAimLeft 的最长公共子字符串
        return calcMin(subOriginLeft, subAimLeft) + calcMin(subOriginRight, subAimRight);
    }

    /**
     * 返回的值的意义：如果不存在公共的子字符串，则返回一个空的List集合，
     * 如果存在公共的子字符串，则返回一个长度为4的List集合，
     * 前两个元素是第一个字符串的起始下标和结尾下标的后一个位置的下标，
     * 后两个元素是第二个字符传的起始下标和结尾下标的后一个位置的下标
     * @param str1
     * @param str2
     * @return
     */
    public static List<Integer> findMaxSubStrIndex(String str1, String str2) {
        List<Integer> result = new ArrayList<>();
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0 ) {
            return result;
        }
        Integer[][] nums = new Integer[str1.length()][str2.length()];
        // 构建寻找最大公共子字符串的矩阵
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                nums[i][j] = str1.charAt(i) == str2.charAt(j) ? 1 : 0;
            }
        }

        boolean[][] flag = new boolean[nums.length][nums[0].length];
        // 在矩阵nums中寻找最长的值为1的斜线
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] == 1 && flag[i][j] == false) {
                    // 找到了一个还没有探索过长度的斜线的开始，下面开始探索这个斜线的过程
                    flag[i][j] = true;
                    int tmpI = i + 1;
                    int tmpJ = j + 1;
                    while (tmpI < nums.length && tmpJ < nums[0].length && nums[tmpI][tmpJ] == 1) {
                        flag[tmpI][tmpJ] = true;
                        tmpI++;
                        tmpJ++;
                    }
                    if (tmpI - i + 1 > maxLength) {
                        maxLength = tmpI - i + 1;
                        result.clear();
                        result.add(i);
                        result.add(tmpI);
                        result.add(j);
                        result.add(tmpJ);
                    }
                }
            }
        }
        return result;
    }
}
