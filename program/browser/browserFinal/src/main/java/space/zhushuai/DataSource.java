package space.zhushuai;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class DataSource {

    private boolean changed = false;  //是否更改过


    private  Properties properties_command = null; //存储命令的键值对
    private Properties properties_command_backup = null; //键值对缓冲区



    //读入数据时 初始化  新增数据 +1
    private int command_count = 0; //记录运行时数据个数

    private  String  folderPath = null; //根据构造函数初始化
    private  String fileName = null;

    /**分别指定文件夹和文件名的数据源
     * */
    public DataSource(String folderPath, String fileName) {
        this.folderPath = folderPath;
        this.fileName = fileName;

        read();
    }

   /**
    * 指定文件名的数据源
    * */
   public DataSource(String fileName){
       this.folderPath = System.getProperty("user.dir")+"/config"; //配置文件夹目录
       this.fileName = "/"+fileName+ ".properties"; //配置文件目录
       read();
   }

    /**
     * 默认数据源
     * */
    public DataSource(){
        this.folderPath = System.getProperty("user.dir")+"/config"; //配置文件夹目录
        this.fileName =  "/config.properties"; //配置文件目录
        read();
    }


    public boolean ischanged() {
        return changed;
    }

    /*
    public void change(){
        changed = true;
    }
    public void unChange(){
        changed = false;
    }
    */

    public Properties getProperties_command() {
        return properties_command;
    }

    /**
     * 读取配置文件  磁盘-> 缓存 -> 运行时  使用构造函数 调用read()
     * */
    private void read(){

        //初始读入数据 没有改变过数据
        changed = false;
        // String rootDirectory = System.getProperty("user.dir");
        //System.out.println(rootDirectory);
        // 如果文件夹不存在就创建
        File folder = new File(folderPath);
        if (!folder.exists()) {
            System.out.println("//不存在");
            folder.mkdirs();
        }
        // 如果文件不存在就创建
        File file = new File(folderPath + fileName);
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
            FileInputStream fis = new FileInputStream(folderPath + fileName);
            properties_command_backup = new Properties();
            properties_command_backup.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        properties_command = new Properties();
        copy(properties_command_backup,properties_command);
        command_count = properties_command.size();
    }

    /**保存时候 会调用写数据  运行时-> 缓存 ->磁盘
     *
     * 外部可以调用
     * */
    public void write(){
        //保存到磁盘数据  执行后 数据没有动过
        changed =false;
       copy(properties_command,properties_command_backup);

        File folder = new File(folderPath);
        if (!folder.exists()) {
            System.out.println("//不存在");
            folder.mkdirs();
        }
        // 如果文件不存在就创建
        File file = new File(folderPath + fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Properties props = new Properties();
        try {
            // 写文件
            FileOutputStream fos = new FileOutputStream(folderPath + fileName);
            properties_command_backup.store(fos,null);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
    /**
     * 新增 运行时数据
     * */
    public void add(String key,String value){
        //运行时数据改变了
        command_count ++;
        changed = true;
        properties_command.setProperty(key,value);
    }
    
    /**撤销更新的数据
     * */
    public void rollBack(){
        //将缓冲区数据覆盖 运行时数据  状态变成没有改变数据
        changed = false;
       copy(properties_command_backup,properties_command);
       command_count = properties_command.size();
    }

    /**清空所有数据
     * */
    public void clear(){
        int is_update = javax.swing.JOptionPane.showConfirmDialog(null, "确定清除数据？", "提示",
                javax.swing.JOptionPane.YES_NO_OPTION);
        if(is_update == 0){
            changed = false;
            command_count = 0;
            properties_command.clear();
            write();
        }else{

        }
    }

    /**
     *  从一个pro 复制到另一个  from -> to
     * */
    private void copy(Properties properties_command_from, Properties getProperties_command_to) {
        getProperties_command_to.clear();
        Iterator<Map.Entry<Object, Object>> it = properties_command_from.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Object, Object> entry = it.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            getProperties_command_to.setProperty(key,value);
        }
    }


    public int getCommand_count() {
        return command_count;
    }


}
