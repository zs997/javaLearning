package cn.zs.secret.utils;

import java.io.*;
import java.util.ArrayList;

public class FileUtils {
    public static ArrayList<String> txt2Strings(File file)   {
        ArrayList<String> result = new ArrayList<>();
        // 如果文件不存在就创建
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                FileWriter fw = new FileWriter(file,true);
                PrintWriter pw = new PrintWriter(fw);
                pw.println("init with hello!");
                pw.flush();
                System.out.println("asfd");
            }catch (Exception e){
                e.printStackTrace();
            }

            result.add("init with hello!");
            return result;
        }

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null && !"".equals(s)){//使用readLine方法，一次读一行
                result.add(s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public static void string2txtAppend(File f,ArrayList<String> datas) {
        FileWriter fw = null;
        try {
            //如果文件存在，则追加内容；如果文件不存在，则创建文件
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        for (int i = 0; i < datas.size(); i++) {
            pw.println(datas.get(i));
        }
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
