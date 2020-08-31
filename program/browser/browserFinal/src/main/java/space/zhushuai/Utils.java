package space.zhushuai;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 执行运行的工具箱
 * */
public class Utils {

    //初始化 所在盘符
    static {
        String path_curr = System.getProperty("user.dir");
        pan_no = path_curr.substring(0,2);
    }

    public static  String pan_no ;

    public static String pathStrip(String path){
        if(path.startsWith(pan_no)){
            return path.substring(2);
        }
        return  path;
    }
    public static  String pathModify(String path){
        if(path.contains(":")){
            return path;
        }
        return pan_no+path;
    }
    public static boolean is_command(String command){
        // 要验证的字符串
        //例如 1_qq.exe
        String regEx = "^\\d+_[\\s\\S]*";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(command);
        // 字符串是否与正则表达式相匹配
         return  matcher.matches();
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

        try{
           rn.exec(path);
        }catch (Exception e){
            System.out.println(e+"it can not be execute");
        }
    }

}
