/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 吉彬
 */
public class Solution {
    public static void main(String[] args){
        
    }
    /*
    问题：
    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
    输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 
    例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 
    NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
    */
    
    /*
    解决思路：
    二分查找。
    由题意知要求的最小值就是两个子序列的拐点，后面序列的最小值；
    还可知后面序列的最大值（也就是整个数组的最后一个元素）小于等于前面序列的最小值（也就是整个数组的第一个元素）。
    定义两个指针start和end，start指向第一个元素，end指向最后一个元素。
    mid=（start+end）/2表示中间位置，判断中间位置的元素。
    如果中间位置的元素大于等于start指向的元素，则证明mid指向的中间元素在前面的序列中，
    要求的最小值在该中间元素之后，此时可以将start指向中间元素以缩小搜索范围；
    如果中间位置的元素小于等于end指向的元素，则证明mid指向的中间元素在后面的序列中，
    要求的最小值在该中间元素之前，此时可以将end指向中间元素以缩小搜索范围。
    如此二分下去，知道end-start==1时，start指向前面序列的最大值，end指向后面序列的最小值，所求刚好就是end指向的元素。
    */
    public int minNumberInRotateArray(int [] array) {
        if(array==null||array.length==0)
            return 0;
        int start = 0;
        int end = array.length-1;
        while(true){
            int mid = (start+end)/2;
            if(array[mid]>=array[start])
                start = mid;
            if(array[mid]<=array[end])
                end = mid;
            if(end-start==1)
                break;
        }
        return array[end];
    }
}
