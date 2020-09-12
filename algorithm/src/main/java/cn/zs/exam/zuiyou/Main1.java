package cn.zs.exam.zuiyou;
import java.util.HashMap;
import java.util.Scanner;

public class Main1 {
    // 定义36进制数字
    private static final String X36 = "0123456789abcdefghijklmnopqrstuvwxyz";
    // 拿到36进制转换10进制的值键对
    private static HashMap<Character, Integer> thirysixToTen = createMapThirtysixToTen();
    // 定义静态进制数
    private static int BASE = 36;

    private static HashMap<Character, Integer> createMapThirtysixToTen() {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < X36.length(); i++) {
            // 0--0,... ..., Z -- 35的对应存放进去
            map.put(X36.charAt(i), i);
        }
        return map;
    }



    /**
     * 36 to 10
     *
     * @param pStr
     *            36进制字符串
     * @return 十进制
     */
    public static long ThirtysixToDeciaml(String pStr) {
        if (pStr == "" || pStr== null|| pStr.length() ==0)
            return 0;

        // 目标十进制数初始化为0
        long deciaml = 0;
        // 记录次方,初始为36进制长度 -1
        int power = pStr.length() - 1;
        // 将36进制字符串转换成char[]
        char[] keys = pStr.toCharArray();
        boolean flag = false;
        for (int i = 0; i < pStr.length(); i++) {
            if (i == 0 && keys[0] == '-') {
                flag = true;
            }else if ((keys[i] >= '0' && keys[i] <= '9')||(keys[i] >= 'a' && keys[i] <='z')){
                // 拿到36进制对应的10进制数
                int value = thirysixToTen.get(keys[i]);
                if (flag){
                    deciaml =(long )(deciaml + value * Math.pow(BASE, power-1));
                }else {
                    deciaml =(long )(deciaml + value * Math.pow(BASE, power));
                }

                // 执行完毕 次方自减
                power--;
            }else  {
                return 0;
            }
        }
        return flag ? -deciaml:deciaml;
    }

//  &avd1
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(ThirtysixToDeciaml(s));

    }
}