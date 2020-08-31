package cn.zs.exam.SameCity58;

import java.util.ArrayList;
import java.util.HashSet;
/**
 *  找每个字符串数组都出现的字符串 ac
 * */
public class Main1 {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("asd");
        list1.add("zxc");
        list1.add("good");
        list1.add("apple");
        data.add(list1);
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("qsc");
        list2.add("good");
        list2.add("cas");
        list2.add("apple");
        data.add(list2);
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("fddfg");
        list3.add("good");
        list3.add("gdg");
        list3.add("apple");
        data.add(list3);
        ArrayList<String> commonString = new Main1().findCommonString(data);
        for (int i = 0; i < commonString.size(); i++) {
            System.out.println(commonString.get(i));
        }

    }
    public ArrayList<String> findCommonString (ArrayList<ArrayList<String>> values) {
        // write code here
        ArrayList<String> res = new ArrayList<>();
        HashSet<String> [] sets = new HashSet[values.size()];
        for (int i = 0; i < values.size()-1; i++) {
            ArrayList<String> list = values.get(i);
            sets[i] = new HashSet<>();
            for (int j = 0; j < list.size(); j++) {
                sets[i].add(list.get(j));
            }

        }
        ArrayList<String> last = values.get(values.size() - 1);
        for (int i = 0; i < last.size(); i++) {
            String s = last.get(i);
            boolean flag = true;
            for (int j = 0; j < sets.length-1; j++) {
                if (!sets[j].contains(s)){
                    flag = false;
                    break;
                }
            }
            if (flag)
                res.add(s);

        }
        return res;
    }
    public ArrayList<String> findCommonString1 (ArrayList<ArrayList<String>> values) {
        // write code here
        if (values.size() == 0)
            return  new ArrayList<>();
        ArrayList<String> ans = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            ArrayList<String> temp = values.get(i);
            ans = test(temp,ans);
        }
        return ans;

    }
    public  ArrayList<String> test(ArrayList<String> l1,ArrayList<String> l2){
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < l2.size(); i++) {
            if (l1.contains(l2.get(i)) && !ans.contains(l2.get(i)))
                ans.add(l2.get(i));
        }
        return ans;
    }
}
