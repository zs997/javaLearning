package cn.zs.secret;

import cn.zs.secret.utils.FileUtils;
import cn.zs.secret.utils.SecretKey;

import java.io.File;
import java.util.ArrayList;

public class FileDecode {

    public static void main(String[] args){
        String curPath = System.getProperty("user.dir");
        File file = new File(curPath+"\\encode.txt");
        ArrayList<String> sources = FileUtils.txt2Strings(file);
        SecretKey secretKey = new SecretKey();
        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < sources.size(); i++) {
            String decode = secretKey.decode(sources.get(i));
            datas.add(decode);
        }
        File f=new File(curPath+"\\decode.txt");
        FileUtils.string2txtAppend(f,datas);
    }
}
