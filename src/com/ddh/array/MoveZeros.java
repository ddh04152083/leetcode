package com.ddh.array;


import java.util.Arrays;

/**
 * 给定一个数组nums 编写一个函数将所有的0，移动到数组的末尾，同时保持非零元素的相对性
 *
 * 例：
 * 输入【0,1,0,3,12】
 * 输出[1,3,12,0,0]
 * 要求 必须在原数组中进行操作，并且尽量减少操作次数
 */
public class MoveZeros {


    public static void main(String[] args) {

        Integer[] nums = {0,2,0,3,12};
        moveZeros(nums);

        Arrays.asList(nums).forEach(System.out::print);
    }
    private static void moveZeros(Integer[] nums){

        int j=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                nums[j]=nums[i];
                if (i!=j){
                    nums[i]=0;
                }
                j++;
            }
        }
    }
}
