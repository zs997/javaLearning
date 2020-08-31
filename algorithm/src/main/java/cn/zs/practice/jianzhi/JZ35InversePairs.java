package cn.zs.practice.jianzhi;
/*
题目描述
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
即输出P%1000000007
输入描述:
题目保证输入的数组中没有的相同的数字
数据范围：
	对于%50的数据,size<=10^4
	对于%75的数据,size<=10^5
	对于%100的数据,size<=2*10^5
示例1
输入1,2,3,4,5,6,7,0
输出
7
*/
public class JZ35InversePairs {
    public static void main(String[] args) {

    }
    public int InversePairs(int [] array) {
        if(array==null || array.length==0)
            return 0;
        return mergeSort(array, 0, array.length-1);
    }
    public int mergeSort(int[] arr, int left, int right){
        if(left>=right)
            return 0;
        int mid = left + ((right - left)>>1);
        int leftNum = mergeSort(arr, left, mid);
        int rightNum = mergeSort(arr, mid+1, right);
        //在merge函数之前 就已经是排序好的数组，合并数组  并且计算数组之间的逆序对数目
        int currNum = merge(arr, left, mid, right);
        return (leftNum + rightNum + currNum) % 1000000007;
    }
    //归并过程, 大的数放前面
    public int merge(int[] arr, int left, int mid, int right){
        int[] help = new int[arr.length];
        int i=left, p1=left, p2=mid+1, count=0;
        while(p1<=mid && p2<=right){
            if(arr[p1] > arr[p2]){
                count += right - p2 + 1;
                count = count%1000000007;
                help[i++] = arr[p1++];
            }
            else
                help[i++] = arr[p2++];
        }
        while(p1<=mid)
            help[i++] = arr[p1++];
        while(p2<=right)
            help[i++] = arr[p2++];
        for(int k=left; k<= right; k++)
            arr[left++] = help[k];
        return count;
    }
}
