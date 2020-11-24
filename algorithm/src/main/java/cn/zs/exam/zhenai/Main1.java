package cn.zs.exam.zhenai;
public class Main1 {
    public boolean parking (int[] park, int n) {
        // write code here
        int count = 0;
        for (int i = 0; i < park.length; i++) {
            if (park[i] == 0){
                if (i==0 && park[i+1] == 0){
                    park[i] = 1;
                    count++;
                }else if (i == park.length-1 && park[i-1] == 0){
                    park[i] = 1;
                    count++;
                }else if (park[i-1] == 0 && park[i+1] ==0){
                    park[i] = 1;
                    count++;
                }

            }
        }
        if (count >= n)
            return true;
        return false;
    }
}
