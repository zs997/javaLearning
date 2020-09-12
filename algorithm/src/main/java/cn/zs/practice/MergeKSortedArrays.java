package cn.zs.practice;

public class MergeKSortedArrays {
    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     * 合并k个排序数组
     */
    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here
        if(arrays == null || arrays.length == 0)
            return null;

        return helper(arrays, 0, arrays.length-1);

    }

    private int[] helper(int[][] arrays, int l, int r){
        if(l == r)
            return arrays[l];
        if(l + 1 == r)
            return merge2Arrays(arrays[l], arrays[r]);
        int mid = l + (r-l)/2;
        int[] left = helper(arrays, l, mid);
        int[] right = helper(arrays, mid+1, r);
        return merge2Arrays(left, right);
    }

    private int[] merge2Arrays(int[] a, int[] b){
        int[] res = new int[a.length + b.length];
        int i=0, j=0;
        for(int k=0; k<res.length; k++){
            if(i >= a.length)
                res[k] = b[j++];
            else if(j >= b.length)
                res[k] = a[i++];
            else if(a[i] < b[j])
                res[k] = a[i++];
            else
                res[k] = b[j++];
        }
        return res;
    }

}
