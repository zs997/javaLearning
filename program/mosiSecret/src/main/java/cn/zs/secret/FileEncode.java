package cn.zs.secret;



import cn.zs.secret.utils.FileUtils;
import cn.zs.secret.utils.SecretLock;

import java.io.File;
import java.util.ArrayList;

public class FileEncode {

    public static void main(String[] args){
        String curPath = System.getProperty("user.dir");
        ArrayList<String> sources = FileUtils.txt2Strings(new File(curPath+"\\source.txt"));

        SecretLock secretLock = new SecretLock();
        ArrayList<String> codes = new ArrayList<>();
        for (int i = 0; i < sources.size(); i++) {
            String encode = secretLock.encode(sources.get(i));
            codes.add(encode);
        }

        FileUtils.string2txtAppend(new File(curPath+"\\encode.txt"),codes);
    }

}
