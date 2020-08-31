package cn.zs;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class Utils {

    static String  folderPath = System.getProperty("user.dir")+"/config"; //配置文件夹目录
    static String filePath = "/config.properties"; //配置文件目录
    /**
     * 读取配置文件
     * */
    static void read_pro(Properties properties_command){
       // String rootDirectory = System.getProperty("user.dir");
        //System.out.println(rootDirectory);
        // 如果文件夹不存在就创建
        File folder = new File(folderPath);
        if (!folder.exists()) {
            System.out.println("//不存在");
            folder.mkdirs();
        }
        // 如果文件不存在就创建
        File file = new File(folderPath + filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Properties props = new Properties();
        try {
            // 读取文件
            FileInputStream fis = new FileInputStream(folderPath + filePath);
            properties_command.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    static void write_pro(Properties properties_command){
        File folder = new File(folderPath);
        if (!folder.exists()) {
            System.out.println("//不存在");
            folder.mkdirs();
        }
        // 如果文件不存在就创建
        File file = new File(folderPath + filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Properties props = new Properties();
        try {
            // 读取文件
            FileOutputStream fos = new FileOutputStream(folderPath + filePath);
            properties_command.store(fos,null);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }



    /**判断路径对应命令的种类
     * */
    public static  String Command_type(String Path){
        String fileNameNow = Path.substring(Path.lastIndexOf("\\")+1);
        if(fileNameNow.endsWith(".exe")){
           return "exe";
        }else{
            //将快捷方式 充当文件夹使用 可以打开
            return "Folder";
        }
    }
    /**
     * 打开指定路径的命令
     * */
    public  static  void RunCommand(String Path){
        String command_type = Command_type(Path);

        if(command_type.equals("exe")){
            RunWinExe(Path);
        }else if(command_type.equals("Folder")){
            RunFolder(Path);
        }else{
            //可以拓展
        }
    }
    /**
     * 打开指定位置文件夹  可能可以打开windows所有自己能打开的东西
     * */
    public static void RunFolder(String path){
        try {
            Desktop.getDesktop().open(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("无法打开指定文件夹");
        }
    }


    /**
     * 执行
     * 路径 path下的win exe程序
     *
     * */
    public  static void RunWinExe(String path){
        Runtime rn = Runtime.getRuntime();
        Process p =null;
        try{
            p = rn.exec(path);
        }catch (Exception e){
            System.out.println(e+"it can not be execute");
        }
    }
/**
 *  从一个pro 复制到另一个  from -> to
 * */
    public static void properties_command_copy(Properties properties_command_from, Properties getProperties_command_to) {
        getProperties_command_to.clear();
        Iterator<Map.Entry<Object, Object>> it = properties_command_from.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Object, Object> entry = it.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            getProperties_command_to.setProperty(key,value);

        }

    }


    /**
     * 执行数组索引的路径
     * */
    /*
    public  void RunWinExe(int command_no){
        try{
            String path = file_list.get(command_no);
            RunWinExe(path);
        }catch (Exception e){
            System.out.println(e+"it can not be execute");
        }
    }
    */
}
